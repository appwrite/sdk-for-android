package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * App installations list
 */
data class AppInstallationList(
    /**
     * Total number of installations that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of installations.
     */
    @SerializedName("installations")
    val installations: List<AppInstallation>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "installations" to installations.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AppInstallationList(
            total = (map["total"] as Number).toLong(),
            installations = (map["installations"] as List<Map<String, Any>>).map { AppInstallation.from(map = it) },
        )
    }
}
