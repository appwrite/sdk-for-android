package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 Grant
 */
data class Oauth2Grant(
    /**
     * Grant ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Grant creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Grant update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * ID of the user the grant belongs to.
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * ID of the OAuth2 client (app) the grant was requested for.
     */
    @SerializedName("appId")
    val appId: String,

    /**
     * Requested OAuth2 scopes the user is being asked to consent to.
     */
    @SerializedName("scopes")
    val scopes: List<String>,

    /**
     * Requested authorization_details the user is being asked to consent to, as a JSON string. Each entry has a `type` plus project-defined fields.
     */
    @SerializedName("authorizationDetails")
    val authorizationDetails: String,

    /**
     * OIDC prompt directive the consent screen should honor. Space-separated list of: login, consent, select_account.
     */
    @SerializedName("prompt")
    val prompt: String,

    /**
     * Redirect URI the user will be sent to after the flow completes.
     */
    @SerializedName("redirectUri")
    val redirectUri: String,

    /**
     * Unix timestamp of when the user last authenticated.
     */
    @SerializedName("authTime")
    val authTime: Long,

    /**
     * Grant expiration time in ISO 8601 format.
     */
    @SerializedName("expire")
    val expire: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "userId" to userId as Any,
        "appId" to appId as Any,
        "scopes" to scopes as Any,
        "authorizationDetails" to authorizationDetails as Any,
        "prompt" to prompt as Any,
        "redirectUri" to redirectUri as Any,
        "authTime" to authTime as Any,
        "expire" to expire as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2Grant(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            userId = map["userId"] as String,
            appId = map["appId"] as String,
            scopes = map["scopes"] as List<String>,
            authorizationDetails = map["authorizationDetails"] as String,
            prompt = map["prompt"] as String,
            redirectUri = map["redirectUri"] as String,
            authTime = (map["authTime"] as Number).toLong(),
            expire = map["expire"] as String,
        )
    }
}