package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import io.appwrite.models.*
import okhttp3.Cookie
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import java.io.File

/**
 * The Videos service allows you to transcode video files into adaptive HLS and DASH streams.
 */
class Videos(client: Client) : Service(client) {
    /**
     * Get a list of videos in the current project. Sessions receive only videos they can read according to each video's `$permissions`. API keys and admins receive the full project catalog. Playback uses the same document read ACL plus the `videos.play` (or `videos.read`) scope: a guest can stream a video that grants `read("any")` or `read("guests")` even though guests lack `videos.read` and will not see it in this list.
     *
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: bucketId, fileId, name, size, format, duration, width, height, videoCodec, videoBitRate, audioCodec, audioBitRate, search
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.VideoList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.VideoList {
        val apiPath = "/videos"
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.VideoList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.VideoList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.VideoList::class.java,
            converter,
        )
    }

    /**
     * Create a video resource from an existing file in a storage bucket. The source file must be a video or audio file, and the caller must be able to read that file. Creating a video stores the document and queues timeline generation. The worker downloads the source, probes metadata, extracts embedded captions once, and deletes its working copy when finished. Sources with a video track also get a thumbnail timeline. Call create-rendition to package a streaming output.
     *
     * An optional `name` defaults to the source file name. An optional `permissions` array sets the video document ACL (list, get, update, delete, manage child resources, and playback). By default, only the current user is granted all permissions; API keys and admins create with empty permissions when omitted. Guests with `videos.play` can stream when the video grants them read (`read("any")` or `read("guests")`).
     *
     * Uploaded caption files stay listed alongside auto-extracted tracks for the same language; when the current default is an auto-extracted track with that code, the upload takes the default flag.
     *
     *
     * @param videoId Video ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param bucketId Storage bucket unique ID holding the source file.
     * @param fileId Source file unique ID.
     * @param name Video name. Defaults to the source file name. Max length: 2048 chars.
     * @param permissions An array of permission strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @return [io.appwrite.models.Video]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
        videoId: String,
        bucketId: String,
        fileId: String,
        name: String? = null,
        permissions: List<String>? = null,
    ): io.appwrite.models.Video {
        val apiPath = "/videos"
        val apiParams = mutableMapOf<String, Any?>(
            "videoId" to videoId,
            "bucketId" to bucketId,
            "fileId" to fileId,
            "name" to name,
            "permissions" to permissions,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Video = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Video.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Video::class.java,
            converter,
        )
    }

    /**
     * Get a list of video encode codecs enabled on this instance. Each codec includes the output formats it may be packaged into.
     *
     *
     * @return [io.appwrite.models.VideoCodecList]
     */
    @Throws(AppwriteException::class)
    suspend fun listCodecs(): io.appwrite.models.VideoCodecList {
        val apiPath = "/videos/codecs"
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.VideoCodecList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.VideoCodecList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.VideoCodecList::class.java,
            converter,
        )
    }

    /**
     * Get a video by its unique ID. This endpoint response returns a JSON object with the video metadata.
     *
     *
     * @param videoId Video unique ID.
     * @return [io.appwrite.models.Video]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        videoId: String,
    ): io.appwrite.models.Video {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        val apiPath = ("/videos/{videoId}"
            .replace("{videoId}", Client.encodePath(videoId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Video = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Video.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Video::class.java,
            converter,
        )
    }

    /**
     * Update a video's name, permissions, or both. Only the fields you pass are changed: omit `name` to keep the current name and `permissions` to keep the current ACL. The caller must hold update permission on the video document. The source file cannot be replaced; delete the video and create a new one to point at a different file.
     *
     *
     * @param videoId Video unique ID.
     * @param name Video name. Max length: 2048 chars.
     * @param permissions An array of permission strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @return [io.appwrite.models.Video]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
        videoId: String,
        name: String? = null,
        permissions: List<String>? = null,
    ): io.appwrite.models.Video {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        val apiPath = ("/videos/{videoId}"
            .replace("{videoId}", Client.encodePath(videoId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "permissions" to permissions,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Video = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Video.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Video::class.java,
            converter,
        )
    }

    /**
     * Delete a video by its unique ID. This also removes every rendition, caption, preview and transcoded artifact derived from it. Fails with `video_rendition_in_progress` while a rendition is started or ended, unless that rendition has not been updated within the rendition retention window. Fails with `video_timeline_in_progress` while the video's timeline is being generated, unless the video has not been updated within the same window.
     *
     *
     * @param videoId Video unique ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        videoId: String,
    ): Any {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        val apiPath = ("/videos/{videoId}"
            .replace("{videoId}", Client.encodePath(videoId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * Get a list of all the caption tracks attached to a video. You can use the query params to filter your results.
     *
     *
     * @param videoId Video unique ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, language, default, status, size, bucketId, fileId
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.VideoCaptionList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listCaptions(
        videoId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.VideoCaptionList {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        val apiPath = ("/videos/{videoId}/captions"
            .replace("{videoId}", Client.encodePath(videoId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.VideoCaptionList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.VideoCaptionList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.VideoCaptionList::class.java,
            converter,
        )
    }

    /**
     * Add a caption track to a video from a WebVTT or SubRip file in a storage bucket. The file is normalised to WebVTT and segmented in the background. Subscribe to `videos.[videoId].captions.[captionId].update` for `started`, `ready`, and `error` status changes instead of only polling the caption document.
     *
     * Uploaded tracks are listed alongside auto-extracted embedded tracks (`embedded: true`). When the current default is an auto-extracted track for the same language code, the upload takes the default flag so players pick the authored file first. Auto-extracted tracks are never removed automatically — delete a track explicitly to remove it. Extraction runs once per video, so a deleted extracted track is not re-created.
     *
     *
     * @param videoId Video unique ID.
     * @param bucketId Storage bucket unique ID holding the caption file.
     * @param fileId Caption file unique ID.
     * @param name Caption display name. Allowed characters: a-z, A-Z, 0-9, space, and - . , ( ) _ '
     * @param language Caption ISO 639-2 three-letter language code.
     * @param default Make this the default caption track for the video.
     * @return [io.appwrite.models.VideoCaption]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createCaption(
        videoId: String,
        bucketId: String,
        fileId: String,
        name: String,
        language: String,
        default: Boolean? = null,
    ): io.appwrite.models.VideoCaption {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        val apiPath = ("/videos/{videoId}/captions"
            .replace("{videoId}", Client.encodePath(videoId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "bucketId" to bucketId,
            "fileId" to fileId,
            "name" to name,
            "language" to language,
            "default" to default,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.VideoCaption = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.VideoCaption.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.VideoCaption::class.java,
            converter,
        )
    }

    /**
     * Update a caption track by its unique ID. Pass only `name`, `language`, and/or `default` to retag an extracted track (for example `und` → `heb` for Hebrew) without replacing the file. Changing `bucketId`/`fileId` re-packages the track in the background.
     *
     *
     * @param videoId Video unique ID.
     * @param captionId Caption unique ID.
     * @param bucketId Storage bucket unique ID holding the caption file. Omit together with fileId to only update name, language, or default.
     * @param fileId Caption file unique ID. Omit together with bucketId to only update name, language, or default.
     * @param name Caption display name. Allowed characters: a-z, A-Z, 0-9, space, and - . , ( ) _ '
     * @param language Caption ISO 639-2 three-letter language code (for example `heb` for Hebrew).
     * @param default Make this the default caption track for the video. Omit to leave unchanged.
     * @return [io.appwrite.models.VideoCaption]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateCaption(
        videoId: String,
        captionId: String,
        bucketId: String? = null,
        fileId: String? = null,
        name: String? = null,
        language: String? = null,
        default: Boolean? = null,
    ): io.appwrite.models.VideoCaption {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        if (captionId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"captionId\"")
        }
        val apiPath = ("/videos/{videoId}/captions/{captionId}"
            .replace("{videoId}", Client.encodePath(videoId))
            .replace("{captionId}", Client.encodePath(captionId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "bucketId" to bucketId,
            "fileId" to fileId,
            "name" to name,
            "language" to language,
            "default" to default,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.VideoCaption = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.VideoCaption.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.VideoCaption::class.java,
            converter,
        )
    }

    /**
     * Delete a caption track by its unique ID, along with its packaged segments.
     *
     *
     * @param videoId Video unique ID.
     * @param captionId Caption unique ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteCaption(
        videoId: String,
        captionId: String,
    ): Any {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        if (captionId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"captionId\"")
        }
        val apiPath = ("/videos/{videoId}/captions/{captionId}"
            .replace("{videoId}", Client.encodePath(videoId))
            .replace("{captionId}", Client.encodePath(captionId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * Get the top-level streaming manifest for a video output: an HLS master playlist (`master.m3u8`) or a DASH MPD (`master.mpd`). Hand this URL to a player to begin adaptive playback.
     *
     * Guests can request this URL when they hold `videos.play` (or `videos.read`) **and** the video document grants them read. A video with `read("any")` or `read("guests")` is playable without a session.
     *
     * For CMAF renditions, use `getCmafHlsManifest` or `getCmafDashManifest`. Both masters point at the same fMP4 segment set.
     *
     *
     * @param videoId Video unique ID.
     * @return [ByteArray]
     */
    @Throws(AppwriteException::class)
    suspend fun getCmafHlsManifest(
        videoId: String,
    ): ByteArray {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        val apiPath = ("/videos/{videoId}/outputs/cmaf/master.m3u8"
            .replace("{videoId}", Client.encodePath(videoId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "*/*",
        )
        return client.call(
            "GET",
            apiPath,
            headers = apiHeaders,
            params = apiParams,
            responseType = ByteArray::class.java
        )
    }

    /**
     * Get the top-level streaming manifest for a video output: an HLS master playlist (`master.m3u8`) or a DASH MPD (`master.mpd`). Hand this URL to a player to begin adaptive playback.
     *
     * Guests can request this URL when they hold `videos.play` (or `videos.read`) **and** the video document grants them read. A video with `read("any")` or `read("guests")` is playable without a session.
     *
     * For CMAF renditions, use `getCmafHlsManifest` or `getCmafDashManifest`. Both masters point at the same fMP4 segment set.
     *
     *
     * @param videoId Video unique ID.
     * @return [ByteArray]
     */
    @Throws(AppwriteException::class)
    suspend fun getCmafDashManifest(
        videoId: String,
    ): ByteArray {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        val apiPath = ("/videos/{videoId}/outputs/cmaf/master.mpd"
            .replace("{videoId}", Client.encodePath(videoId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "*/*",
        )
        return client.call(
            "GET",
            apiPath,
            headers = apiHeaders,
            params = apiParams,
            responseType = ByteArray::class.java
        )
    }

    /**
     * Get the top-level streaming manifest for a video output: an HLS master playlist (`master.m3u8`) or a DASH MPD (`master.mpd`). Hand this URL to a player to begin adaptive playback.
     *
     * Guests can request this URL when they hold `videos.play` (or `videos.read`) **and** the video document grants them read. A video with `read("any")` or `read("guests")` is playable without a session.
     *
     * For CMAF renditions, use `getCmafHlsManifest` or `getCmafDashManifest`. Both masters point at the same fMP4 segment set.
     *
     *
     * @param videoId Video unique ID.
     * @return [ByteArray]
     */
    @Throws(AppwriteException::class)
    suspend fun getDashManifest(
        videoId: String,
    ): ByteArray {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        val apiPath = ("/videos/{videoId}/outputs/dash/master.mpd"
            .replace("{videoId}", Client.encodePath(videoId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "*/*",
        )
        return client.call(
            "GET",
            apiPath,
            headers = apiHeaders,
            params = apiParams,
            responseType = ByteArray::class.java
        )
    }

    /**
     * Get the top-level streaming manifest for a video output: an HLS master playlist (`master.m3u8`) or a DASH MPD (`master.mpd`). Hand this URL to a player to begin adaptive playback.
     *
     * Guests can request this URL when they hold `videos.play` (or `videos.read`) **and** the video document grants them read. A video with `read("any")` or `read("guests")` is playable without a session.
     *
     * For CMAF renditions, use `getCmafHlsManifest` or `getCmafDashManifest`. Both masters point at the same fMP4 segment set.
     *
     *
     * @param videoId Video unique ID.
     * @return [ByteArray]
     */
    @Throws(AppwriteException::class)
    suspend fun getHlsManifest(
        videoId: String,
    ): ByteArray {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        val apiPath = ("/videos/{videoId}/outputs/hls/master.m3u8"
            .replace("{videoId}", Client.encodePath(videoId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "*/*",
        )
        return client.call(
            "GET",
            apiPath,
            headers = apiHeaders,
            params = apiParams,
            responseType = ByteArray::class.java
        )
    }

    /**
     * Get the playable caption resource for a video output: an HLS captions playlist, or the WebVTT file itself for DASH.
     *
     * Guests can request this URL when they hold `videos.play` (or `videos.read`) **and** the video document grants them read.
     *
     *
     * @param videoId Video unique ID.
     * @param output Streaming output format.
     * @param captionId Caption unique ID.
     * @return [ByteArray]
     */
    @Throws(AppwriteException::class)
    suspend fun getCaptionManifest(
        videoId: String,
        output: io.appwrite.enums.VideoOutput,
        captionId: String,
    ): ByteArray {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        if (captionId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"captionId\"")
        }
        val apiPath = ("/videos/{videoId}/outputs/{output}/captions/{captionId}/manifest"
            .replace("{videoId}", Client.encodePath(videoId))
            .replace("{output}", Client.encodePath(output.value))
            .replace("{captionId}", Client.encodePath(captionId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "*/*",
        )
        return client.call(
            "GET",
            apiPath,
            headers = apiHeaders,
            params = apiParams,
            responseType = ByteArray::class.java
        )
    }

    /**
     * Get a list of all the renditions of a video. You can use the query params to filter your results.
     *
     *
     * @param videoId Video unique ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: profileId, name, status, output, codec, width, height, videoBitRate, audioBitRate, size, startedAt, endedAt
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.VideoRenditionList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listRenditions(
        videoId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.VideoRenditionList {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        val apiPath = ("/videos/{videoId}/renditions"
            .replace("{videoId}", Client.encodePath(videoId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.VideoRenditionList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.VideoRenditionList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.VideoRenditionList::class.java,
            converter,
        )
    }

    /**
     * Get a rendition by its unique ID, including its current transcoding status and progress.
     *
     *
     * @param videoId Video unique ID.
     * @param renditionId Rendition unique ID.
     * @return [io.appwrite.models.VideoRendition]
     */
    @Throws(AppwriteException::class)
    suspend fun getRendition(
        videoId: String,
        renditionId: String,
    ): io.appwrite.models.VideoRendition {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        if (renditionId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"renditionId\"")
        }
        val apiPath = ("/videos/{videoId}/renditions/{renditionId}"
            .replace("{videoId}", Client.encodePath(videoId))
            .replace("{renditionId}", Client.encodePath(renditionId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.VideoRendition = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.VideoRendition.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.VideoRendition::class.java,
            converter,
        )
    }

    /**
     * Delete a rendition by its unique ID, along with its packaged segments and transcoded output. Fails with `video_rendition_in_progress` while the rendition is started or ended, unless it has not been updated within the rendition retention window.
     *
     *
     * @param videoId Video unique ID.
     * @param renditionId Rendition unique ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteRendition(
        videoId: String,
        renditionId: String,
    ): Any {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        if (renditionId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"renditionId\"")
        }
        val apiPath = ("/videos/{videoId}/renditions/{renditionId}"
            .replace("{videoId}", Client.encodePath(videoId))
            .replace("{renditionId}", Client.encodePath(renditionId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * Get a single thumbnail sheet from a video's timeline as an image. You can resize the returned image and choose its output format.
     *
     * Guests can request this URL when they hold `videos.play` (or `videos.read`) **and** the video document grants them read.
     *
     *
     * @param videoId Video unique ID.
     * @param thumbnailId Thumbnail unique ID.
     * @param width Resize thumbnail image width, in pixels.
     * @param height Resize thumbnail image height, in pixels.
     * @param output Output format type (jpeg, jpg, png, gif and webp).
     * @return [ByteArray]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getThumbnail(
        videoId: String,
        thumbnailId: String,
        width: Long? = null,
        height: Long? = null,
        output: io.appwrite.enums.ImageFormat? = null,
    ): ByteArray {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        if (thumbnailId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"thumbnailId\"")
        }
        val apiPath = ("/videos/{videoId}/thumbnails/{thumbnailId}"
            .replace("{videoId}", Client.encodePath(videoId))
            .replace("{thumbnailId}", Client.encodePath(thumbnailId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "width" to width,
            "height" to height,
            "output" to output,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "image/*",
        )
        return client.call(
            "GET",
            apiPath,
            headers = apiHeaders,
            params = apiParams,
            responseType = ByteArray::class.java
        )
    }

    /**
     * Get the WebVTT thumbnail timeline for a video, used to render scrubbing thumbnails in a player. Timeline generation is queued when the video is created. Subscribe to `videos.[videoId].timelines.update` for probe and terminal updates, or poll this endpoint until it returns a WebVTT document. Audio-only sources produce no timeline and this endpoint returns `video_timelines_not_found`.
     *
     * Guests can request this URL when they hold `videos.play` (or `videos.read`) **and** the video document grants them read. A video with `read("any")` or `read("guests")` is playable without a session.
     *
     *
     * @param videoId Video unique ID.
     * @return [ByteArray]
     */
    @Throws(AppwriteException::class)
    suspend fun getTimeline(
        videoId: String,
    ): ByteArray {
        if (videoId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"videoId\"")
        }
        val apiPath = ("/videos/{videoId}/timeline"
            .replace("{videoId}", Client.encodePath(videoId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "*/*",
        )
        return client.call(
            "GET",
            apiPath,
            headers = apiHeaders,
            params = apiParams,
            responseType = ByteArray::class.java
        )
    }
}
