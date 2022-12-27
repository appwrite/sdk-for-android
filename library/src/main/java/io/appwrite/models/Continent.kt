package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Continent
 */
data class Continent(
    /**
     * Continent name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Continent two letter code.
     */
    @SerializedName("code")
    val code: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
        "code" to code as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Continent(
            name = map["name"] as String,
            code = map["code"] as String,
        )
    }
}