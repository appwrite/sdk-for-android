package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Video codec
 */
data class VideoCodec(
    /**
     * Codec ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Codec display name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Streaming output formats this codec may be packaged into.
     */
    @SerializedName("outputs")
    val outputs: List<io.appwrite.enums.VideoOutput>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "name" to name as Any,
        "outputs" to outputs.map { it.value } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = VideoCodec(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            outputs = ((if (map.containsKey("outputs")) map["outputs"] else listOf<Any?>()) as List<*>).mapNotNull { value -> io.appwrite.enums.VideoOutput.values().find { it.value == value } },
        )
    }
}
