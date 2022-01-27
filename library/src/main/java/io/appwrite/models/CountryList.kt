package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Countries List
 */
data class CountryList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of countries.
     *
     */
    @SerializedName("countries")
    val countries: List<Country>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = CountryList(
            sum = (map["sum"] as Number).toLong(),
            countries = (map["countries"] as List<Map<String, Any>>).map { Country.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "countries" to countries.map { it.toMap() } as Any
    )
}