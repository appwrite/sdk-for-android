package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * User
 */
data class User<T>(
    /**
     * User ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * User creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * User update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * User name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Hashed user password.
     */
    @SerializedName("password")
    var password: String?,

    /**
     * Password hashing algorithm.
     */
    @SerializedName("hash")
    var hash: String?,

    /**
     * Password hashing algorithm configuration.
     */
    @SerializedName("hashOptions")
    var hashOptions: Any?,

    /**
     * User registration date in ISO 8601 format.
     */
    @SerializedName("registration")
    val registration: String,

    /**
     * User status. Pass `true` for enabled and `false` for disabled.
     */
    @SerializedName("status")
    val status: Boolean,

    /**
     * Labels for the user.
     */
    @SerializedName("labels")
    val labels: List<Any>,

    /**
     * Password update time in ISO 8601 format.
     */
    @SerializedName("passwordUpdate")
    val passwordUpdate: String,

    /**
     * User email address.
     */
    @SerializedName("email")
    val email: String,

    /**
     * User phone number in E.164 format.
     */
    @SerializedName("phone")
    val phone: String,

    /**
     * Email verification status.
     */
    @SerializedName("emailVerification")
    val emailVerification: Boolean,

    /**
     * Phone verification status.
     */
    @SerializedName("phoneVerification")
    val phoneVerification: Boolean,

    /**
     * Multi factor authentication status.
     */
    @SerializedName("mfa")
    val mfa: Boolean,

    /**
     * TOTP status.
     */
    @SerializedName("totp")
    val totp: Boolean,

    /**
     * User preferences as a key-value object
     */
    @SerializedName("prefs")
    val prefs: Preferences<T>,

    /**
     * A user-owned message receiver. A single user may have multiple e.g. emails, phones, and a browser. Each target is registered with a single provider.
     */
    @SerializedName("targets")
    val targets: List<Target>,

    /**
     * Most recent access date in ISO 8601 format. This attribute is only updated again after 24 hours.
     */
    @SerializedName("accessedAt")
    val accessedAt: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "password" to password as Any,
        "hash" to hash as Any,
        "hashOptions" to hashOptions as Any,
        "registration" to registration as Any,
        "status" to status as Any,
        "labels" to labels as Any,
        "passwordUpdate" to passwordUpdate as Any,
        "email" to email as Any,
        "phone" to phone as Any,
        "emailVerification" to emailVerification as Any,
        "phoneVerification" to phoneVerification as Any,
        "mfa" to mfa as Any,
        "totp" to totp as Any,
        "prefs" to prefs.toMap() as Any,
        "targets" to targets.map { it.toMap() } as Any,
        "accessedAt" to accessedAt as Any,
    )

    companion object {
        operator fun invoke(
            id: String,
            createdAt: String,
            updatedAt: String,
            name: String,
            password: String?,
            hash: String?,
            hashOptions: Any?,
            registration: String,
            status: Boolean,
            labels: List<Any>,
            passwordUpdate: String,
            email: String,
            phone: String,
            emailVerification: Boolean,
            phoneVerification: Boolean,
            mfa: Boolean,
            totp: Boolean,
            prefs: Preferences<Map<String, Any>>,
            targets: List<Target>,
            accessedAt: String,
        ) = User<Map<String, Any>>(
            id,
            createdAt,
            updatedAt,
            name,
            password,
            hash,
            hashOptions,
            registration,
            status,
            labels,
            passwordUpdate,
            email,
            phone,
            emailVerification,
            phoneVerification,
            mfa,
            totp,
            prefs,
            targets,
            accessedAt,
        )

        @Suppress("UNCHECKED_CAST")
        fun <T> from(
            map: Map<String, Any>,
            nestedType: Class<T>
        ) = User<T>(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            password = map["password"] as? String?,
            hash = map["hash"] as? String?,
            hashOptions = map["hashOptions"] as? Any?,
            registration = map["registration"] as String,
            status = map["status"] as Boolean,
            labels = map["labels"] as List<Any>,
            passwordUpdate = map["passwordUpdate"] as String,
            email = map["email"] as String,
            phone = map["phone"] as String,
            emailVerification = map["emailVerification"] as Boolean,
            phoneVerification = map["phoneVerification"] as Boolean,
            mfa = map["mfa"] as Boolean,
            totp = map["totp"] as Boolean,
            prefs = Preferences.from(map = map["prefs"] as Map<String, Any>, nestedType),
            targets = (map["targets"] as List<Map<String, Any>>).map { Target.from(map = it) },
            accessedAt = map["accessedAt"] as String,
        )
    }
}