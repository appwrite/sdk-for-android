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
     * @param collectionId Collection unique ID. You can create a new collection with validation rules using the Database service [server integration](/docs/server/database#createCollection).
     * @param filters Array of filter strings. Each filter is constructed from a key name, comparison operator (=, !=, &gt;, &lt;, &lt;=, &gt;=) and a value. You can also use a dot (.) separator in attribute names to filter by child document attributes. Examples: &#039;name=John Doe&#039; or &#039;category.$id&gt;=5bed2d152c362&#039;.
     * @param limit Maximum number of documents to return in response.  Use this value to manage pagination. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this param to manage pagination.
     * @param orderField Document field that results will be sorted by.
     * @param orderType Order direction. Possible values are DESC for descending order, or ASC for ascending order.
     * @param orderCast Order field type casting. Possible values are int, string, date, time or datetime. The database will attempt to cast the order field to the value you pass here. The default value is a string.
     * @param search Search query. Enter any free text search. The database will try to find a match against all document attributes and children. Max length: 256 chars.
     * @return [io.appwrite.models.DocumentList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listDocuments(
		collectionId: String,
		filters: List<Any>? = null,
		limit: Long? = null,
		offset: Long? = null,
		orderField: String? = null,
		orderType: String? = null,
		orderCast: String? = null,
		search: String? = null
	): io.appwrite.models.DocumentList {
        val path = "/database/collections/{collectionId}/documents".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "filters" to filters,
            "limit" to limit,
            "offset" to offset,
            "orderField" to orderField,
            "orderType" to orderType,
            "orderCast" to orderCast,
            "search" to search
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
     * @param data Document data as JSON object.
     * @param read An array of strings with read permissions. By default only the current user is granted with read permissions. [learn more about permissions](/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default only the current user is granted with write permissions. [learn more about permissions](/docs/permissions) and get a full list of available permissions.
     * @param parentDocument Parent document unique ID. Use when you want your new document to be a child of a parent document.
     * @param parentProperty Parent document property name. Use when you want your new document to be a child of a parent document.
     * @param parentPropertyType Parent document property connection type. You can set this value to **assign**, **append** or **prepend**, default value is assign. Use when you want your new document to be a child of a parent document.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDocument(
		collectionId: String,
		data: Any,
		read: List<Any>? = null,
		write: List<Any>? = null,
		parentDocument: String? = null,
		parentProperty: String? = null,
		parentPropertyType: String? = null
	): io.appwrite.models.Document {
        val path = "/database/collections/{collectionId}/documents".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "data" to data,
            "read" to read,
            "write" to write,
            "parentDocument" to parentDocument,
            "parentProperty" to parentProperty,
            "parentPropertyType" to parentPropertyType
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
     * @param collectionId Collection unique ID. You can create a new collection with validation rules using the Database service [server integration](/docs/server/database#createCollection).
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
     * @param collectionId Collection unique ID. You can create a new collection with validation rules using the Database service [server integration](/docs/server/database#createCollection).
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