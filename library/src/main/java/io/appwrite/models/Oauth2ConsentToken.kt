package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 Consent Token
 */
data class Oauth2ConsentToken(
    /**
     * Token family ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Token creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Token update date in ISO 8601 format. Refreshing the token family updates this.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * ID of the consent the token family was issued under.
     */
    @SerializedName("consentId")
    val consentId: String,

    /**
     * ID of the user the token family belongs to.
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * ID of the registered app the token family was issued to. Empty for URL-form (CIMD) clients.
     */
    @SerializedName("appId")
    val appId: String,

    /**
     * Client ID metadata document URL of the client the token family was issued to. Empty for registered apps.
     */
    @SerializedName("cimdUrl")
    val cimdUrl: String,

    /**
     * OAuth2 scopes granted on the token family.
     */
    @SerializedName("scopes")
    val scopes: List<String>,

    /**
     * RFC 8707 resource indicators granted on the token family.
     */
    @SerializedName("resources")
    val resources: List<String>,

    /**
     * Authorization details granted on the token family, as a JSON string. Each entry has a `type` plus project-defined fields.
     */
    @SerializedName("authorizationDetails")
    val authorizationDetails: String,

    /**
     * Expiration time of the current access token of this family in ISO 8601 format.
     */
    @SerializedName("expire")
    val expire: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "consentId" to consentId as Any,
        "userId" to userId as Any,
        "appId" to appId as Any,
        "cimdUrl" to cimdUrl as Any,
        "scopes" to scopes as Any,
        "resources" to resources as Any,
        "authorizationDetails" to authorizationDetails as Any,
        "expire" to expire as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2ConsentToken(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            consentId = map["consentId"] as String,
            userId = map["userId"] as String,
            appId = map["appId"] as String,
            cimdUrl = map["cimdUrl"] as String,
            scopes = map["scopes"] as List<String>,
            resources = map["resources"] as List<String>,
            authorizationDetails = map["authorizationDetails"] as String,
            expire = map["expire"] as String,
        )
    }
}
