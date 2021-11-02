package io.appwrite.models

/**
 * Phone
 */
data class Phone(
    /**
     * Phone code.
     *
     */
    val code: String,

    /**
     * Country two-character ISO 3166-1 alpha code.
     *
     */
    val countryCode: String,

    /**
     * Country name.
     *
     */
    val countryName: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Phone(
            code = map["code"] as String,
            countryCode = map["countryCode"] as String,
            countryName = map["countryName"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "code" to code as Any,
        "countryCode" to countryCode as Any,
        "countryName" to countryName as Any
    )
}