package io.appwrite.models

/**
 * JWT
 */
data class Jwt(
    /**
     * JWT encoded string.
     *
     */
    val jwt: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Jwt(
            jwt = map["jwt"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "jwt" to jwt as Any
    )
}