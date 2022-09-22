package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Document
 */
data class Document(
    /**
     * Document ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Collection ID.
     *
     */
    @SerializedName("\$collectionId")
    val collectionId: String,

    /**
     * Database ID.
     *
     */
    @SerializedName("\$databaseId")
    val databaseId: String,

    /**
     * Document creation date in ISO 8601 format.
     *
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Document update date in ISO 8601 format.
     *
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Document permissions. [Learn more about permissions](/docs/permissions).
     *
     */
    @SerializedName("\$permissions")
    val permissions: List<Any>,

    val data: Map<String, Any>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Document(
            id = map["\$id"] as String,
            collectionId = map["\$collectionId"] as String,
            databaseId = map["\$databaseId"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            permissions = map["\$permissions"] as List<Any>,
            data = map
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$collectionId" to collectionId as Any,
        "\$databaseId" to databaseId as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "data" to data
    )

    fun <T> convertTo(fromJson: (Map<String, Any>) -> T): T {
        return fromJson(data)
    }
}