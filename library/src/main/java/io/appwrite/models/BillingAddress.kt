package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * BillingAddress
 */
data class BillingAddress(
    /**
     * Region ID
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * User ID
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * Street address
     */
    @SerializedName("streetAddress")
    val streetAddress: String,

    /**
     * Address line 2
     */
    @SerializedName("addressLine2")
    val addressLine2: String,

    /**
     * Address country
     */
    @SerializedName("country")
    val country: String,

    /**
     * city
     */
    @SerializedName("city")
    val city: String,

    /**
     * state
     */
    @SerializedName("state")
    val state: String,

    /**
     * postal code
     */
    @SerializedName("postalCode")
    val postalCode: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "userId" to userId as Any,
        "streetAddress" to streetAddress as Any,
        "addressLine2" to addressLine2 as Any,
        "country" to country as Any,
        "city" to city as Any,
        "state" to state as Any,
        "postalCode" to postalCode as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BillingAddress(
            id = map["\$id"] as String,
            userId = map["userId"] as String,
            streetAddress = map["streetAddress"] as String,
            addressLine2 = map["addressLine2"] as String,
            country = map["country"] as String,
            city = map["city"] as String,
            state = map["state"] as String,
            postalCode = map["postalCode"] as String,
        )
    }
}