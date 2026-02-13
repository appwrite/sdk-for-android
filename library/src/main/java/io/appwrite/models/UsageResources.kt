package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * UsageResource
 */
data class UsageResources(
    /**
     * Invoice name
     */
    @SerializedName("name")
    val name: String,

    /**
     * Invoice value
     */
    @SerializedName("value")
    val value: Long,

    /**
     * Invoice amount
     */
    @SerializedName("amount")
    val amount: Double,

    /**
     * Invoice rate
     */
    @SerializedName("rate")
    val rate: Double,

    /**
     * Invoice description
     */
    @SerializedName("desc")
    val desc: String,

    /**
     * Resource ID
     */
    @SerializedName("resourceId")
    val resourceId: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
        "value" to value as Any,
        "amount" to amount as Any,
        "rate" to rate as Any,
        "desc" to desc as Any,
        "resourceId" to resourceId as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = UsageResources(
            name = map["name"] as String,
            value = (map["value"] as Number).toLong(),
            amount = (map["amount"] as Number).toDouble(),
            rate = (map["rate"] as Number).toDouble(),
            desc = map["desc"] as String,
            resourceId = map["resourceId"] as String,
        )
    }
}