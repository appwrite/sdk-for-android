package io.appwrite

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import io.appwrite.cookies.ListenableCookieJar
import io.appwrite.cookies.stores.SharedPreferencesCookieStore
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.fromJson
import io.appwrite.extensions.toJson
import io.appwrite.models.InputFile
import io.appwrite.models.UploadProgress
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.*
import okhttp3.Headers.Companion.toHeaders
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.File
import java.io.RandomAccessFile
import java.io.IOException
import java.lang.IllegalArgumentException
import java.net.CookieManager
import java.net.CookiePolicy
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.atomic.AtomicReference
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume

class Client @JvmOverloads constructor(
    context: Context,
    var endpoint: String = "https://cloud.appwrite.io/v1",
    var endpointRealtime: String? = null,
    private var selfSigned: Boolean = false
) : CoroutineScope {

    companion object {
        /**
         * The size for chunked uploads in bytes.
         */
        internal const val CHUNK_SIZE = 5*1024*1024; // 5MB
        internal const val MAX_CONCURRENT_UPLOADS = 8
        internal const val GLOBAL_PREFS = "io.appwrite"
        internal const val COOKIE_PREFS = "myCookie"
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val job = Job()

    internal lateinit var http: OkHttpClient

    internal val headers: MutableMap<String, String>

    val config: MutableMap<String, String>

    internal val cookieJar = ListenableCookieJar(CookieManager(
        SharedPreferencesCookieStore(context.getSharedPreferences(COOKIE_PREFS, Context.MODE_PRIVATE)),
        CookiePolicy.ACCEPT_ALL
    ))

    private val appVersion by lazy {
        try {
            val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            return@lazy pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            return@lazy ""
        }
    }

    init {
        headers = mutableMapOf(
            "content-type" to "application/json",
            "origin" to "appwrite-android://${context.packageName}",
            "user-agent" to "${context.packageName}/${appVersion}, ${System.getProperty("http.agent")}",
            "x-sdk-name" to "Android",
            "x-sdk-platform" to "client",
            "x-sdk-language" to "android",
            "x-sdk-version" to "25.2.0",
            "x-appwrite-response-format" to "1.9.5"
        )
        config = mutableMapOf()

        setSelfSigned(selfSigned)
    }

    /**
     * Set Project
     *
     * Your project ID
     *
     * @param {string} project
     *
     * @return this
     */
    fun setProject(value: String): Client {
        config["project"] = value
        return this
    }

    /**
     * Set JWT
     *
     * Your secret JSON Web Token
     *
     * @param {string} jwt
     *
     * @return this
     */
    fun setJWT(value: String): Client {
        config["jWT"] = value
        addHeader("x-appwrite-jwt", value)
        return this
    }

    /**
     * Set Locale
     *
     * @param {string} locale
     *
     * @return this
     */
    fun setLocale(value: String): Client {
        config["locale"] = value
        addHeader("x-appwrite-locale", value)
        return this
    }

    /**
     * Set Session
     *
     * The user session to authenticate with
     *
     * @param {string} session
     *
     * @return this
     */
    fun setSession(value: String): Client {
        config["session"] = value
        addHeader("x-appwrite-session", value)
        return this
    }

    /**
     * Set DevKey
     *
     * Your secret dev API key
     *
     * @param {string} devkey
     *
     * @return this
     */
    fun setDevKey(value: String): Client {
        config["devKey"] = value
        addHeader("x-appwrite-dev-key", value)
        return this
    }

    /**
     * Set Cookie
     *
     * The user cookie to authenticate with. Used by SDKs that forward an incoming Cookie header in server-side runtimes.
     *
     * @param {string} cookie
     *
     * @return this
     */
    fun setCookie(value: String): Client {
        config["cookie"] = value
        addHeader("cookie", value)
        return this
    }

    /**
     * Set ImpersonateUserId
     *
     * Impersonate a user by ID
     *
     * @param {string} impersonateuserid
     *
     * @return this
     */
    fun setImpersonateUserId(value: String): Client {
        config["impersonateUserId"] = value
        addHeader("x-appwrite-impersonate-user-id", value)
        return this
    }

    /**
     * Set ImpersonateUserEmail
     *
     * Impersonate a user by email
     *
     * @param {string} impersonateuseremail
     *
     * @return this
     */
    fun setImpersonateUserEmail(value: String): Client {
        config["impersonateUserEmail"] = value
        addHeader("x-appwrite-impersonate-user-email", value)
        return this
    }

    /**
     * Set ImpersonateUserPhone
     *
     * Impersonate a user by phone
     *
     * @param {string} impersonateuserphone
     *
     * @return this
     */
    fun setImpersonateUserPhone(value: String): Client {
        config["impersonateUserPhone"] = value
        addHeader("x-appwrite-impersonate-user-phone", value)
        return this
    }

    /**
     * Set self Signed
     *
     * @param status
     *
     * @return this
     */
    fun setSelfSigned(status: Boolean): Client {
        selfSigned = status

        val builder = OkHttpClient()
            .newBuilder()
            .cookieJar(cookieJar)

        if (!selfSigned) {
            http = builder.build()
            return this
        }

        try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts = arrayOf<TrustManager>(
                @Suppress("CustomX509TrustManager")
                object : X509TrustManager {
                    @Suppress("TrustAllX509TrustManager")
                    override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
                    }
                    @Suppress("TrustAllX509TrustManager")
                    override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
                    }
                    override fun getAcceptedIssuers(): Array<X509Certificate> {
                        return arrayOf()
                    }
                }
            )
            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory: SSLSocketFactory = sslContext.socketFactory
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier { _, _ -> true }

            http = builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

        return this
    }

    /**
     * Set endpoint and realtime endpoint.
     *
     * @param endpoint
     *
     * @return this
     */
    @Throws(IllegalArgumentException::class)
    fun setEndpoint(endpoint: String): Client {
        require(endpoint.startsWith("http://") || endpoint.startsWith("https://")) {
            "Invalid endpoint URL: $endpoint"
        }

        this.endpoint = endpoint
        this.endpointRealtime = endpoint.replaceFirst("http", "ws")

        return this
    }

    /**
     * Set realtime endpoint
     *
     * @param endpoint
     *
     * @return this
     */
    @Throws(IllegalArgumentException::class)
    fun setEndpointRealtime(endpoint: String): Client {
        require(endpoint.startsWith("ws://") || endpoint.startsWith("wss://")) {
            "Invalid realtime endpoint URL: $endpoint"
        }

        this.endpointRealtime = endpoint
        return this
    }

    /**
     * Add Header
     *
     * @param key
     * @param value
     *
     * @return this
     */
    fun addHeader(key: String, value: String): Client {
        headers[key] = value
        return this
    }

    /**
     * Get the current request headers used for Appwrite API calls.
     *
     * @return a copy of the current request headers
     */
    fun getHeaders(): Map<String, String> = headers.toMap()

    /**
     * Get the cookies for a given URL from the SDK's cookie store.
     *
     * @param url the URL to retrieve cookies for
     * @return a list of cookies for the given URL
     */
    fun getCookies(url: String): List<Cookie> = cookieJar.loadForRequest(url.toHttpUrl())

    /**
     * Get the OkHttpClient instance used by this SDK.
     *
     * @return the OkHttpClient instance used by this client
     */
    fun getHttpClient(): OkHttpClient = http

    /**
     * Send a ping to project as part of onboarding.
     *
     * @return String
     */
    suspend fun ping(): String {
        val apiPath = "/ping"
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf(
            "X-Appwrite-Project" to config["project"].orEmpty(),
            "accept" to "application/json",
        )

        return call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = String::class.java
        )
    }

    /**
     * Send the HTTP request
     *
     * @param method
     * @param path
     * @param headers
     * @param params
     *
     * @return [T]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> call(
        method: String,
        path: String,
        headers:  Map<String, String> = mapOf(),
        params: Map<String, Any?> = mapOf(),
        responseType: Class<T>,
        converter: ((Any) -> T)? = null
    ): T {
        val filteredParams = params.filterValues { it != null }

        val requestHeaders = this.headers.toHeaders().newBuilder()
            .addAll(headers.toHeaders())
            .build()

        val httpBuilder = (endpoint + path).toHttpUrl().newBuilder()

        if ("GET" == method) {
            filteredParams.forEach {
                when (it.value) {
                    null -> {
                        return@forEach
                    }
                    is List<*> -> {
                        val list = it.value as List<*>
                        for (index in list.indices) {
                            httpBuilder.addQueryParameter(
                                "${it.key}[]",
                                list[index].toString()
                            )
                        }
                    }
                    else -> {
                        httpBuilder.addQueryParameter(it.key, it.value.toString())
                    }
                }
            }
            val request = Request.Builder()
                .url(httpBuilder.build())
                .headers(requestHeaders)
                .get()
                .build()

            return awaitResponse(request, responseType, converter)
        }

        val body = if (MultipartBody.FORM.toString() == headers["content-type"]) {
            val builder = MultipartBody.Builder().setType(MultipartBody.FORM)

            filteredParams.forEach {
                when {
                    it.key == "file" -> {
                        builder.addPart(it.value as MultipartBody.Part)
                    }
                    it.value is List<*> -> {
                        val list = it.value as List<*>
                        for (index in list.indices) {
                            builder.addFormDataPart(
                                "${it.key}[]",
                                list[index].toString()
                            )
                        }
                    }
                    else -> {
                        builder.addFormDataPart(it.key, it.value.toString())
                    }
                }
            }
            builder.build()
        } else {
            filteredParams
                .toJson()
                .toRequestBody("application/json".toMediaType())
        }

        val request = Request.Builder()
            .url(httpBuilder.build())
            .headers(requestHeaders)
            .method(method, body)
            .build()

        return awaitResponse(request, responseType, converter)
    }

    /**
     * Upload a file in chunks
     *
     * @param path
     * @param headers
     * @param params
     *
     * @return [T]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> chunkedUpload(
        path: String,
        headers:  MutableMap<String, String>,
        params: MutableMap<String, Any?>,
        responseType: Class<T>,
        converter: ((Any) -> T),
        paramName: String,
        idParamName: String? = null,
        onProgress: ((UploadProgress) -> Unit)? = null,
    ): T {
        val input = params[paramName] as InputFile
        val size: Long = when(input.sourceType) {
            "path", "file" -> {
                File(input.path).length()
            }
            "bytes" -> {
                (input.data as ByteArray).size.toLong()
            }
            else -> throw UnsupportedOperationException()
        }

        if (size < CHUNK_SIZE) {
            val data = when(input.sourceType) {
                "file", "path" -> File(input.path).asRequestBody()
                "bytes" -> (input.data as ByteArray).toRequestBody(input.mimeType.toMediaType())
                else -> throw UnsupportedOperationException()
            }
            params[paramName] = MultipartBody.Part.createFormData(
                paramName,
                input.filename,
                data
            )
            return call(
                method = "POST",
                path,
                headers,
                params,
                responseType,
                converter
            )
        }

        var offset = 0L
        var result: Map<*, *>? = null
        var uploadId: String? = null

        if (idParamName?.isNotEmpty() == true) {
            // Make a request to check if a file already exists
            val current = call(
                method = "GET",
                path = "$path/${params[idParamName]}",
                headers = headers,
                params = emptyMap(),
                responseType = Map::class.java,
            )
            val chunksUploaded = current["chunksUploaded"] as Long
            offset = chunksUploaded * CHUNK_SIZE
            uploadId = params[idParamName]?.toString()
            result = current
        }

        fun readChunk(start: Long, end: Long): ByteArray {
            val length = (end - start).toInt()
            return when(input.sourceType) {
                "file", "path" -> {
                    RandomAccessFile(input.path, "r").use { chunkFile ->
                        val chunk = ByteArray(length)
                        chunkFile.seek(start)
                        chunkFile.readFully(chunk)
                        chunk
                    }
                }
                "bytes" -> {
                    (input.data as ByteArray).copyOfRange(start.toInt(), end.toInt())
                }
                else -> throw UnsupportedOperationException()
            }
        }

        val totalChunks = (size + CHUNK_SIZE - 1) / CHUNK_SIZE

        fun isUploadComplete(chunkResult: Map<*, *>): Boolean {
            val chunksUploaded = chunkResult["chunksUploaded"]?.toString()?.toLongOrNull() ?: return false
            val chunksTotal = chunkResult["chunksTotal"]?.toString()?.toLongOrNull() ?: totalChunks
            return chunksUploaded >= chunksTotal
        }

        suspend fun uploadChunk(index: Int, start: Long, end: Long, includeUploadId: Boolean): Map<*, *> {
            val chunkParams = params.toMutableMap()
            val chunkHeaders = headers.toMutableMap()

            if (includeUploadId && uploadId != null) {
                chunkHeaders["x-appwrite-id"] = uploadId!!
            }

            chunkHeaders["Content-Range"] = "bytes $start-${end - 1}/$size"
            chunkParams[paramName] = MultipartBody.Part.createFormData(
                paramName,
                input.filename,
                readChunk(start, end).toRequestBody()
            )

            val chunkResult = call(
                method = "POST",
                path,
                chunkHeaders,
                chunkParams,
                responseType = Map::class.java
            )

            if (index == 0) {
                uploadId = chunkResult["\$id"].toString()
            }

            return chunkResult
        }

        if (offset == 0L) {
            val firstChunkEnd = CHUNK_SIZE.toLong().coerceAtMost(size)
            result = uploadChunk(0, 0, firstChunkEnd, false)
            offset = firstChunkEnd
            onProgress?.invoke(
                UploadProgress(
                    id = uploadId ?: result!!["\$id"].toString(),
                    progress = offset.coerceAtMost(size).toDouble() / size * 100,
                    sizeUploaded = offset.coerceAtMost(size),
                    chunksTotal = result!!["chunksTotal"].toString().toInt(),
                    chunksUploaded = result!!["chunksUploaded"].toString().toInt(),
                )
            )
        }

        val chunks = mutableListOf<Triple<Int, Long, Long>>()
        var chunkOffset = offset
        while (chunkOffset < size) {
            val end = (chunkOffset + CHUNK_SIZE).coerceAtMost(size)
            chunks.add(Triple((chunkOffset / CHUNK_SIZE).toInt(), chunkOffset, end))
            chunkOffset = end
        }

        if (chunks.isNotEmpty()) {
            val nextChunk = AtomicInteger(0)
            val completedChunks = AtomicInteger((offset / CHUNK_SIZE).toInt())
            val uploadedBytes = AtomicLong(offset.coerceAtMost(size))
            val completedResultRef = AtomicReference<Map<*, *>?>(null)
            val lastResultRef = AtomicReference(result)
            val progressLock = Any()

            coroutineScope {
                List(MAX_CONCURRENT_UPLOADS.coerceAtMost(chunks.size)) {
                    async {
                        while (true) {
                            val chunkIndex = nextChunk.getAndIncrement()
                            if (chunkIndex >= chunks.size) {
                                break
                            }

                            val (index, start, end) = chunks[chunkIndex]
                            val chunkResult = uploadChunk(index, start, end, true)

                            val chunksUploaded = completedChunks.incrementAndGet()
                            val sizeUploaded = uploadedBytes.addAndGet(end - start)

                            lastResultRef.set(chunkResult)
                            if (isUploadComplete(chunkResult)) {
                                completedResultRef.set(chunkResult)
                            }

                            synchronized(progressLock) {
                                onProgress?.invoke(
                                    UploadProgress(
                                        id = uploadId ?: chunkResult["\$id"].toString(),
                                        progress = sizeUploaded.coerceAtMost(size).toDouble() / size * 100,
                                        sizeUploaded = sizeUploaded.coerceAtMost(size),
                                        chunksTotal = chunkResult["chunksTotal"].toString().toInt(),
                                        chunksUploaded = chunksUploaded,
                                    )
                                )
                            }
                        }
                    }
                }.awaitAll()
            }
            result = completedResultRef.get() ?: lastResultRef.get()
        }

        return converter(result as Map<String, Any>)
    }

    /**
     * Await Response
     *
     * @param request
     * @param responseType
     * @param converter
     *
     * @return [T]
     */
    @Throws(AppwriteException::class)
    private suspend fun <T> awaitResponse(
        request: Request,
        responseType: Class<T>,
        converter: ((Any) -> T)? = null
    ) = suspendCancellableCoroutine<T> {
        http.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                if (it.isCancelled) {
                    return
                }
                it.cancel(e)
            }

            @Suppress("UNCHECKED_CAST")
            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    val body = response.body!!
                        .charStream()
                        .buffered()
                        .use(BufferedReader::readText)

                    val error = if (response.headers["content-type"]?.contains("application/json") == true) {
                        val map = body.fromJson<Map<String, Any>>()

                        AppwriteException(
                            map["message"] as? String ?: "",
                            (map["code"] as Number).toInt(),
                            map["type"] as? String ?: "",
                            body
                        )
                    } else {
                        AppwriteException(body, response.code, "", body)
                    }
                    it.cancel(error)
                    return
                }

                val warnings = response.headers["x-appwrite-warning"]
                if (warnings != null) {
                    warnings.split(";").forEach { warning ->
                        System.err.println("Warning: $warning")
                    }
                }

                when {
                    responseType == Boolean::class.java -> {
                        it.resume(true as T)
                        return
                    }
                    responseType == String::class.java -> {
                        val body = response.body!!
                            .charStream()
                            .buffered()
                            .use(BufferedReader::readText)
                        it.resume(body as T)
                        return
                    }
                    responseType == ByteArray::class.java -> {
                        it.resume(response.body!!
                            .byteStream()
                            .buffered()
                            .use(BufferedInputStream::readBytes) as T
                        )
                        return
                    }
                    response.body == null -> {
                        it.resume(true as T)
                        return
                    }
                }
                val body = response.body!!
                    .charStream()
                    .buffered()
                    .use(BufferedReader::readText)
                if (body.isEmpty()) {
                    it.resume(true as T)
                    return
                }

                val map = body.fromJson<Any>()

                it.resume(
                    converter?.invoke(map) ?: map as T
                )
            }
        })
    }
}
