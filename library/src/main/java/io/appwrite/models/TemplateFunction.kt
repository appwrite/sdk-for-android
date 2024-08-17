package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Template Function
 */
data class TemplateFunction(
    /**
     * Function Template Icon.
     */
    @SerializedName("icon")
    val icon: String,

    /**
     * Function Template ID.
     */
    @SerializedName("id")
    val id: String,

    /**
     * Function Template Name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Function Template Tagline.
     */
    @SerializedName("tagline")
    val tagline: String,

    /**
     * Execution permissions.
     */
    @SerializedName("permissions")
    val permissions: List<Any>,

    /**
     * Function trigger events.
     */
    @SerializedName("events")
    val events: List<Any>,

    /**
     * Function execution schedult in CRON format.
     */
    @SerializedName("cron")
    val cron: String,

    /**
     * Function execution timeout in seconds.
     */
    @SerializedName("timeout")
    val timeout: Long,

    /**
     * Function use cases.
     */
    @SerializedName("useCases")
    val useCases: List<Any>,

    /**
     * List of runtimes that can be used with this template.
     */
    @SerializedName("runtimes")
    val runtimes: List<TemplateRuntime>,

    /**
     * Function Template Instructions.
     */
    @SerializedName("instructions")
    val instructions: String,

    /**
     * VCS (Version Control System) Provider.
     */
    @SerializedName("vcsProvider")
    val vcsProvider: String,

    /**
     * VCS (Version Control System) Repository ID
     */
    @SerializedName("providerRepositoryId")
    val providerRepositoryId: String,

    /**
     * VCS (Version Control System) Owner.
     */
    @SerializedName("providerOwner")
    val providerOwner: String,

    /**
     * VCS (Version Control System) branch version (tag).
     */
    @SerializedName("providerVersion")
    val providerVersion: String,

    /**
     * Function variables.
     */
    @SerializedName("variables")
    val variables: List<TemplateVariable>,

    /**
     * Function scopes.
     */
    @SerializedName("scopes")
    val scopes: List<Any>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "icon" to icon as Any,
        "id" to id as Any,
        "name" to name as Any,
        "tagline" to tagline as Any,
        "permissions" to permissions as Any,
        "events" to events as Any,
        "cron" to cron as Any,
        "timeout" to timeout as Any,
        "useCases" to useCases as Any,
        "runtimes" to runtimes.map { it.toMap() } as Any,
        "instructions" to instructions as Any,
        "vcsProvider" to vcsProvider as Any,
        "providerRepositoryId" to providerRepositoryId as Any,
        "providerOwner" to providerOwner as Any,
        "providerVersion" to providerVersion as Any,
        "variables" to variables.map { it.toMap() } as Any,
        "scopes" to scopes as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = TemplateFunction(
            icon = map["icon"] as String,
            id = map["id"] as String,
            name = map["name"] as String,
            tagline = map["tagline"] as String,
            permissions = map["permissions"] as List<Any>,
            events = map["events"] as List<Any>,
            cron = map["cron"] as String,
            timeout = (map["timeout"] as Number).toLong(),
            useCases = map["useCases"] as List<Any>,
            runtimes = (map["runtimes"] as List<Map<String, Any>>).map { TemplateRuntime.from(map = it) },
            instructions = map["instructions"] as String,
            vcsProvider = map["vcsProvider"] as String,
            providerRepositoryId = map["providerRepositoryId"] as String,
            providerOwner = map["providerOwner"] as String,
            providerVersion = map["providerVersion"] as String,
            variables = (map["variables"] as List<Map<String, Any>>).map { TemplateVariable.from(map = it) },
            scopes = map["scopes"] as List<Any>,
        )
    }
}