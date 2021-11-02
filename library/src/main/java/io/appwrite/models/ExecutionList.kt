package io.appwrite.models

/**
 * Executions List
 */
data class ExecutionList(
    /**
     * Total number of items available on the server.
     *
     */
    val sum: Long,

    /**
     * List of executions.
     *
     */
    val executions: List<Execution>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = ExecutionList(
            sum = map["sum"] as Long,
            executions = (map["executions"] as List<Map<String, Any>>).map { Execution.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "executions" to executions.map { it.toMap() } as Any
    )
}