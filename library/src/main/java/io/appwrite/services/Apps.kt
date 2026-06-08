package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * 
 */
class Apps(client: Client) : Service(client) {

    /**
     * List applications.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.AppsList]
     */
    @JvmOverloads
    suspend fun list(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.AppsList {
        val apiPath = "/apps"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AppsList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.AppsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AppsList::class.java,
            converter,
        )
    }


    /**
     * Create a new application.
     *
     * @param appId Application ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Application name.
     * @param redirectUris Redirect URIs (array of valid URLs).
     * @param enabled Is application enabled?
     * @param type OAuth2 client type. Use `public` for SPAs, mobile, and native apps that cannot keep a `client_secret` — PKCE is then required at the token endpoint. Use `confidential` for server-side clients that present a `client_secret`. Defaults to `confidential`.
     * @param deviceFlow Allow this client to use the OAuth2 Device Authorization Grant (RFC 8628) for input-constrained devices such as TVs and CLIs. Defaults to false.
     * @param teamId Team unique ID.
     * @return [io.appwrite.models.App]
     */
    @JvmOverloads
    suspend fun create(
        appId: String,
        name: String,
        redirectUris: List<String>,
        enabled: Boolean? = null,
        type: String? = null,
        deviceFlow: Boolean? = null,
        teamId: String? = null,
    ): io.appwrite.models.App {
        val apiPath = "/apps"

        val apiParams = mutableMapOf<String, Any?>(
            "appId" to appId,
            "name" to name,
            "redirectUris" to redirectUris,
            "enabled" to enabled,
            "type" to type,
            "deviceFlow" to deviceFlow,
            "teamId" to teamId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.App = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.App.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.App::class.java,
            converter,
        )
    }


    /**
     * Get an application by its unique ID.
     *
     * @param appId Application unique ID.
     * @return [io.appwrite.models.App]
     */
    suspend fun get(
        appId: String,
    ): io.appwrite.models.App {
        val apiPath = "/apps/{appId}"
            .replace("{appId}", appId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.App = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.App.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.App::class.java,
            converter,
        )
    }


    /**
     * Update an application by its unique ID.
     *
     * @param appId Application unique ID.
     * @param name Application name.
     * @param enabled Is application enabled?
     * @param redirectUris Redirect URIs (array of valid URLs).
     * @param type OAuth2 client type. Use `public` for SPAs, mobile, and native apps that cannot keep a `client_secret` — PKCE is then required at the token endpoint. Use `confidential` for server-side clients that present a `client_secret`. Defaults to `confidential`.
     * @param deviceFlow Allow this client to use the OAuth2 Device Authorization Grant (RFC 8628) for input-constrained devices such as TVs and CLIs. Defaults to false.
     * @return [io.appwrite.models.App]
     */
    @JvmOverloads
    suspend fun update(
        appId: String,
        name: String,
        enabled: Boolean? = null,
        redirectUris: List<String>? = null,
        type: String? = null,
        deviceFlow: Boolean? = null,
    ): io.appwrite.models.App {
        val apiPath = "/apps/{appId}"
            .replace("{appId}", appId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "redirectUris" to redirectUris,
            "type" to type,
            "deviceFlow" to deviceFlow,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.App = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.App.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.App::class.java,
            converter,
        )
    }


    /**
     * Delete an application by its unique ID.
     *
     * @param appId Application unique ID.
     * @return [Any]
     */
    suspend fun delete(
        appId: String,
    ): Any {
        val apiPath = "/apps/{appId}"
            .replace("{appId}", appId)

        val apiParams = mutableMapOf<String, Any?>(
        )
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


    /**
     * List client secrets for an application.
     *
     * @param appId Application unique ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.AppSecretList]
     */
    @JvmOverloads
    suspend fun listSecrets(
        appId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.AppSecretList {
        val apiPath = "/apps/{appId}/secrets"
            .replace("{appId}", appId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AppSecretList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.AppSecretList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AppSecretList::class.java,
            converter,
        )
    }


    /**
     * Create a new client secret for an application.
     *
     * @param appId Application unique ID.
     * @return [io.appwrite.models.AppSecretPlaintext]
     */
    suspend fun createSecret(
        appId: String,
    ): io.appwrite.models.AppSecretPlaintext {
        val apiPath = "/apps/{appId}/secrets"
            .replace("{appId}", appId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AppSecretPlaintext = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.AppSecretPlaintext.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AppSecretPlaintext::class.java,
            converter,
        )
    }


    /**
     * Get an application client secret by its unique ID.
     *
     * @param appId Application unique ID.
     * @param secretId Secret unique ID.
     * @return [io.appwrite.models.AppSecret]
     */
    suspend fun getSecret(
        appId: String,
        secretId: String,
    ): io.appwrite.models.AppSecret {
        val apiPath = "/apps/{appId}/secrets/{secretId}"
            .replace("{appId}", appId)
            .replace("{secretId}", secretId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AppSecret = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.AppSecret.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AppSecret::class.java,
            converter,
        )
    }


    /**
     * Delete an application client secret by its unique ID.
     *
     * @param appId Application unique ID.
     * @param secretId Secret unique ID.
     * @return [Any]
     */
    suspend fun deleteSecret(
        appId: String,
        secretId: String,
    ): Any {
        val apiPath = "/apps/{appId}/secrets/{secretId}"
            .replace("{appId}", appId)
            .replace("{secretId}", secretId)

        val apiParams = mutableMapOf<String, Any?>(
        )
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


    /**
     * Transfer an application to another team by its unique ID.
     *
     * @param appId Application unique ID.
     * @param teamId Team ID of the team to transfer application to.
     * @return [io.appwrite.models.App]
     */
    suspend fun updateTeam(
        appId: String,
        teamId: String,
    ): io.appwrite.models.App {
        val apiPath = "/apps/{appId}/team"
            .replace("{appId}", appId)

        val apiParams = mutableMapOf<String, Any?>(
            "teamId" to teamId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.App = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.App.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.App::class.java,
            converter,
        )
    }


    /**
     * Revoke all tokens for an application by its unique ID.
     *
     * @param appId Application unique ID.
     * @return [Any]
     */
    suspend fun deleteTokens(
        appId: String,
    ): Any {
        val apiPath = "/apps/{appId}/tokens"
            .replace("{appId}", appId)

        val apiParams = mutableMapOf<String, Any?>(
        )
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
