package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Continents List
 */
data class ContinentList(
    /**
     * Total number of continents that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of continents.
     */
    @SerializedName("continents")
    val continents: List<Continent>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "continents" to continents.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ContinentList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            continents = ((if (map.containsKey("continents")) map["continents"] else listOf<Any?>()) as List<Map<String, Any>>).map { Continent.from(map = it) },
        )
    }
}
