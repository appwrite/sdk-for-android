package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Device
 */
data class Device(
    /**
     * Device ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Device creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Device update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Device expiration date in ISO 8601 format.
     */
    @SerializedName("expire")
    val expire: String,

    /**
     * ID of the session that is currently active on the device. Empty when no session is active, for example right after the active session was deleted.
     */
    @SerializedName("activeSessionId")
    val activeSessionId: String,

    /**
     * List of sessions the device holds. Switch between them to change the active account.
     */
    @SerializedName("sessions")
    val sessions: List<Session>,

    /**
     * Secret used to authenticate the device. Carried by the device cookie; only included in the response if the request was made with an API key.
     */
    @SerializedName("secret")
    val secret: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "expire" to expire as Any,
        "activeSessionId" to activeSessionId as Any,
        "sessions" to sessions.map { it.toMap() } as Any,
        "secret" to secret as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Device(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            expire = (if (map.containsKey("expire")) map["expire"] else "") as String,
            activeSessionId = (if (map.containsKey("activeSessionId")) map["activeSessionId"] else "") as String,
            sessions = ((if (map.containsKey("sessions")) map["sessions"] else listOf<Any?>()) as List<Map<String, Any>>).map { Session.from(map = it) },
            secret = (if (map.containsKey("secret")) map["secret"] else "") as String,
        )
    }
}
