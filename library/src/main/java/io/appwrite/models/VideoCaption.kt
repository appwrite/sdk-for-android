package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.VideoCaptionStatus
import io.appwrite.extensions.jsonCast

/**
 * Video caption
 */
data class VideoCaption(
    /**
     * Caption ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Caption creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Caption update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Video ID.
     */
    @SerializedName("videoId")
    val videoId: String,

    /**
     * Storage bucket ID holding the caption file.
     */
    @SerializedName("bucketId")
    val bucketId: String,

    /**
     * Caption file ID.
     */
    @SerializedName("fileId")
    val fileId: String,

    /**
     * Caption display name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Caption ISO 639-2 language code.
     */
    @SerializedName("language")
    val language: String,

    /**
     * Is this the default caption track?
     */
    @SerializedName("default")
    val default: Boolean,

    /**
     * Was this track auto-extracted from the source container? Extracted tracks have no backing file; extraction runs once per video, so a deleted extracted track is not re-created.
     */
    @SerializedName("embedded")
    val embedded: Boolean,

    /**
     * Longest segment duration in seconds.
     */
    @SerializedName("targetDuration")
    val targetDuration: Double,

    /**
     * Packaging status: one of `pending`, `started`, `ready`, `error` or `aborted`.
     */
    @SerializedName("status")
    val status: VideoCaptionStatus,

    /**
     * Why the caption failed or was aborted. Empty unless `status` is `error` or `aborted`.
     */
    @SerializedName("error")
    val error: String,

    /**
     * Stored caption size in bytes.
     */
    @SerializedName("size")
    val size: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "videoId" to videoId as Any,
        "bucketId" to bucketId as Any,
        "fileId" to fileId as Any,
        "name" to name as Any,
        "language" to language as Any,
        "default" to default as Any,
        "embedded" to embedded as Any,
        "targetDuration" to targetDuration as Any,
        "status" to status.value as Any,
        "error" to error as Any,
        "size" to size as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = VideoCaption(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            videoId = (if (map.containsKey("videoId")) map["videoId"] else "") as String,
            bucketId = (if (map.containsKey("bucketId")) map["bucketId"] else "") as String,
            fileId = (if (map.containsKey("fileId")) map["fileId"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            language = (if (map.containsKey("language")) map["language"] else "") as String,
            default = (if (map.containsKey("default")) map["default"] else false) as Boolean,
            embedded = (if (map.containsKey("embedded")) map["embedded"] else false) as Boolean,
            targetDuration = ((if (map.containsKey("targetDuration")) map["targetDuration"] else 0.0) as Number).toDouble(),
            status = VideoCaptionStatus.values().find { it.value == (if (map.containsKey("status")) map["status"] else "pending") as String }!!,
            error = (if (map.containsKey("error")) map["error"] else "") as String,
            size = ((if (map.containsKey("size")) map["size"] else 0) as Number).toLong(),
        )
    }
}
