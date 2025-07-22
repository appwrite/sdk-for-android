package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Rows List
 */
data class RowList<T>(
    /**
     * Total number of rows rows that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of rows.
     */
    @SerializedName("rows")
    val rows: List<Row<T>>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "rows" to rows.map { it.toMap() } as Any,
    )

    companion object {
        operator fun invoke(
            total: Long,
            rows: List<Row<Map<String, Any>>>,
        ) = RowList<Map<String, Any>>(
            total,
            rows,
        )

        @Suppress("UNCHECKED_CAST")
        fun <T> from(
            map: Map<String, Any>,
            nestedType: Class<T>
        ) = RowList<T>(
            total = (map["total"] as Number).toLong(),
            rows = (map["rows"] as List<Map<String, Any>>).map { Row.from(map = it, nestedType) },
        )
    }
}