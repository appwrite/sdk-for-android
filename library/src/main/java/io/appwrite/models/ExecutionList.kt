package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Executions List
 */
data class ExecutionList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of executions.
     *
     */
    @SerializedName("executions")
    val executions: List<Execution>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = ExecutionList(
            sum = (map["sum"] as Number).toLong(),
            executions = (map["executions"] as List<Map<String, Any>>).map { Execution.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "executions" to executions.map { it.toMap() } as Any
    )
}