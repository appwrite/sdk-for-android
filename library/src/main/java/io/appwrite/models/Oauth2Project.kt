package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 Project
 */
data class Oauth2Project(
    /**
     * Project ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Region ID the project is deployed in.
     */
    @SerializedName("region")
    val region: String,

    /**
     * API endpoint of the region the project is deployed in. Empty when the region has no public hostname configured.
     */
    @SerializedName("endpoint")
    val endpoint: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "region" to region as Any,
        "endpoint" to endpoint as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2Project(
            id = map["\$id"] as String,
            region = map["region"] as String,
            endpoint = map["endpoint"] as String,
        )
    }
}
