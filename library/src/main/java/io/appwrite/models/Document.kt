package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Document
 */
data class Document<T>(
    /**
     * Document ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Document automatically incrementing ID.
     */
    @SerializedName("\$sequence")
    val sequence: Long,

    /**
     * Collection ID.
     */
    @SerializedName("\$collectionId")
    val collectionId: String,

    /**
     * Database ID.
     */
    @SerializedName("\$databaseId")
    val databaseId: String,

    /**
     * Document creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Document update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Document permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerializedName("\$permissions")
    val permissions: List<String>,

    /**
     * Additional properties
     */
    @SerializedName("data")
    val data: T
) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$sequence" to sequence as Any,
        "\$collectionId" to collectionId as Any,
        "\$databaseId" to databaseId as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "data" to data!!.jsonCast(to = Map::class.java)
    )

    companion object {
        operator fun invoke(
            id: String,
            sequence: Long,
            collectionId: String,
            databaseId: String,
            createdAt: String,
            updatedAt: String,
            permissions: List<String>,
            data: Map<String, Any>
        ) = Document<Map<String, Any>>(
            id,
            sequence,
            collectionId,
            databaseId,
            createdAt,
            updatedAt,
            permissions,
            data
        )

        @Suppress("UNCHECKED_CAST")
        fun <T> from(
            map: Map<String, Any>,
            nestedType: Class<T>
        ) = Document<T>(
            id = map["\$id"] as String,
            sequence = (map["\$sequence"] as Number).toLong(),
            collectionId = map["\$collectionId"] as String,
            databaseId = map["\$databaseId"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            permissions = map["\$permissions"] as List<String>,
            data = map.jsonCast(to = nestedType)
        )
    }
}