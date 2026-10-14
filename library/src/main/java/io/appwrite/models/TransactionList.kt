package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Transaction List
 */
data class TransactionList(
    /**
     * Total number of transactions that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of transactions.
     */
    @SerializedName("transactions")
    val transactions: List<Transaction>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "transactions" to transactions.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = TransactionList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            transactions = ((if (map.containsKey("transactions")) map["transactions"] else listOf<Any?>()) as List<Map<String, Any>>).map { Transaction.from(map = it) },
        )
    }
}
