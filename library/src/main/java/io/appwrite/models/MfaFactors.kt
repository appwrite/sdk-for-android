package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * MFAFactors
 */
data class MfaFactors(
    /**
     * TOTP
     */
    @SerializedName("totp")
    val totp: Boolean,

    /**
     * Phone
     */
    @SerializedName("phone")
    val phone: Boolean,

    /**
     * Email
     */
    @SerializedName("email")
    val email: Boolean,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "totp" to totp as Any,
        "phone" to phone as Any,
        "email" to email as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MfaFactors(
            totp = map["totp"] as Boolean,
            phone = map["phone"] as Boolean,
            email = map["email"] as Boolean,
        )
    }
}