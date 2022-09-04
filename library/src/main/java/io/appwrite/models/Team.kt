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
     * Team creation date in Datetime
     *
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Team update date in Datetime
     *
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Team name.
     *
     */
    @SerializedName("name")
    val name: String,

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
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            total = (map["total"] as Number).toLong()
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "total" to total as Any
    )
}