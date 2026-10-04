package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * App keys list
 */
data class AppKeyList(
    /**
     * Total number of keys that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of keys.
     */
    @SerializedName("keys")
    val keys: List<AppKey>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "keys" to keys.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AppKeyList(
            total = (map["total"] as Number).toLong(),
            keys = (map["keys"] as List<Map<String, Any>>).map { AppKey.from(map = it) },
        )
    }
}
