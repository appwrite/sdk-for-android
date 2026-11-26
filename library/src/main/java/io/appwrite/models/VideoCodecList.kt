package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Video Codecs List
 */
data class VideoCodecList(
    /**
     * Total number of codecs that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of codecs.
     */
    @SerializedName("codecs")
    val codecs: List<VideoCodec>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "codecs" to codecs.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = VideoCodecList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            codecs = ((if (map.containsKey("codecs")) map["codecs"] else listOf<Any?>()) as List<Map<String, Any>>).map { VideoCodec.from(map = it) },
        )
    }
}
