package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * AlgoScrypt
 */
data class AlgoScrypt(
    /**
     * Algo type.
     */
    @SerializedName("type")
    val type: String,

    /**
     * CPU complexity of computed hash.
     */
    @SerializedName("costCpu")
    val costCpu: Long,

    /**
     * Memory complexity of computed hash.
     */
    @SerializedName("costMemory")
    val costMemory: Long,

    /**
     * Parallelization of computed hash.
     */
    @SerializedName("costParallel")
    val costParallel: Long,

    /**
     * Length used to compute hash.
     */
    @SerializedName("length")
    val length: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "type" to type as Any,
        "costCpu" to costCpu as Any,
        "costMemory" to costMemory as Any,
        "costParallel" to costParallel as Any,
        "length" to length as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AlgoScrypt(
            type = (if (map.containsKey("type")) map["type"] else "scrypt") as String,
            costCpu = ((if (map.containsKey("costCpu")) map["costCpu"] else 8) as Number).toLong(),
            costMemory = ((if (map.containsKey("costMemory")) map["costMemory"] else 14) as Number).toLong(),
            costParallel = ((if (map.containsKey("costParallel")) map["costParallel"] else 1) as Number).toLong(),
            length = ((if (map.containsKey("length")) map["length"] else 64) as Number).toLong(),
        )
    }
}
