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
 * The Functions Service allows you view, create and manage your Cloud Functions.
 */
class Functions(client: Client) : Service(client) {

    /**
     * Get a list of all the current user function execution logs. You can use the query params to filter your results.
     *
     * @param functionId Function ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: trigger, status, responseStatusCode, duration, requestMethod, requestPath, deploymentId
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.ExecutionList]
     */
    @JvmOverloads
    suspend fun listExecutions(
        functionId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.ExecutionList {
        val apiPath = "/functions/{functionId}/executions"
            .replace("{functionId}", functionId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.ExecutionList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.ExecutionList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ExecutionList::class.java,
            converter,
        )
    }


    /**
     * Trigger a function execution. The returned object will return you the current execution status. You can ping the `Get Execution` endpoint to get updates on the current execution status. Once this endpoint is called, your function execution process will start asynchronously.
     *
     * @param functionId Function ID.
     * @param body HTTP body of execution. Default value is empty string.
     * @param async Execute code in the background. Default value is false.
     * @param path HTTP path of execution. Path can include query params. Default value is /
     * @param method HTTP method of execution. Default value is POST.
     * @param headers HTTP headers of execution. Defaults to empty.
     * @param scheduledAt Scheduled execution time in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future with precision in minutes.
     * @return [io.appwrite.models.Execution]
     */
    @JvmOverloads
    suspend fun createExecution(
        functionId: String,
        body: String? = null,
        async: Boolean? = null,
        path: String? = null,
        method: io.appwrite.enums.ExecutionMethod? = null,
        headers: Any? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Execution {
        val apiPath = "/functions/{functionId}/executions"
            .replace("{functionId}", functionId)

        val apiParams = mutableMapOf<String, Any?>(
            "body" to body,
            "async" to async,
            "path" to path,
            "method" to method,
            "headers" to headers,
            "scheduledAt" to scheduledAt,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Execution = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Execution.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Execution::class.java,
            converter,
        )
    }


    /**
     * Get a function execution log by its unique ID.
     *
     * @param functionId Function ID.
     * @param executionId Execution ID.
     * @return [io.appwrite.models.Execution]
     */
    suspend fun getExecution(
        functionId: String,
        executionId: String,
    ): io.appwrite.models.Execution {
        val apiPath = "/functions/{functionId}/executions/{executionId}"
            .replace("{functionId}", functionId)
            .replace("{executionId}", executionId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Execution = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Execution.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Execution::class.java,
            converter,
        )
    }


}