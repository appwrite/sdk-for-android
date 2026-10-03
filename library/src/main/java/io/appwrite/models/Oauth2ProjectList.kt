package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 accessible projects list
 */
data class Oauth2ProjectList(
    /**
     * Total number of projects that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of projects.
     */
    @SerializedName("projects")
    val projects: List<Oauth2Project>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "projects" to projects.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2ProjectList(
            total = (map["total"] as Number).toLong(),
            projects = (map["projects"] as List<Map<String, Any>>).map { Oauth2Project.from(map = it) },
        )
    }
}
