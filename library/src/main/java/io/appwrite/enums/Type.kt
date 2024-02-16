package io.appwrite.enums

enum class Type(val value: String) {
    TOTP("totp");

    override fun toString() = value
}