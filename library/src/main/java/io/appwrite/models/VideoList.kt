package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Videos List
 */
data class VideoList(
    /**
     * Total number of videos that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of videos.
     */
    @SerializedName("videos")
    val videos: List<Video>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "videos" to videos.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = VideoList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            videos = ((if (map.containsKey("videos")) map["videos"] else listOf<Any?>()) as List<Map<String, Any>>).map { Video.from(map = it) },
        )
    }
}
