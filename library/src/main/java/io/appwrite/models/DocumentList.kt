package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Documents List
 */
data class DocumentList(
    /**
     * Total number of documents documents that matched your query.
     *
     */
    @SerializedName("total")
    val total: Long,

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
            total = (map["total"] as Number).toLong(),
            documents = (map["documents"] as List<Map<String, Any>>).map { Document.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "documents" to documents.map { it.toMap() } as Any
    )

    fun <T> convertTo(fromJson: (Map<String, Any>) -> T) =
        documents.map { it.convertTo(fromJson = fromJson) }
}