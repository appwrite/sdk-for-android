package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Template Runtime
 */
data class TemplateRuntime(
    /**
     * Runtime Name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * The build command used to build the deployment.
     */
    @SerializedName("commands")
    val commands: String,

    /**
     * The entrypoint file used to execute the deployment.
     */
    @SerializedName("entrypoint")
    val entrypoint: String,

    /**
     * Path to function in VCS (Version Control System) repository
     */
    @SerializedName("providerRootDirectory")
    val providerRootDirectory: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
        "commands" to commands as Any,
        "entrypoint" to entrypoint as Any,
        "providerRootDirectory" to providerRootDirectory as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = TemplateRuntime(
            name = map["name"] as String,
            commands = map["commands"] as String,
            entrypoint = map["entrypoint"] as String,
            providerRootDirectory = map["providerRootDirectory"] as String,
        )
    }
}