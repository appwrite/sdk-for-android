package io.appwrite.models

/**
 * Currency
 */
data class Currency(
    /**
     * Currency symbol.
     *
     */
    val symbol: String,

    /**
     * Currency name.
     *
     */
    val name: String,

    /**
     * Currency native symbol.
     *
     */
    val symbolNative: String,

    /**
     * Number of decimal digits.
     *
     */
    val decimalDigits: Long,

    /**
     * Currency digit rounding.
     *
     */
    val rounding: Double,

    /**
     * Currency code in [ISO 4217-1](http://en.wikipedia.org/wiki/ISO_4217) three-character format.
     *
     */
    val code: String,

    /**
     * Currency plural name
     *
     */
    val namePlural: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Currency(
            symbol = map["symbol"] as String,
            name = map["name"] as String,
            symbolNative = map["symbolNative"] as String,
            decimalDigits = map["decimalDigits"] as Long,
            rounding = map["rounding"] as Double,
            code = map["code"] as String,
            namePlural = map["namePlural"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "symbol" to symbol as Any,
        "name" to name as Any,
        "symbolNative" to symbolNative as Any,
        "decimalDigits" to decimalDigits as Any,
        "rounding" to rounding as Any,
        "code" to code as Any,
        "namePlural" to namePlural as Any
    )
}