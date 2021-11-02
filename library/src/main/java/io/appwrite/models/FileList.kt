package io.appwrite.models

/**
 * Files List
 */
data class FileList(
    /**
     * Total number of items available on the server.
     *
     */
    val sum: Long,

    /**
     * List of files.
     *
     */
    val files: List<File>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = FileList(
            sum = map["sum"] as Long,
            files = (map["files"] as List<Map<String, Any>>).map { File.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "files" to files.map { it.toMap() } as Any
    )
}