package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Presences List
 */
data class PresenceList<T>(
    /**
     * Total number of presences that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of presences.
     */
    @SerializedName("presences")
    val presences: List<Presence<T>>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "presences" to presences.map { it.toMap() } as Any,
    )

    companion object {
        operator fun invoke(
            total: Long,
            presences: List<Presence<Map<String, Any>>>,
        ) = PresenceList<Map<String, Any>>(
            total,
            presences,
        )

        @Suppress("UNCHECKED_CAST")
        fun <T> from(
            map: Map<String, Any>,
            nestedType: Class<T>
        ) = PresenceList<T>(
            total = (map["total"] as Number).toLong(),
            presences = (map["presences"] as List<Map<String, Any>>).map { Presence.from(map = it, nestedType) },
        )
    }
}