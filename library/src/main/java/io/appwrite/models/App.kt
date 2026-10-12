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
     * Application description shown to users during OAuth2 consent.
     */
    @SerializedName("description")
    val description: String,

    /**
     * Application homepage URL shown to users during OAuth2 consent.
     */
    @SerializedName("clientUri")
    val clientUri: String,

    /**
     * Application logo URL shown to users during OAuth2 consent.
     */
    @SerializedName("logoUri")
    val logoUri: String,

    /**
     * Application privacy policy URL shown to users during OAuth2 consent.
     */
    @SerializedName("privacyPolicyUrl")
    val privacyPolicyUrl: String,

    /**
     * Application terms of service URL shown to users during OAuth2 consent.
     */
    @SerializedName("termsUrl")
    val termsUrl: String,

    /**
     * Application support or security contact emails.
     */
    @SerializedName("contacts")
    val contacts: List<String>,

    /**
     * Application tagline shown to users during OAuth2 consent.
     */
    @SerializedName("tagline")
    val tagline: String,

    /**
     * Application tags shown to users during OAuth2 consent.
     */
    @SerializedName("tags")
    val tags: List<String>,

    /**
     * Application labels. Read-only for clients; only a server SDK using a project API key can update them.
     */
    @SerializedName("labels")
    val labels: List<String>,

    /**
     * Application image URLs shown to users during OAuth2 consent.
     */
    @SerializedName("images")
    val images: List<String>,

    /**
     * Application support URL shown to users during OAuth2 consent.
     */
    @SerializedName("supportUrl")
    val supportUrl: String,

    /**
     * Application data deletion URL shown to users during OAuth2 consent.
     */
    @SerializedName("dataDeletionUrl")
    val dataDeletionUrl: String,

    /**
     * List of authorized redirect URIs. These URIs can be used to redirect users after they authenticate.
     */
    @SerializedName("redirectUris")
    val redirectUris: List<String>,

    /**
     * List of authorized post-logout redirect URIs for OpenID Connect RP-Initiated Logout. The logout endpoint only redirects users to URIs in this list after ending their session.
     */
    @SerializedName("postLogoutRedirectUris")
    val postLogoutRedirectUris: List<String>,

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
     * Scopes the application requests when installed on a team. Organization-level and project-level scopes only.
     */
    @SerializedName("installationScopes")
    val installationScopes: List<String>,

    /**
     * URL users are redirected to after creating or updating an installation of this application. Empty for no redirect.
     */
    @SerializedName("installationRedirectUrl")
    val installationRedirectUrl: String,

    /**
     * List of application secrets.
     */
    @SerializedName("secrets")
    val secrets: List<AppSecret>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "description" to description as Any,
        "clientUri" to clientUri as Any,
        "logoUri" to logoUri as Any,
        "privacyPolicyUrl" to privacyPolicyUrl as Any,
        "termsUrl" to termsUrl as Any,
        "contacts" to contacts as Any,
        "tagline" to tagline as Any,
        "tags" to tags as Any,
        "labels" to labels as Any,
        "images" to images as Any,
        "supportUrl" to supportUrl as Any,
        "dataDeletionUrl" to dataDeletionUrl as Any,
        "redirectUris" to redirectUris as Any,
        "postLogoutRedirectUris" to postLogoutRedirectUris as Any,
        "enabled" to enabled as Any,
        "type" to type as Any,
        "deviceFlow" to deviceFlow as Any,
        "teamId" to teamId as Any,
        "userId" to userId as Any,
        "installationScopes" to installationScopes as Any,
        "installationRedirectUrl" to installationRedirectUrl as Any,
        "secrets" to secrets.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = App(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            description = (if (map.containsKey("description")) map["description"] else "") as String,
            clientUri = (if (map.containsKey("clientUri")) map["clientUri"] else "") as String,
            logoUri = (if (map.containsKey("logoUri")) map["logoUri"] else "") as String,
            privacyPolicyUrl = (if (map.containsKey("privacyPolicyUrl")) map["privacyPolicyUrl"] else "") as String,
            termsUrl = (if (map.containsKey("termsUrl")) map["termsUrl"] else "") as String,
            contacts = (if (map.containsKey("contacts")) map["contacts"] else listOf<Any?>()) as List<String>,
            tagline = (if (map.containsKey("tagline")) map["tagline"] else "") as String,
            tags = (if (map.containsKey("tags")) map["tags"] else listOf<Any?>()) as List<String>,
            labels = (if (map.containsKey("labels")) map["labels"] else listOf<Any?>()) as List<String>,
            images = (if (map.containsKey("images")) map["images"] else listOf<Any?>()) as List<String>,
            supportUrl = (if (map.containsKey("supportUrl")) map["supportUrl"] else "") as String,
            dataDeletionUrl = (if (map.containsKey("dataDeletionUrl")) map["dataDeletionUrl"] else "") as String,
            redirectUris = (if (map.containsKey("redirectUris")) map["redirectUris"] else listOf<Any?>()) as List<String>,
            postLogoutRedirectUris = (if (map.containsKey("postLogoutRedirectUris")) map["postLogoutRedirectUris"] else listOf<Any?>()) as List<String>,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else true) as Boolean,
            type = (if (map.containsKey("type")) map["type"] else "confidential") as String,
            deviceFlow = (if (map.containsKey("deviceFlow")) map["deviceFlow"] else false) as Boolean,
            teamId = (if (map.containsKey("teamId")) map["teamId"] else "") as String,
            userId = (if (map.containsKey("userId")) map["userId"] else "") as String,
            installationScopes = (if (map.containsKey("installationScopes")) map["installationScopes"] else listOf<Any?>()) as List<String>,
            installationRedirectUrl = (if (map.containsKey("installationRedirectUrl")) map["installationRedirectUrl"] else "") as String,
            secrets = (map["secrets"] as List<Map<String, Any>>).map { AppSecret.from(map = it) },
        )
    }
}
