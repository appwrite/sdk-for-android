package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Detection
 */
data class Detection(
    /**
     * Runtime
     */
    @SerializedName("runtime")
    val runtime: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "runtime" to runtime as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Detection(
            runtime = map["runtime"] as String,
        )
    }
}