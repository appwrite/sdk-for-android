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
    val permissions: List<Any>,

    /**
     * Function ID.
     */
    @SerializedName("functionId")
    val functionId: String,

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
     * The script status code.
     */
    @SerializedName("statusCode")
    val statusCode: Long,

    /**
     * The script response output string. Logs the last 4,000 characters of the execution response output.
     */
    @SerializedName("response")
    val response: String,

    /**
     * The script stdout output string. Logs the last 4,000 characters of the execution stdout output. This will return an empty string unless the response is returned using an API key or as part of a webhook payload.
     */
    @SerializedName("stdout")
    val stdout: String,

    /**
     * The script stderr output string. Logs the last 4,000 characters of the execution stderr output. This will return an empty string unless the response is returned using an API key or as part of a webhook payload.
     */
    @SerializedName("stderr")
    val stderr: String,

    /**
     * The script execution duration in seconds.
     */
    @SerializedName("duration")
    val duration: Double,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "functionId" to functionId as Any,
        "trigger" to trigger as Any,
        "status" to status as Any,
        "statusCode" to statusCode as Any,
        "response" to response as Any,
        "stdout" to stdout as Any,
        "stderr" to stderr as Any,
        "duration" to duration as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Execution(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            permissions = map["\$permissions"] as List<Any>,
            functionId = map["functionId"] as String,
            trigger = map["trigger"] as String,
            status = map["status"] as String,
            statusCode = (map["statusCode"] as Number).toLong(),
            response = map["response"] as String,
            stdout = map["stdout"] as String,
            stderr = map["stderr"] as String,
            duration = (map["duration"] as Number).toDouble(),
        )
    }
}