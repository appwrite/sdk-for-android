package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * 
 */
class DocumentsDB(client: Client) : Service(client) {

    /**
     * 
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries).
     * @return [io.appwrite.models.TransactionList]
     */
    @JvmOverloads
    suspend fun listTransactions(
        queries: List<String>? = null,
    ): io.appwrite.models.TransactionList {
        val apiPath = "/documentsdb/transactions"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.TransactionList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.TransactionList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.TransactionList::class.java,
            converter,
        )
    }


    /**
     * 
     *
     * @param ttl Seconds before the transaction expires.
     * @return [io.appwrite.models.Transaction]
     */
    @JvmOverloads
    suspend fun createTransaction(
        ttl: Long? = null,
    ): io.appwrite.models.Transaction {
        val apiPath = "/documentsdb/transactions"

        val apiParams = mutableMapOf<String, Any?>(
            "ttl" to ttl,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Transaction = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Transaction.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Transaction::class.java,
            converter,
        )
    }


    /**
     * 
     *
     * @param transactionId Transaction ID.
     * @return [io.appwrite.models.Transaction]
     */
    suspend fun getTransaction(
        transactionId: String,
    ): io.appwrite.models.Transaction {
        val apiPath = "/documentsdb/transactions/{transactionId}"
            .replace("{transactionId}", transactionId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Transaction = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Transaction.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Transaction::class.java,
            converter,
        )
    }


    /**
     * 
     *
     * @param transactionId Transaction ID.
     * @param commit Commit transaction?
     * @param rollback Rollback transaction?
     * @return [io.appwrite.models.Transaction]
     */
    @JvmOverloads
    suspend fun updateTransaction(
        transactionId: String,
        commit: Boolean? = null,
        rollback: Boolean? = null,
    ): io.appwrite.models.Transaction {
        val apiPath = "/documentsdb/transactions/{transactionId}"
            .replace("{transactionId}", transactionId)

        val apiParams = mutableMapOf<String, Any?>(
            "commit" to commit,
            "rollback" to rollback,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Transaction = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Transaction.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Transaction::class.java,
            converter,
        )
    }


    /**
     * 
     *
     * @param transactionId Transaction ID.
     * @return [Any]
     */
    suspend fun deleteTransaction(
        transactionId: String,
    ): Any {
        val apiPath = "/documentsdb/transactions/{transactionId}"
            .replace("{transactionId}", transactionId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
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
     * 
     *
     * @param transactionId Transaction ID.
     * @param operations Array of staged operations.
     * @return [io.appwrite.models.Transaction]
     */
    @JvmOverloads
    suspend fun createOperations(
        transactionId: String,
        operations: List<Any>? = null,
    ): io.appwrite.models.Transaction {
        val apiPath = "/documentsdb/transactions/{transactionId}/operations"
            .replace("{transactionId}", transactionId)

        val apiParams = mutableMapOf<String, Any?>(
            "operations" to operations,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Transaction = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Transaction.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Transaction::class.java,
            converter,
        )
    }


    /**
     * Get a list of all the user's documents in a given collection. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @param ttl TTL (seconds) for cached responses when caching is enabled for select queries. Must be between 0 and 86400 (24 hours).
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @JvmOverloads
    suspend fun <T> listDocuments(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        total: Boolean? = null,
        ttl: Long? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.DocumentList<T> {
        val apiPath = "/documentsdb/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "transactionId" to transactionId,
            "total" to total,
            "ttl" to ttl,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.DocumentList<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.DocumentList.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Get a list of all the user's documents in a given collection. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @param ttl TTL (seconds) for cached responses when caching is enabled for select queries. Must be between 0 and 86400 (24 hours).
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listDocuments(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        total: Boolean? = null,
        ttl: Long? = null,
    ): io.appwrite.models.DocumentList<Map<String, Any>> = listDocuments(
        databaseId,
        collectionId,
        queries,
        transactionId,
        total,
        ttl,
        nestedType = classOf(),
    )

    /**
     * Create a new Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#documentsDBCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documentId Document ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    suspend fun <T> createDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any,
        permissions: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/documentsdb/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "documentId" to documentId,
            "data" to data,
            "permissions" to permissions,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Document<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Document.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create a new Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#documentsDBCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documentId Document ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any,
        permissions: List<String>? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = createDocument(
        databaseId,
        collectionId,
        documentId,
        data,
        permissions,
        nestedType = classOf(),
    )

    /**
     * Create new Documents. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#documentsDBCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documents Array of documents data as JSON objects.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    suspend fun <T> createDocuments(
        databaseId: String,
        collectionId: String,
        documents: List<Any>,
        nestedType: Class<T>,
    ): io.appwrite.models.DocumentList<T> {
        val apiPath = "/documentsdb/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "documents" to documents,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DocumentList<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.DocumentList.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create new Documents. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#documentsDBCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documents Array of documents data as JSON objects.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun createDocuments(
        databaseId: String,
        collectionId: String,
        documents: List<Any>,
    ): io.appwrite.models.DocumentList<Map<String, Any>> = createDocuments(
        databaseId,
        collectionId,
        documents,
        nestedType = classOf(),
    )

    /**
     * Get a document by its unique ID. This endpoint response returns a JSON object with the document data.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    suspend fun <T> getDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/documentsdb/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Document<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Document.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Get a document by its unique ID. This endpoint response returns a JSON object with the document data.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = getDocument(
        databaseId,
        collectionId,
        documentId,
        queries,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Create or update a Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#documentsDBCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include all required fields of the document to be created or updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    suspend fun <T> upsertDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/documentsdb/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to data,
            "permissions" to permissions,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Document<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Document.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create or update a Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#documentsDBCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include all required fields of the document to be created or updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun upsertDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = upsertDocument(
        databaseId,
        collectionId,
        documentId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Update a document by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include only fields and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    suspend fun <T> updateDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/documentsdb/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to data,
            "permissions" to permissions,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Document<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Document.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update a document by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include only fields and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = updateDocument(
        databaseId,
        collectionId,
        documentId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Delete a document by its unique ID.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @param transactionId Transaction ID for staging the operation.
     * @return [Any]
     */
    @JvmOverloads
    suspend fun deleteDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        transactionId: String? = null,
    ): Any {
        val apiPath = "/documentsdb/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val apiParams = mutableMapOf<String, Any?>(
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
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
     * Decrement a specific column of a row by a given value.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param attribute Attribute key.
     * @param value Value to decrement the attribute by. The value must be a number.
     * @param min Minimum value for the attribute. If the current value is lesser than this value, an exception will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    suspend fun <T> decrementDocumentAttribute(
        databaseId: String,
        collectionId: String,
        documentId: String,
        attribute: String,
        value: Double? = null,
        min: Double? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/documentsdb/{databaseId}/collections/{collectionId}/documents/{documentId}/{attribute}/decrement"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)
            .replace("{attribute}", attribute)

        val apiParams = mutableMapOf<String, Any?>(
            "value" to value,
            "min" to min,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Document<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Document.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Decrement a specific column of a row by a given value.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param attribute Attribute key.
     * @param value Value to decrement the attribute by. The value must be a number.
     * @param min Minimum value for the attribute. If the current value is lesser than this value, an exception will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun decrementDocumentAttribute(
        databaseId: String,
        collectionId: String,
        documentId: String,
        attribute: String,
        value: Double? = null,
        min: Double? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = decrementDocumentAttribute(
        databaseId,
        collectionId,
        documentId,
        attribute,
        value,
        min,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Increment a specific column of a row by a given value.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param attribute Attribute key.
     * @param value Value to increment the attribute by. The value must be a number.
     * @param max Maximum value for the attribute. If the current value is greater than this value, an error will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    suspend fun <T> incrementDocumentAttribute(
        databaseId: String,
        collectionId: String,
        documentId: String,
        attribute: String,
        value: Double? = null,
        max: Double? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/documentsdb/{databaseId}/collections/{collectionId}/documents/{documentId}/{attribute}/increment"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)
            .replace("{attribute}", attribute)

        val apiParams = mutableMapOf<String, Any?>(
            "value" to value,
            "max" to max,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Document<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Document.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Increment a specific column of a row by a given value.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param attribute Attribute key.
     * @param value Value to increment the attribute by. The value must be a number.
     * @param max Maximum value for the attribute. If the current value is greater than this value, an error will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun incrementDocumentAttribute(
        databaseId: String,
        collectionId: String,
        documentId: String,
        attribute: String,
        value: Double? = null,
        max: Double? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = incrementDocumentAttribute(
        databaseId,
        collectionId,
        documentId,
        attribute,
        value,
        max,
        transactionId,
        nestedType = classOf(),
    )

}