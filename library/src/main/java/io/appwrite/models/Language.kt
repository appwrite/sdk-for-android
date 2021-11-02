package io.appwrite.models

/**
 * Language
 */
data class Language(
    /**
     * Language name.
     *
     */
    val name: String,

    /**
     * Language two-character ISO 639-1 codes.
     *
     */
    val code: String,

    /**
     * Language native name.
     *
     */
    val nativeName: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Language(
            name = map["name"] as String,
            code = map["code"] as String,
            nativeName = map["nativeName"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
        "code" to code as Any,
        "nativeName" to nativeName as Any
    )
}