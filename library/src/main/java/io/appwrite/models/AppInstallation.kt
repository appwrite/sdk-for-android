package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * AppInstallation
 */
data class AppInstallation(
    /**
     * Installation ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Installation creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Installation update time in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * ID of the installed application.
     */
    @SerializedName("appId")
    val appId: String,

    /**
     * ID of the team the application is installed on.
     */
    @SerializedName("teamId")
    val teamId: String,

    /**
     * Scopes granted to the application. Snapshot of the application's installation scopes taken when the installation was created or last updated.
     */
    @SerializedName("scopes")
    val scopes: List<String>,

    /**
     * Authorization details granted to the application. Rich authorization request (RFC 9396) style entries; the Appwrite Console stores authorized project IDs here.
     */
    @SerializedName("authorizationDetails")
    val authorizationDetails: List<Map<String, Any?>>,

    /**
     * ID of the user who created the installation.
     */
    @SerializedName("createdById")
    val createdById: String,

    /**
     * Name of the user who created the installation.
     */
    @SerializedName("createdByName")
    val createdByName: String,

    /**
     * Time an access token was last issued for the installation in ISO 8601 format. Null if never used.
     */
    @SerializedName("lastAccessedAt")
    var lastAccessedAt: String?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "appId" to appId as Any,
        "teamId" to teamId as Any,
        "scopes" to scopes as Any,
        "authorizationDetails" to authorizationDetails as Any,
        "createdById" to createdById as Any,
        "createdByName" to createdByName as Any,
        "lastAccessedAt" to lastAccessedAt as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AppInstallation(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            appId = map["appId"] as String,
            teamId = map["teamId"] as String,
            scopes = map["scopes"] as List<String>,
            authorizationDetails = map["authorizationDetails"] as List<Map<String, Any?>>,
            createdById = map["createdById"] as String,
            createdByName = map["createdByName"] as String,
            lastAccessedAt = map["lastAccessedAt"] as? String,
        )
    }
}
