package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 Approve
 */
data class Oauth2Approve(
    /**
     * URL the end user should be redirected to after the grant is approved, carrying the authorization `code` and/or `id_token` along with the original `state`.
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
        ) = Oauth2Approve(
            redirectUrl = map["redirectUrl"] as String,
        )
    }
}