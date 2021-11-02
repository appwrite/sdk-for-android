package io.appwrite.models

/**
 * Preferences
 */
data class Preferences(
    val data: Map<String, Any>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Preferences(
            data = map
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "data" to data
    )

    fun <T> convertTo(fromJson: (Map<String, Any>) -> T): T {
        return fromJson(data)
    }
}