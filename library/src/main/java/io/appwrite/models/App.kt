package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * App
 */
data class App(
    /**
     * App ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * App creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * App update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Application name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * List of authorized redirect URIs. These URIs can be used to redirect users after they authenticate.
     */
    @SerializedName("redirectUris")
    val redirectUris: List<String>,

    /**
     * Whether the app is enabled or not.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * OAuth2 client type. `public` for SPAs, mobile, and native apps that cannot keep a client secret (PKCE required); `confidential` for server-side clients that authenticate with a client secret.
     */
    @SerializedName("type")
    val type: String,

    /**
     * Whether this client may use the OAuth2 Device Authorization Grant (RFC 8628).
     */
    @SerializedName("deviceFlow")
    val deviceFlow: Boolean,

    /**
     * ID of team that owns the application, if owned by team. Otherwise, user ID will be used.
     */
    @SerializedName("teamId")
    val teamId: String,

    /**
     * ID of user who owns the application, if owned by user. Otherwise, team ID will be used.
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * List of application secrets.
     */
    @SerializedName("secrets")
    val secrets: List<AppSecret>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "redirectUris" to redirectUris as Any,
        "enabled" to enabled as Any,
        "type" to type as Any,
        "deviceFlow" to deviceFlow as Any,
        "teamId" to teamId as Any,
        "userId" to userId as Any,
        "secrets" to secrets.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = App(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            redirectUris = map["redirectUris"] as List<String>,
            enabled = map["enabled"] as Boolean,
            type = map["type"] as String,
            deviceFlow = map["deviceFlow"] as Boolean,
            teamId = map["teamId"] as String,
            userId = map["userId"] as String,
            secrets = (map["secrets"] as List<Map<String, Any>>).map { AppSecret.from(map = it) },
        )
    }
}