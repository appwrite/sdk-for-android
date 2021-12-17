package io.appwrite.models

/**
 * Token
 */
data class Token(
    /**
     * Token ID.
     *
     */
    val id: String,

    /**
     * User ID.
     *
     */
    val userId: String,

    /**
     * Token secret key. This will return an empty string unless the response is returned using an API key or as part of a webhook payload.
     *
     */
    val secret: String,

    /**
     * Token expiration date in Unix timestamp.
     *
     */
    val expire: Long
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Token(
            id = map["\$id"] as String,
            userId = map["userId"] as String,
            secret = map["secret"] as String,
            expire = map["expire"] as Long
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "userId" to userId as Any,
        "secret" to secret as Any,
        "expire" to expire as Any
    )
}