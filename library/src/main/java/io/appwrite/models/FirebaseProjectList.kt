package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Migrations Firebase Projects List
 */
data class FirebaseProjectList(
    /**
     * Total number of projects documents that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of projects.
     */
    @SerializedName("projects")
    val projects: List<FirebaseProject>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "projects" to projects.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = FirebaseProjectList(
            total = (map["total"] as Number).toLong(),
            projects = (map["projects"] as List<Map<String, Any>>).map { FirebaseProject.from(map = it) },
        )
    }
}