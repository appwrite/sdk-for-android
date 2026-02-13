package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Invoice
 */
data class Invoice(
    /**
     * Invoice ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Invoice creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Invoice update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Invoice permissions. [Learn more about permissions](/docs/permissions).
     */
    @SerializedName("\$permissions")
    val permissions: List<String>,

    /**
     * Project ID
     */
    @SerializedName("teamId")
    val teamId: String,

    /**
     * Aggregation ID
     */
    @SerializedName("aggregationId")
    val aggregationId: String,

    /**
     * Billing plan selected. Can be one of `tier-0`, `tier-1` or `tier-2`.
     */
    @SerializedName("plan")
    val plan: String,

    /**
     * Usage breakdown per resource
     */
    @SerializedName("usage")
    val usage: List<UsageResources>,

    /**
     * Invoice Amount
     */
    @SerializedName("amount")
    val amount: Double,

    /**
     * Tax percentage
     */
    @SerializedName("tax")
    val tax: Double,

    /**
     * Tax amount
     */
    @SerializedName("taxAmount")
    val taxAmount: Double,

    /**
     * VAT percentage
     */
    @SerializedName("vat")
    val vat: Double,

    /**
     * VAT amount
     */
    @SerializedName("vatAmount")
    val vatAmount: Double,

    /**
     * Gross amount after vat, tax, and discounts applied.
     */
    @SerializedName("grossAmount")
    val grossAmount: Double,

    /**
     * Credits used.
     */
    @SerializedName("creditsUsed")
    val creditsUsed: Double,

    /**
     * Currency the invoice is in
     */
    @SerializedName("currency")
    val currency: String,

    /**
     * Client secret for processing failed payments in front-end
     */
    @SerializedName("clientSecret")
    val clientSecret: String,

    /**
     * Invoice status
     */
    @SerializedName("status")
    val status: String,

    /**
     * Last payment error associated with the invoice
     */
    @SerializedName("lastError")
    val lastError: String,

    /**
     * Invoice due date.
     */
    @SerializedName("dueAt")
    val dueAt: String,

    /**
     * Beginning date of the invoice
     */
    @SerializedName("from")
    val from: String,

    /**
     * End date of the invoice
     */
    @SerializedName("to")
    val to: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "teamId" to teamId as Any,
        "aggregationId" to aggregationId as Any,
        "plan" to plan as Any,
        "usage" to usage.map { it.toMap() } as Any,
        "amount" to amount as Any,
        "tax" to tax as Any,
        "taxAmount" to taxAmount as Any,
        "vat" to vat as Any,
        "vatAmount" to vatAmount as Any,
        "grossAmount" to grossAmount as Any,
        "creditsUsed" to creditsUsed as Any,
        "currency" to currency as Any,
        "clientSecret" to clientSecret as Any,
        "status" to status as Any,
        "lastError" to lastError as Any,
        "dueAt" to dueAt as Any,
        "from" to from as Any,
        "to" to to as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Invoice(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            permissions = map["\$permissions"] as List<String>,
            teamId = map["teamId"] as String,
            aggregationId = map["aggregationId"] as String,
            plan = map["plan"] as String,
            usage = (map["usage"] as List<Map<String, Any>>).map { UsageResources.from(map = it) },
            amount = (map["amount"] as Number).toDouble(),
            tax = (map["tax"] as Number).toDouble(),
            taxAmount = (map["taxAmount"] as Number).toDouble(),
            vat = (map["vat"] as Number).toDouble(),
            vatAmount = (map["vatAmount"] as Number).toDouble(),
            grossAmount = (map["grossAmount"] as Number).toDouble(),
            creditsUsed = (map["creditsUsed"] as Number).toDouble(),
            currency = map["currency"] as String,
            clientSecret = map["clientSecret"] as String,
            status = map["status"] as String,
            lastError = map["lastError"] as String,
            dueAt = map["dueAt"] as String,
            from = map["from"] as String,
            to = map["to"] as String,
        )
    }
}