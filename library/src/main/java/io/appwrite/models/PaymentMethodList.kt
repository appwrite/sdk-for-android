package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Payment methods list
 */
data class PaymentMethodList(
    /**
     * Total number of paymentMethods that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of paymentMethods.
     */
    @SerializedName("paymentMethods")
    val paymentMethods: List<PaymentMethod>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "paymentMethods" to paymentMethods.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PaymentMethodList(
            total = (map["total"] as Number).toLong(),
            paymentMethods = (map["paymentMethods"] as List<Map<String, Any>>).map { PaymentMethod.from(map = it) },
        )
    }
}