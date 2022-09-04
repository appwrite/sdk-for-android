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
    @SerializedName("\$collection")
    val collection: String,

    /**
     * Document creation date in Datetime
     *
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Document update date in Datetime
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
            collection = map["\$collection"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            permissions = map["\$permissions"] as List<Any>,
            data = map
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$collection" to collection as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "data" to data
    )

    fun <T> convertTo(fromJson: (Map<String, Any>) -> T): T {
        return fromJson(data)
    }
}