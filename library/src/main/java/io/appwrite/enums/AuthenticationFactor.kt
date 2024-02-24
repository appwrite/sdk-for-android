package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class AuthenticationFactor(val value: String) {
    @SerializedName("totp")
    TOTP("totp"),
    @SerializedName("phone")
    PHONE("phone"),
    @SerializedName("email")
    EMAIL("email");

    override fun toString() = value
}