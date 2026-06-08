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
class Oauth2(client: Client) : Service(client) {

    /**
     * Approve an OAuth2 grant after the user gives consent. Returns the `redirectUrl` the end user should be sent to. The consent screen may optionally pass enriched `authorization_details` to record the concrete resources the user selected. You can pass Accept header of `application/json` to receive a JSON response instead of a redirect.
     *
     * @param projectId Project ID in which OAuth2 client that created grant during authorization exists.
     * @param grantId Grant ID made during authorization, provided to consent screen in URL search params.
     * @param authorizationDetails Enriched `authorization_details` the user consented to, replacing what the client requested. Each entry must use a `type` the project accepts. Optional; omit to keep the originally requested details.
     * @return [io.appwrite.models.Oauth2Approve]
     */
    @JvmOverloads
    suspend fun approve(
        projectId: String,
        grantId: String,
        authorizationDetails: String? = null,
    ): io.appwrite.models.Oauth2Approve {
        val apiPath = "/oauth2/{project_id}/approve"
            .replace("{project_id}", projectId)
            + "?project=${java.net.URLEncoder.encode(client.config["project"].orEmpty(), "UTF-8")}"

        val apiParams = mutableMapOf<String, Any?>(
            "grant_id" to grantId,
            "authorization_details" to authorizationDetails,
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
     * @param projectId Project ID in which OAuth2 client exists.
     * @param clientId OAuth2 client ID.
     * @param redirectUri Redirect URI where visitor will be redirected after authorization, whether successful or not.
     * @param responseType OAuth2 / OIDC response type. One of `code` (Authorization Code Flow), `id_token` (Implicit Flow, OIDC login only), or `code id_token` (Hybrid Flow).
     * @param scope Space-separated OAuth2 scopes. Can include project scopes, and built-in scopes: `openid`, `email`, `profile`.
     * @param state OAuth2 state. You receive this back in the redirect URI.
     * @param nonce OIDC nonce parameter to prevent replay attacks. Required when response_type includes `id_token`.
     * @param codeChallenge PKCE code challenge. Required when OAuth2 app is public.
     * @param codeChallengeMethod PKCE code challenge method. Required when OAuth2 app is public.
     * @param prompt OIDC prompt parameter for customization of consent screen. Space-separated list of: none, login, consent, select_account.
     * @param maxAge OIDC max_age paraleter for customization of consent screen. Maximum allowable elapsed time in seconds since the user last authenticated. If exceeded, re-authentication is required.
     * @param authorizationDetails Rich authorization request. JSON array of objects, each with a `type` and project-defined fields
     * @return [io.appwrite.models.Oauth2Authorize]
     */
    @JvmOverloads
    suspend fun authorize(
        projectId: String,
        clientId: String,
        redirectUri: String,
        responseType: String,
        scope: String,
        state: String? = null,
        nonce: String? = null,
        codeChallenge: String? = null,
        codeChallengeMethod: String? = null,
        prompt: String? = null,
        maxAge: Long? = null,
        authorizationDetails: String? = null,
    ): io.appwrite.models.Oauth2Authorize {
        val apiPath = "/oauth2/{project_id}/authorize"
            .replace("{project_id}", projectId)
            + "?project=${java.net.URLEncoder.encode(client.config["project"].orEmpty(), "UTF-8")}"

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
     * Exchange a device flow user code for an OAuth2 grant. The authenticated user is bound to the pending grant. Pass the returned grant ID to the get grant endpoint to render the consent screen, then to the approve or reject endpoint to complete the flow.
     *
     * @param projectId Project ID in which OAuth2 client exists.
     * @param userCode User code displayed on the device.
     * @return [io.appwrite.models.Oauth2Grant]
     */
    suspend fun createGrant(
        projectId: String,
        userCode: String,
    ): io.appwrite.models.Oauth2Grant {
        val apiPath = "/oauth2/{project_id}/grants"
            .replace("{project_id}", projectId)

        val apiParams = mutableMapOf<String, Any?>(
            "user_code" to userCode,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
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
     * @param projectId Project ID in which OAuth2 client that created grant during authorization exists.
     * @param grantId Grant ID made during authorization, provided to consent screen in URL search params.
     * @return [io.appwrite.models.Oauth2Grant]
     */
    suspend fun getGrant(
        projectId: String,
        grantId: String,
    ): io.appwrite.models.Oauth2Grant {
        val apiPath = "/oauth2/{project_id}/grants/{grant_id}"
            .replace("{project_id}", projectId)
            .replace("{grant_id}", grantId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
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
     * Reject an OAuth2 grant when the user denies consent. Returns the `redirectUrl` the end user should be sent to with an `access_denied` error. You can pass Accept header of `application/json` to receive a JSON response instead of a redirect.
     *
     * @param projectId Project ID in which OAuth2 client that created grant during authorization exists.
     * @param grantId Grant ID made during authorization, provided to consent screen in URL search params.
     * @return [io.appwrite.models.Oauth2Reject]
     */
    suspend fun reject(
        projectId: String,
        grantId: String,
    ): io.appwrite.models.Oauth2Reject {
        val apiPath = "/oauth2/{project_id}/reject"
            .replace("{project_id}", projectId)
            + "?project=${java.net.URLEncoder.encode(client.config["project"].orEmpty(), "UTF-8")}"

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


}
