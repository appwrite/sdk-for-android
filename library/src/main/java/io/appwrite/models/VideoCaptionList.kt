package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Video Captions List
 */
data class VideoCaptionList(
    /**
     * Total number of captions that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of captions.
     */
    @SerializedName("captions")
    val captions: List<VideoCaption>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "captions" to captions.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = VideoCaptionList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            captions = ((if (map.containsKey("captions")) map["captions"] else listOf<Any?>()) as List<Map<String, Any>>).map { VideoCaption.from(map = it) },
        )
    }
}
