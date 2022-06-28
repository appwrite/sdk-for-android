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
     * Document creation date in Unix timestamp.
     *
     */
    @SerializedName("\$createdAt")
    val createdAt: Long,

    /**
     * Document update date in Unix timestamp.
     *
     */
    @SerializedName("\$updatedAt")
    val updatedAt: Long,

    /**
     * Document read permissions.
     *
     */
    @SerializedName("\$read")
    val read: List<Any>,

    /**
     * Document write permissions.
     *
     */
    @SerializedName("\$write")
    val write: List<Any>,

    val data: Map<String, Any>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Document(
            id = map["\$id"] as String,
            collection = map["\$collection"] as String,
            createdAt = (map["\$createdAt"] as Number).toLong(),
            updatedAt = (map["\$updatedAt"] as Number).toLong(),
            read = map["\$read"] as List<Any>,
            write = map["\$write"] as List<Any>,
            data = map
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$collection" to collection as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$read" to read as Any,
        "\$write" to write as Any,
        "data" to data
    )

    fun <T> convertTo(fromJson: (Map<String, Any>) -> T): T {
        return fromJson(data)
    }
}