package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import java.io.File

class Storage(client: Client) : Service(client) {

    /**
     * List Files
     *
     * Get a list of all the user files. You can use the query params to filter
     * your results. On admin mode, this endpoint will return a list of all of the
     * project's files. [Learn more about different API modes](/docs/admin).
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param limit Maximum number of files to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this param to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursor ID of the file used as the starting point for the query, excluding the file itself. Should be used for efficient pagination when working with large sets of data. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursorDirection Direction of the cursor.
     * @param orderType Order result by ASC or DESC order.
     * @return [io.appwrite.models.FileList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listFiles(
		bucketId: String,
		search: String? = null,
		limit: Long? = null,
		offset: Long? = null,
		cursor: String? = null,
		cursorDirection: String? = null,
		orderType: String? = null
	): io.appwrite.models.FileList {
        val path = "/storage/buckets/{bucketId}/files".replace("{bucketId}", bucketId)
        val params = mutableMapOf<String, Any?>(
            "search" to search,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderType" to orderType
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.FileList = {
            io.appwrite.models.FileList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.FileList::class.java,
            converter,
        )
    }
    
    /**
     * Create File
     *
     * Create a new file. Before using this route, you should create a new bucket
     * resource using either a [server
     * integration](/docs/server/database#storageCreateBucket) API or directly
     * from your Appwrite console.
     * 
     * Larger files should be uploaded using multiple requests with the
     * [content-range](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Range)
     * header to send a partial request with a maximum supported chunk of `5MB`.
     * The `content-range` header values should always be in bytes.
     * 
     * When the first request is sent, the server will return the **File** object,
     * and the subsequent part request must include the file's **id** in
     * `x-appwrite-id` header to allow the server to know that the partial upload
     * is for the existing file and not for a new one.
     * 
     * If you're creating a new file using one of the Appwrite SDKs, all the
     * chunking logic will be managed by the SDK internally.
     * 
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID. Choose your own unique ID or pass the string &quot;unique()&quot; to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param file Binary file.
     * @param read An array of strings with read permissions. By default only the current user is granted with read permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default only the current user is granted with write permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @return [io.appwrite.models.File]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createFile(
		bucketId: String,
		fileId: String,
		file: File,
		read: List<Any>? = null,
		write: List<Any>? = null, onProgress: ((UploadProgress) -> Unit)? = null
	): io.appwrite.models.File {
        val path = "/storage/buckets/{bucketId}/files".replace("{bucketId}", bucketId)
        val params = mutableMapOf<String, Any?>(
            "fileId" to fileId,
            "file" to file,
            "read" to read,
            "write" to write
        )
        val headers = mutableMapOf(
            "content-type" to "multipart/form-data"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.File = {
            io.appwrite.models.File.from(map = it)
        }
        val idParamName: String? = "fileId"    
        idParamName = "fileId"
        val paramName = "file"
        return client.chunkedUpload(
            path,
            headers,
            params,
            responseType = io.appwrite.models.File::class.java,
            converter,
            paramName,
            idParamName,
            onProgress,
        )
    }
    
    /**
     * Get File
     *
     * Get a file by its unique ID. This endpoint response returns a JSON object
     * with the file metadata.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @return [io.appwrite.models.File]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFile(
		bucketId: String,
		fileId: String
	): io.appwrite.models.File {
        val path = "/storage/buckets/{bucketId}/files/{fileId}".replace("{bucketId}", bucketId).replace("{fileId}", fileId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.File = {
            io.appwrite.models.File.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.File::class.java,
            converter,
        )
    }
    
    /**
     * Update File
     *
     * Update a file by its unique ID. Only users with write permissions have
     * access to update this resource.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File unique ID.
     * @param read An array of strings with read permissions. By default no user is granted with any read permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default no user is granted with any write permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @return [io.appwrite.models.File]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateFile(
		bucketId: String,
		fileId: String,
		read: List<Any>? = null,
		write: List<Any>? = null
	): io.appwrite.models.File {
        val path = "/storage/buckets/{bucketId}/files/{fileId}".replace("{bucketId}", bucketId).replace("{fileId}", fileId)
        val params = mutableMapOf<String, Any?>(
            "read" to read,
            "write" to write
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.File = {
            io.appwrite.models.File.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.File::class.java,
            converter,
        )
    }
    
    /**
     * Delete File
     *
     * Delete a file by its unique ID. Only users with write permissions have
     * access to delete this resource.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteFile(
		bucketId: String,
		fileId: String
	): Any {
        val path = "/storage/buckets/{bucketId}/files/{fileId}".replace("{bucketId}", bucketId).replace("{fileId}", fileId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Get File for Download
     *
     * Get a file content by its unique ID. The endpoint response return with a
     * 'Content-Disposition: attachment' header that tells the browser to start
     * downloading the file to user downloads directory.
     *
     * @param bucketId Storage bucket ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFileDownload(
		bucketId: String,
		fileId: String
	): ByteArray {
        val path = "/storage/buckets/{bucketId}/files/{fileId}/download".replace("{bucketId}", bucketId).replace("{fileId}", fileId)
        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            path,
            params = params,
            responseType = ByteArray::class.java
        )
    }
    
    /**
     * Get File Preview
     *
     * Get a file preview image. Currently, this method supports preview for image
     * files (jpg, png, and gif), other supported formats, like pdf, docs, slides,
     * and spreadsheets, will return the file icon image. You can also pass query
     * string arguments for cutting and resizing your preview image. Preview is
     * supported only for image files smaller than 10MB.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID
     * @param width Resize preview image width, Pass an integer between 0 to 4000.
     * @param height Resize preview image height, Pass an integer between 0 to 4000.
     * @param gravity Image crop gravity. Can be one of center,top-left,top,top-right,left,right,bottom-left,bottom,bottom-right
     * @param quality Preview image quality. Pass an integer between 0 to 100. Defaults to 100.
     * @param borderWidth Preview image border in pixels. Pass an integer between 0 to 100. Defaults to 0.
     * @param borderColor Preview image border color. Use a valid HEX color, no # is needed for prefix.
     * @param borderRadius Preview image border radius in pixels. Pass an integer between 0 to 4000.
     * @param opacity Preview image opacity. Only works with images having an alpha channel (like png). Pass a number between 0 to 1.
     * @param rotation Preview image rotation in degrees. Pass an integer between -360 and 360.
     * @param background Preview image background color. Only works with transparent images (png). Use a valid HEX color, no # is needed for prefix.
     * @param output Output format type (jpeg, jpg, png, gif and webp).
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFilePreview(
		bucketId: String,
		fileId: String,
		width: Long? = null,
		height: Long? = null,
		gravity: String? = null,
		quality: Long? = null,
		borderWidth: Long? = null,
		borderColor: String? = null,
		borderRadius: Long? = null,
		opacity: Double? = null,
		rotation: Long? = null,
		background: String? = null,
		output: String? = null
	): ByteArray {
        val path = "/storage/buckets/{bucketId}/files/{fileId}/preview".replace("{bucketId}", bucketId).replace("{fileId}", fileId)
        val params = mutableMapOf<String, Any?>(
            "width" to width,
            "height" to height,
            "gravity" to gravity,
            "quality" to quality,
            "borderWidth" to borderWidth,
            "borderColor" to borderColor,
            "borderRadius" to borderRadius,
            "opacity" to opacity,
            "rotation" to rotation,
            "background" to background,
            "output" to output,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            path,
            params = params,
            responseType = ByteArray::class.java
        )
    }
    
    /**
     * Get File for View
     *
     * Get a file content by its unique ID. This endpoint is similar to the
     * download method but returns with no  'Content-Disposition: attachment'
     * header.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFileView(
		bucketId: String,
		fileId: String
	): ByteArray {
        val path = "/storage/buckets/{bucketId}/files/{fileId}/view".replace("{bucketId}", bucketId).replace("{fileId}", fileId)
        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            path,
            params = params,
            responseType = ByteArray::class.java
        )
    }
    
}