package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Branches List
 */
data class BranchList(
    /**
     * Total number of branches documents that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of branches.
     */
    @SerializedName("branches")
    val branches: List<Branch>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "branches" to branches.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BranchList(
            total = (map["total"] as Number).toLong(),
            branches = (map["branches"] as List<Map<String, Any>>).map { Branch.from(map = it) },
        )
    }
}