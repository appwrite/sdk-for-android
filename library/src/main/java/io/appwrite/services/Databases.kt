package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Databases : Service {

    val databaseId: String

    public constructor(client: Client, databaseId: String) : super(client) {
        this.databaseId = databaseId
    }

    /**
     * List Documents
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/database#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param limit Maximum number of documents to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this value to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursor ID of the document used as the starting point for the query, excluding the document itself. Should be used for efficient pagination when working with large sets of data. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursorDirection Direction of the cursor, can be either &#039;before&#039; or &#039;after&#039;.
     * @param orderAttributes Array of attributes used to sort results. Maximum of 100 order attributes are allowed, each 4096 characters long.
     * @param orderTypes Array of order directions for sorting attribtues. Possible values are DESC for descending order, or ASC for ascending order. Maximum of 100 order types are allowed.
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
        val path = "/databases/{databaseId}/collections/{collectionId}/documents".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderAttributes" to orderAttributes,
            "orderTypes" to orderTypes
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.DocumentList = {
            io.appwrite.models.DocumentList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.DocumentList::class.java,
            converter,
        )
    }
    
    /**
     * Create Document
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection). Make sure to define attributes before creating documents.
     * @param documentId Document ID. Choose your own unique ID or pass the string &quot;unique()&quot; to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param read An array of strings with read permissions. By default only the current user is granted with read permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default only the current user is granted with write permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
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
        val path = "/databases/{databaseId}/collections/{collectionId}/documents".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "documentId" to documentId,
            "data" to data,
            "read" to read,
            "write" to write
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            converter,
        )
    }
    
    /**
     * Get Document
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param documentId Document ID.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getDocument(
		collectionId: String,
		documentId: String
	): io.appwrite.models.Document {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{documentId}", documentId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            converter,
        )
    }
    
    /**
     * Update Document
     *
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param read An array of strings with read permissions. By default inherits the existing read permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default inherits the existing write permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDocument(
		collectionId: String,
		documentId: String,
		data: Any? = null,
		read: List<Any>? = null,
		write: List<Any>? = null
	): io.appwrite.models.Document {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{documentId}", documentId)
        val params = mutableMapOf<String, Any?>(
            "data" to data,
            "read" to read,
            "write" to write
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            converter,
        )
    }
    
    /**
     * Delete Document
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param documentId Document ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteDocument(
		collectionId: String,
		documentId: String
	): Any {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{documentId}", documentId)
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
    
}