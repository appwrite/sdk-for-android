package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.ExecutionResourceType
import io.appwrite.enums.ExecutionTrigger
import io.appwrite.enums.ExecutionStatus
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
     * Execution update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Execution roles.
     */
    @SerializedName("\$permissions")
    val permissions: List<String>,

    /**
     * Function or site ID.
     */
    @SerializedName("resourceId")
    val resourceId: String,

    /**
     * Execution resource type.
     */
    @SerializedName("resourceType")
    val resourceType: ExecutionResourceType,

    /**
     * Deployment ID used to create the execution.
     */
    @SerializedName("deploymentId")
    val deploymentId: String,

    /**
     * The trigger that caused the resource to execute. Possible values can be: `http`, `schedule`, or `event`.
     */
    @SerializedName("trigger")
    val trigger: ExecutionTrigger,

    /**
     * The status of the resource execution. Possible values can be: `waiting`, `processing`, `completed`, `failed`, or `scheduled`.
     */
    @SerializedName("status")
    val status: ExecutionStatus,

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
     * HTTP request headers as a key-value object. This will return only whitelisted headers. All headers are returned if execution is created as synchronous.
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
     * Resource logs. Includes the last 4,000 characters. This will return an empty string unless the response is returned using an API key or as part of a webhook payload.
     */
    @SerializedName("logs")
    val logs: String,

    /**
     * Resource errors. Includes the last 4,000 characters. This will return an empty string unless the response is returned using an API key or as part of a webhook payload.
     */
    @SerializedName("errors")
    val errors: String,

    /**
     * Total time the resource(function/site) took to respond, in seconds.
     */
    @SerializedName("duration")
    val duration: Double,

    /**
     * The scheduled time for execution. If left empty, execution will be queued immediately.
     */
    @SerializedName("scheduledAt")
    var scheduledAt: String?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "resourceId" to resourceId as Any,
        "resourceType" to resourceType.value as Any,
        "deploymentId" to deploymentId as Any,
        "trigger" to trigger.value as Any,
        "status" to status.value as Any,
        "requestMethod" to requestMethod as Any,
        "requestPath" to requestPath as Any,
        "requestHeaders" to requestHeaders.map { it.toMap() } as Any,
        "responseStatusCode" to responseStatusCode as Any,
        "responseBody" to responseBody as Any,
        "responseHeaders" to responseHeaders.map { it.toMap() } as Any,
        "logs" to logs as Any,
        "errors" to errors as Any,
        "duration" to duration as Any,
        "scheduledAt" to scheduledAt as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Execution(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            permissions = map["\$permissions"] as List<String>,
            resourceId = (if (map.containsKey("resourceId")) map["resourceId"] else "") as String,
            resourceType = ExecutionResourceType.values().find { it.value == (if (map.containsKey("resourceType")) map["resourceType"] else "functions") as String }!!,
            deploymentId = (if (map.containsKey("deploymentId")) map["deploymentId"] else "") as String,
            trigger = ExecutionTrigger.values().find { it.value == map["trigger"] as String }!!,
            status = ExecutionStatus.values().find { it.value == map["status"] as String }!!,
            requestMethod = (if (map.containsKey("requestMethod")) map["requestMethod"] else "") as String,
            requestPath = (if (map.containsKey("requestPath")) map["requestPath"] else "") as String,
            requestHeaders = (map["requestHeaders"] as List<Map<String, Any>>).map { Headers.from(map = it) },
            responseStatusCode = ((if (map.containsKey("responseStatusCode")) map["responseStatusCode"] else 0) as Number).toLong(),
            responseBody = (if (map.containsKey("responseBody")) map["responseBody"] else "") as String,
            responseHeaders = (map["responseHeaders"] as List<Map<String, Any>>).map { Headers.from(map = it) },
            logs = (if (map.containsKey("logs")) map["logs"] else "") as String,
            errors = (if (map.containsKey("errors")) map["errors"] else "") as String,
            duration = ((if (map.containsKey("duration")) map["duration"] else 0.0) as Number).toDouble(),
            scheduledAt = map["scheduledAt"] as? String,
        )
    }
}
