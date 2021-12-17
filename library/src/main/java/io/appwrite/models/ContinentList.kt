package io.appwrite.models

/**
 * Continents List
 */
data class ContinentList(
    /**
     * Total number of items available on the server.
     *
     */
    val sum: Long,

    /**
     * List of continents.
     *
     */
    val continents: List<Continent>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = ContinentList(
            sum = map["sum"] as Long,
            continents = (map["continents"] as List<Map<String, Any>>).map { Continent.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "continents" to continents.map { it.toMap() } as Any
    )
}