package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.WebAuthComponent
import androidx.activity.ComponentActivity
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import java.io.File

class Account(client: Client) : Service(client) {

    /**
     * Get Account
     *
     * Get currently logged in user data as JSON object.
     *
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun get(): io.appwrite.models.User {
        val path = "/account"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Account
     *
     * Use this endpoint to allow a new user to register a new account in your
     * project. After the user registration completes successfully, you can use
     * the [/account/verfication](/docs/client/account#accountCreateVerification)
     * route to start verifying the user email address. To allow the new user to
     * login to their new account, you need to create a new [account
     * session](/docs/client/account#accountCreateSession).
     *
     * @param userId Unique Id. Choose your own unique ID or pass the string `unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password. Must be between 6 to 32 chars.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
		userId: String,
		email: String,
		password: String,
		name: String? = null
	): io.appwrite.models.User {
        val path = "/account"
        val params = mapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "name" to name
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            convert = convert
        )
    }
    
    /**
     * Delete Account
     *
     * Delete a currently logged in user account. Behind the scene, the user
     * record is not deleted but permanently blocked from any access. This is done
     * to avoid deleted accounts being overtaken by new users with the same email
     * address. Any user-related resources like documents or storage files should
     * be deleted separately.
     *
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun delete(): Any {
        val path = "/account"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Update Account Email
     *
     * Update currently logged in user account email address. After changing user
     * address, user confirmation status is being reset and a new confirmation
     * mail is sent. For security measures, user password is required to complete
     * this request.
     * This endpoint can also be used to convert an anonymous account to a normal
     * one, by passing an email address and a new password.
     *
     * @param email User email.
     * @param password User password. Must be between 6 to 32 chars.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateEmail(
		email: String,
		password: String
	): io.appwrite.models.User {
        val path = "/account/email"
        val params = mapOf<String, Any?>(
            "email" to email,
            "password" to password
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Account JWT
     *
     * Use this endpoint to create a JSON Web Token. You can use the resulting JWT
     * to authenticate on behalf of the current user when working with the
     * Appwrite server-side API and SDKs. The JWT secret is valid for 15 minutes
     * from its creation and will be invalid if the user will logout in that time
     * frame.
     *
     * @return [io.appwrite.models.Jwt]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createJWT(): io.appwrite.models.Jwt {
        val path = "/account/jwt"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Jwt = {
            io.appwrite.models.Jwt.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Jwt::class.java,
            convert = convert
        )
    }
    
    /**
     * Get Account Logs
     *
     * Get currently logged in user list of latest security activity logs. Each
     * log returns user IP address, location and date and time of log.
     *
     * @param limit Maximum number of logs to return in response.  Use this value to manage pagination. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this param to manage pagination.
     * @return [io.appwrite.models.LogList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getLogs(
		limit: Long? = null,
		offset: Long? = null
	): io.appwrite.models.LogList {
        val path = "/account/logs"
        val params = mapOf<String, Any?>(
            "limit" to limit,
            "offset" to offset
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.LogList = {
            io.appwrite.models.LogList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.LogList::class.java,
            convert = convert
        )
    }
    
    /**
     * Update Account Name
     *
     * Update currently logged in user account name.
     *
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateName(
		name: String
	): io.appwrite.models.User {
        val path = "/account/name"
        val params = mapOf<String, Any?>(
            "name" to name
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            convert = convert
        )
    }
    
    /**
     * Update Account Password
     *
     * Update currently logged in user password. For validation, user is required
     * to pass in the new password, and the old password. For users created with
     * OAuth and Team Invites, oldPassword is optional.
     *
     * @param password New user password. Must be between 6 to 32 chars.
     * @param oldPassword Old user password. Must be between 6 to 32 chars.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updatePassword(
		password: String,
		oldPassword: String? = null
	): io.appwrite.models.User {
        val path = "/account/password"
        val params = mapOf<String, Any?>(
            "password" to password,
            "oldPassword" to oldPassword
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            convert = convert
        )
    }
    
    /**
     * Get Account Preferences
     *
     * Get currently logged in user preferences as a key-value object.
     *
     * @return [io.appwrite.models.Preferences]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getPrefs(): io.appwrite.models.Preferences {
        val path = "/account/prefs"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Preferences = {
            io.appwrite.models.Preferences.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Preferences::class.java,
            convert = convert
        )
    }
    
    /**
     * Update Account Preferences
     *
     * Update currently logged in user account preferences. You can pass only the
     * specific settings you wish to update.
     *
     * @param prefs Prefs key-value JSON object.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updatePrefs(
		prefs: Any
	): io.appwrite.models.User {
        val path = "/account/prefs"
        val params = mapOf<String, Any?>(
            "prefs" to prefs
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Password Recovery
     *
     * Sends the user an email with a temporary secret key for password reset.
     * When the user clicks the confirmation link he is redirected back to your
     * app password reset URL with the secret key and email address values
     * attached to the URL query string. Use the query string params to submit a
     * request to the [PUT
     * /account/recovery](/docs/client/account#accountUpdateRecovery) endpoint to
     * complete the process. The verification link sent to the user's email
     * address is valid for 1 hour.
     *
     * @param email User email.
     * @param url URL to redirect the user back to your app from the recovery email. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @return [io.appwrite.models.Token]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRecovery(
		email: String,
		url: String
	): io.appwrite.models.Token {
        val path = "/account/recovery"
        val params = mapOf<String, Any?>(
            "email" to email,
            "url" to url
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Password Recovery (confirmation)
     *
     * Use this endpoint to complete the user account password reset. Both the
     * **userId** and **secret** arguments will be passed as query parameters to
     * the redirect URL you have provided when sending your request to the [POST
     * /account/recovery](/docs/client/account#accountCreateRecovery) endpoint.
     * 
     * Please note that in order to avoid a [Redirect
     * Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md)
     * the only valid redirect URLs are the ones from domains you have set when
     * adding your platforms in the console interface.
     *
     * @param userId User account UID address.
     * @param secret Valid reset token.
     * @param password New password. Must be between 6 to 32 chars.
     * @param passwordAgain New password again. Must be between 6 to 32 chars.
     * @return [io.appwrite.models.Token]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRecovery(
		userId: String,
		secret: String,
		password: String,
		passwordAgain: String
	): io.appwrite.models.Token {
        val path = "/account/recovery"
        val params = mapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
            "password" to password,
            "passwordAgain" to passwordAgain
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            convert = convert
        )
    }
    
    /**
     * Get Account Sessions
     *
     * Get currently logged in user list of active sessions across different
     * devices.
     *
     * @return [io.appwrite.models.SessionList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getSessions(): io.appwrite.models.SessionList {
        val path = "/account/sessions"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.SessionList = {
            io.appwrite.models.SessionList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.SessionList::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Account Session
     *
     * Allow the user to login into their account by providing a valid email and
     * password combination. This route will create a new session for the user.
     *
     * @param email User email.
     * @param password User password. Must be between 6 to 32 chars.
     * @return [io.appwrite.models.Session]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createSession(
		email: String,
		password: String
	): io.appwrite.models.Session {
        val path = "/account/sessions"
        val params = mapOf<String, Any?>(
            "email" to email,
            "password" to password
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Session = {
            io.appwrite.models.Session.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Session::class.java,
            convert = convert
        )
    }
    
    /**
     * Delete All Account Sessions
     *
     * Delete all sessions from the user account and remove any sessions cookies
     * from the end client.
     *
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteSessions(): Any {
        val path = "/account/sessions"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Create Anonymous Session
     *
     * Use this endpoint to allow a new user to register an anonymous account in
     * your project. This route will also create a new session for the user. To
     * allow the new user to convert an anonymous account to a normal account, you
     * need to update its [email and
     * password](/docs/client/account#accountUpdateEmail) or create an [OAuth2
     * session](/docs/client/account#accountCreateOAuth2Session).
     *
     * @return [io.appwrite.models.Session]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createAnonymousSession(): io.appwrite.models.Session {
        val path = "/account/sessions/anonymous"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Session = {
            io.appwrite.models.Session.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Session::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Magic URL session
     *
     * Sends the user an email with a secret key for creating a session. When the
     * user clicks the link in the email, the user is redirected back to the URL
     * you provided with the secret key and userId values attached to the URL
     * query string. Use the query string parameters to submit a request to the
     * [PUT
     * /account/sessions/magic-url](/docs/client/account#accountUpdateMagicURLSession)
     * endpoint to complete the login process. The link sent to the user's email
     * address is valid for 1 hour. If you are on a mobile device you can leave
     * the URL parameter empty, so that the login completion will be handled by
     * your Appwrite instance by default.
     *
     * @param userId Unique Id. Choose your own unique ID or pass the string `unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param url URL to redirect the user back to your app from the magic URL login. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @return [io.appwrite.models.Token]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createMagicURLSession(
		userId: String,
		email: String,
		url: String? = null
	): io.appwrite.models.Token {
        val path = "/account/sessions/magic-url"
        val params = mapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "url" to url
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Magic URL session (confirmation)
     *
     * Use this endpoint to complete creating the session with the Magic URL. Both
     * the **userId** and **secret** arguments will be passed as query parameters
     * to the redirect URL you have provided when sending your request to the
     * [POST
     * /account/sessions/magic-url](/docs/client/account#accountCreateMagicURLSession)
     * endpoint.
     * 
     * Please note that in order to avoid a [Redirect
     * Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md)
     * the only valid redirect URLs are the ones from domains you have set when
     * adding your platforms in the console interface.
     *
     * @param userId User unique ID.
     * @param secret Valid verification token.
     * @return [io.appwrite.models.Session]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateMagicURLSession(
		userId: String,
		secret: String
	): io.appwrite.models.Session {
        val path = "/account/sessions/magic-url"
        val params = mapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Session = {
            io.appwrite.models.Session.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Session::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Account Session with OAuth2
     *
     * Allow the user to login to their account using the OAuth2 provider of their
     * choice. Each OAuth2 provider should be enabled from the Appwrite console
     * first. Use the success and failure arguments to provide a redirect URL's
     * back to your app when login is completed.
     * 
     * If there is already an active session, the new session will be attached to
     * the logged-in account. If there are no active sessions, the server will
     * attempt to look for a user with the same email address as the email
     * received from the OAuth2 provider and attach the new session to the
     * existing user. If no matching user is found - the server will create a new
     * user..
     * 
     *
     * @param provider OAuth2 Provider. Currently, supported providers are: amazon, apple, bitbucket, bitly, box, discord, dropbox, facebook, github, gitlab, google, linkedin, microsoft, paypal, paypalSandbox, salesforce, slack, spotify, tradeshift, tradeshiftBox, twitch, vk, yahoo, yandex, wordpress.
     * @param success URL to redirect back to your app after a successful login attempt.  Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @param failure URL to redirect back to your app after a failed login attempt.  Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @param scopes A list of custom OAuth2 scopes. Check each provider internal docs for a list of supported scopes.
     *      
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createOAuth2Session(
		activity: ComponentActivity, 
		provider: String,
		success: String? = null,
		failure: String? = null,
		scopes: List<Any>? = null
	) {
        val path = "/account/sessions/oauth2/{provider}".replace("{provider}", provider)
        val params = mapOf<String, Any?>(
            "success" to success,
            "failure" to failure,
            "scopes" to scopes,
            "project" to client.config["project"]
        )
        val query = mutableListOf<String>()
        params.forEach {
            when (it.value) {
                null -> {
                    return@forEach
                }
                is List<*> -> {
                    query.add("${it.key}[]=${it.value.toString()}")
                }
                else -> {
                   query.add("${it.key}=${it.value.toString()}")
                }
            }
        }

        val url = Uri.parse("${client.endPoint}${path}?${query.joinToString("&")}")
        val callbackUrlScheme = "appwrite-callback-${client.config["project"]}"

        WebAuthComponent.authenticate(activity, url, callbackUrlScheme) {
            if (it.isFailure) {
                throw it.exceptionOrNull()!!
            }

            val resultUrl = it.getOrNull()!!
            val uri = Uri.parse(resultUrl)
            val key = uri.getQueryParameter("key")
            val secret = uri.getQueryParameter("secret")
            if (key == null || secret == null) {
                throw AppwriteException("Authentication cookie missing!")
            }
            val cookie = Cookie.Builder()
                .name(key)
                .value(secret)
                .domain(Uri.parse(client.endPoint).host!!)
                .httpOnly()
                .build()
            
            client.http.cookieJar.saveFromResponse(
                client.endPoint.toHttpUrl(),
                listOf(cookie)
            )
        }
    }
    
    /**
     * Get Session By ID
     *
     * Use this endpoint to get a logged in user's session using a Session ID.
     * Inputting 'current' will return the current session being used.
     *
     * @param sessionId Session unique ID. Use the string &#039;current&#039; to get the current device session.
     * @return [io.appwrite.models.Session]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getSession(
		sessionId: String
	): io.appwrite.models.Session {
        val path = "/account/sessions/{sessionId}".replace("{sessionId}", sessionId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Session = {
            io.appwrite.models.Session.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Session::class.java,
            convert = convert
        )
    }
    
    /**
     * Delete Account Session
     *
     * Use this endpoint to log out the currently logged in user from all their
     * account sessions across all of their different devices. When using the
     * option id argument, only the session unique ID provider will be deleted.
     *
     * @param sessionId Session unique ID. Use the string &#039;current&#039; to delete the current device session.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteSession(
		sessionId: String
	): Any {
        val path = "/account/sessions/{sessionId}".replace("{sessionId}", sessionId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Create Email Verification
     *
     * Use this endpoint to send a verification message to your user email address
     * to confirm they are the valid owners of that address. Both the **userId**
     * and **secret** arguments will be passed as query parameters to the URL you
     * have provided to be attached to the verification email. The provided URL
     * should redirect the user back to your app and allow you to complete the
     * verification process by verifying both the **userId** and **secret**
     * parameters. Learn more about how to [complete the verification
     * process](/docs/client/account#accountUpdateVerification). The verification
     * link sent to the user's email address is valid for 7 days.
     * 
     * Please note that in order to avoid a [Redirect
     * Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md),
     * the only valid redirect URLs are the ones from domains you have set when
     * adding your platforms in the console interface.
     * 
     *
     * @param url URL to redirect the user back to your app from the verification email. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @return [io.appwrite.models.Token]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createVerification(
		url: String
	): io.appwrite.models.Token {
        val path = "/account/verification"
        val params = mapOf<String, Any?>(
            "url" to url
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Email Verification (confirmation)
     *
     * Use this endpoint to complete the user email verification process. Use both
     * the **userId** and **secret** parameters that were attached to your app URL
     * to verify the user email ownership. If confirmed this route will return a
     * 200 status code.
     *
     * @param userId User unique ID.
     * @param secret Valid verification token.
     * @return [io.appwrite.models.Token]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateVerification(
		userId: String,
		secret: String
	): io.appwrite.models.Token {
        val path = "/account/verification"
        val params = mapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            convert = convert
        )
    }
    
}