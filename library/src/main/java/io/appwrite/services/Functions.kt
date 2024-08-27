package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import java.io.File

/**
 * The Functions Service allows you view, create and manage your Cloud Functions.
**/
class Functions(client: Client) : Service(client) {

    /**
     * Get function template
     *
     * Get a function template using ID. You can use template details in [createFunction](/docs/references/cloud/server-nodejs/functions#create) method.
     *
     * @param templateId Template ID.
     * @return [io.appwrite.models.TemplateFunction]
     */
    suspend fun getTemplate(
        templateId: String,
    ): io.appwrite.models.TemplateFunction {
        val apiPath = "/functions/templates/{templateId}"
            .replace("{templateId}", templateId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.TemplateFunction = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.TemplateFunction.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.TemplateFunction::class.java,
            converter,
        )
    }


    /**
     * Download deployment
     *
     * Get a Deployment&#039;s contents by its unique ID. This endpoint supports range requests for partial or streaming file download.
     *
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @return [ByteArray]
     */
    suspend fun getDeploymentDownload(
        functionId: String,
        deploymentId: String,
    ): ByteArray {
        val apiPath = "/functions/{functionId}/deployments/{deploymentId}/download"
            .replace("{functionId}", functionId)
            .replace("{deploymentId}", deploymentId)

        val apiParams = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        return client.call(
            "GET",
            apiPath,
            params = apiParams,
            responseType = ByteArray::class.java
        )
    }


    /**
     * List executions
     *
     * Get a list of all the current user function execution logs. You can use the query params to filter your results.
     *
     * @param functionId Function ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: trigger, status, responseStatusCode, duration, requestMethod, requestPath, deploymentId
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.ExecutionList]
     */
    @JvmOverloads
    suspend fun listExecutions(
        functionId: String,
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.ExecutionList {
        val apiPath = "/functions/{functionId}/executions"
            .replace("{functionId}", functionId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
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
     * Create execution
     *
     * Trigger a function execution. The returned object will return you the current execution status. You can ping the `Get Execution` endpoint to get updates on the current execution status. Once this endpoint is called, your function execution process will start asynchronously.
     *
     * @param functionId Function ID.
     * @param body HTTP body of execution. Default value is empty string.
     * @param async Execute code in the background. Default value is false.
     * @param path HTTP path of execution. Path can include query params. Default value is /
     * @param method HTTP method of execution. Default value is GET.
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
        val apiHeaders = mutableMapOf(
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
     * Get execution
     *
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
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
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