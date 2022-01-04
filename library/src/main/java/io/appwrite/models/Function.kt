package io.appwrite.models

/**
 * Function
 */
data class Function(
    /**
     * Function ID.
     *
     */
    val id: String,

    /**
     * Execution permissions.
     *
     */
    val execute: String,

    /**
     * Function name.
     *
     */
    val name: String,

    /**
     * Function creation date in Unix timestamp.
     *
     */
    val dateCreated: Long,

    /**
     * Function update date in Unix timestamp.
     *
     */
    val dateUpdated: Long,

    /**
     * Function status. Possible values: `disabled`, `enabled`
     *
     */
    val status: String,

    /**
     * Function execution runtime.
     *
     */
    val runtime: String,

    /**
     * Function active tag ID.
     *
     */
    val tag: String,

    /**
     * Function environment variables.
     *
     */
    val vars: String,

    /**
     * Function trigger events.
     *
     */
    val events: List<Any>,

    /**
     * Function execution schedult in CRON format.
     *
     */
    val schedule: String,

    /**
     * Function next scheduled execution date in Unix timestamp.
     *
     */
    val scheduleNext: Long,

    /**
     * Function next scheduled execution date in Unix timestamp.
     *
     */
    val schedulePrevious: Long,

    /**
     * Function execution timeout in seconds.
     *
     */
    val timeout: Long
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Function(
            id = map["\$id"] as String,
            execute = map["execute"] as String,
            name = map["name"] as String,
            dateCreated = map["dateCreated"] as Long,
            dateUpdated = map["dateUpdated"] as Long,
            status = map["status"] as String,
            runtime = map["runtime"] as String,
            tag = map["tag"] as String,
            vars = map["vars"] as String,
            events = map["events"] as List<Any>,
            schedule = map["schedule"] as String,
            scheduleNext = map["scheduleNext"] as Long,
            schedulePrevious = map["schedulePrevious"] as Long,
            timeout = map["timeout"] as Long
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "execute" to execute as Any,
        "name" to name as Any,
        "dateCreated" to dateCreated as Any,
        "dateUpdated" to dateUpdated as Any,
        "status" to status as Any,
        "runtime" to runtime as Any,
        "tag" to tag as Any,
        "vars" to vars as Any,
        "events" to events as Any,
        "schedule" to schedule as Any,
        "scheduleNext" to scheduleNext as Any,
        "schedulePrevious" to schedulePrevious as Any,
        "timeout" to timeout as Any
    )
}