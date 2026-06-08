package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 Reject
 */
data class Oauth2Reject(
    /**
     * URL the end user should be redirected to after the grant is rejected, carrying an `access_denied` error.
     */
    @SerializedName("redirectUrl")
    val redirectUrl: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "redirectUrl" to redirectUrl as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2Reject(
            redirectUrl = map["redirectUrl"] as String,
        )
    }
}