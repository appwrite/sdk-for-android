package io.appwrite.enums

enum class AuthenticationFactor(val value: String) {
    TOTP("totp"),
    PHONE("phone"),
    EMAIL("email");

    override fun toString() = value
}