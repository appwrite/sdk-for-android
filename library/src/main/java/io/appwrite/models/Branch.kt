package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Branch
 */
data class Branch(
    /**
     * Branch Name.
     */
    @SerializedName("name")
    val name: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Branch(
            name = map["name"] as String,
        )
    }
}