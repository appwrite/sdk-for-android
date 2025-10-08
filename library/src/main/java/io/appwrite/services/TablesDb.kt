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
     * Get a list of all the user's rows in a given table. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the TablesDB service [server integration](https://appwrite.io/docs/products/databases/tables#create-table).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.RowList<T>]
     */
    @JvmOverloads
    suspend fun <T> listRows(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.RowList<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
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
     * @return [io.appwrite.models.RowList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listRows(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.RowList<Map<String, Any>> = listRows(
        databaseId,
        tableId,
        queries,
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
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    suspend fun <T> createRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any,
        permissions: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "rowId" to rowId,
            "data" to data,
            "permissions" to permissions,
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
    ): io.appwrite.models.Row<Map<String, Any>> = createRow(
        databaseId,
        tableId,
        rowId,
        data,
        permissions,
        nestedType = classOf(),
    )

    /**
     * Get a row by its unique ID. This endpoint response returns a JSON object with the row data.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param rowId Row ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    suspend fun <T> getRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        queries: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
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
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = getRow(
        databaseId,
        tableId,
        rowId,
        queries,
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
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    suspend fun <T> upsertRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to data,
            "permissions" to permissions,
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
    ): io.appwrite.models.Row<Map<String, Any>> = upsertRow(
        databaseId,
        tableId,
        rowId,
        data,
        permissions,
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
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    suspend fun <T> updateRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to data,
            "permissions" to permissions,
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
    ): io.appwrite.models.Row<Map<String, Any>> = updateRow(
        databaseId,
        tableId,
        rowId,
        data,
        permissions,
        nestedType = classOf(),
    )

    /**
     * Delete a row by its unique ID.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param rowId Row ID.
     * @return [Any]
     */
    suspend fun deleteRow(
        databaseId: String,
        tableId: String,
        rowId: String,
    ): Any {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

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
     * Decrement a specific column of a row by a given value.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param column Column key.
     * @param value Value to increment the column by. The value must be a number.
     * @param min Minimum value for the column. If the current value is lesser than this value, an exception will be thrown.
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
    ): io.appwrite.models.Row<Map<String, Any>> = decrementRowColumn(
        databaseId,
        tableId,
        rowId,
        column,
        value,
        min,
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
    ): io.appwrite.models.Row<Map<String, Any>> = incrementRowColumn(
        databaseId,
        tableId,
        rowId,
        column,
        value,
        max,
        nestedType = classOf(),
    )

}