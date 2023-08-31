package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import java.io.File

/**
 * The Storage service allows you to manage your project files.
**/
class Storage : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * List Files
     *
     * Get a list of all the user files. You can use the query params to filter your results.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, signature, mimeType, sizeOriginal, chunksTotal, chunksUploaded
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.FileList]
     */
    @JvmOverloads
    suspend fun listFiles(
        bucketId: String,
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.FileList {
        val apiPath = "/storage/buckets/{bucketId}/files"
            .replace("{bucketId}", bucketId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.FileList = {
            io.appwrite.models.FileList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.FileList::class.java,
            converter,
        )
    }


    /**
     * Create File
     *
     * Create a new file. Before using this route, you should create a new bucket resource using either a [server integration](/docs/server/storage#storageCreateBucket) API or directly from your Appwrite console.Larger files should be uploaded using multiple requests with the [content-range](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Range) header to send a partial request with a maximum supported chunk of `5MB`. The `content-range` header values should always be in bytes.When the first request is sent, the server will return the **File** object, and the subsequent part request must include the file&#039;s **id** in `x-appwrite-id` header to allow the server to know that the partial upload is for the existing file and not for a new one.If you&#039;re creating a new file using one of the Appwrite SDKs, all the chunking logic will be managed by the SDK internally.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param file Binary file. Appwrite SDKs provide helpers to handle file input. [Learn about file input](/docs/storage#file-input).
     * @param permissions An array of permission strings. By default, only the current user is granted all permissions. [Learn more about permissions](/docs/permissions).
     * @return [io.appwrite.models.File]
     */
    @JvmOverloads
    suspend fun createFile(
        bucketId: String,
        fileId: String,
        file: InputFile,
        permissions: List<String>? = null,
        onProgress: ((UploadProgress) -> Unit)? = null
    ): io.appwrite.models.File {
        val apiPath = "/storage/buckets/{bucketId}/files"
            .replace("{bucketId}", bucketId)

        val apiParams = mutableMapOf<String, Any?>(
            "fileId" to fileId,
            "file" to file,
            "permissions" to permissions,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "multipart/form-data",
        )
        val converter: (Any) -> io.appwrite.models.File = {
            io.appwrite.models.File.from(map = it as Map<String, Any>)
        }
        val idParamName: String? = "fileId"    
        val paramName = "file"
        return client.chunkedUpload(
            apiPath,
            apiHeaders,
            apiParams,
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
     * Get a file by its unique ID. This endpoint response returns a JSON object with the file metadata.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @return [io.appwrite.models.File]
     */
    suspend fun getFile(
        bucketId: String,
        fileId: String,
    ): io.appwrite.models.File {
        val apiPath = "/storage/buckets/{bucketId}/files/{fileId}"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.File = {
            io.appwrite.models.File.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.File::class.java,
            converter,
        )
    }


    /**
     * Update File
     *
     * Update a file by its unique ID. Only users with write permissions have access to update this resource.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File unique ID.
     * @param name Name of the file
     * @param permissions An array of permission string. By default, the current permissions are inherited. [Learn more about permissions](/docs/permissions).
     * @return [io.appwrite.models.File]
     */
    @JvmOverloads
    suspend fun updateFile(
        bucketId: String,
        fileId: String,
        name: String? = null,
        permissions: List<String>? = null,
    ): io.appwrite.models.File {
        val apiPath = "/storage/buckets/{bucketId}/files/{fileId}"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "permissions" to permissions,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.File = {
            io.appwrite.models.File.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.File::class.java,
            converter,
        )
    }


    /**
     * Delete File
     *
     * Delete a file by its unique ID. Only users with write permissions have access to delete this resource.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @return [Any]
     */
    suspend fun deleteFile(
        bucketId: String,
        fileId: String,
    ): Any {
        val apiPath = "/storage/buckets/{bucketId}/files/{fileId}"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }


    /**
     * Get File for Download
     *
     * Get a file content by its unique ID. The endpoint response return with a &#039;Content-Disposition: attachment&#039; header that tells the browser to start downloading the file to user downloads directory.
     *
     * @param bucketId Storage bucket ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @return [ByteArray]
     */
    suspend fun getFileDownload(
        bucketId: String,
        fileId: String,
    ): ByteArray {
        val apiPath = "/storage/buckets/{bucketId}/files/{fileId}/download"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)

        val apiParams = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        return client.call(
            "GET",
            apiPath,
            params = apiParams,
            responseType = ByteArray::class.java
        )
    }


    /**
     * Get File Preview
     *
     * Get a file preview image. Currently, this method supports preview for image files (jpg, png, and gif), other supported formats, like pdf, docs, slides, and spreadsheets, will return the file icon image. You can also pass query string arguments for cutting and resizing your preview image. Preview is supported only for image files smaller than 10MB.
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
        output: String? = null,
    ): ByteArray {
        val apiPath = "/storage/buckets/{bucketId}/files/{fileId}/preview"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)

        val apiParams = mutableMapOf<String, Any?>(
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
            "project" to client.config["project"],
        )
        return client.call(
            "GET",
            apiPath,
            params = apiParams,
            responseType = ByteArray::class.java
        )
    }


    /**
     * Get File for View
     *
     * Get a file content by its unique ID. This endpoint is similar to the download method but returns with no  &#039;Content-Disposition: attachment&#039; header.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @return [ByteArray]
     */
    suspend fun getFileView(
        bucketId: String,
        fileId: String,
    ): ByteArray {
        val apiPath = "/storage/buckets/{bucketId}/files/{fileId}/view"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)

        val apiParams = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        return client.call(
            "GET",
            apiPath,
            params = apiParams,
            responseType = ByteArray::class.java
        )
    }


}