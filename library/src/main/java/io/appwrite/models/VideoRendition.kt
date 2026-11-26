package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.VideoRenditionStatus
import io.appwrite.enums.VideoOutput
import io.appwrite.enums.VideoCodecId
import io.appwrite.extensions.jsonCast

/**
 * Video rendition
 */
data class VideoRendition(
    /**
     * Rendition ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Rendition creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Rendition update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Video ID.
     */
    @SerializedName("videoId")
    val videoId: String,

    /**
     * Video profile ID this rendition was encoded against.
     */
    @SerializedName("profileId")
    val profileId: String,

    /**
     * Rendition name, derived from its dimensions and bitrate.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Transcoding start time in ISO 8601 format.
     */
    @SerializedName("startedAt")
    val startedAt: String,

    /**
     * Transcoding end time in ISO 8601 format.
     */
    @SerializedName("endedAt")
    val endedAt: String,

    /**
     * Rendition width in pixels.
     */
    @SerializedName("width")
    val width: Long,

    /**
     * Rendition height in pixels.
     */
    @SerializedName("height")
    val height: Long,

    /**
     * Video bitrate in bits per second.
     */
    @SerializedName("videoBitRate")
    val videoBitRate: Long,

    /**
     * Audio bitrate in bits per second.
     */
    @SerializedName("audioBitRate")
    val audioBitRate: Long,

    /**
     * Longest segment duration in seconds.
     */
    @SerializedName("targetDuration")
    val targetDuration: Double,

    /**
     * Transcoding status: one of `pending`, `started`, `ended`, `ready`, `error` or `aborted`.
     */
    @SerializedName("status")
    val status: VideoRenditionStatus,

    /**
     * Why the rendition failed or was aborted. Empty unless `status` is `error` or `aborted`.
     */
    @SerializedName("error")
    val error: String,

    /**
     * Transcoding progress as a percentage, from 0 to 100.
     */
    @SerializedName("progress")
    val progress: Long,

    /**
     * Streaming output format: `hls`, `dash`, or `cmaf`.
     */
    @SerializedName("output")
    val output: VideoOutput,

    /**
     * Video encode codec snapshotted from the profile at create time: one of `h264`, `hevc`, or `vp9`.
     */
    @SerializedName("codec")
    val codec: VideoCodecId,

    /**
     * Stored rendition size in bytes.
     */
    @SerializedName("size")
    val size: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "videoId" to videoId as Any,
        "profileId" to profileId as Any,
        "name" to name as Any,
        "startedAt" to startedAt as Any,
        "endedAt" to endedAt as Any,
        "width" to width as Any,
        "height" to height as Any,
        "videoBitRate" to videoBitRate as Any,
        "audioBitRate" to audioBitRate as Any,
        "targetDuration" to targetDuration as Any,
        "status" to status.value as Any,
        "error" to error as Any,
        "progress" to progress as Any,
        "output" to output.value as Any,
        "codec" to codec.value as Any,
        "size" to size as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = VideoRendition(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            videoId = (if (map.containsKey("videoId")) map["videoId"] else "") as String,
            profileId = (if (map.containsKey("profileId")) map["profileId"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            startedAt = (if (map.containsKey("startedAt")) map["startedAt"] else "") as String,
            endedAt = (if (map.containsKey("endedAt")) map["endedAt"] else "") as String,
            width = ((if (map.containsKey("width")) map["width"] else 0) as Number).toLong(),
            height = ((if (map.containsKey("height")) map["height"] else 0) as Number).toLong(),
            videoBitRate = ((if (map.containsKey("videoBitRate")) map["videoBitRate"] else 0) as Number).toLong(),
            audioBitRate = ((if (map.containsKey("audioBitRate")) map["audioBitRate"] else 0) as Number).toLong(),
            targetDuration = ((if (map.containsKey("targetDuration")) map["targetDuration"] else 0.0) as Number).toDouble(),
            status = VideoRenditionStatus.values().find { it.value == (if (map.containsKey("status")) map["status"] else "pending") as String }!!,
            error = (if (map.containsKey("error")) map["error"] else "") as String,
            progress = ((if (map.containsKey("progress")) map["progress"] else 0) as Number).toLong(),
            output = VideoOutput.values().find { it.value == (if (map.containsKey("output")) map["output"] else "hls") as String }!!,
            codec = VideoCodecId.values().find { it.value == (if (map.containsKey("codec")) map["codec"] else "h264") as String }!!,
            size = ((if (map.containsKey("size")) map["size"] else 0) as Number).toLong(),
        )
    }
}
