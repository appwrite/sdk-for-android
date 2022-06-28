package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * User
 */
data class User(
    /**
     * User ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * User creation date in Unix timestamp.
     *
     */
    @SerializedName("\$createdAt")
    val createdAt: Long,

    /**
     * User update date in Unix timestamp.
     *
     */
    @SerializedName("\$updatedAt")
    val updatedAt: Long,

    /**
     * User name.
     *
     */
    @SerializedName("name")
    val name: String,

    /**
     * User registration date in Unix timestamp.
     *
     */
    @SerializedName("registration")
    val registration: Long,

    /**
     * User status. Pass `true` for enabled and `false` for disabled.
     *
     */
    @SerializedName("status")
    val status: Boolean,

    /**
     * Unix timestamp of the most recent password update
     *
     */
    @SerializedName("passwordUpdate")
    val passwordUpdate: Long,

    /**
     * User email address.
     *
     */
    @SerializedName("email")
    val email: String,

    /**
     * User phone number in E.164 format.
     *
     */
    @SerializedName("phone")
    val phone: String,

    /**
     * Email verification status.
     *
     */
    @SerializedName("emailVerification")
    val emailVerification: Boolean,

    /**
     * Phone verification status.
     *
     */
    @SerializedName("phoneVerification")
    val phoneVerification: Boolean,

    /**
     * User preferences as a key-value object
     *
     */
    @SerializedName("prefs")
    val prefs: Preferences
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = User(
            id = map["\$id"] as String,
            createdAt = (map["\$createdAt"] as Number).toLong(),
            updatedAt = (map["\$updatedAt"] as Number).toLong(),
            name = map["name"] as String,
            registration = (map["registration"] as Number).toLong(),
            status = map["status"] as Boolean,
            passwordUpdate = (map["passwordUpdate"] as Number).toLong(),
            email = map["email"] as String,
            phone = map["phone"] as String,
            emailVerification = map["emailVerification"] as Boolean,
            phoneVerification = map["phoneVerification"] as Boolean,
            prefs = Preferences.from(map = map["prefs"] as Map<String, Any>)
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "registration" to registration as Any,
        "status" to status as Any,
        "passwordUpdate" to passwordUpdate as Any,
        "email" to email as Any,
        "phone" to phone as Any,
        "emailVerification" to emailVerification as Any,
        "phoneVerification" to phoneVerification as Any,
        "prefs" to prefs.toMap() as Any
    )
}