package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Languages List
 */
data class LanguageList(
    /**
     * Total number of languages that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of languages.
     */
    @SerializedName("languages")
    val languages: List<Language>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "languages" to languages.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = LanguageList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            languages = ((if (map.containsKey("languages")) map["languages"] else listOf<Any?>()) as List<Map<String, Any>>).map { Language.from(map = it) },
        )
    }
}
