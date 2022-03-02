package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Teams List
 */
data class TeamList(
    /**
     * Total number of teams documents that matched your query.
     *
     */
    @SerializedName("total")
    val total: Long,

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
            total = (map["total"] as Number).toLong(),
            teams = (map["teams"] as List<Map<String, Any>>).map { Team.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "teams" to teams.map { it.toMap() } as Any
    )
}