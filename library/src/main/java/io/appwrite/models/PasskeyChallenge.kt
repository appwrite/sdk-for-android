package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Passkey Challenge
 */
data class PasskeyChallenge(
    /**
     * Challenge ID. When signing in, pass it back with the credential to receive a token.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Challenge creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * ID of the passkey being registered. Empty for sign-in challenges.
     */
    @SerializedName("passkeyId")
    val passkeyId: String,

    /**
     * Challenge expiration date in ISO 8601 format.
     */
    @SerializedName("expire")
    val expire: String,

    /**
     * WebAuthn options in JSON form. Pass them to `PublicKeyCredential.parseCreationOptionsFromJSON()` when registering, or `PublicKeyCredential.parseRequestOptionsFromJSON()` when signing in.
     */
    @SerializedName("publicKey")
    val publicKey: Map<String, Any?>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "passkeyId" to passkeyId as Any,
        "expire" to expire as Any,
        "publicKey" to publicKey as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PasskeyChallenge(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            passkeyId = (if (map.containsKey("passkeyId")) map["passkeyId"] else "") as String,
            expire = (if (map.containsKey("expire")) map["expire"] else "") as String,
            publicKey = (if (map.containsKey("publicKey")) map["publicKey"] else mapOf<String, Any?>()) as Map<String, Any?>,
        )
    }
}
