package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * App scopes list
 */
data class AppScopeList(
    /**
     * Total number of scopes that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of scopes.
     */
    @SerializedName("scopes")
    val scopes: List<AppScope>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "scopes" to scopes.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AppScopeList(
            total = (map["total"] as Number).toLong(),
            scopes = (map["scopes"] as List<Map<String, Any>>).map { AppScope.from(map = it) },
        )
    }
}
