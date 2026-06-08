package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Apps list
 */
data class AppsList(
    /**
     * Total number of apps that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of apps.
     */
    @SerializedName("apps")
    val apps: List<App>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "apps" to apps.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AppsList(
            total = (map["total"] as Number).toLong(),
            apps = (map["apps"] as List<Map<String, Any>>).map { App.from(map = it) },
        )
    }
}