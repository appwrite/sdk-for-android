package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * AppScope
 */
data class AppScope(
    /**
     * Scope value as requested by apps.
     */
    @SerializedName("value")
    val value: String,

    /**
     * Human-readable description of what the scope grants.
     */
    @SerializedName("description")
    val description: String,

    /**
     * What the scope grants access to. One of `account`, `project`, or `organization`. Only `project` and `organization` scopes are installable.
     */
    @SerializedName("type")
    val type: String,

    /**
     * Scope category, used to group scopes on consent and installation screens.
     */
    @SerializedName("category")
    val category: String,

    /**
     * Whether the scope is deprecated. Deprecated scopes can still be requested but should not be offered for new grants.
     */
    @SerializedName("deprecated")
    val deprecated: Boolean,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "value" to value as Any,
        "description" to description as Any,
        "type" to type as Any,
        "category" to category as Any,
        "deprecated" to deprecated as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AppScope(
            value = map["value"] as String,
            description = map["description"] as String,
            type = map["type"] as String,
            category = map["category"] as String,
            deprecated = map["deprecated"] as Boolean,
        )
    }
}
