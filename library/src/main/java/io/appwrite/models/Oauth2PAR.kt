package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 PAR
 */
data class Oauth2PAR(
    /**
     * Authorization request handle to pass to the authorize endpoint.
     */
    @SerializedName("request_uri")
    val request_uri: String,

    /**
     * Lifetime of the authorization request handle in seconds.
     */
    @SerializedName("expires_in")
    val expires_in: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "request_uri" to request_uri as Any,
        "expires_in" to expires_in as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2PAR(
            request_uri = map["request_uri"] as String,
            expires_in = (map["expires_in"] as Number).toLong(),
        )
    }
}
