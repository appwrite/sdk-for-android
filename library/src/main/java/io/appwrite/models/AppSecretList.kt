package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * App secrets list
 */
data class AppSecretList(
    /**
     * Total number of secrets that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of secrets.
     */
    @SerializedName("secrets")
    val secrets: List<AppSecret>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "secrets" to secrets.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AppSecretList(
            total = (map["total"] as Number).toLong(),
            secrets = (map["secrets"] as List<Map<String, Any>>).map { AppSecret.from(map = it) },
        )
    }
}