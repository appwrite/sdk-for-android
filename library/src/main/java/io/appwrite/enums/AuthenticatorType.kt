package io.appwrite.enums

enum class AuthenticatorType(val value: String) {
    TOTP("totp");

    override fun toString() = value
}