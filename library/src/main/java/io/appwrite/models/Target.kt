package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Target
 */
data class Target(
    /**
     * Target ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Target creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Target update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Target Name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * User ID.
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * Provider ID.
     */
    @SerializedName("providerId")
    var providerId: String?,

    /**
     * The target provider type. Can be one of the following: `email`, `sms` or `push`.
     */
    @SerializedName("providerType")
    val providerType: String,

    /**
     * The target identifier.
     */
    @SerializedName("identifier")
    val identifier: String,

    /**
     * Is the target expired.
     */
    @SerializedName("expired")
    val expired: Boolean,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "userId" to userId as Any,
        "providerId" to providerId as Any?,
        "providerType" to providerType as Any,
        "identifier" to identifier as Any,
        "expired" to expired as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Target(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            userId = (if (map.containsKey("userId")) map["userId"] else "") as String,
            providerId = map["providerId"] as? String,
            providerType = (if (map.containsKey("providerType")) map["providerType"] else "") as String,
            identifier = (if (map.containsKey("identifier")) map["identifier"] else "") as String,
            expired = (if (map.containsKey("expired")) map["expired"] else false) as Boolean,
        )
    }
}
