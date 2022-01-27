package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Languages List
 */
data class LanguageList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of languages.
     *
     */
    @SerializedName("languages")
    val languages: List<Language>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = LanguageList(
            sum = (map["sum"] as Number).toLong(),
            languages = (map["languages"] as List<Map<String, Any>>).map { Language.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "languages" to languages.map { it.toMap() } as Any
    )
}