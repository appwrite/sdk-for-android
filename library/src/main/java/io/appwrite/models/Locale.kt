package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Locale
 */
data class Locale(
    /**
     * User IP address.
     */
    @SerializedName("ip")
    val ip: String,

    /**
     * Country code in [ISO 3166-1](http://en.wikipedia.org/wiki/ISO_3166-1) two-character format
     */
    @SerializedName("countryCode")
    val countryCode: String,

    /**
     * Country name. This field support localization.
     */
    @SerializedName("country")
    val country: String,

    /**
     * Continent code. A two character continent code "AF" for Africa, "AN" for Antarctica, "AS" for Asia, "EU" for Europe, "NA" for North America, "OC" for Oceania, and "SA" for South America.
     */
    @SerializedName("continentCode")
    val continentCode: String,

    /**
     * Continent name. This field support localization.
     */
    @SerializedName("continent")
    val continent: String,

    /**
     * True if country is part of the European Union.
     */
    @SerializedName("eu")
    val eu: Boolean,

    /**
     * Currency code in [ISO 4217-1](http://en.wikipedia.org/wiki/ISO_4217) three-character format
     */
    @SerializedName("currency")
    val currency: String,

    /**
     * City
     */
    @SerializedName("city")
    var city: String?,

    /**
     * Name of timezone
     */
    @SerializedName("timeZone")
    var timeZone: String?,

    /**
     * Postal code
     */
    @SerializedName("postalCode")
    var postalCode: String?,

    /**
     * Latitude
     */
    @SerializedName("latitude")
    var latitude: Double?,

    /**
     * Longitude
     */
    @SerializedName("longitude")
    var longitude: Double?,

    /**
     * Autonomous System Number (ASN) of the IP
     */
    @SerializedName("autonomousSystemNumber")
    var autonomousSystemNumber: String?,

    /**
     * Organization that owns the ASN
     */
    @SerializedName("autonomousSystemOrganization")
    var autonomousSystemOrganization: String?,

    /**
     * Internet service provider of the IP
     */
    @SerializedName("isp")
    var isp: String?,

    /**
     * Connection type of the IP (e.g. cable, cellular, corporate)
     */
    @SerializedName("connectionType")
    var connectionType: String?,

    /**
     * User type classification of the IP (e.g. residential, business, hosting)
     */
    @SerializedName("connectionUsageType")
    var connectionUsageType: String?,

    /**
     * Registered organization of the IP
     */
    @SerializedName("connectionOrganization")
    var connectionOrganization: String?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "ip" to ip as Any,
        "countryCode" to countryCode as Any,
        "country" to country as Any,
        "continentCode" to continentCode as Any,
        "continent" to continent as Any,
        "eu" to eu as Any,
        "currency" to currency as Any,
        "city" to city as Any?,
        "timeZone" to timeZone as Any?,
        "postalCode" to postalCode as Any?,
        "latitude" to latitude as Any?,
        "longitude" to longitude as Any?,
        "autonomousSystemNumber" to autonomousSystemNumber as Any?,
        "autonomousSystemOrganization" to autonomousSystemOrganization as Any?,
        "isp" to isp as Any?,
        "connectionType" to connectionType as Any?,
        "connectionUsageType" to connectionUsageType as Any?,
        "connectionOrganization" to connectionOrganization as Any?,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Locale(
            ip = map["ip"] as String,
            countryCode = map["countryCode"] as String,
            country = map["country"] as String,
            continentCode = map["continentCode"] as String,
            continent = map["continent"] as String,
            eu = map["eu"] as Boolean,
            currency = map["currency"] as String,
            city = map["city"] as? String,
            timeZone = map["timeZone"] as? String,
            postalCode = map["postalCode"] as? String,
            latitude = (map["latitude"] as? Number)?.toDouble(),
            longitude = (map["longitude"] as? Number)?.toDouble(),
            autonomousSystemNumber = map["autonomousSystemNumber"] as? String,
            autonomousSystemOrganization = map["autonomousSystemOrganization"] as? String,
            isp = map["isp"] as? String,
            connectionType = map["connectionType"] as? String,
            connectionUsageType = map["connectionUsageType"] as? String,
            connectionOrganization = map["connectionOrganization"] as? String,
        )
    }
}
