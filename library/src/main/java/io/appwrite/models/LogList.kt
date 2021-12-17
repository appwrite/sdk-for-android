package io.appwrite.models

/**
 * Logs List
 */
data class LogList(
    /**
     * List of logs.
     *
     */
    val logs: List<Log>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = LogList(
            logs = (map["logs"] as List<Map<String, Any>>).map { Log.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "logs" to logs.map { it.toMap() } as Any
    )
}