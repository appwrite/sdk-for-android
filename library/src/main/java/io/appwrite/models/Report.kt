package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Report
 */
data class Report(
    /**
     * Report ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Report creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Report update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * ID of the third-party app that submitted the report.
     */
    @SerializedName("appId")
    val appId: String,

    /**
     * Analyzer that produced this report. e.g. lighthouse, audit, databaseAnalyzer.
     */
    @SerializedName("type")
    val type: String,

    /**
     * Short, human-readable title for the report.
     */
    @SerializedName("title")
    val title: String,

    /**
     * Markdown summary describing the report.
     */
    @SerializedName("summary")
    val summary: String,

    /**
     * Plural noun describing what the report analyzes, e.g. databases, sites, urls.
     */
    @SerializedName("targetType")
    val targetType: String,

    /**
     * Free-form target identifier (URL for lighthouse, resource ID for db).
     */
    @SerializedName("target")
    val target: String,

    /**
     * Categories covered by the report, e.g. performance, accessibility.
     */
    @SerializedName("categories")
    val categories: List<String>,

    /**
     * Insights nested under this report.
     */
    @SerializedName("insights")
    val insights: List<Insight>,

    /**
     * Time the report was analyzed in ISO 8601 format.
     */
    @SerializedName("analyzedAt")
    var analyzedAt: String?,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "appId" to appId as Any,
        "type" to type as Any,
        "title" to title as Any,
        "summary" to summary as Any,
        "targetType" to targetType as Any,
        "target" to target as Any,
        "categories" to categories as Any,
        "insights" to insights.map { it.toMap() } as Any,
        "analyzedAt" to analyzedAt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Report(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            appId = map["appId"] as String,
            type = map["type"] as String,
            title = map["title"] as String,
            summary = map["summary"] as String,
            targetType = map["targetType"] as String,
            target = map["target"] as String,
            categories = map["categories"] as List<String>,
            insights = (map["insights"] as List<Map<String, Any>>).map { Insight.from(map = it) },
            analyzedAt = map["analyzedAt"] as? String,
        )
    }
}