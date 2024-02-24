package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class AuthenticatorType(val value: String) {
    @SerializedName("totp")
    TOTP("totp");

    override fun toString() = value
}