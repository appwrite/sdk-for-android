package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Sessions List
 */
data class SessionList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of sessions.
     *
     */
    @SerializedName("sessions")
    val sessions: List<Session>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = SessionList(
            sum = (map["sum"] as Number).toLong(),
            sessions = (map["sessions"] as List<Map<String, Any>>).map { Session.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "sessions" to sessions.map { it.toMap() } as Any
    )
}