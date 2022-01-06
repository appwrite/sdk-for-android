package io.appwrite.models

/**
 * AttributeInteger
 */
data class AttributeInteger(
    /**
     * Attribute Key.
     *
     */
    val key: String,

    /**
     * Attribute type.
     *
     */
    val type: String,

    /**
     * Attribute status. Possible values: `available`, `processing`, `deleting`, `stuck`, or `failed`
     *
     */
    val status: String,

    /**
     * Is attribute required?
     *
     */
    val required: Boolean,

    /**
     * Is attribute an array?
     *
     */
    var array: Boolean? = ,

    /**
     * Minimum value to enforce for new documents.
     *
     */
    var min: Long? = ,

    /**
     * Maximum value to enforce for new documents.
     *
     */
    var max: Long? = ,

    /**
     * Default value for attribute when not provided. Cannot be set when attribute is required.
     *
     */
    var default: Long? = 
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = AttributeInteger(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            required = map["required"] as Boolean,
            array = map["array"] as? Boolean,
            min = map["min"] as? Long,
            max = map["max"] as? Long,
            default = map["default"] as? Long
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "type" to type as Any,
        "status" to status as Any,
        "required" to required as Any,
        "array" to array as Any,
        "min" to min as Any,
        "max" to max as Any,
        "default" to default as Any
    )
}