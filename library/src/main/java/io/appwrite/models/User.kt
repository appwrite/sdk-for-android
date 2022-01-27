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
     * Email verification status.
     *
     */
    @SerializedName("emailVerification")
    val emailVerification: Boolean,

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
            name = map["name"] as String,
            registration = (map["registration"] as Number).toLong(),
            status = map["status"] as Boolean,
            passwordUpdate = (map["passwordUpdate"] as Number).toLong(),
            email = map["email"] as String,
            emailVerification = map["emailVerification"] as Boolean,
            prefs = Preferences.from(map = map["prefs"] as Map<String, Any>)
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "name" to name as Any,
        "registration" to registration as Any,
        "status" to status as Any,
        "passwordUpdate" to passwordUpdate as Any,
        "email" to email as Any,
        "emailVerification" to emailVerification as Any,
        "prefs" to prefs.toMap() as Any
    )
}