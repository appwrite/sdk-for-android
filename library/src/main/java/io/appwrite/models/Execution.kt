package io.appwrite.models

/**
 * Execution
 */
data class Execution(
    /**
     * Execution ID.
     *
     */
    val id: String,

    /**
     * Execution permissions.
     *
     */
    val permissions: Permissions,

    /**
     * Function ID.
     *
     */
    val functionId: String,

    /**
     * The execution creation date in Unix timestamp.
     *
     */
    val dateCreated: Long,

    /**
     * The trigger that caused the function to execute. Possible values can be: `http`, `schedule`, or `event`.
     *
     */
    val trigger: String,

    /**
     * The status of the function execution. Possible values can be: `waiting`, `processing`, `completed`, or `failed`.
     *
     */
    val status: String,

    /**
     * The script exit code.
     *
     */
    val exitCode: Long,

    /**
     * The script stdout output string. Logs the last 4,000 characters of the execution stdout output.
     *
     */
    val stdout: String,

    /**
     * The script stderr output string. Logs the last 4,000 characters of the execution stderr output
     *
     */
    val stderr: String,

    /**
     * The script execution time in seconds.
     *
     */
    val time: Double
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Execution(
            id = map["\$id"] as String,
            permissions = Permissions.from(map = map["\$permissions"] as Map<String, Any>),
            functionId = map["functionId"] as String,
            dateCreated = map["dateCreated"] as Long,
            trigger = map["trigger"] as String,
            status = map["status"] as String,
            exitCode = map["exitCode"] as Long,
            stdout = map["stdout"] as String,
            stderr = map["stderr"] as String,
            time = map["time"] as Double
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$permissions" to permissions.toMap() as Any,
        "functionId" to functionId as Any,
        "dateCreated" to dateCreated as Any,
        "trigger" to trigger as Any,
        "status" to status as Any,
        "exitCode" to exitCode as Any,
        "stdout" to stdout as Any,
        "stderr" to stderr as Any,
        "time" to time as Any
    )
}