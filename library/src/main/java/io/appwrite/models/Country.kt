package io.appwrite.models

/**
 * Country
 */
data class Country(
    /**
     * Country name.
     *
     */
    val name: String,

    /**
     * Country two-character ISO 3166-1 alpha code.
     *
     */
    val code: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Country(
            name = map["name"] as String,
            code = map["code"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
        "code" to code as Any
    )
}