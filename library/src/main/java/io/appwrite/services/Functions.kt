package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Functions : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * Retry Build
     *
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @param buildId Build unique ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun retryBuild(
		functionId: String,
		deploymentId: String,
		buildId: String
	): Any {
        val path = "/functions/{functionId}/deployments/{deploymentId}/builds/{buildId}".replace("{functionId}", functionId).replace("{deploymentId}", deploymentId).replace("{buildId}", buildId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * List Executions
     *
     * Get a list of all the current user function execution logs. You can use the
     * query params to filter your results. On admin mode, this endpoint will
     * return a list of all of the project's executions. [Learn more about
     * different API modes](/docs/admin).
     *
     * @param functionId Function ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: trigger, status, statusCode, duration
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.ExecutionList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listExecutions(
		functionId: String,
		queries: List<String>? = null,
		search: String? = null
	): io.appwrite.models.ExecutionList {
        val path = "/functions/{functionId}/executions".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.ExecutionList = {
            io.appwrite.models.ExecutionList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.ExecutionList::class.java,
            converter,
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
     * @param functionId Function ID.
     * @param data String of custom data to send to function.
     * @param async Execute code in the background. Default value is false.
     * @return [io.appwrite.models.Execution]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createExecution(
		functionId: String,
		data: String? = null,
		async: Boolean? = null
	): io.appwrite.models.Execution {
        val path = "/functions/{functionId}/executions".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
            "data" to data,
            "async" to async
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Execution = {
            io.appwrite.models.Execution.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Execution::class.java,
            converter,
        )
    }
    
    /**
     * Get Execution
     *
     * Get a function execution log by its unique ID.
     *
     * @param functionId Function ID.
     * @param executionId Execution ID.
     * @return [io.appwrite.models.Execution]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getExecution(
		functionId: String,
		executionId: String
	): io.appwrite.models.Execution {
        val path = "/functions/{functionId}/executions/{executionId}".replace("{functionId}", functionId).replace("{executionId}", executionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Execution = {
            io.appwrite.models.Execution.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Execution::class.java,
            converter,
        )
    }
    
}