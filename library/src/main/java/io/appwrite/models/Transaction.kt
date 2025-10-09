package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Transaction
 */
data class Transaction(
    /**
     * Transaction ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Transaction creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Transaction update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Current status of the transaction. One of: pending, committing, committed, rolled_back, failed.
     */
    @SerializedName("status")
    val status: String,

    /**
     * Number of operations in the transaction.
     */
    @SerializedName("operations")
    val operations: Long,

    /**
     * Expiration time in ISO 8601 format.
     */
    @SerializedName("expiresAt")
    val expiresAt: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "status" to status as Any,
        "operations" to operations as Any,
        "expiresAt" to expiresAt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Transaction(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            status = map["status"] as String,
            operations = (map["operations"] as Number).toLong(),
            expiresAt = map["expiresAt"] as String,
        )
    }
}