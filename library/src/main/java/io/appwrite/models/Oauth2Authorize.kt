package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 Authorize
 */
data class Oauth2Authorize(
    /**
     * OAuth2 grant ID. Set when the user must give explicit consent; pass it to the approve or reject endpoint. Empty when a redirect URL is returned instead.
     */
    @SerializedName("grantId")
    val grantId: String,

    /**
     * URL the end user should be redirected to when the flow can complete without consent. Empty when consent is still required.
     */
    @SerializedName("redirectUrl")
    val redirectUrl: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "grantId" to grantId as Any,
        "redirectUrl" to redirectUrl as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2Authorize(
            grantId = map["grantId"] as String,
            redirectUrl = map["redirectUrl"] as String,
        )
    }
}