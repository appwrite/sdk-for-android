package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Database(client: Client) : Service(client) {

    /**
     * List Documents
     *
     * Get a list of all the user documents. You can use the query params to
     * filter your results. On admin mode, this endpoint will return a list of all
     * of the project's documents. [Learn more about different API
     * modes](/docs/admin).
     *
     * @param collectionId Collection unique ID. You can create a new collection using the Database service [server integration](/docs/server/database#createCollection).
     * @param queries Array of query strings.
     * @param limit Maximum number of documents to return in response.  Use this value to manage pagination. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this param to manage pagination.
     * @param cursor ID of the document used as the starting point for the query, excluding the document itself. Should be used for efficient pagination when working with large sets of data.
     * @param cursorDirection Direction of the cursor.
     * @param orderAttributes Array of attributes used to sort results.
     * @param orderTypes Array of order directions for sorting attribtues. Possible values are DESC for descending order, or ASC for ascending order.
     * @return [io.appwrite.models.DocumentList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listDocuments(
		collectionId: String,
		queries: List<Any>? = null,
		limit: Long? = null,
		offset: Long? = null,
		cursor: String? = null,
		cursorDirection: String? = null,
		orderAttributes: List<Any>? = null,
		orderTypes: List<Any>? = null
	): io.appwrite.models.DocumentList {
        val path = "/database/collections/{collectionId}/documents".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "queries" to queries,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderAttributes" to orderAttributes,
            "orderTypes" to orderTypes
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.DocumentList = {
            io.appwrite.models.DocumentList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.DocumentList::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Document
     *
     * Create a new Document. Before using this route, you should create a new
     * collection resource using either a [server
     * integration](/docs/server/database#databaseCreateCollection) API or
     * directly from your database console.
     *
     * @param collectionId Collection unique ID. You can create a new collection with validation rules using the Database service [server integration](/docs/server/database#createCollection).
     * @param documentId Unique Id. Choose your own unique ID or pass the string `unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param read An array of strings with read permissions. By default only the current user is granted with read permissions. [learn more about permissions](/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default only the current user is granted with write permissions. [learn more about permissions](/docs/permissions) and get a full list of available permissions.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDocument(
		collectionId: String,
		documentId: String,
		data: Any,
		read: List<Any>? = null,
		write: List<Any>? = null
	): io.appwrite.models.Document {
        val path = "/database/collections/{collectionId}/documents".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "documentId" to documentId,
            "data" to data,
            "read" to read,
            "write" to write
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            convert = convert
        )
    }
    
    /**
     * Get Document
     *
     * Get a document by its unique ID. This endpoint response returns a JSON
     * object with the document data.
     *
     * @param collectionId Collection unique ID. You can create a new collection using the Database service [server integration](/docs/server/database#createCollection).
     * @param documentId Document unique ID.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getDocument(
		collectionId: String,
		documentId: String
	): io.appwrite.models.Document {
        val path = "/database/collections/{collectionId}/documents/{documentId}".replace("{collectionId}", collectionId).replace("{documentId}", documentId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            convert = convert
        )
    }
    
    /**
     * Update Document
     *
     * Update a document by its unique ID. Using the patch method you can pass
     * only specific fields that will get updated.
     *
     * @param collectionId Collection unique ID. You can create a new collection with validation rules using the Database service [server integration](/docs/server/database#createCollection).
     * @param documentId Document unique ID.
     * @param data Document data as JSON object.
     * @param read An array of strings with read permissions. By default inherits the existing read permissions. [learn more about permissions](/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default inherits the existing write permissions. [learn more about permissions](/docs/permissions) and get a full list of available permissions.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDocument(
		collectionId: String,
		documentId: String,
		data: Any,
		read: List<Any>? = null,
		write: List<Any>? = null
	): io.appwrite.models.Document {
        val path = "/database/collections/{collectionId}/documents/{documentId}".replace("{collectionId}", collectionId).replace("{documentId}", documentId)
        val params = mapOf<String, Any?>(
            "data" to data,
            "read" to read,
            "write" to write
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            convert = convert
        )
    }
    
    /**
     * Delete Document
     *
     * Delete a document by its unique ID. This endpoint deletes only the parent
     * documents, its attributes and relations to other documents. Child documents
     * **will not** be deleted.
     *
     * @param collectionId Collection unique ID. You can create a new collection using the Database service [server integration](/docs/server/database#createCollection).
     * @param documentId Document unique ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteDocument(
		collectionId: String,
		documentId: String
	): Any {
        val path = "/database/collections/{collectionId}/documents/{documentId}".replace("{collectionId}", collectionId).replace("{documentId}", documentId)
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
    
}