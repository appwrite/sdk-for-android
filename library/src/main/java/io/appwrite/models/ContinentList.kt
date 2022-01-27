package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Continents List
 */
data class ContinentList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of continents.
     *
     */
    @SerializedName("continents")
    val continents: List<Continent>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = ContinentList(
            sum = (map["sum"] as Number).toLong(),
            continents = (map["continents"] as List<Map<String, Any>>).map { Continent.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "continents" to continents.map { it.toMap() } as Any
    )
}