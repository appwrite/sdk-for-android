package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * AppKey
 */
data class AppKey(
    /**
     * App key ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * App key creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * App key update time in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Application ID this app key belongs to.
     */
    @SerializedName("appId")
    val appId: String,

    /**
     * App key secret.
     */
    @SerializedName("secret")
    val secret: String,

    /**
     * Last few characters of the app key secret, used to help identify it.
     */
    @SerializedName("hint")
    val hint: String,

    /**
     * ID of the user who created the app key.
     */
    @SerializedName("createdById")
    val createdById: String,

    /**
     * Name of the user who created the app key.
     */
    @SerializedName("createdByName")
    val createdByName: String,

    /**
     * Time the app key was last used for authentication in ISO 8601 format. Null if never used.
     */
    @SerializedName("lastAccessedAt")
    var lastAccessedAt: String?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "appId" to appId as Any,
        "secret" to secret as Any,
        "hint" to hint as Any,
        "createdById" to createdById as Any,
        "createdByName" to createdByName as Any,
        "lastAccessedAt" to lastAccessedAt as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AppKey(
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
