package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * MFAFactors
 */
data class MfaFactors(
    /**
     * Can TOTP be used for MFA challenge for this account.
     */
    @SerializedName("totp")
    val totp: Boolean,

    /**
     * Can phone (SMS) be used for MFA challenge for this account.
     */
    @SerializedName("phone")
    val phone: Boolean,

    /**
     * Can email be used for MFA challenge for this account.
     */
    @SerializedName("email")
    val email: Boolean,

    /**
     * Can recovery code be used for MFA challenge for this account.
     */
    @SerializedName("recoveryCode")
    val recoveryCode: Boolean,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "totp" to totp as Any,
        "phone" to phone as Any,
        "email" to email as Any,
        "recoveryCode" to recoveryCode as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MfaFactors(
            totp = map["totp"] as Boolean,
            phone = map["phone"] as Boolean,
            email = map["email"] as Boolean,
            recoveryCode = map["recoveryCode"] as Boolean,
        )
    }
}