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
class TablesDB(client: Client) : Service(client) {

    /**
     * List transactions across all databases.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries).
     * @return [io.appwrite.models.TransactionList]
     */
    @JvmOverloads
    suspend fun listTransactions(
        queries: List<String>? = null,
    ): io.appwrite.models.TransactionList {
        val apiPath = "/tablesdb/transactions"

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
     * Create a new transaction.
     *
     * @param ttl Seconds before the transaction expires.
     * @return [io.appwrite.models.Transaction]
     */
    @JvmOverloads
    suspend fun createTransaction(
        ttl: Long? = null,
    ): io.appwrite.models.Transaction {
        val apiPath = "/tablesdb/transactions"

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
     * Get a transaction by its unique ID.
     *
     * @param transactionId Transaction ID.
     * @return [io.appwrite.models.Transaction]
     */
    suspend fun getTransaction(
        transactionId: String,
    ): io.appwrite.models.Transaction {
        val apiPath = "/tablesdb/transactions/{transactionId}"
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
     * Update a transaction, to either commit or roll back its operations.
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
        val apiPath = "/tablesdb/transactions/{transactionId}"
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
     * Delete a transaction by its unique ID.
     *
     * @param transactionId Transaction ID.
     * @return [Any]
     */
    suspend fun deleteTransaction(
        transactionId: String,
    ): Any {
        val apiPath = "/tablesdb/transactions/{transactionId}"
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
     * Create multiple operations in a single transaction.
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
        val apiPath = "/tablesdb/transactions/{transactionId}/operations"
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
     * Get a list of all the user's rows in a given table. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the TablesDB service [server integration](https://appwrite.io/docs/products/databases/tables#create-table).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.RowList<T>]
     */
    @JvmOverloads
    suspend fun <T> listRows(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        total: Boolean? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.RowList<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "transactionId" to transactionId,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.RowList<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.RowList.from(map = it as Map<String, Any>, nestedType)
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
     * Get a list of all the user's rows in a given table. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the TablesDB service [server integration](https://appwrite.io/docs/products/databases/tables#create-table).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.RowList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listRows(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.RowList<Map<String, Any>> = listRows(
        databaseId,
        tableId,
        queries,
        transactionId,
        total,
        nestedType = classOf(),
    )

    /**
     * Create a new Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable). Make sure to define columns before creating rows.
     * @param rowId Row ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Row data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    suspend fun <T> createRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "rowId" to rowId,
            "data" to data,
            "permissions" to permissions,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Row<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Row.from(map = it as Map<String, Any>, nestedType)
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
     * Create a new Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable). Make sure to define columns before creating rows.
     * @param rowId Row ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Row data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = createRow(
        databaseId,
        tableId,
        rowId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Get a row by its unique ID. This endpoint response returns a JSON object with the row data.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param rowId Row ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    suspend fun <T> getRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Row<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Row.from(map = it as Map<String, Any>, nestedType)
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
     * Get a row by its unique ID. This endpoint response returns a JSON object with the row data.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param rowId Row ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = getRow(
        databaseId,
        tableId,
        rowId,
        queries,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Create or update a Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param data Row data as JSON object. Include all required columns of the row to be created or updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    suspend fun <T> upsertRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to data,
            "permissions" to permissions,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Row<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Row.from(map = it as Map<String, Any>, nestedType)
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
     * Create or update a Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param data Row data as JSON object. Include all required columns of the row to be created or updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun upsertRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = upsertRow(
        databaseId,
        tableId,
        rowId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Update a row by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param data Row data as JSON object. Include only columns and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    suspend fun <T> updateRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to data,
            "permissions" to permissions,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Row<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Row.from(map = it as Map<String, Any>, nestedType)
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
     * Update a row by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param data Row data as JSON object. Include only columns and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = updateRow(
        databaseId,
        tableId,
        rowId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Delete a row by its unique ID.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param rowId Row ID.
     * @param transactionId Transaction ID for staging the operation.
     * @return [Any]
     */
    @JvmOverloads
    suspend fun deleteRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        transactionId: String? = null,
    ): Any {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

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
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param column Column key.
     * @param value Value to increment the column by. The value must be a number.
     * @param min Minimum value for the column. If the current value is lesser than this value, an exception will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    suspend fun <T> decrementRowColumn(
        databaseId: String,
        tableId: String,
        rowId: String,
        column: String,
        value: Double? = null,
        min: Double? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}/{column}/decrement"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)
            .replace("{column}", column)

        val apiParams = mutableMapOf<String, Any?>(
            "value" to value,
            "min" to min,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Row<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Row.from(map = it as Map<String, Any>, nestedType)
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
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param column Column key.
     * @param value Value to increment the column by. The value must be a number.
     * @param min Minimum value for the column. If the current value is lesser than this value, an exception will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun decrementRowColumn(
        databaseId: String,
        tableId: String,
        rowId: String,
        column: String,
        value: Double? = null,
        min: Double? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = decrementRowColumn(
        databaseId,
        tableId,
        rowId,
        column,
        value,
        min,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Increment a specific column of a row by a given value.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param column Column key.
     * @param value Value to increment the column by. The value must be a number.
     * @param max Maximum value for the column. If the current value is greater than this value, an error will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    suspend fun <T> incrementRowColumn(
        databaseId: String,
        tableId: String,
        rowId: String,
        column: String,
        value: Double? = null,
        max: Double? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}/{column}/increment"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)
            .replace("{column}", column)

        val apiParams = mutableMapOf<String, Any?>(
            "value" to value,
            "max" to max,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Row<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Row.from(map = it as Map<String, Any>, nestedType)
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
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param column Column key.
     * @param value Value to increment the column by. The value must be a number.
     * @param max Maximum value for the column. If the current value is greater than this value, an error will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun incrementRowColumn(
        databaseId: String,
        tableId: String,
        rowId: String,
        column: String,
        value: Double? = null,
        max: Double? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = incrementRowColumn(
        databaseId,
        tableId,
        rowId,
        column,
        value,
        max,
        transactionId,
        nestedType = classOf(),
    )

}