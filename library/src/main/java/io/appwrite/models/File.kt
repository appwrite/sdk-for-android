package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * File
 */
data class File(
    /**
     * File ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Bucket ID.
     *
     */
    @SerializedName("bucketId")
    val bucketId: String,

    /**
     * File read permissions.
     *
     */
    @SerializedName("\$read")
    val read: List<Any>,

    /**
     * File write permissions.
     *
     */
    @SerializedName("\$write")
    val write: List<Any>,

    /**
     * File name.
     *
     */
    @SerializedName("name")
    val name: String,

    /**
     * File creation date in Unix timestamp.
     *
     */
    @SerializedName("dateCreated")
    val dateCreated: Long,

    /**
     * File MD5 signature.
     *
     */
    @SerializedName("signature")
    val signature: String,

    /**
     * File mime type.
     *
     */
    @SerializedName("mimeType")
    val mimeType: String,

    /**
     * File original size in bytes.
     *
     */
    @SerializedName("sizeOriginal")
    val sizeOriginal: Long,

    /**
     * Total number of chunks available
     *
     */
    @SerializedName("chunksTotal")
    val chunksTotal: Long,

    /**
     * Total number of chunks uploaded
     *
     */
    @SerializedName("chunksUploaded")
    val chunksUploaded: Long
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = File(
            id = map["\$id"] as String,
            bucketId = map["bucketId"] as String,
            read = map["\$read"] as List<Any>,
            write = map["\$write"] as List<Any>,
            name = map["name"] as String,
            dateCreated = (map["dateCreated"] as Number).toLong(),
            signature = map["signature"] as String,
            mimeType = map["mimeType"] as String,
            sizeOriginal = (map["sizeOriginal"] as Number).toLong(),
            chunksTotal = (map["chunksTotal"] as Number).toLong(),
            chunksUploaded = (map["chunksUploaded"] as Number).toLong()
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "bucketId" to bucketId as Any,
        "\$read" to read as Any,
        "\$write" to write as Any,
        "name" to name as Any,
        "dateCreated" to dateCreated as Any,
        "signature" to signature as Any,
        "mimeType" to mimeType as Any,
        "sizeOriginal" to sizeOriginal as Any,
        "chunksTotal" to chunksTotal as Any,
        "chunksUploaded" to chunksUploaded as Any
    )
}