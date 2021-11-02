package io.appwrite.models

/**
 * Permissions
 */
data class Permissions(
    /**
     * Read permissions.
     *
     */
    val read: List<Any>,

    /**
     * Write permissions.
     *
     */
    val write: List<Any>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Permissions(
            read = map["read"] as List<Any>,
            write = map["write"] as List<Any>
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "read" to read as Any,
        "write" to write as Any
    )
}