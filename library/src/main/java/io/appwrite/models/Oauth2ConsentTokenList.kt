package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 consent tokens list
 */
data class Oauth2ConsentTokenList(
    /**
     * Total number of tokens that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of tokens.
     */
    @SerializedName("tokens")
    val tokens: List<Oauth2ConsentToken>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "tokens" to tokens.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2ConsentTokenList(
            total = (map["total"] as Number).toLong(),
            tokens = (map["tokens"] as List<Map<String, Any>>).map { Oauth2ConsentToken.from(map = it) },
        )
    }
}
