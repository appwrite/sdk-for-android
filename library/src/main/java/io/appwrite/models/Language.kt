package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Language
 */
data class Language(
    /**
     * Language name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Language two-character ISO 639-1 codes.
     */
    @SerializedName("code")
    val code: String,

    /**
     * Language native name.
     */
    @SerializedName("nativeName")
    val nativeName: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "name" to name as Any,
        "code" to code as Any,
        "nativeName" to nativeName as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Language(
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            code = (if (map.containsKey("code")) map["code"] else "") as String,
            nativeName = (if (map.containsKey("nativeName")) map["nativeName"] else "") as String,
        )
    }
}
