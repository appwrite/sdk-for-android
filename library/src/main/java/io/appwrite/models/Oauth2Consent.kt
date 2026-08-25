package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 Consent
 */
data class Oauth2Consent(
    /**
     * Consent ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Consent creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Consent update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * ID of the user the consent belongs to.
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * ID of the registered app the consent was given to. Empty for URL-form (CIMD) clients.
     */
    @SerializedName("appId")
    val appId: String,

    /**
     * Client ID metadata document URL of the client the consent was given to. Empty for registered apps.
     */
    @SerializedName("cimdUrl")
    val cimdUrl: String,

    /**
     * OAuth2 scopes the user consented to.
     */
    @SerializedName("scopes")
    val scopes: List<String>,

    /**
     * RFC 8707 resource indicators the user consented to.
     */
    @SerializedName("resources")
    val resources: List<String>,

    /**
     * Authorization details the user consented to, as a JSON string. Each entry has a `type` plus project-defined fields.
     */
    @SerializedName("authorizationDetails")
    val authorizationDetails: String,

    /**
     * Consent expiration time in ISO 8601 format. Empty when the consent has no token-bound expiry yet.
     */
    @SerializedName("expire")
    val expire: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
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
        ) = Oauth2Consent(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
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
