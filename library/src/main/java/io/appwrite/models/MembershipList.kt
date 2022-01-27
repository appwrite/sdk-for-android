package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Memberships List
 */
data class MembershipList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of memberships.
     *
     */
    @SerializedName("memberships")
    val memberships: List<Membership>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = MembershipList(
            sum = (map["sum"] as Number).toLong(),
            memberships = (map["memberships"] as List<Map<String, Any>>).map { Membership.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "memberships" to memberships.map { it.toMap() } as Any
    )
}