package io.appwrite.enums

enum class AuthenticatorFactor(val value: String) {
    TOTP("totp");

    override fun toString() = value
}