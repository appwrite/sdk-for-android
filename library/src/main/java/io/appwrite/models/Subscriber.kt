package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Subscriber
 */
data class Subscriber(
    /**
     * Subscriber ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Subscriber creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Subscriber update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Target ID.
     */
    @SerializedName("targetId")
    val targetId: String,

    /**
     * Target.
     */
    @SerializedName("target")
    val target: Target,

    /**
     * Topic ID.
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * User Name.
     */
    @SerializedName("userName")
    val userName: String,

    /**
     * Topic ID.
     */
    @SerializedName("topicId")
    val topicId: String,

    /**
     * The target provider type. Can be one of the following: `email`, `sms` or `push`.
     */
    @SerializedName("providerType")
    val providerType: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "targetId" to targetId as Any,
        "target" to target.toMap() as Any,
        "userId" to userId as Any,
        "userName" to userName as Any,
        "topicId" to topicId as Any,
        "providerType" to providerType as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Subscriber(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            targetId = (if (map.containsKey("targetId")) map["targetId"] else "") as String,
            target = Target.from(map = map["target"] as Map<String, Any>),
            userId = (if (map.containsKey("userId")) map["userId"] else "") as String,
            userName = (if (map.containsKey("userName")) map["userName"] else "") as String,
            topicId = (if (map.containsKey("topicId")) map["topicId"] else "") as String,
            providerType = (if (map.containsKey("providerType")) map["providerType"] else "") as String,
        )
    }
}
