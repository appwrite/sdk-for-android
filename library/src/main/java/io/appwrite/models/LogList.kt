package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Logs List
 */
data class LogList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of logs.
     *
     */
    @SerializedName("logs")
    val logs: List<Log>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = LogList(
            sum = (map["sum"] as Number).toLong(),
            logs = (map["logs"] as List<Map<String, Any>>).map { Log.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "logs" to logs.map { it.toMap() } as Any
    )
}