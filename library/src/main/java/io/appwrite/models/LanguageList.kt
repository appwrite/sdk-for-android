package io.appwrite.models

/**
 * Languages List
 */
data class LanguageList(
    /**
     * Total number of items available on the server.
     *
     */
    val sum: Long,

    /**
     * List of languages.
     *
     */
    val languages: List<Language>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = LanguageList(
            sum = map["sum"] as Long,
            languages = (map["languages"] as List<Map<String, Any>>).map { Language.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "languages" to languages.map { it.toMap() } as Any
    )
}