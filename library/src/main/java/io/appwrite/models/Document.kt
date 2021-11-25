package io.appwrite.models

/**
 * Document
 */
data class Document(
    /**
     * Document ID.
     *
     */
    val id: String,

    /**
     * Collection ID.
     *
     */
    val collection: String,

    /**
     * Document read permissions.
     *
     */
    val read: List<Any>,

    /**
     * Document write permissions.
     *
     */
    val write: List<Any>,

    val data: Map<String, Any>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Document(
            id = map["\$id"] as String,
            collection = map["\$collection"] as String,
            read = map["\$read"] as List<Any>,
            write = map["\$write"] as List<Any>,
            data = map
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$collection" to collection as Any,
        "\$read" to read as Any,
        "\$write" to write as Any,
        "data" to data
    )

    fun <T> convertTo(fromJson: (Map<String, Any>) -> T): T {
        return fromJson(data)
    }
}