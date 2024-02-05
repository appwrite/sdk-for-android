package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * MFAProvider
 */
data class MfaProvider(
    /**
     * Backup codes.
     */
    @SerializedName("backups")
    val backups: List<Any>,

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
    fun toMap(): Map<String, Any> = mapOf(
        "backups" to backups as Any,
        "secret" to secret as Any,
        "uri" to uri as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MfaProvider(
            backups = map["backups"] as List<Any>,
            secret = map["secret"] as String,
            uri = map["uri"] as String,
        )
    }
}