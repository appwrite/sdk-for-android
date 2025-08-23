package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Execution
 */
data class Execution(
    /**
     * Execution ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Execution creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Execution upate date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Execution roles.
     */
    @SerializedName("\$permissions")
    val permissions: List<String>,

    /**
     * Function ID.
     */
    @SerializedName("functionId")
    val functionId: String,

    /**
     * Function&#039;s deployment ID used to create the execution.
     */
    @SerializedName("deploymentId")
    val deploymentId: String,

    /**
     * The trigger that caused the function to execute. Possible values can be: `http`, `schedule`, or `event`.
     */
    @SerializedName("trigger")
    val trigger: String,

    /**
     * The status of the function execution. Possible values can be: `waiting`, `processing`, `completed`, or `failed`.
     */
    @SerializedName("status")
    val status: String,

    /**
     * HTTP request method type.
     */
    @SerializedName("requestMethod")
    val requestMethod: String,

    /**
     * HTTP request path and query.
     */
    @SerializedName("requestPath")
    val requestPath: String,

    /**
     * HTTP response headers as a key-value object. This will return only whitelisted headers. All headers are returned if execution is created as synchronous.
     */
    @SerializedName("requestHeaders")
    val requestHeaders: List<Headers>,

    /**
     * HTTP response status code.
     */
    @SerializedName("responseStatusCode")
    val responseStatusCode: Long,

    /**
     * HTTP response body. This will return empty unless execution is created as synchronous.
     */
    @SerializedName("responseBody")
    val responseBody: String,

    /**
     * HTTP response headers as a key-value object. This will return only whitelisted headers. All headers are returned if execution is created as synchronous.
     */
    @SerializedName("responseHeaders")
    val responseHeaders: List<Headers>,

    /**
     * Function logs. Includes the last 4,000 characters. This will return an empty string unless the response is returned using an API key or as part of a webhook payload.
     */
    @SerializedName("logs")
    val logs: String,

    /**
     * Function errors. Includes the last 4,000 characters. This will return an empty string unless the response is returned using an API key or as part of a webhook payload.
     */
    @SerializedName("errors")
    val errors: String,

    /**
     * Resource(function/site) execution duration in seconds.
     */
    @SerializedName("duration")
    val duration: Double,

    /**
     * The scheduled time for execution. If left empty, execution will be queued immediately.
     */
    @SerializedName("scheduledAt")
    var scheduledAt: String?,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "functionId" to functionId as Any,
        "deploymentId" to deploymentId as Any,
        "trigger" to trigger as Any,
        "status" to status as Any,
        "requestMethod" to requestMethod as Any,
        "requestPath" to requestPath as Any,
        "requestHeaders" to requestHeaders.map { it.toMap() } as Any,
        "responseStatusCode" to responseStatusCode as Any,
        "responseBody" to responseBody as Any,
        "responseHeaders" to responseHeaders.map { it.toMap() } as Any,
        "logs" to logs as Any,
        "errors" to errors as Any,
        "duration" to duration as Any,
        "scheduledAt" to scheduledAt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Execution(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            permissions = map["\$permissions"] as List<String>,
            functionId = map["functionId"] as String,
            deploymentId = map["deploymentId"] as String,
            trigger = map["trigger"] as String,
            status = map["status"] as String,
            requestMethod = map["requestMethod"] as String,
            requestPath = map["requestPath"] as String,
            requestHeaders = (map["requestHeaders"] as List<Map<String, Any>>).map { Headers.from(map = it) },
            responseStatusCode = (map["responseStatusCode"] as Number).toLong(),
            responseBody = map["responseBody"] as String,
            responseHeaders = (map["responseHeaders"] as List<Map<String, Any>>).map { Headers.from(map = it) },
            logs = map["logs"] as String,
            errors = map["errors"] as String,
            duration = (map["duration"] as Number).toDouble(),
            scheduledAt = map["scheduledAt"] as? String?,
        )
    }
}