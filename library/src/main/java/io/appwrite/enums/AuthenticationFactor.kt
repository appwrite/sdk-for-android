package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class AuthenticationFactor(val value: String) {
    @SerializedName("email")
    EMAIL("email"),
    @SerializedName("phone")
    PHONE("phone"),
    @SerializedName("totp")
    TOTP("totp"),
    @SerializedName("recoverycode")
    RECOVERYCODE("recoverycode"),
    @SerializedName("custom")
    CUSTOM("custom");

    override fun toString() = value
}
