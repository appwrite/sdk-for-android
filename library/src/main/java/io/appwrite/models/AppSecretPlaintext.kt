package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * AppSecretPlaintext
 */
data class AppSecretPlaintext(
    /**
     * Secret ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Secret creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Secret update time in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Application ID this secret belongs to.
     */
    @SerializedName("appId")
    val appId: String,

    /**
     * Application client secret. Returned in full only when the secret is created; subsequent reads return a masked value.
     */
    @SerializedName("secret")
    val secret: String,

    /**
     * Last few characters of the client secret, used to help identify it.
     */
    @SerializedName("hint")
    val hint: String,

    /**
     * ID of the user who created the secret.
     */
    @SerializedName("createdById")
    val createdById: String,

    /**
     * Name of the user who created the secret.
     */
    @SerializedName("createdByName")
    val createdByName: String,

    /**
     * Time the secret was last used for authentication in ISO 8601 format. Null if never used.
     */
    @SerializedName("lastAccessedAt")
    var lastAccessedAt: String?,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "appId" to appId as Any,
        "secret" to secret as Any,
        "hint" to hint as Any,
        "createdById" to createdById as Any,
        "createdByName" to createdByName as Any,
        "lastAccessedAt" to lastAccessedAt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AppSecretPlaintext(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            appId = map["appId"] as String,
            secret = map["secret"] as String,
            hint = map["hint"] as String,
            createdById = map["createdById"] as String,
            createdByName = map["createdByName"] as String,
            lastAccessedAt = map["lastAccessedAt"] as? String,
        )
    }
}