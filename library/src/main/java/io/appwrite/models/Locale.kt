package io.appwrite.models

/**
 * Locale
 */
data class Locale(
    /**
     * User IP address.
     *
     */
    val ip: String,

    /**
     * Country code in [ISO 3166-1](http://en.wikipedia.org/wiki/ISO_3166-1) two-character format
     *
     */
    val countryCode: String,

    /**
     * Country name. This field support localization.
     *
     */
    val country: String,

    /**
     * Continent code. A two character continent code &quot;AF&quot; for Africa, &quot;AN&quot; for Antarctica, &quot;AS&quot; for Asia, &quot;EU&quot; for Europe, &quot;NA&quot; for North America, &quot;OC&quot; for Oceania, and &quot;SA&quot; for South America.
     *
     */
    val continentCode: String,

    /**
     * Continent name. This field support localization.
     *
     */
    val continent: String,

    /**
     * True if country is part of the Europian Union.
     *
     */
    val eu: Boolean,

    /**
     * Currency code in [ISO 4217-1](http://en.wikipedia.org/wiki/ISO_4217) three-character format
     *
     */
    val currency: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Locale(
            ip = map["ip"] as String,
            countryCode = map["countryCode"] as String,
            country = map["country"] as String,
            continentCode = map["continentCode"] as String,
            continent = map["continent"] as String,
            eu = map["eu"] as Boolean,
            currency = map["currency"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "ip" to ip as Any,
        "countryCode" to countryCode as Any,
        "country" to country as Any,
        "continentCode" to continentCode as Any,
        "continent" to continent as Any,
        "eu" to eu as Any,
        "currency" to currency as Any
    )
}