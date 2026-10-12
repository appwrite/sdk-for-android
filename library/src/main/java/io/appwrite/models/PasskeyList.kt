package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Passkeys List
 */
data class PasskeyList(
    /**
     * Total number of passkeys that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of passkeys.
     */
    @SerializedName("passkeys")
    val passkeys: List<Passkey>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "passkeys" to passkeys.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PasskeyList(
            total = (map["total"] as Number).toLong(),
            passkeys = (map["passkeys"] as List<Map<String, Any>>).map { Passkey.from(map = it) },
        )
    }
}
