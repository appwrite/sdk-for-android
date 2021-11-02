package io.appwrite.models

/**
 * Teams List
 */
data class TeamList(
    /**
     * Total number of items available on the server.
     *
     */
    val sum: Long,

    /**
     * List of teams.
     *
     */
    val teams: List<Team>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = TeamList(
            sum = map["sum"] as Long,
            teams = (map["teams"] as List<Map<String, Any>>).map { Team.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "teams" to teams.map { it.toMap() } as Any
    )
}