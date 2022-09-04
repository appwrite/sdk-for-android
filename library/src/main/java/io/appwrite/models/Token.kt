package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Token
 */
data class Token(
    /**
     * Token ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Token creation date in Unix timestamp.
     *
     */
    @SerializedName("\$createdAt")
    val createdAt: Long,

    /**
     * User ID.
     *
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * Token secret key. This will return an empty string unless the response is returned using an API key or as part of a webhook payload.
     *
     */
    @SerializedName("secret")
    val secret: String,

    /**
     * Token expiration date in Datetime.
     *
     */
    @SerializedName("expire")
    val expire: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Token(
            id = map["\$id"] as String,
            createdAt = (map["\$createdAt"] as Number).toLong(),
            userId = map["userId"] as String,
            secret = map["secret"] as String,
            expire = map["expire"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "userId" to userId as Any,
        "secret" to secret as Any,
        "expire" to expire as Any
    )
}