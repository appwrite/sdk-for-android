package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 accessible organizations list
 */
data class Oauth2OrganizationList(
    /**
     * Total number of organizations that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of organizations.
     */
    @SerializedName("organizations")
    val organizations: List<Oauth2Organization>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "organizations" to organizations.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2OrganizationList(
            total = (map["total"] as Number).toLong(),
            organizations = (map["organizations"] as List<Map<String, Any>>).map { Oauth2Organization.from(map = it) },
        )
    }
}
