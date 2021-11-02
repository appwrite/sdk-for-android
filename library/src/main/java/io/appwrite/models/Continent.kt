package io.appwrite.models

/**
 * Continent
 */
data class Continent(
    /**
     * Continent name.
     *
     */
    val name: String,

    /**
     * Continent two letter code.
     *
     */
    val code: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Continent(
            name = map["name"] as String,
            code = map["code"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
        "code" to code as Any
    )
}