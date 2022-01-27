package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Teams List
 */
data class TeamList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of teams.
     *
     */
    @SerializedName("teams")
    val teams: List<Team>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = TeamList(
            sum = (map["sum"] as Number).toLong(),
            teams = (map["teams"] as List<Map<String, Any>>).map { Team.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "teams" to teams.map { it.toMap() } as Any
    )
}