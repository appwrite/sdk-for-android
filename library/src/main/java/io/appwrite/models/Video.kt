package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.VideoTimelineStatus
import io.appwrite.extensions.jsonCast

/**
 * Video
 */
data class Video(
    /**
     * Video ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Video creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Video update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Video permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerializedName("\$permissions")
    val permissions: List<String>,

    /**
     * Storage bucket ID holding the source file.
     */
    @SerializedName("bucketId")
    val bucketId: String,

    /**
     * Source file ID.
     */
    @SerializedName("fileId")
    val fileId: String,

    /**
     * Video name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Source file size in bytes.
     */
    @SerializedName("size")
    val size: Long,

    /**
     * Container format.
     */
    @SerializedName("format")
    val format: String,

    /**
     * Video duration in milliseconds.
     */
    @SerializedName("duration")
    val duration: Long,

    /**
     * Video width in pixels.
     */
    @SerializedName("width")
    val width: Long,

    /**
     * Video height in pixels.
     */
    @SerializedName("height")
    val height: Long,

    /**
     * Video aspect ratio.
     */
    @SerializedName("aspectRatio")
    val aspectRatio: String,

    /**
     * Video codec.
     */
    @SerializedName("videoCodec")
    val videoCodec: String,

    /**
     * Video format.
     */
    @SerializedName("videoFormat")
    val videoFormat: String,

    /**
     * Video format profile.
     */
    @SerializedName("videoFormatProfile")
    val videoFormatProfile: String,

    /**
     * Video bitrate in bits per second.
     */
    @SerializedName("videoBitRate")
    val videoBitRate: Long,

    /**
     * Video frame rate in frames per second.
     */
    @SerializedName("videoFrameRate")
    val videoFrameRate: Double,

    /**
     * Video frame rate mode.
     */
    @SerializedName("videoFrameRateMode")
    val videoFrameRateMode: String,

    /**
     * Audio codec.
     */
    @SerializedName("audioCodec")
    val audioCodec: String,

    /**
     * Audio format.
     */
    @SerializedName("audioFormat")
    val audioFormat: String,

    /**
     * Audio bitrate in bits per second.
     */
    @SerializedName("audioBitRate")
    val audioBitRate: Long,

    /**
     * Audio sample rate in hertz.
     */
    @SerializedName("audioSampleRate")
    val audioSampleRate: Long,

    /**
     * Thumbnail timeline job status: one of `pending`, `started`, `ready`, `skipped` (source has no video track) or `error`.
     */
    @SerializedName("timelineStatus")
    val timelineStatus: VideoTimelineStatus,

    /**
     * Why the timeline job failed. Empty unless `timelineStatus` is `error`.
     */
    @SerializedName("timelineError")
    val timelineError: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "bucketId" to bucketId as Any,
        "fileId" to fileId as Any,
        "name" to name as Any,
        "size" to size as Any,
        "format" to format as Any,
        "duration" to duration as Any,
        "width" to width as Any,
        "height" to height as Any,
        "aspectRatio" to aspectRatio as Any,
        "videoCodec" to videoCodec as Any,
        "videoFormat" to videoFormat as Any,
        "videoFormatProfile" to videoFormatProfile as Any,
        "videoBitRate" to videoBitRate as Any,
        "videoFrameRate" to videoFrameRate as Any,
        "videoFrameRateMode" to videoFrameRateMode as Any,
        "audioCodec" to audioCodec as Any,
        "audioFormat" to audioFormat as Any,
        "audioBitRate" to audioBitRate as Any,
        "audioSampleRate" to audioSampleRate as Any,
        "timelineStatus" to timelineStatus.value as Any,
        "timelineError" to timelineError as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Video(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            permissions = (if (map.containsKey("\$permissions")) map["\$permissions"] else listOf<Any?>()) as List<String>,
            bucketId = (if (map.containsKey("bucketId")) map["bucketId"] else "") as String,
            fileId = (if (map.containsKey("fileId")) map["fileId"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            size = ((if (map.containsKey("size")) map["size"] else 0) as Number).toLong(),
            format = (if (map.containsKey("format")) map["format"] else "") as String,
            duration = ((if (map.containsKey("duration")) map["duration"] else 0) as Number).toLong(),
            width = ((if (map.containsKey("width")) map["width"] else 0) as Number).toLong(),
            height = ((if (map.containsKey("height")) map["height"] else 0) as Number).toLong(),
            aspectRatio = (if (map.containsKey("aspectRatio")) map["aspectRatio"] else "") as String,
            videoCodec = (if (map.containsKey("videoCodec")) map["videoCodec"] else "") as String,
            videoFormat = (if (map.containsKey("videoFormat")) map["videoFormat"] else "") as String,
            videoFormatProfile = (if (map.containsKey("videoFormatProfile")) map["videoFormatProfile"] else "") as String,
            videoBitRate = ((if (map.containsKey("videoBitRate")) map["videoBitRate"] else 0) as Number).toLong(),
            videoFrameRate = ((if (map.containsKey("videoFrameRate")) map["videoFrameRate"] else 0.0) as Number).toDouble(),
            videoFrameRateMode = (if (map.containsKey("videoFrameRateMode")) map["videoFrameRateMode"] else "") as String,
            audioCodec = (if (map.containsKey("audioCodec")) map["audioCodec"] else "") as String,
            audioFormat = (if (map.containsKey("audioFormat")) map["audioFormat"] else "") as String,
            audioBitRate = ((if (map.containsKey("audioBitRate")) map["audioBitRate"] else 0) as Number).toLong(),
            audioSampleRate = ((if (map.containsKey("audioSampleRate")) map["audioSampleRate"] else 0) as Number).toLong(),
            timelineStatus = VideoTimelineStatus.values().find { it.value == (if (map.containsKey("timelineStatus")) map["timelineStatus"] else "pending") as String }!!,
            timelineError = (if (map.containsKey("timelineError")) map["timelineError"] else "") as String,
        )
    }
}
