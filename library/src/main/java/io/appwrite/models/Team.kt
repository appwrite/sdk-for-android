package io.appwrite.models

/**
 * Team
 */
data class Team(
    /**
     * Team ID.
     *
     */
    val id: String,

    /**
     * Team name.
     *
     */
    val name: String,

    /**
     * Team creation date in Unix timestamp.
     *
     */
    val dateCreated: Long,

    /**
     * Total sum of team members.
     *
     */
    val sum: Long
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Team(
            id = map["\$id"] as String,
            name = map["name"] as String,
            dateCreated = map["dateCreated"] as Long,
            sum = map["sum"] as Long
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "name" to name as Any,
        "dateCreated" to dateCreated as Any,
        "sum" to sum as Any
    )
}