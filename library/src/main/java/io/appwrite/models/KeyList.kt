package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * API Keys List
 */
data class KeyList(
    /**
     * Total number of keys that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of keys.
     */
    @SerializedName("keys")
    val keys: List<Key>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "keys" to keys.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = KeyList(
            total = (map["total"] as Number).toLong(),
            keys = (map["keys"] as List<Map<String, Any>>).map { Key.from(map = it) },
        )
    }
}