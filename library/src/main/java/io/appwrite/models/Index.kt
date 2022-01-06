package io.appwrite.models

/**
 * Index
 */
data class Index(
    /**
     * Index Key.
     *
     */
    val key: String,

    /**
     * Index type.
     *
     */
    val type: String,

    /**
     * Index status. Possible values: `available`, `processing`, `deleting`, `stuck`, or `failed`
     *
     */
    val status: String,

    /**
     * Index attributes.
     *
     */
    val attributes: List<Any>,

    /**
     * Index orders.
     *
     */
    val orders: List<Any>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Index(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            attributes = map["attributes"] as List<Any>,
            orders = map["orders"] as List<Any>
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "type" to type as Any,
        "status" to status as Any,
        "attributes" to attributes as Any,
        "orders" to orders as Any
    )
}