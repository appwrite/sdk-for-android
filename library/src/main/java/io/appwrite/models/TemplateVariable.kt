package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Template Variable
 */
data class TemplateVariable(
    /**
     * Variable Name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Variable Description.
     */
    @SerializedName("description")
    val description: String,

    /**
     * Variable Value.
     */
    @SerializedName("value")
    val value: String,

    /**
     * Variable Placeholder.
     */
    @SerializedName("placeholder")
    val placeholder: String,

    /**
     * Is the variable required?
     */
    @SerializedName("required")
    val required: Boolean,

    /**
     * Variable Type.
     */
    @SerializedName("type")
    val type: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
        "description" to description as Any,
        "value" to value as Any,
        "placeholder" to placeholder as Any,
        "required" to required as Any,
        "type" to type as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = TemplateVariable(
            name = map["name"] as String,
            description = map["description"] as String,
            value = map["value"] as String,
            placeholder = map["placeholder"] as String,
            required = map["required"] as Boolean,
            type = map["type"] as String,
        )
    }
}