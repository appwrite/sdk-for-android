package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * MFAType
 */
data class MfaType(
    /**
     * Secret token used for TOTP factor.
     */
    @SerializedName("secret")
    val secret: String,

    /**
     * URI for authenticator apps.
     */
    @SerializedName("uri")
    val uri: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "secret" to secret as Any,
        "uri" to uri as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MfaType(
            secret = (if (map.containsKey("secret")) map["secret"] else "") as String,
            uri = (if (map.containsKey("uri")) map["uri"] else "") as String,
        )
    }
}
