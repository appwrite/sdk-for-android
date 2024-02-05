package io.appwrite.enums

enum class AuthenticatorProvider(val value: String) {
    TOTP("totp");

    override fun toString() = value
}