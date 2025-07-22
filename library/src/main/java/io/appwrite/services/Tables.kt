package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Tables service allows you to create structured tables of rows, query and filter lists of rows
**/
class Tables(client: Client) : Service(client) {

    /**
     * Get a list of all the user&#039;s rows in a given table. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
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
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows"
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
     * Get a list of all the user&#039;s rows in a given table. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
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
     * Create a new Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate). Make sure to define columns before creating rows.
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
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows"
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
     * Create a new Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate). Make sure to define columns before creating rows.
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
     * Create new Rows. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate). Make sure to define columns before creating rows.
     * @param rows Array of documents data as JSON objects.
     * @return [io.appwrite.models.RowList<T>]
     */
    suspend fun <T> createRows(
        databaseId: String,
        tableId: String,
        rows: List<Any>,
        nestedType: Class<T>,
    ): io.appwrite.models.RowList<T> {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "rows" to rows,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.RowList<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.RowList.from(map = it as Map<String, Any>, nestedType)
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
     * Create new Rows. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate). Make sure to define columns before creating rows.
     * @param rows Array of documents data as JSON objects.
     * @return [io.appwrite.models.RowList<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun createRows(
        databaseId: String,
        tableId: String,
        rows: List<Any>,
    ): io.appwrite.models.RowList<Map<String, Any>> = createRows(
        databaseId,
        tableId,
        rows,
        nestedType = classOf(),
    )

    /**
     * Get a row by its unique ID. This endpoint response returns a JSON object with the row data.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
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
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows/{rowId}"
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
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
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
     * Create or update a Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @return [io.appwrite.models.Row<T>]
     */
    suspend fun <T> upsertRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

        val apiParams = mutableMapOf<String, Any?>(
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
     * Create or update a Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @return [io.appwrite.models.Row<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun upsertRow(
        databaseId: String,
        tableId: String,
        rowId: String,
    ): io.appwrite.models.Row<Map<String, Any>> = upsertRow(
        databaseId,
        tableId,
        rowId,
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
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows/{rowId}"
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
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param rowId Row ID.
     * @return [Any]
     */
    suspend fun deleteRow(
        databaseId: String,
        tableId: String,
        rowId: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows/{rowId}"
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


}