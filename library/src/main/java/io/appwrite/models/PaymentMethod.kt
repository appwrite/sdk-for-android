package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * paymentMethod
 */
data class PaymentMethod(
    /**
     * Payment Method ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Payment method creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Payment method update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Payment method permissions. [Learn more about permissions](/docs/permissions).
     */
    @SerializedName("\$permissions")
    val permissions: List<String>,

    /**
     * Payment method ID from the payment provider
     */
    @SerializedName("providerMethodId")
    val providerMethodId: String,

    /**
     * Client secret hash for payment setup
     */
    @SerializedName("clientSecret")
    val clientSecret: String,

    /**
     * User ID from the payment provider.
     */
    @SerializedName("providerUserId")
    val providerUserId: String,

    /**
     * ID of the Team.
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * Expiry month of the payment method.
     */
    @SerializedName("expiryMonth")
    val expiryMonth: Long,

    /**
     * Expiry year of the payment method.
     */
    @SerializedName("expiryYear")
    val expiryYear: Long,

    /**
     * Last 4 digit of the payment method
     */
    @SerializedName("last4")
    val last4: String,

    /**
     * Payment method brand
     */
    @SerializedName("brand")
    val brand: String,

    /**
     * Name of the owner
     */
    @SerializedName("name")
    val name: String,

    /**
     * Mandate ID of the payment method
     */
    @SerializedName("mandateId")
    val mandateId: String,

    /**
     * Country of the payment method
     */
    @SerializedName("country")
    val country: String,

    /**
     * State of the payment method
     */
    @SerializedName("state")
    val state: String,

    /**
     * Last payment error associated with the payment method.
     */
    @SerializedName("lastError")
    val lastError: String,

    /**
     * True when it's the default payment method.
     */
    @SerializedName("default")
    val default: Boolean,

    /**
     * True when payment method has expired.
     */
    @SerializedName("expired")
    val expired: Boolean,

    /**
     * True when payment method has failed to process multiple times.
     */
    @SerializedName("failed")
    val failed: Boolean,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "providerMethodId" to providerMethodId as Any,
        "clientSecret" to clientSecret as Any,
        "providerUserId" to providerUserId as Any,
        "userId" to userId as Any,
        "expiryMonth" to expiryMonth as Any,
        "expiryYear" to expiryYear as Any,
        "last4" to last4 as Any,
        "brand" to brand as Any,
        "name" to name as Any,
        "mandateId" to mandateId as Any,
        "country" to country as Any,
        "state" to state as Any,
        "lastError" to lastError as Any,
        "default" to default as Any,
        "expired" to expired as Any,
        "failed" to failed as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PaymentMethod(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            permissions = map["\$permissions"] as List<String>,
            providerMethodId = map["providerMethodId"] as String,
            clientSecret = map["clientSecret"] as String,
            providerUserId = map["providerUserId"] as String,
            userId = map["userId"] as String,
            expiryMonth = (map["expiryMonth"] as Number).toLong(),
            expiryYear = (map["expiryYear"] as Number).toLong(),
            last4 = map["last4"] as String,
            brand = map["brand"] as String,
            name = map["name"] as String,
            mandateId = map["mandateId"] as String,
            country = map["country"] as String,
            state = map["state"] as String,
            lastError = map["lastError"] as String,
            default = map["default"] as Boolean,
            expired = map["expired"] as Boolean,
            failed = map["failed"] as Boolean,
        )
    }
}