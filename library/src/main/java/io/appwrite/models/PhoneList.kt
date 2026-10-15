package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Phones List
 */
data class PhoneList(
    /**
     * Total number of phones that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of phones.
     */
    @SerializedName("phones")
    val phones: List<Phone>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "phones" to phones.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PhoneList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            phones = ((if (map.containsKey("phones")) map["phones"] else listOf<Any?>()) as List<Map<String, Any>>).map { Phone.from(map = it) },
        )
    }
}
