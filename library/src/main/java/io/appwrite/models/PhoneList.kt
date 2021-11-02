package io.appwrite.models

/**
 * Phones List
 */
data class PhoneList(
    /**
     * Total number of items available on the server.
     *
     */
    val sum: Long,

    /**
     * List of phones.
     *
     */
    val phones: List<Phone>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = PhoneList(
            sum = map["sum"] as Long,
            phones = (map["phones"] as List<Map<String, Any>>).map { Phone.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "phones" to phones.map { it.toMap() } as Any
    )
}