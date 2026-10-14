package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * File
 */
data class File(
    /**
     * File ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Bucket ID.
     */
    @SerializedName("bucketId")
    val bucketId: String,

    /**
     * File creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * File update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * File permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerializedName("\$permissions")
    val permissions: List<String>,

    /**
     * File name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Virtual folder containing the file, with a trailing slash. Empty for the bucket root.
     */
    @SerializedName("folder")
    val folder: String,

    /**
     * Full virtual path of the file: the folder followed by the file name.
     */
    @SerializedName("key")
    val key: String,

    /**
     * File MD5 signature.
     */
    @SerializedName("signature")
    val signature: String,

    /**
     * File mime type.
     */
    @SerializedName("mimeType")
    val mimeType: String,

    /**
     * File original size in bytes.
     */
    @SerializedName("sizeOriginal")
    val sizeOriginal: Long,

    /**
     * File actual stored size in bytes after compression and/or encryption.
     */
    @SerializedName("sizeActual")
    val sizeActual: Long,

    /**
     * Total number of chunks available
     */
    @SerializedName("chunksTotal")
    val chunksTotal: Long,

    /**
     * Total number of chunks uploaded
     */
    @SerializedName("chunksUploaded")
    val chunksUploaded: Long,

    /**
     * Whether file contents are encrypted at rest.
     */
    @SerializedName("encryption")
    val encryption: Boolean,

    /**
     * Compression algorithm used for the file. Will be one of none, [gzip](https://en.wikipedia.org/wiki/Gzip), or [zstd](https://en.wikipedia.org/wiki/Zstd).
     */
    @SerializedName("compression")
    val compression: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "bucketId" to bucketId as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "name" to name as Any,
        "folder" to folder as Any,
        "key" to key as Any,
        "signature" to signature as Any,
        "mimeType" to mimeType as Any,
        "sizeOriginal" to sizeOriginal as Any,
        "sizeActual" to sizeActual as Any,
        "chunksTotal" to chunksTotal as Any,
        "chunksUploaded" to chunksUploaded as Any,
        "encryption" to encryption as Any,
        "compression" to compression as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = File(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            bucketId = (if (map.containsKey("bucketId")) map["bucketId"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            permissions = (if (map.containsKey("\$permissions")) map["\$permissions"] else listOf<Any?>()) as List<String>,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            folder = (if (map.containsKey("folder")) map["folder"] else "") as String,
            key = (if (map.containsKey("key")) map["key"] else "") as String,
            signature = (if (map.containsKey("signature")) map["signature"] else "") as String,
            mimeType = (if (map.containsKey("mimeType")) map["mimeType"] else "") as String,
            sizeOriginal = ((if (map.containsKey("sizeOriginal")) map["sizeOriginal"] else 0) as Number).toLong(),
            sizeActual = ((if (map.containsKey("sizeActual")) map["sizeActual"] else 0) as Number).toLong(),
            chunksTotal = ((if (map.containsKey("chunksTotal")) map["chunksTotal"] else 0) as Number).toLong(),
            chunksUploaded = ((if (map.containsKey("chunksUploaded")) map["chunksUploaded"] else 0) as Number).toLong(),
            encryption = (if (map.containsKey("encryption")) map["encryption"] else false) as Boolean,
            compression = (if (map.containsKey("compression")) map["compression"] else "none") as String,
        )
    }
}
