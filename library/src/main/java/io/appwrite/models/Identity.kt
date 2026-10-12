package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Identity
 */
data class Identity(
    /**
     * Identity ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Identity creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Identity update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * User ID.
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * Identity Provider.
     */
    @SerializedName("provider")
    val provider: String,

    /**
     * ID of the User in the Identity Provider.
     */
    @SerializedName("providerUid")
    val providerUid: String,

    /**
     * Email of the User in the Identity Provider.
     */
    @SerializedName("providerEmail")
    val providerEmail: String,

    /**
     * Identity Provider Access Token.
     */
    @SerializedName("providerAccessToken")
    val providerAccessToken: String,

    /**
     * The date of when the access token expires in ISO 8601 format.
     */
    @SerializedName("providerAccessTokenExpiry")
    val providerAccessTokenExpiry: String,

    /**
     * Identity Provider Refresh Token.
     */
    @SerializedName("providerRefreshToken")
    val providerRefreshToken: String,

    /**
     * Identity Provider ID token (JWT) from the most recent native sign-in. Empty for identities created through the browser OAuth2 flow.
     */
    @SerializedName("providerIdToken")
    val providerIdToken: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "userId" to userId as Any,
        "provider" to provider as Any,
        "providerUid" to providerUid as Any,
        "providerEmail" to providerEmail as Any,
        "providerAccessToken" to providerAccessToken as Any,
        "providerAccessTokenExpiry" to providerAccessTokenExpiry as Any,
        "providerRefreshToken" to providerRefreshToken as Any,
        "providerIdToken" to providerIdToken as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Identity(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            userId = (if (map.containsKey("userId")) map["userId"] else "") as String,
            provider = (if (map.containsKey("provider")) map["provider"] else "") as String,
            providerUid = (if (map.containsKey("providerUid")) map["providerUid"] else "") as String,
            providerEmail = (if (map.containsKey("providerEmail")) map["providerEmail"] else "") as String,
            providerAccessToken = (if (map.containsKey("providerAccessToken")) map["providerAccessToken"] else "") as String,
            providerAccessTokenExpiry = (if (map.containsKey("providerAccessTokenExpiry")) map["providerAccessTokenExpiry"] else "") as String,
            providerRefreshToken = (if (map.containsKey("providerRefreshToken")) map["providerRefreshToken"] else "") as String,
            providerIdToken = (if (map.containsKey("providerIdToken")) map["providerIdToken"] else "") as String,
        )
    }
}
