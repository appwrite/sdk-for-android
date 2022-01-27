package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Documents List
 */
data class DocumentList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of documents.
     *
     */
    @SerializedName("documents")
    val documents: List<Document>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = DocumentList(
            sum = (map["sum"] as Number).toLong(),
            documents = (map["documents"] as List<Map<String, Any>>).map { Document.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "documents" to documents.map { it.toMap() } as Any
    )

    fun <T> convertTo(fromJson: (Map<String, Any>) -> T) =
        documents.map { it.convertTo(fromJson = fromJson) }
}