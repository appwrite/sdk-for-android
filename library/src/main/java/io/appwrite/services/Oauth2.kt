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
 * The OAuth2 service allows you to authorize apps and issue standards-based OAuth2 and OpenID Connect tokens.
 */
class Oauth2(client: Client) : Service(client) {
    /**
     * Approve an OAuth2 grant after the user gives consent. Returns the `redirectUrl` the end user should be sent to. The consent screen may optionally pass enriched `authorization_details` to record the concrete resources the user selected. You can pass Accept header of `application/json` to receive a JSON response instead of a redirect.
     *
     * @param grantId Grant ID made during authorization, provided to consent screen in URL search params.
     * @param authorizationDetails Enriched `authorization_details` the user consented to, replacing what the client requested. Each entry must use a `type` the project accepts. Optional; omit to keep the originally requested details.
     * @param scope Space-separated scopes the user consented to. Must be a subset of the scopes originally requested; identity scopes such as `openid` are always retained. Optional; omit to keep the originally requested scopes.
     * @return [io.appwrite.models.Oauth2Approve]
     */
    @JvmOverloads
    suspend fun approve(
        grantId: String,
        authorizationDetails: String? = null,
        scope: String? = null,
    ): io.appwrite.models.Oauth2Approve {
        val apiPath = ("/oauth2/{project_id}/approve"
            .replace("{project_id}", client.config["project"].orEmpty())
        )
        val apiParams = mutableMapOf<String, Any?>(
            "grant_id" to grantId,
            "authorization_details" to authorizationDetails,
            "scope" to scope,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Oauth2Approve = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Oauth2Approve.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Oauth2Approve::class.java,
            converter,
        )
    }

    /**
     * Begin the OAuth2 authorization flow. When called without a session, the user is redirected to the consent screen without grant ID. When called with a session, the redirect URL includes param for grant ID. You can pass Accept header of `application/json` to receive a JSON response instead of a redirect.
     *
     * @param clientId OAuth2 client ID. Either a registered app ID or an HTTPS client ID metadata document URL.
     * @param redirectUri Redirect URI where visitor will be redirected after authorization, whether successful or not.
     * @param responseType OAuth2 / OIDC response type. One of `code` (Authorization Code Flow), `id_token` (Implicit Flow, OIDC login only), or `code id_token` (Hybrid Flow).
     * @param scope Space-separated OAuth2 scopes. Can include project scopes, and built-in scopes: `openid`, `email`, `profile`, `phone`.
     * @param state OAuth2 state. You receive this back in the redirect URI.
     * @param nonce OIDC nonce parameter to prevent replay attacks. Required when response_type includes `id_token`.
     * @param codeChallenge PKCE code challenge. Required when OAuth2 app is public.
     * @param codeChallengeMethod PKCE code challenge method. Required when OAuth2 app is public.
     * @param prompt OIDC prompt parameter for customization of consent screen. Space-separated list of: none, login, consent, select_account.
     * @param maxAge OIDC max_age paraleter for customization of consent screen. Maximum allowable elapsed time in seconds since the user last authenticated. If exceeded, re-authentication is required.
     * @param authorizationDetails Rich authorization request. JSON array of objects, each with a `type` and project-defined fields
     * @param resource RFC 8707 resource indicator URI or URI list. Each value must be an absolute URI without a fragment.
     * @param audience Compatibility alias for a single OAuth2 resource indicator URI.
     * @param requestUri OAuth2 authorization request handle returned by the pushed authorization request endpoint.
     * @return [io.appwrite.models.Oauth2Authorize]
     */
    @JvmOverloads
    suspend fun authorize(
        clientId: String? = null,
        redirectUri: String? = null,
        responseType: String? = null,
        scope: String? = null,
        state: String? = null,
        nonce: String? = null,
        codeChallenge: String? = null,
        codeChallengeMethod: String? = null,
        prompt: String? = null,
        maxAge: Long? = null,
        authorizationDetails: String? = null,
        resource: String? = null,
        audience: String? = null,
        requestUri: String? = null,
    ): io.appwrite.models.Oauth2Authorize {
        val apiPath = ("/oauth2/{project_id}/authorize"
            .replace("{project_id}", client.config["project"].orEmpty())
        )
        val apiParams = mutableMapOf<String, Any?>(
            "client_id" to clientId,
            "redirect_uri" to redirectUri,
            "response_type" to responseType,
            "scope" to scope,
            "state" to state,
            "nonce" to nonce,
            "code_challenge" to codeChallenge,
            "code_challenge_method" to codeChallengeMethod,
            "prompt" to prompt,
            "max_age" to maxAge,
            "authorization_details" to authorizationDetails,
            "resource" to resource,
            "audience" to audience,
            "request_uri" to requestUri,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Oauth2Authorize = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Oauth2Authorize.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Oauth2Authorize::class.java,
            converter,
        )
    }

    /**
     * Begin the OAuth2 authorization flow. When called without a session, the user is redirected to the consent screen without grant ID. When called with a session, the redirect URL includes param for grant ID. You can pass Accept header of `application/json` to receive a JSON response instead of a redirect.
     *
     * @param clientId OAuth2 client ID. Either a registered app ID or an HTTPS client ID metadata document URL.
     * @param redirectUri Redirect URI where visitor will be redirected after authorization, whether successful or not.
     * @param responseType OAuth2 / OIDC response type. One of `code` (Authorization Code Flow), `id_token` (Implicit Flow, OIDC login only), or `code id_token` (Hybrid Flow).
     * @param scope Space-separated OAuth2 scopes. Can include project scopes, and built-in scopes: `openid`, `email`, `profile`, `phone`.
     * @param state OAuth2 state. You receive this back in the redirect URI.
     * @param nonce OIDC nonce parameter to prevent replay attacks. Required when response_type includes `id_token`.
     * @param codeChallenge PKCE code challenge. Required when OAuth2 app is public.
     * @param codeChallengeMethod PKCE code challenge method. Required when OAuth2 app is public.
     * @param prompt OIDC prompt parameter for customization of consent screen. Space-separated list of: none, login, consent, select_account.
     * @param maxAge OIDC max_age paraleter for customization of consent screen. Maximum allowable elapsed time in seconds since the user last authenticated. If exceeded, re-authentication is required.
     * @param authorizationDetails Rich authorization request. JSON array of objects, each with a `type` and project-defined fields
     * @param resource RFC 8707 resource indicator URI or URI list. Each value must be an absolute URI without a fragment.
     * @param audience Compatibility alias for a single OAuth2 resource indicator URI.
     * @param requestUri OAuth2 authorization request handle returned by the pushed authorization request endpoint.
     * @return [io.appwrite.models.Oauth2Authorize]
     */
    @JvmOverloads
    suspend fun authorizePost(
        clientId: String? = null,
        redirectUri: String? = null,
        responseType: String? = null,
        scope: String? = null,
        state: String? = null,
        nonce: String? = null,
        codeChallenge: String? = null,
        codeChallengeMethod: String? = null,
        prompt: String? = null,
        maxAge: Long? = null,
        authorizationDetails: String? = null,
        resource: String? = null,
        audience: String? = null,
        requestUri: String? = null,
    ): io.appwrite.models.Oauth2Authorize {
        val apiPath = ("/oauth2/{project_id}/authorize"
            .replace("{project_id}", client.config["project"].orEmpty())
        )
        val apiParams = mutableMapOf<String, Any?>(
            "client_id" to clientId,
            "redirect_uri" to redirectUri,
            "response_type" to responseType,
            "scope" to scope,
            "state" to state,
            "nonce" to nonce,
            "code_challenge" to codeChallenge,
            "code_challenge_method" to codeChallengeMethod,
            "prompt" to prompt,
            "max_age" to maxAge,
            "authorization_details" to authorizationDetails,
            "resource" to resource,
            "audience" to audience,
            "request_uri" to requestUri,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Oauth2Authorize = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Oauth2Authorize.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Oauth2Authorize::class.java,
            converter,
        )
    }

    /**
     * Start the OAuth2 Device Authorization Grant. Returns the device code, user code, verification URL, expiration, and polling interval.
     *
     * @param clientId OAuth2 client ID. Either a registered app ID or an HTTPS client ID metadata document URL.
     * @param scope Space-separated OAuth2 scopes. Can include project scopes, and built-in scopes: `openid`, `email`, `profile`.
     * @param authorizationDetails Rich authorization request. JSON array of objects, each with a `type` and project-defined fields
     * @param resource RFC 8707 resource indicator URI or URI list. Each value must be an absolute URI without a fragment.
     * @param audience Compatibility alias for a single OAuth2 resource indicator URI.
     * @return [io.appwrite.models.Oauth2DeviceAuthorization]
     */
    @JvmOverloads
    suspend fun createDeviceAuthorization(
        clientId: String? = null,
        scope: String? = null,
        authorizationDetails: String? = null,
        resource: String? = null,
        audience: String? = null,
    ): io.appwrite.models.Oauth2DeviceAuthorization {
        val apiPath = ("/oauth2/{project_id}/device_authorization"
            .replace("{project_id}", client.config["project"].orEmpty())
        )
        val apiParams = mutableMapOf<String, Any?>(
            "client_id" to clientId,
            "scope" to scope,
            "authorization_details" to authorizationDetails,
            "resource" to resource,
            "audience" to audience,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Oauth2DeviceAuthorization = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Oauth2DeviceAuthorization.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Oauth2DeviceAuthorization::class.java,
            converter,
        )
    }

    /**
     * Exchange a device flow user code for an OAuth2 grant. The authenticated user is bound to the pending grant. Pass the returned grant ID to the get grant endpoint to render the consent screen, then to the approve or reject endpoint to complete the flow.
     *
     * @param userCode User code displayed on the device.
     * @return [io.appwrite.models.Oauth2Grant]
     */
    suspend fun createGrant(
        userCode: String,
    ): io.appwrite.models.Oauth2Grant {
        val apiPath = ("/oauth2/{project_id}/grants"
            .replace("{project_id}", client.config["project"].orEmpty())
        )
        val apiParams = mutableMapOf<String, Any?>(
            "user_code" to userCode,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Oauth2Grant = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Oauth2Grant.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Oauth2Grant::class.java,
            converter,
        )
    }

    /**
     * Get an OAuth2 grant by its ID. Used by the consent screen to display the details of the authorization the user is being asked to approve. A grant can only be read by the user it belongs to, or by server SDK.
     *
     * @param grantId Grant ID made during authorization, provided to consent screen in URL search params.
     * @return [io.appwrite.models.Oauth2Grant]
     */
    suspend fun getGrant(
        grantId: String,
    ): io.appwrite.models.Oauth2Grant {
        if (grantId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"grantId\"")
        }
        val apiPath = ("/oauth2/{project_id}/grants/{grant_id}"
            .replace("{project_id}", client.config["project"].orEmpty())
            .replace("{grant_id}", grantId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Oauth2Grant = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Oauth2Grant.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Oauth2Grant::class.java,
            converter,
        )
    }

    /**
     * OpenID Connect RP-Initiated Logout. Ends the user session and revokes the tokens issued to the app identified by the `id_token_hint`, then redirects the user to `post_logout_redirect_uri` when it matches a URI registered on the app.
     *
     * @param idTokenHint ID Token previously issued to the app, used as proof of the logout request. Required to end the session; signature and issuer are validated while expiry is ignored.
     * @param logoutHint Hint about the user that is logging out. Accepted for OIDC compatibility.
     * @param clientId OAuth2 client ID. When both `client_id` and `id_token_hint` are provided, they must identify the same app.
     * @param postLogoutRedirectUri URI to redirect the user to after logout. Must exactly match a URI registered in the app's `postLogoutRedirectUris`.
     * @param state Opaque value passed back unchanged in the `state` query param of the post-logout redirect.
     * @param uiLocales Preferred languages for any logout UI, as space-separated BCP47 tags. Accepted for OIDC compatibility.
     * @return [Any]
     */
    @JvmOverloads
    suspend fun logout(
        idTokenHint: String? = null,
        logoutHint: String? = null,
        clientId: String? = null,
        postLogoutRedirectUri: String? = null,
        state: String? = null,
        uiLocales: String? = null,
    ): Any {
        val apiPath = ("/oauth2/{project_id}/logout"
            .replace("{project_id}", client.config["project"].orEmpty())
        )
        val apiParams = mutableMapOf<String, Any?>(
            "id_token_hint" to idTokenHint,
            "logout_hint" to logoutHint,
            "client_id" to clientId,
            "post_logout_redirect_uri" to postLogoutRedirectUri,
            "state" to state,
            "ui_locales" to uiLocales,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "accept" to "application/json",
        )
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * OpenID Connect RP-Initiated Logout. Ends the user session and revokes the tokens issued to the app identified by the `id_token_hint`, then redirects the user to `post_logout_redirect_uri` when it matches a URI registered on the app.
     *
     * @param idTokenHint ID Token previously issued to the app, used as proof of the logout request. Required to end the session; signature and issuer are validated while expiry is ignored.
     * @param logoutHint Hint about the user that is logging out. Accepted for OIDC compatibility.
     * @param clientId OAuth2 client ID. When both `client_id` and `id_token_hint` are provided, they must identify the same app.
     * @param postLogoutRedirectUri URI to redirect the user to after logout. Must exactly match a URI registered in the app's `postLogoutRedirectUris`.
     * @param state Opaque value passed back unchanged in the `state` query param of the post-logout redirect.
     * @param uiLocales Preferred languages for any logout UI, as space-separated BCP47 tags. Accepted for OIDC compatibility.
     * @return [Any]
     */
    @JvmOverloads
    suspend fun logoutPost(
        idTokenHint: String? = null,
        logoutHint: String? = null,
        clientId: String? = null,
        postLogoutRedirectUri: String? = null,
        state: String? = null,
        uiLocales: String? = null,
    ): Any {
        val apiPath = ("/oauth2/{project_id}/logout"
            .replace("{project_id}", client.config["project"].orEmpty())
        )
        val apiParams = mutableMapOf<String, Any?>(
            "id_token_hint" to idTokenHint,
            "logout_hint" to logoutHint,
            "client_id" to clientId,
            "post_logout_redirect_uri" to postLogoutRedirectUri,
            "state" to state,
            "ui_locales" to uiLocales,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * List the organizations the OAuth2 access token can access. Resolves the token's `organization` authorization details, expanding the `*` wildcard into the concrete set of organizations the user can see.
     *
     * @param limit Maximum number of organizations to return. Between 1 and 5000.
     * @param offset Number of organizations to skip before returning results. Used for pagination.
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.Oauth2OrganizationList]
     */
    @JvmOverloads
    suspend fun listOrganizations(
        limit: Long? = null,
        offset: Long? = null,
        search: String? = null,
    ): io.appwrite.models.Oauth2OrganizationList {
        val apiPath = ("/oauth2/{project_id}/organizations"
            .replace("{project_id}", client.config["project"].orEmpty())
        )
        val apiParams = mutableMapOf<String, Any?>(
            "limit" to limit,
            "offset" to offset,
            "search" to search,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Oauth2OrganizationList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Oauth2OrganizationList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Oauth2OrganizationList::class.java,
            converter,
        )
    }

    /**
     * Store an OAuth2 authorization request server-side and receive a short-lived request_uri handle for the authorize endpoint.
     *
     * @param clientId OAuth2 client ID. Either a registered app ID or an HTTPS client ID metadata document URL.
     * @param redirectUri Redirect URI where visitor will be redirected after authorization, whether successful or not.
     * @param responseType OAuth2 / OIDC response type.
     * @param scope Space-separated OAuth2 scopes. Can include project scopes, and built-in scopes: `openid`, `email`, `profile`, `phone`.
     * @param state OAuth2 state. You receive this back in the redirect URI.
     * @param nonce OIDC nonce parameter to prevent replay attacks. Required when response_type includes `id_token`.
     * @param codeChallenge PKCE code challenge. Required when OAuth2 app is public.
     * @param codeChallengeMethod PKCE code challenge method. Required when OAuth2 app is public.
     * @param prompt OIDC prompt parameter for customization of consent screen. Space-separated list of: none, login, consent, select_account.
     * @param maxAge OIDC max_age parameter for customization of consent screen.
     * @param authorizationDetails Rich authorization request. JSON array of objects, each with a `type` and project-defined fields
     * @param resource RFC 8707 resource indicator URI or URI list. Each value must be an absolute URI without a fragment.
     * @param audience Compatibility alias for a single OAuth2 resource indicator URI.
     * @return [io.appwrite.models.Oauth2PAR]
     */
    @JvmOverloads
    suspend fun createPAR(
        clientId: String,
        redirectUri: String,
        responseType: String,
        scope: String? = null,
        state: String? = null,
        nonce: String? = null,
        codeChallenge: String? = null,
        codeChallengeMethod: String? = null,
        prompt: String? = null,
        maxAge: Long? = null,
        authorizationDetails: String? = null,
        resource: String? = null,
        audience: String? = null,
    ): io.appwrite.models.Oauth2PAR {
        val apiPath = ("/oauth2/{project_id}/par"
            .replace("{project_id}", client.config["project"].orEmpty())
        )
        val apiParams = mutableMapOf<String, Any?>(
            "client_id" to clientId,
            "redirect_uri" to redirectUri,
            "response_type" to responseType,
            "scope" to scope,
            "state" to state,
            "nonce" to nonce,
            "code_challenge" to codeChallenge,
            "code_challenge_method" to codeChallengeMethod,
            "prompt" to prompt,
            "max_age" to maxAge,
            "authorization_details" to authorizationDetails,
            "resource" to resource,
            "audience" to audience,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Oauth2PAR = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Oauth2PAR.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Oauth2PAR::class.java,
            converter,
        )
    }

    /**
     * List the projects the OAuth2 access token can access. Resolves the token's `project` authorization details, expanding the `*` wildcard into the concrete set of projects the user can see.
     *
     * @param limit Maximum number of projects to return. Between 1 and 5000.
     * @param offset Number of projects to skip before returning results. Used for pagination.
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.Oauth2ProjectList]
     */
    @JvmOverloads
    suspend fun listProjects(
        limit: Long? = null,
        offset: Long? = null,
        search: String? = null,
    ): io.appwrite.models.Oauth2ProjectList {
        val apiPath = ("/oauth2/{project_id}/projects"
            .replace("{project_id}", client.config["project"].orEmpty())
        )
        val apiParams = mutableMapOf<String, Any?>(
            "limit" to limit,
            "offset" to offset,
            "search" to search,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Oauth2ProjectList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Oauth2ProjectList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Oauth2ProjectList::class.java,
            converter,
        )
    }

    /**
     * Reject an OAuth2 grant when the user denies consent. Returns the `redirectUrl` the end user should be sent to with an `access_denied` error. You can pass Accept header of `application/json` to receive a JSON response instead of a redirect.
     *
     * @param grantId Grant ID made during authorization, provided to consent screen in URL search params.
     * @return [io.appwrite.models.Oauth2Reject]
     */
    suspend fun reject(
        grantId: String,
    ): io.appwrite.models.Oauth2Reject {
        val apiPath = ("/oauth2/{project_id}/reject"
            .replace("{project_id}", client.config["project"].orEmpty())
        )
        val apiParams = mutableMapOf<String, Any?>(
            "grant_id" to grantId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Oauth2Reject = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Oauth2Reject.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Oauth2Reject::class.java,
            converter,
        )
    }

    /**
     * Revoke an OAuth2 access token or refresh token.
     *
     * @param token The access or refresh token to revoke.
     * @param tokenTypeHint Type of token to revoke (access_token or refresh_token).
     * @param clientId OAuth2 client ID. Either a registered app ID or an HTTPS client ID metadata document URL.
     * @param clientSecret OAuth2 client secret. Required for confidential apps; omitted for public apps.
     * @return [Any]
     */
    @JvmOverloads
    suspend fun revoke(
        token: String,
        tokenTypeHint: String? = null,
        clientId: String? = null,
        clientSecret: String? = null,
    ): Any {
        val apiPath = ("/oauth2/{project_id}/revoke"
            .replace("{project_id}", client.config["project"].orEmpty())
        )
        val apiParams = mutableMapOf<String, Any?>(
            "token" to token,
            "token_type_hint" to tokenTypeHint,
            "client_id" to clientId,
            "client_secret" to clientSecret,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * Exchange an OAuth2 authorization code, refresh token, or device code for access and refresh tokens.
     *
     * @param grantType OAuth2 grant type. Can be one of: `authorization_code`, `refresh_token`, `urn:ietf:params:oauth:grant-type:device_code`.
     * @param code Authorization code to be exchanged for access and refresh tokens. Required for `authorization_code` grant type.
     * @param refreshToken Refresh token to be exchanged for a new access and refresh tokens. Required for `refresh_token` grant type.
     * @param deviceCode Device code obtained from the device authorization endpoint. Required for `urn:ietf:params:oauth:grant-type:device_code` grant type.
     * @param clientId OAuth2 client ID. Either a registered app ID or an HTTPS client ID metadata document URL.
     * @param clientSecret OAuth2 client secret. Required for confidential apps.
     * @param codeVerifier PKCE code verifier. Required for public apps.
     * @param redirectUri Redirect URI. Required for `authorization_code` grant type.
     * @param resource RFC 8707 resource indicator URI or URI list. Each value must be an absolute URI without a fragment.
     * @param audience Compatibility alias for a single OAuth2 resource indicator URI.
     * @return [io.appwrite.models.Oauth2Token]
     */
    @JvmOverloads
    suspend fun createToken(
        grantType: String,
        code: String? = null,
        refreshToken: String? = null,
        deviceCode: String? = null,
        clientId: String? = null,
        clientSecret: String? = null,
        codeVerifier: String? = null,
        redirectUri: String? = null,
        resource: String? = null,
        audience: String? = null,
    ): io.appwrite.models.Oauth2Token {
        val apiPath = ("/oauth2/{project_id}/token"
            .replace("{project_id}", client.config["project"].orEmpty())
        )
        val apiParams = mutableMapOf<String, Any?>(
            "grant_type" to grantType,
            "code" to code,
            "refresh_token" to refreshToken,
            "device_code" to deviceCode,
            "client_id" to clientId,
            "client_secret" to clientSecret,
            "code_verifier" to codeVerifier,
            "redirect_uri" to redirectUri,
            "resource" to resource,
            "audience" to audience,
        )
        val apiHeaders = mutableMapOf<String, String>(
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
}
