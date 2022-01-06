package io.appwrite.models

/**
 * AttributeFloat
 */
data class AttributeFloat(
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
    var min: Double? = ,

    /**
     * Maximum value to enforce for new documents.
     *
     */
    var max: Double? = ,

    /**
     * Default value for attribute when not provided. Cannot be set when attribute is required.
     *
     */
    var default: Double? = 
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = AttributeFloat(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            required = map["required"] as Boolean,
            array = map["array"] as? Boolean,
            min = map["min"] as? Double,
            max = map["max"] as? Double,
            default = map["default"] as? Double
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