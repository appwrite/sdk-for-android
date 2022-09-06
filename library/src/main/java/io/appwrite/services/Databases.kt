package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Databases : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * List Documents
     *
     * Get a list of all the user's documents in a given collection. You can use
     * the query params to filter your results. On admin mode, this endpoint will
     * return a list of all of documents belonging to the provided collectionId.
     * [Learn more about different API modes](/docs/admin).
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.DocumentList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listDocuments(
		databaseId: String,
		collectionId: String,
		queries: List<String>? = null
	): io.appwrite.models.DocumentList {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "queries" to queries
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
     * Create a new Document. Before using this route, you should create a new
     * collection resource using either a [server
     * integration](/docs/server/databases#databasesCreateCollection) API or
     * directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documentId Document ID. Choose your own unique ID or pass the string "unique()" to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param permissions An array of permissions strings. By default the current user is granted with all permissions. [Learn more about permissions](/docs/permissions).
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDocument(
		databaseId: String,
		collectionId: String,
		documentId: String,
		data: Any,
		permissions: List<String>? = null
	): io.appwrite.models.Document {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "documentId" to documentId,
            "data" to data,
            "permissions" to permissions
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
     * Get a document by its unique ID. This endpoint response returns a JSON
     * object with the document data.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getDocument(
		databaseId: String,
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
     * Update a document by its unique ID. Using the patch method you can pass
     * only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param permissions An array of permissions strings. By default the current permissions are inherited. [Learn more about permissions](/docs/permissions).
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDocument(
		databaseId: String,
		collectionId: String,
		documentId: String,
		data: Any? = null,
		permissions: List<String>? = null
	): io.appwrite.models.Document {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{documentId}", documentId)
        val params = mutableMapOf<String, Any?>(
            "data" to data,
            "permissions" to permissions
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
     * Delete a document by its unique ID.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteDocument(
		databaseId: String,
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