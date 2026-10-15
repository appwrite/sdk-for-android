package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Executions List
 */
data class ExecutionList(
    /**
     * Total number of executions that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of executions.
     */
    @SerializedName("executions")
    val executions: List<Execution>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "executions" to executions.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ExecutionList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            executions = ((if (map.containsKey("executions")) map["executions"] else listOf<Any?>()) as List<Map<String, Any>>).map { Execution.from(map = it) },
        )
    }
}
