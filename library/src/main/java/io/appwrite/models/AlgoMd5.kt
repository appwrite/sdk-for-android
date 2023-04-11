package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * AlgoMD5
 */
data class AlgoMd5(
    /**
     * Algo type.
     */
    @SerializedName("type")
    val type: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "type" to type as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AlgoMd5(
            type = map["type"] as String,
        )
    }
}