package io.appwrite.models

/**
 * Tag
 */
data class Tag(
    /**
     * Tag ID.
     *
     */
    val id: String,

    /**
     * Function ID.
     *
     */
    val functionId: String,

    /**
     * The tag creation date in Unix timestamp.
     *
     */
    val dateCreated: Long,

    /**
     * The entrypoint command in use to execute the tag code.
     *
     */
    val command: String,

    /**
     * The code size in bytes.
     *
     */
    val size: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Tag(
            id = map["\$id"] as String,
            functionId = map["functionId"] as String,
            dateCreated = map["dateCreated"] as Long,
            command = map["command"] as String,
            size = map["size"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "functionId" to functionId as Any,
        "dateCreated" to dateCreated as Any,
        "command" to command as Any,
        "size" to size as Any
    )
}