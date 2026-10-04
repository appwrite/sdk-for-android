package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 Token
 */
data class Oauth2Token(
    /**
     * OAuth2 access token.
     */
    @SerializedName("access_token")
    val access_token: String,

    /**
     * OAuth2 token type.
     */
    @SerializedName("token_type")
    val token_type: String,

    /**
     * Access token lifetime in seconds.
     */
    @SerializedName("expires_in")
    val expires_in: Long,

    /**
     * OAuth2 refresh token.
     */
    @SerializedName("refresh_token")
    val refresh_token: String,

    /**
     * Space-separated scopes granted to the access token.
     */
    @SerializedName("scope")
    val scope: String,

    /**
     * Granted RFC 9396 authorization details as a JSON string.
     */
    @SerializedName("authorization_details")
    var authorization_details: String?,

    /**
     * OpenID Connect ID token. Returned when the `openid` scope is granted.
     */
    @SerializedName("id_token")
    var id_token: String?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "access_token" to access_token as Any,
        "token_type" to token_type as Any,
        "expires_in" to expires_in as Any,
        "refresh_token" to refresh_token as Any,
        "scope" to scope as Any,
        "authorization_details" to authorization_details as Any?,
        "id_token" to id_token as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2Token(
            access_token = map["access_token"] as String,
            token_type = map["token_type"] as String,
            expires_in = (map["expires_in"] as Number).toLong(),
            refresh_token = map["refresh_token"] as String,
            scope = map["scope"] as String,
            authorization_details = map["authorization_details"] as? String,
            id_token = map["id_token"] as? String,
        )
    }
}
