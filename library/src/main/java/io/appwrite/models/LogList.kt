package io.appwrite.models

/**
 * Logs List
 */
data class LogList(
    /**
     * Total number of items available on the server.
     *
     */
    val sum: Long,

    /**
     * List of logs.
     *
     */
    val logs: List<Log>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = LogList(
            sum = map["sum"] as Long,
            logs = (map["logs"] as List<Map<String, Any>>).map { Log.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "logs" to logs.map { it.toMap() } as Any
    )
}