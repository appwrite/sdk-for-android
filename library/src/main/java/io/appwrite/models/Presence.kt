package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Presence
 */
data class Presence<T>(
    /**
     * Presence ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Presence creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Presence update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Presence permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerializedName("\$permissions")
    val permissions: List<String>,

    /**
     * User ID.
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * Presence status.
     */
    @SerializedName("status")
    var status: String?,

    /**
     * Presence source.
     */
    @SerializedName("source")
    val source: String,

    /**
     * Presence expiry date in ISO 8601 format.
     */
    @SerializedName("expiresAt")
    var expiresAt: String?,

    /**
     * Additional properties
     */
    @SerializedName("metadata")
    val metadata: T
) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "userId" to userId as Any,
        "status" to status as Any,
        "source" to source as Any,
        "expiresAt" to expiresAt as Any,
        "metadata" to metadata!!.jsonCast(to = Map::class.java)
    )

    companion object {
        operator fun invoke(
            id: String,
            createdAt: String,
            updatedAt: String,
            permissions: List<String>,
            userId: String,
            status: String?,
            source: String,
            expiresAt: String?,
            metadata: Map<String, Any>
        ) = Presence<Map<String, Any>>(
            id,
            createdAt,
            updatedAt,
            permissions,
            userId,
            status,
            source,
            expiresAt,
            metadata
        )

        @Suppress("UNCHECKED_CAST")
        fun <T> from(
            map: Map<String, Any>,
            nestedType: Class<T>
        ) = Presence<T>(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            permissions = map["\$permissions"] as List<String>,
            userId = map["userId"] as String,
            status = map["status"] as? String,
            source = map["source"] as String,
            expiresAt = map["expiresAt"] as? String,
            metadata = map["metadata"]?.jsonCast(to = nestedType) ?: emptyMap<String, Any>().jsonCast(to = nestedType)
        )
    }
}