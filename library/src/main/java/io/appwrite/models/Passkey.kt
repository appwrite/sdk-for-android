package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Passkey
 */
data class Passkey(
    /**
     * Passkey ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Passkey creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Passkey update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Passkey name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Most recent sign-in with this passkey in ISO 8601 format. Empty until the passkey is used to sign in.
     */
    @SerializedName("accessedAt")
    val accessedAt: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "accessedAt" to accessedAt as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Passkey(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            accessedAt = map["accessedAt"] as String,
        )
    }
}
