package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * MigrationFirebaseProject
 */
data class FirebaseProject(
    /**
     * Project ID.
     */
    @SerializedName("projectId")
    val projectId: String,

    /**
     * Project display name.
     */
    @SerializedName("displayName")
    val displayName: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "projectId" to projectId as Any,
        "displayName" to displayName as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = FirebaseProject(
            projectId = map["projectId"] as String,
            displayName = map["displayName"] as String,
        )
    }
}