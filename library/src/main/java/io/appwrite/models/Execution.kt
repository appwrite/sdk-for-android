package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Execution
 */
data class Execution(
    /**
     * Execution ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Execution read permissions.
     *
     */
    @SerializedName("\$read")
    val read: List<Any>,

    /**
     * Function ID.
     *
     */
    @SerializedName("functionId")
    val functionId: String,

    /**
     * The execution creation date in Unix timestamp.
     *
     */
    @SerializedName("dateCreated")
    val dateCreated: Long,

    /**
     * The trigger that caused the function to execute. Possible values can be: `http`, `schedule`, or `event`.
     *
     */
    @SerializedName("trigger")
    val trigger: String,

    /**
     * The status of the function execution. Possible values can be: `waiting`, `processing`, `completed`, or `failed`.
     *
     */
    @SerializedName("status")
    val status: String,

    /**
     * The script status code.
     *
     */
    @SerializedName("statusCode")
    val statusCode: Long,

    /**
     * The script response output string. Logs the last 4,000 characters of the execution response output.
     *
     */
    @SerializedName("response")
    val response: String,

    /**
     * The script stderr output string. Logs the last 4,000 characters of the execution stderr output
     *
     */
    @SerializedName("stderr")
    val stderr: String,

    /**
     * The script execution time in seconds.
     *
     */
    @SerializedName("time")
    val time: Double
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Execution(
            id = map["\$id"] as String,
            read = map["\$read"] as List<Any>,
            functionId = map["functionId"] as String,
            dateCreated = (map["dateCreated"] as Number).toLong(),
            trigger = map["trigger"] as String,
            status = map["status"] as String,
            statusCode = (map["statusCode"] as Number).toLong(),
            response = map["response"] as String,
            stderr = map["stderr"] as String,
            time = (map["time"] as Number).toDouble()
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$read" to read as Any,
        "functionId" to functionId as Any,
        "dateCreated" to dateCreated as Any,
        "trigger" to trigger as Any,
        "status" to status as Any,
        "statusCode" to statusCode as Any,
        "response" to response as Any,
        "stderr" to stderr as Any,
        "time" to time as Any
    )
}