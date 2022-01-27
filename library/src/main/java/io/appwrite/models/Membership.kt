package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Membership
 */
data class Membership(
    /**
     * Membership ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * User ID.
     *
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * Team ID.
     *
     */
    @SerializedName("teamId")
    val teamId: String,

    /**
     * User name.
     *
     */
    @SerializedName("name")
    val name: String,

    /**
     * User email address.
     *
     */
    @SerializedName("email")
    val email: String,

    /**
     * Date, the user has been invited to join the team in Unix timestamp.
     *
     */
    @SerializedName("invited")
    val invited: Long,

    /**
     * Date, the user has accepted the invitation to join the team in Unix timestamp.
     *
     */
    @SerializedName("joined")
    val joined: Long,

    /**
     * User confirmation status, true if the user has joined the team or false otherwise.
     *
     */
    @SerializedName("confirm")
    val confirm: Boolean,

    /**
     * User list of roles
     *
     */
    @SerializedName("roles")
    val roles: List<Any>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Membership(
            id = map["\$id"] as String,
            userId = map["userId"] as String,
            teamId = map["teamId"] as String,
            name = map["name"] as String,
            email = map["email"] as String,
            invited = (map["invited"] as Number).toLong(),
            joined = (map["joined"] as Number).toLong(),
            confirm = map["confirm"] as Boolean,
            roles = map["roles"] as List<Any>
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "userId" to userId as Any,
        "teamId" to teamId as Any,
        "name" to name as Any,
        "email" to email as Any,
        "invited" to invited as Any,
        "joined" to joined as Any,
        "confirm" to confirm as Any,
        "roles" to roles as Any
    )
}