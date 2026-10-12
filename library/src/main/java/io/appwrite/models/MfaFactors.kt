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

    /**
     * Can custom factor be used for MFA challenge for this account.
     */
    @SerializedName("custom")
    val custom: Boolean,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "totp" to totp as Any,
        "phone" to phone as Any,
        "email" to email as Any,
        "recoveryCode" to recoveryCode as Any,
        "custom" to custom as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MfaFactors(
            totp = (if (map.containsKey("totp")) map["totp"] else false) as Boolean,
            phone = (if (map.containsKey("phone")) map["phone"] else false) as Boolean,
            email = (if (map.containsKey("email")) map["email"] else false) as Boolean,
            recoveryCode = (if (map.containsKey("recoveryCode")) map["recoveryCode"] else false) as Boolean,
            custom = (if (map.containsKey("custom")) map["custom"] else false) as Boolean,
        )
    }
}
