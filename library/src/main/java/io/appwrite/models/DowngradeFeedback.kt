package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Downgrade Feedback
 */
data class DowngradeFeedback(
    /**
     * Feedback ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Feedback creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Feedback update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Feedback reason
     */
    @SerializedName("title")
    val title: String,

    /**
     * Feedback message
     */
    @SerializedName("message")
    val message: String,

    /**
     * Plan ID downgrading from
     */
    @SerializedName("fromPlanId")
    val fromPlanId: String,

    /**
     * Plan ID downgrading to
     */
    @SerializedName("toPlanId")
    val toPlanId: String,

    /**
     * Organization ID
     */
    @SerializedName("teamId")
    val teamId: String,

    /**
     * User ID who submitted feedback
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * Console version
     */
    @SerializedName("version")
    val version: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "title" to title as Any,
        "message" to message as Any,
        "fromPlanId" to fromPlanId as Any,
        "toPlanId" to toPlanId as Any,
        "teamId" to teamId as Any,
        "userId" to userId as Any,
        "version" to version as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DowngradeFeedback(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            title = map["title"] as String,
            message = map["message"] as String,
            fromPlanId = map["fromPlanId"] as String,
            toPlanId = map["toPlanId"] as String,
            teamId = map["teamId"] as String,
            userId = map["userId"] as String,
            version = map["version"] as String,
        )
    }
}