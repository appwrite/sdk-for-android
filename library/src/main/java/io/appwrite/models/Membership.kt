package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Membership
 */
data class Membership(
    /**
     * Membership ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Membership creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Membership update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * User ID.
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * User name. Hide this attribute by toggling membership privacy in the Console.
     */
    @SerializedName("userName")
    val userName: String,

    /**
     * User email address. Hide this attribute by toggling membership privacy in the Console.
     */
    @SerializedName("userEmail")
    val userEmail: String,

    /**
     * User phone number. Hide this attribute by toggling membership privacy in the Console.
     */
    @SerializedName("userPhone")
    val userPhone: String,

    /**
     * Team ID.
     */
    @SerializedName("teamId")
    val teamId: String,

    /**
     * Team name.
     */
    @SerializedName("teamName")
    val teamName: String,

    /**
     * Date, the user has been invited to join the team in ISO 8601 format.
     */
    @SerializedName("invited")
    val invited: String,

    /**
     * Date, the user has accepted the invitation to join the team in ISO 8601 format.
     */
    @SerializedName("joined")
    val joined: String,

    /**
     * User confirmation status, true if the user has joined the team or false otherwise.
     */
    @SerializedName("confirm")
    val confirm: Boolean,

    /**
     * Multi factor authentication status, true if the user has MFA enabled or false otherwise. Hide this attribute by toggling membership privacy in the Console.
     */
    @SerializedName("mfa")
    val mfa: Boolean,

    /**
     * Most recent access date in ISO 8601 format. Show this attribute by toggling membership privacy in the Console.
     */
    @SerializedName("userAccessedAt")
    val userAccessedAt: String,

    /**
     * User list of roles
     */
    @SerializedName("roles")
    val roles: List<String>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "userId" to userId as Any,
        "userName" to userName as Any,
        "userEmail" to userEmail as Any,
        "userPhone" to userPhone as Any,
        "teamId" to teamId as Any,
        "teamName" to teamName as Any,
        "invited" to invited as Any,
        "joined" to joined as Any,
        "confirm" to confirm as Any,
        "mfa" to mfa as Any,
        "userAccessedAt" to userAccessedAt as Any,
        "roles" to roles as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Membership(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            userId = (if (map.containsKey("userId")) map["userId"] else "") as String,
            userName = (if (map.containsKey("userName")) map["userName"] else "") as String,
            userEmail = (if (map.containsKey("userEmail")) map["userEmail"] else "") as String,
            userPhone = (if (map.containsKey("userPhone")) map["userPhone"] else "") as String,
            teamId = (if (map.containsKey("teamId")) map["teamId"] else "") as String,
            teamName = (if (map.containsKey("teamName")) map["teamName"] else "") as String,
            invited = (if (map.containsKey("invited")) map["invited"] else "") as String,
            joined = (if (map.containsKey("joined")) map["joined"] else "") as String,
            confirm = (if (map.containsKey("confirm")) map["confirm"] else false) as Boolean,
            mfa = (if (map.containsKey("mfa")) map["mfa"] else false) as Boolean,
            userAccessedAt = (if (map.containsKey("userAccessedAt")) map["userAccessedAt"] else "") as String,
            roles = (if (map.containsKey("roles")) map["roles"] else listOf<Any?>()) as List<String>,
        )
    }
}
