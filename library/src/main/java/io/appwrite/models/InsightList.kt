package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Insights List
 */
data class InsightList(
    /**
     * Total number of insights that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of insights.
     */
    @SerializedName("insights")
    val insights: List<Insight>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "insights" to insights.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = InsightList(
            total = (map["total"] as Number).toLong(),
            insights = (map["insights"] as List<Map<String, Any>>).map { Insight.from(map = it) },
        )
    }
}