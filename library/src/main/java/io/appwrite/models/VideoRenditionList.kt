package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Video Renditions List
 */
data class VideoRenditionList(
    /**
     * Total number of renditions that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of renditions.
     */
    @SerializedName("renditions")
    val renditions: List<VideoRendition>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "renditions" to renditions.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = VideoRenditionList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            renditions = ((if (map.containsKey("renditions")) map["renditions"] else listOf<Any?>()) as List<Map<String, Any>>).map { VideoRendition.from(map = it) },
        )
    }
}
