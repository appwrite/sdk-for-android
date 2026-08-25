package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import io.appwrite.models.*
import okhttp3.Cookie
import java.io.File

/**
 * The Organization service allows you to manage organization-level projects. */
class Organization(client: Client) : Service(client) {
    /**
     * List app installations on the organization. Any organization member can read installations.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.AppInstallationList]
     */
    @JvmOverloads
    suspend fun listInstallations(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.AppInstallationList {
        val apiPath = "/organization/installations"
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AppInstallationList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.AppInstallationList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AppInstallationList::class.java,
            converter,
        )
    }

    /**
     * Install an app on the organization. Only organization members with the owner role can install apps. The installation is granted the scopes the app currently requests.
     *
     * @param appId Application unique ID.
     * @param authorizationDetails Authorization details granted to the installation as a JSON array of objects, each with a `type` and app-defined fields. The Appwrite Console stores authorized project IDs here.
     * @return [io.appwrite.models.AppInstallation]
     */
    @JvmOverloads
    suspend fun createInstallation(
        appId: String,
        authorizationDetails: String? = null,
    ): io.appwrite.models.AppInstallation {
        val apiPath = "/organization/installations"
        val apiParams = mutableMapOf<String, Any?>(
            "appId" to appId,
            "authorizationDetails" to authorizationDetails,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AppInstallation = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.AppInstallation.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AppInstallation::class.java,
            converter,
        )
    }

    /**
     * Get an app installation on the organization by its unique ID. Any organization member can read installations.
     *
     * @param installationId Installation unique ID.
     * @return [io.appwrite.models.AppInstallation]
     */
    suspend fun getInstallation(
        installationId: String,
    ): io.appwrite.models.AppInstallation {
        val apiPath = ("/organization/installations/{installationId}"
            .replace("{installationId}", installationId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AppInstallation = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.AppInstallation.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AppInstallation::class.java,
            converter,
        )
    }

    /**
     * Update an app installation on the organization. Only organization members with the owner role can update installations. The installation's granted scopes are refreshed to the scopes the app currently requests; previously issued installation access tokens are revoked.
     *
     * @param installationId Installation unique ID.
     * @param authorizationDetails Authorization details granted to the installation as a JSON array of objects, each with a `type` and app-defined fields. Omit to keep the current value.
     * @return [io.appwrite.models.AppInstallation]
     */
    @JvmOverloads
    suspend fun updateInstallation(
        installationId: String,
        authorizationDetails: String? = null,
    ): io.appwrite.models.AppInstallation {
        val apiPath = ("/organization/installations/{installationId}"
            .replace("{installationId}", installationId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "authorizationDetails" to authorizationDetails,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AppInstallation = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.AppInstallation.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AppInstallation::class.java,
            converter,
        )
    }

    /**
     * Uninstall an app from the organization by its installation ID. Only organization members with the owner role can remove installations. Previously issued installation access tokens are revoked.
     *
     * @param installationId Installation unique ID.
     * @return [Any]
     */
    suspend fun deleteInstallation(
        installationId: String,
    ): Any {
        val apiPath = ("/organization/installations/{installationId}"
            .replace("{installationId}", installationId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }
}
