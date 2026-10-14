package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * AlgoScryptModified
 */
data class AlgoScryptModified(
    /**
     * Algo type.
     */
    @SerializedName("type")
    val type: String,

    /**
     * Salt used to compute hash.
     */
    @SerializedName("salt")
    val salt: String,

    /**
     * Separator used to compute hash.
     */
    @SerializedName("saltSeparator")
    val saltSeparator: String,

    /**
     * Key used to compute hash.
     */
    @SerializedName("signerKey")
    val signerKey: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "type" to type as Any,
        "salt" to salt as Any,
        "saltSeparator" to saltSeparator as Any,
        "signerKey" to signerKey as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AlgoScryptModified(
            type = (if (map.containsKey("type")) map["type"] else "scryptMod") as String,
            salt = (if (map.containsKey("salt")) map["salt"] else "") as String,
            saltSeparator = (if (map.containsKey("saltSeparator")) map["saltSeparator"] else "") as String,
            signerKey = (if (map.containsKey("signerKey")) map["signerKey"] else "") as String,
        )
    }
}
