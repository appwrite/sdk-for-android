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
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param limit Results limit value. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Results offset. The default value is 0. Use this param to manage pagination.
     * @param cursor ID of the file used as the starting point for the query, excluding the file itself. Should be used for efficient pagination when working with large sets of data.
     * @param cursorDirection Direction of the cursor.
     * @param orderType Order result by ASC or DESC order.
     * @return [io.appwrite.models.FileList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listFiles(
		search: String? = null,
		limit: Long? = null,
		offset: Long? = null,
		cursor: String? = null,
		cursorDirection: String? = null,
		orderType: String? = null
	): io.appwrite.models.FileList {
        val path = "/storage/files"
        val params = mapOf<String, Any?>(
            "search" to search,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderType" to orderType
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.FileList = {
            io.appwrite.models.FileList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.FileList::class.java,
            convert = convert
        )
    }
    
    /**
     * Create File
     *
     * Create a new file. The user who creates the file will automatically be
     * assigned to read and write access unless he has passed custom values for
     * read and write arguments.
     *
     * @param fileId Unique Id. Choose your own unique ID or pass the string `unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param file Binary file.
     * @param read An array of strings with read permissions. By default only the current user is granted with read permissions. [learn more about permissions](/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default only the current user is granted with write permissions. [learn more about permissions](/docs/permissions) and get a full list of available permissions.
     * @return [io.appwrite.models.File]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createFile(
		fileId: String,
		file: File,
		read: List<Any>? = null,
		write: List<Any>? = null
	): io.appwrite.models.File {
        val path = "/storage/files"
        val params = mapOf<String, Any?>(
            "fileId" to fileId,
            "file" to file,
            "read" to read,
            "write" to write
        )
        val headers = mapOf(
            "content-type" to "multipart/form-data"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.File = {
            io.appwrite.models.File.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.File::class.java,
            convert = convert
        )
    }
    
    /**
     * Get File
     *
     * Get a file by its unique ID. This endpoint response returns a JSON object
     * with the file metadata.
     *
     * @param fileId File unique ID.
     * @return [io.appwrite.models.File]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFile(
		fileId: String
	): io.appwrite.models.File {
        val path = "/storage/files/{fileId}".replace("{fileId}", fileId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.File = {
            io.appwrite.models.File.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.File::class.java,
            convert = convert
        )
    }
    
    /**
     * Update File
     *
     * Update a file by its unique ID. Only users with write permissions have
     * access to update this resource.
     *
     * @param fileId File unique ID.
     * @param read An array of strings with read permissions. By default no user is granted with any read permissions. [learn more about permissions](/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default no user is granted with any write permissions. [learn more about permissions](/docs/permissions) and get a full list of available permissions.
     * @return [io.appwrite.models.File]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateFile(
		fileId: String,
		read: List<Any>,
		write: List<Any>
	): io.appwrite.models.File {
        val path = "/storage/files/{fileId}".replace("{fileId}", fileId)
        val params = mapOf<String, Any?>(
            "read" to read,
            "write" to write
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.File = {
            io.appwrite.models.File.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.File::class.java,
            convert = convert
        )
    }
    
    /**
     * Delete File
     *
     * Delete a file by its unique ID. Only users with write permissions have
     * access to delete this resource.
     *
     * @param fileId File unique ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteFile(
		fileId: String
	): Any {
        val path = "/storage/files/{fileId}".replace("{fileId}", fileId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
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
     * @param fileId File unique ID.
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFileDownload(
		fileId: String
	): ByteArray {
        val path = "/storage/files/{fileId}/download".replace("{fileId}", fileId)
        val params = mapOf<String, Any?>(
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
     * string arguments for cutting and resizing your preview image.
     *
     * @param fileId File unique ID
     * @param width Resize preview image width, Pass an integer between 0 to 4000.
     * @param height Resize preview image height, Pass an integer between 0 to 4000.
     * @param gravity Image crop gravity. Can be one of center,top-left,top,top-right,left,right,bottom-left,bottom,bottom-right
     * @param quality Preview image quality. Pass an integer between 0 to 100. Defaults to 100.
     * @param borderWidth Preview image border in pixels. Pass an integer between 0 to 100. Defaults to 0.
     * @param borderColor Preview image border color. Use a valid HEX color, no # is needed for prefix.
     * @param borderRadius Preview image border radius in pixels. Pass an integer between 0 to 4000.
     * @param opacity Preview image opacity. Only works with images having an alpha channel (like png). Pass a number between 0 to 1.
     * @param rotation Preview image rotation in degrees. Pass an integer between 0 and 360.
     * @param background Preview image background color. Only works with transparent images (png). Use a valid HEX color, no # is needed for prefix.
     * @param output Output format type (jpeg, jpg, png, gif and webp).
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFilePreview(
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
        val path = "/storage/files/{fileId}/preview".replace("{fileId}", fileId)
        val params = mapOf<String, Any?>(
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
     * @param fileId File unique ID.
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFileView(
		fileId: String
	): ByteArray {
        val path = "/storage/files/{fileId}/view".replace("{fileId}", fileId)
        val params = mapOf<String, Any?>(
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