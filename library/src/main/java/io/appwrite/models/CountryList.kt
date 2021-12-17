package io.appwrite.models

/**
 * Countries List
 */
data class CountryList(
    /**
     * Total number of items available on the server.
     *
     */
    val sum: Long,

    /**
     * List of countries.
     *
     */
    val countries: List<Country>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = CountryList(
            sum = map["sum"] as Long,
            countries = (map["countries"] as List<Map<String, Any>>).map { Country.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "countries" to countries.map { it.toMap() } as Any
    )
}