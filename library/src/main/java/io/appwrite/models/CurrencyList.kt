package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Currencies List
 */
data class CurrencyList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of currencies.
     *
     */
    @SerializedName("currencies")
    val currencies: List<Currency>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = CurrencyList(
            sum = (map["sum"] as Number).toLong(),
            currencies = (map["currencies"] as List<Map<String, Any>>).map { Currency.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "currencies" to currencies.map { it.toMap() } as Any
    )
}