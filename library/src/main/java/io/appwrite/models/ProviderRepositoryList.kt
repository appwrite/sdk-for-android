package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Provider Repositories List
 */
data class ProviderRepositoryList(
    /**
     * Total number of providerRepositories documents that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of providerRepositories.
     */
    @SerializedName("providerRepositories")
    val providerRepositories: List<ProviderRepository>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "providerRepositories" to providerRepositories.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ProviderRepositoryList(
            total = (map["total"] as Number).toLong(),
            providerRepositories = (map["providerRepositories"] as List<Map<String, Any>>).map { ProviderRepository.from(map = it) },
        )
    }
}