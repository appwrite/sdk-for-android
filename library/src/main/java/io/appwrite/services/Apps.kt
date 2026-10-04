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
 * The Apps service allows you to manage OAuth2 applications, their keys, secrets, scopes, and installations.
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
     * @param redirectUris Redirect URIs. Each must be an https URL, an http loopback URL (localhost, 127.0.0.1, [::1]), or a private-use scheme URI (e.g. com.example.app:/oauth), and must not contain a fragment.
     * @param description Application description shown to users during OAuth2 consent.
     * @param clientUri Application homepage URL shown to users during OAuth2 consent.
     * @param logoUri Application logo URL shown to users during OAuth2 consent.
     * @param privacyPolicyUrl Application privacy policy URL shown to users during OAuth2 consent.
     * @param termsUrl Application terms of service URL shown to users during OAuth2 consent.
     * @param contacts Application support or security contact emails. Maximum of 100 contacts are allowed.
     * @param tagline Application tagline shown to users during OAuth2 consent.
     * @param tags Application tags shown to users during OAuth2 consent. Maximum of 100 tags are allowed, each up to 64 characters long.
     * @param images Application image URLs shown to users during OAuth2 consent. Maximum of 100 images are allowed.
     * @param supportUrl Application support URL shown to users during OAuth2 consent.
     * @param dataDeletionUrl Application data deletion URL shown to users during OAuth2 consent.
     * @param postLogoutRedirectUris Post-logout redirect URIs for OpenID Connect RP-Initiated Logout. Each must be an https URL, an http loopback URL, or a private-use scheme URI, and must not contain a fragment. After ending the user session, the logout endpoint only redirects to URIs in this list.
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
        description: String? = null,
        clientUri: String? = null,
        logoUri: String? = null,
        privacyPolicyUrl: String? = null,
        termsUrl: String? = null,
        contacts: List<String>? = null,
        tagline: String? = null,
        tags: List<String>? = null,
        images: List<String>? = null,
        supportUrl: String? = null,
        dataDeletionUrl: String? = null,
        postLogoutRedirectUris: List<String>? = null,
        enabled: Boolean? = null,
        type: String? = null,
        deviceFlow: Boolean? = null,
        teamId: String? = null,
    ): io.appwrite.models.App {
        val apiPath = "/apps"
        val apiParams = mutableMapOf<String, Any?>(
            "appId" to appId,
            "name" to name,
            "description" to description,
            "clientUri" to clientUri,
            "logoUri" to logoUri,
            "privacyPolicyUrl" to privacyPolicyUrl,
            "termsUrl" to termsUrl,
            "contacts" to contacts,
            "tagline" to tagline,
            "tags" to tags,
            "images" to images,
            "supportUrl" to supportUrl,
            "dataDeletionUrl" to dataDeletionUrl,
            "redirectUris" to redirectUris,
            "postLogoutRedirectUris" to postLogoutRedirectUris,
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
     * List scopes an application can request when installed on a team.
     *
     * @return [io.appwrite.models.AppScopeList]
     */
    suspend fun listInstallationScopes(): io.appwrite.models.AppScopeList {
        val apiPath = "/apps/scopes/installations"
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AppScopeList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.AppScopeList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AppScopeList::class.java,
            converter,
        )
    }

    /**
     * List scopes an application can request during the OAuth2 flow.
     *
     * @return [io.appwrite.models.AppScopeList]
     */
    suspend fun listOAuth2Scopes(): io.appwrite.models.AppScopeList {
        val apiPath = "/apps/scopes/oauth2"
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AppScopeList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.AppScopeList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AppScopeList::class.java,
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
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        val apiPath = ("/apps/{appId}"
            .replace("{appId}", appId)
        )
        val apiParams = mutableMapOf<String, Any?>()
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
     * @param description Application description shown to users during OAuth2 consent.
     * @param clientUri Application homepage URL shown to users during OAuth2 consent.
     * @param logoUri Application logo URL shown to users during OAuth2 consent.
     * @param privacyPolicyUrl Application privacy policy URL shown to users during OAuth2 consent.
     * @param termsUrl Application terms of service URL shown to users during OAuth2 consent.
     * @param contacts Application support or security contact emails. Maximum of 100 contacts are allowed.
     * @param tagline Application tagline shown to users during OAuth2 consent.
     * @param tags Application tags shown to users during OAuth2 consent. Maximum of 100 tags are allowed, each up to 64 characters long.
     * @param images Application image URLs shown to users during OAuth2 consent. Maximum of 100 images are allowed.
     * @param supportUrl Application support URL shown to users during OAuth2 consent.
     * @param dataDeletionUrl Application data deletion URL shown to users during OAuth2 consent.
     * @param enabled Is application enabled?
     * @param redirectUris Redirect URIs. Each must be an https URL, an http loopback URL (localhost, 127.0.0.1, [::1]), or a private-use scheme URI (e.g. com.example.app:/oauth), and must not contain a fragment.
     * @param postLogoutRedirectUris Post-logout redirect URIs for OpenID Connect RP-Initiated Logout. Each must be an https URL, an http loopback URL, or a private-use scheme URI, and must not contain a fragment. After ending the user session, the logout endpoint only redirects to URIs in this list.
     * @param type OAuth2 client type. Use `public` for SPAs, mobile, and native apps that cannot keep a `client_secret` — PKCE is then required at the token endpoint. Use `confidential` for server-side clients that present a `client_secret`. Defaults to `confidential`.
     * @param deviceFlow Allow this client to use the OAuth2 Device Authorization Grant (RFC 8628) for input-constrained devices such as TVs and CLIs. Defaults to false.
     * @param installationScopes Scopes the application requests when installed on a team. Only scopes allowed by the project's OAuth2 server installation scopes configuration are accepted; use the list installation scopes endpoint to discover available values. Maximum of 100 scopes are allowed.
     * @param installationRedirectUrl URL users are redirected to after creating or updating an installation of this application. Must be an https URL, an http loopback URL (localhost, 127.0.0.1, [::1]), or a private-use scheme URI, and must not contain a fragment. Leave empty for no redirect.
     * @return [io.appwrite.models.App]
     */
    @JvmOverloads
    suspend fun update(
        appId: String,
        name: String,
        description: String? = null,
        clientUri: String? = null,
        logoUri: String? = null,
        privacyPolicyUrl: String? = null,
        termsUrl: String? = null,
        contacts: List<String>? = null,
        tagline: String? = null,
        tags: List<String>? = null,
        images: List<String>? = null,
        supportUrl: String? = null,
        dataDeletionUrl: String? = null,
        enabled: Boolean? = null,
        redirectUris: List<String>? = null,
        postLogoutRedirectUris: List<String>? = null,
        type: String? = null,
        deviceFlow: Boolean? = null,
        installationScopes: List<String>? = null,
        installationRedirectUrl: String? = null,
    ): io.appwrite.models.App {
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        val apiPath = ("/apps/{appId}"
            .replace("{appId}", appId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "description" to description,
            "clientUri" to clientUri,
            "logoUri" to logoUri,
            "privacyPolicyUrl" to privacyPolicyUrl,
            "termsUrl" to termsUrl,
            "contacts" to contacts,
            "tagline" to tagline,
            "tags" to tags,
            "images" to images,
            "supportUrl" to supportUrl,
            "dataDeletionUrl" to dataDeletionUrl,
            "enabled" to enabled,
            "redirectUris" to redirectUris,
            "postLogoutRedirectUris" to postLogoutRedirectUris,
            "type" to type,
            "deviceFlow" to deviceFlow,
            "installationScopes" to installationScopes,
            "installationRedirectUrl" to installationRedirectUrl,
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
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        val apiPath = ("/apps/{appId}"
            .replace("{appId}", appId)
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

    /**
     * List installations of an application. Requires an app key sent in the `X-Appwrite-Key` header alongside the `X-Appwrite-App` header, or a caller with update access to the app.
     *
     * @param appId Application unique ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.AppInstallationList]
     */
    @JvmOverloads
    suspend fun listInstallations(
        appId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.AppInstallationList {
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        val apiPath = ("/apps/{appId}/installations"
            .replace("{appId}", appId)
        )
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
     * Get an installation of an application by its unique ID. Requires an app key sent in the `X-Appwrite-Key` header alongside the `X-Appwrite-App` header, or a caller with update access to the app.
     *
     * @param appId Application unique ID.
     * @param installationId Installation unique ID.
     * @return [io.appwrite.models.AppInstallation]
     */
    suspend fun getInstallation(
        appId: String,
        installationId: String,
    ): io.appwrite.models.AppInstallation {
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        if (installationId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"installationId\"")
        }
        val apiPath = ("/apps/{appId}/installations/{installationId}"
            .replace("{appId}", appId)
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
     * Delete an installation of an application by its unique ID. Requires a caller with update access to the app. Previously issued installation access tokens are revoked.
     *
     * @param appId Application unique ID.
     * @param installationId Installation unique ID.
     * @return [Any]
     */
    suspend fun deleteInstallation(
        appId: String,
        installationId: String,
    ): Any {
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        if (installationId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"installationId\"")
        }
        val apiPath = ("/apps/{appId}/installations/{installationId}"
            .replace("{appId}", appId)
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

    /**
     * Create a token for an installation of an application. Requires an app key sent in the `X-Appwrite-Key` header alongside the `X-Appwrite-App` header, or a caller with update access to the app. The returned token carries the scopes and authorization details granted to the installation, and can be used as an `Authorization: Bearer` header everywhere OAuth2 access tokens are accepted. Multiple tokens can be active for the same installation at once; each token stays valid until it expires or the installation is updated or deleted.
     *
     * @param appId Application unique ID.
     * @param installationId Installation unique ID.
     * @return [io.appwrite.models.Oauth2Token]
     */
    suspend fun createInstallationToken(
        appId: String,
        installationId: String,
    ): io.appwrite.models.Oauth2Token {
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        if (installationId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"installationId\"")
        }
        val apiPath = ("/apps/{appId}/installations/{installationId}/tokens"
            .replace("{appId}", appId)
            .replace("{installationId}", installationId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Oauth2Token = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Oauth2Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Oauth2Token::class.java,
            converter,
        )
    }

    /**
     * List app keys for an application.
     *
     * @param appId Application unique ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.AppKeyList]
     */
    @JvmOverloads
    suspend fun listKeys(
        appId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.AppKeyList {
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        val apiPath = ("/apps/{appId}/keys"
            .replace("{appId}", appId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AppKeyList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.AppKeyList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AppKeyList::class.java,
            converter,
        )
    }

    /**
     * Create a new app key for an application. App keys carry no scopes; send one in the `X-Appwrite-Key` header alongside the `X-Appwrite-App` header to list the application's installations and create installation access tokens.
     *
     * @param appId Application unique ID.
     * @return [io.appwrite.models.AppKey]
     */
    suspend fun createKey(
        appId: String,
    ): io.appwrite.models.AppKey {
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        val apiPath = ("/apps/{appId}/keys"
            .replace("{appId}", appId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AppKey = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.AppKey.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AppKey::class.java,
            converter,
        )
    }

    /**
     * Get an app key by its unique ID.
     *
     * @param appId Application unique ID.
     * @param keyId App key unique ID.
     * @return [io.appwrite.models.AppKey]
     */
    suspend fun getKey(
        appId: String,
        keyId: String,
    ): io.appwrite.models.AppKey {
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        if (keyId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"keyId\"")
        }
        val apiPath = ("/apps/{appId}/keys/{keyId}"
            .replace("{appId}", appId)
            .replace("{keyId}", keyId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AppKey = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.AppKey.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AppKey::class.java,
            converter,
        )
    }

    /**
     * Delete an app key by its unique ID.
     *
     * @param appId Application unique ID.
     * @param keyId App key unique ID.
     * @return [Any]
     */
    suspend fun deleteKey(
        appId: String,
        keyId: String,
    ): Any {
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        if (keyId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"keyId\"")
        }
        val apiPath = ("/apps/{appId}/keys/{keyId}"
            .replace("{appId}", appId)
            .replace("{keyId}", keyId)
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
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        val apiPath = ("/apps/{appId}/secrets"
            .replace("{appId}", appId)
        )
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
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        val apiPath = ("/apps/{appId}/secrets"
            .replace("{appId}", appId)
        )
        val apiParams = mutableMapOf<String, Any?>()
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
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        if (secretId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"secretId\"")
        }
        val apiPath = ("/apps/{appId}/secrets/{secretId}"
            .replace("{appId}", appId)
            .replace("{secretId}", secretId)
        )
        val apiParams = mutableMapOf<String, Any?>()
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
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        if (secretId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"secretId\"")
        }
        val apiPath = ("/apps/{appId}/secrets/{secretId}"
            .replace("{appId}", appId)
            .replace("{secretId}", secretId)
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
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        val apiPath = ("/apps/{appId}/team"
            .replace("{appId}", appId)
        )
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
        if (appId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"appId\"")
        }
        val apiPath = ("/apps/{appId}/tokens"
            .replace("{appId}", appId)
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
