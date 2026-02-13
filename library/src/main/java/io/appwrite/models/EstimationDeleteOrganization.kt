package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * EstimationDeleteOrganization
 */
data class EstimationDeleteOrganization(
    /**
     * List of unpaid invoices
     */
    @SerializedName("unpaidInvoices")
    val unpaidInvoices: List<Invoice>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "unpaidInvoices" to unpaidInvoices.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = EstimationDeleteOrganization(
            unpaidInvoices = (map["unpaidInvoices"] as List<Map<String, Any>>).map { Invoice.from(map = it) },
        )
    }
}