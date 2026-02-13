package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Billing address list
 */
data class BillingAddressList(
    /**
     * Total number of billingAddresses that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of billingAddresses.
     */
    @SerializedName("billingAddresses")
    val billingAddresses: List<BillingAddress>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "billingAddresses" to billingAddresses.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BillingAddressList(
            total = (map["total"] as Number).toLong(),
            billingAddresses = (map["billingAddresses"] as List<Map<String, Any>>).map { BillingAddress.from(map = it) },
        )
    }
}