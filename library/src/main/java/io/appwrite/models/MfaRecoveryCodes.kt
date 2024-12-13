package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * MFA Recovery Codes
 */
data class MfaRecoveryCodes(
    /**
     * Recovery codes.
     */
    @SerializedName("recoveryCodes")
    val recoveryCodes: List<String>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "recoveryCodes" to recoveryCodes as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MfaRecoveryCodes(
            recoveryCodes = map["recoveryCodes"] as List<String>,
        )
    }
}