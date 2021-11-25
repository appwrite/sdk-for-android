package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Functions(client: Client) : Service(client) {

    /**
     * List Executions
     *
     * Get a list of all the current user function execution logs. You can use the
     * query params to filter your results. On admin mode, this endpoint will
     * return a list of all of the project's executions. [Learn more about
     * different API modes](/docs/admin).
     *
     * @param functionId Function unique ID.
     * @param limit Results limit value. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Results offset. The default value is 0. Use this param to manage pagination.
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param cursor ID of the execution used as the starting point for the query, excluding the execution itself. Should be used for efficient pagination when working with large sets of data.
     * @param cursorDirection Direction of the cursor.
     * @return [io.appwrite.models.ExecutionList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listExecutions(
		functionId: String,
		limit: Long? = null,
		offset: Long? = null,
		search: String? = null,
		cursor: String? = null,
		cursorDirection: String? = null
	): io.appwrite.models.ExecutionList {
        val path = "/functions/{functionId}/executions".replace("{functionId}", functionId)
        val params = mapOf<String, Any?>(
            "limit" to limit,
            "offset" to offset,
            "search" to search,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.ExecutionList = {
            io.appwrite.models.ExecutionList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.ExecutionList::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Execution
     *
     * Trigger a function execution. The returned object will return you the
     * current execution status. You can ping the `Get Execution` endpoint to get
     * updates on the current execution status. Once this endpoint is called, your
     * function execution process will start asynchronously.
     *
     * @param functionId Function unique ID.
     * @param data String of custom data to send to function.
     * @return [io.appwrite.models.Execution]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createExecution(
		functionId: String,
		data: String? = null
	): io.appwrite.models.Execution {
        val path = "/functions/{functionId}/executions".replace("{functionId}", functionId)
        val params = mapOf<String, Any?>(
            "data" to data
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Execution = {
            io.appwrite.models.Execution.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Execution::class.java,
            convert = convert
        )
    }
    
    /**
     * Get Execution
     *
     * Get a function execution log by its unique ID.
     *
     * @param functionId Function unique ID.
     * @param executionId Execution unique ID.
     * @return [io.appwrite.models.Execution]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getExecution(
		functionId: String,
		executionId: String
	): io.appwrite.models.Execution {
        val path = "/functions/{functionId}/executions/{executionId}".replace("{functionId}", functionId).replace("{executionId}", executionId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Execution = {
            io.appwrite.models.Execution.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Execution::class.java,
            convert = convert
        )
    }
    
}