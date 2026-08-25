package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 consents list
 */
data class Oauth2ConsentList(
    /**
     * Total number of consents that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of consents.
     */
    @SerializedName("consents")
    val consents: List<Oauth2Consent>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "consents" to consents.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2ConsentList(
            total = (map["total"] as Number).toLong(),
            consents = (map["consents"] as List<Map<String, Any>>).map { Oauth2Consent.from(map = it) },
        )
    }
}
