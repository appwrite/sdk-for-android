package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Team
 */
data class Team(
    /**
     * Team ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Team name.
     *
     */
    @SerializedName("name")
    val name: String,

    /**
     * Team creation date in Unix timestamp.
     *
     */
    @SerializedName("dateCreated")
    val dateCreated: Long,

    /**
     * Total number of team members.
     *
     */
    @SerializedName("total")
    val total: Long
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Team(
            id = map["\$id"] as String,
            name = map["name"] as String,
            dateCreated = (map["dateCreated"] as Number).toLong(),
            total = (map["total"] as Number).toLong()
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "name" to name as Any,
        "dateCreated" to dateCreated as Any,
        "total" to total as Any
    )
}