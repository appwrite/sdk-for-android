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
     * Total sum of team members.
     *
     */
    @SerializedName("sum")
    val sum: Long
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Team(
            id = map["\$id"] as String,
            name = map["name"] as String,
            dateCreated = (map["dateCreated"] as Number).toLong(),
            sum = (map["sum"] as Number).toLong()
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "name" to name as Any,
        "dateCreated" to dateCreated as Any,
        "sum" to sum as Any
    )
}