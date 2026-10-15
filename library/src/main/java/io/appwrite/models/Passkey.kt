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
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            accessedAt = (if (map.containsKey("accessedAt")) map["accessedAt"] else "") as String,
        )
    }
}
