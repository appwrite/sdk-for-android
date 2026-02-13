package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Key
 */
data class Key(
    /**
     * Key ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Key creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Key update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Key name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Key expiration date in ISO 8601 format.
     */
    @SerializedName("expire")
    val expire: String,

    /**
     * Allowed permission scopes.
     */
    @SerializedName("scopes")
    val scopes: List<String>,

    /**
     * Secret key.
     */
    @SerializedName("secret")
    val secret: String,

    /**
     * Most recent access date in ISO 8601 format. This attribute is only updated again after 24 hours.
     */
    @SerializedName("accessedAt")
    val accessedAt: String,

    /**
     * List of SDK user agents that used this key.
     */
    @SerializedName("sdks")
    val sdks: List<String>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "expire" to expire as Any,
        "scopes" to scopes as Any,
        "secret" to secret as Any,
        "accessedAt" to accessedAt as Any,
        "sdks" to sdks as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Key(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            expire = map["expire"] as String,
            scopes = map["scopes"] as List<String>,
            secret = map["secret"] as String,
            accessedAt = map["accessedAt"] as String,
            sdks = map["sdks"] as List<String>,
        )
    }
}