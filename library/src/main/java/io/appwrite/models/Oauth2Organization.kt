package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 Organization
 */
data class Oauth2Organization(
    /**
     * Organization ID.
     */
    @SerializedName("\$id")
    val id: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2Organization(
            id = map["\$id"] as String,
        )
    }
}
