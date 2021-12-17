package io.appwrite.models

/**
 * Sessions List
 */
data class SessionList(
    /**
     * Total number of items available on the server.
     *
     */
    val sum: Long,

    /**
     * List of sessions.
     *
     */
    val sessions: List<Session>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = SessionList(
            sum = map["sum"] as Long,
            sessions = (map["sessions"] as List<Map<String, Any>>).map { Session.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "sessions" to sessions.map { it.toMap() } as Any
    )
}