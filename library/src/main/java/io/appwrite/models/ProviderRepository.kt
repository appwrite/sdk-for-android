package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * ProviderRepository
 */
data class ProviderRepository(
    /**
     * VCS (Version Control System) repository ID.
     */
    @SerializedName("id")
    val id: String,

    /**
     * VCS (Version Control System) repository name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * VCS (Version Control System) organization name
     */
    @SerializedName("organization")
    val organization: String,

    /**
     * VCS (Version Control System) provider name.
     */
    @SerializedName("provider")
    val provider: String,

    /**
     * Is VCS (Version Control System) repository private?
     */
    @SerializedName("xprivate")
    val xprivate: Boolean,

    /**
     * Auto-detected runtime suggestion. Empty if getting response of getRuntime().
     */
    @SerializedName("runtime")
    val runtime: String,

    /**
     * Last commit date in ISO 8601 format.
     */
    @SerializedName("pushedAt")
    val pushedAt: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "id" to id as Any,
        "name" to name as Any,
        "organization" to organization as Any,
        "provider" to provider as Any,
        "private" to xprivate as Any,
        "runtime" to runtime as Any,
        "pushedAt" to pushedAt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ProviderRepository(
            id = map["id"] as String,
            name = map["name"] as String,
            organization = map["organization"] as String,
            provider = map["provider"] as String,
            xprivate = map["private"] as Boolean,
            runtime = map["runtime"] as String,
            pushedAt = map["pushedAt"] as String,
        )
    }
}