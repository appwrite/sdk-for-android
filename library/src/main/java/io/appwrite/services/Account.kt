package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import io.appwrite.WebAuthComponent
import androidx.activity.ComponentActivity
import okhttp3.Cookie
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import java.io.File

/**
 * The Account service allows you to authenticate and manage a user account.
**/
class Account : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * Get Account
     *
     * Get currently logged in user data as JSON object.
     *
     * @return [io.appwrite.models.Account<T>]
     */
    suspend fun <T> get(
        nestedType: Class<T>,
    ): io.appwrite.models.Account<T> {
        val path = "/account"

        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Account<T> = {
            io.appwrite.models.Account.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Get Account
     *
     * Get currently logged in user data as JSON object.
     *
     * @return [io.appwrite.models.Account<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
    ) = get(
        nestedType = classOf(),
    )

    /**
     * Create Account
     *
     * Use this endpoint to allow a new user to register a new account in your project. After the user registration completes successfully, you can use the [/account/verfication](/docs/client/account#accountCreateVerification) route to start verifying the user email address. To allow the new user to login to their new account, you need to create a new [account session](/docs/client/account#accountCreateSession).
     *
     * @param userId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password. Must be at least 8 chars.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.Account<T>]
     */
    @JvmOverloads
    suspend fun <T> create(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Account<T> {
        val path = "/account"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "name" to name,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Account<T> = {
            io.appwrite.models.Account.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create Account
     *
     * Use this endpoint to allow a new user to register a new account in your project. After the user registration completes successfully, you can use the [/account/verfication](/docs/client/account#accountCreateVerification) route to start verifying the user email address. To allow the new user to login to their new account, you need to create a new [account session](/docs/client/account#accountCreateSession).
     *
     * @param userId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password. Must be at least 8 chars.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.Account<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
    ) = create(
        userId,
        email,
        password,
        name,
        nestedType = classOf(),
    )

    /**
     * Update Email
     *
     * Update currently logged in user account email address. After changing user address, the user confirmation status will get reset. A new confirmation email is not sent automatically however you can use the send confirmation email endpoint again to send the confirmation email. For security measures, user password is required to complete this request.This endpoint can also be used to convert an anonymous account to a normal one, by passing an email address and a new password.
     *
     * @param email User email.
     * @param password User password. Must be at least 8 chars.
     * @return [io.appwrite.models.Account<T>]
     */
    suspend fun <T> updateEmail(
        email: String,
        password: String,
        nestedType: Class<T>,
    ): io.appwrite.models.Account<T> {
        val path = "/account/email"

        val params = mutableMapOf<String, Any?>(
            "email" to email,
            "password" to password,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Account<T> = {
            io.appwrite.models.Account.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update Email
     *
     * Update currently logged in user account email address. After changing user address, the user confirmation status will get reset. A new confirmation email is not sent automatically however you can use the send confirmation email endpoint again to send the confirmation email. For security measures, user password is required to complete this request.This endpoint can also be used to convert an anonymous account to a normal one, by passing an email address and a new password.
     *
     * @param email User email.
     * @param password User password. Must be at least 8 chars.
     * @return [io.appwrite.models.Account<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateEmail(
        email: String,
        password: String,
    ) = updateEmail(
        email,
        password,
        nestedType = classOf(),
    )

    /**
     * Create JWT
     *
     * Use this endpoint to create a JSON Web Token. You can use the resulting JWT to authenticate on behalf of the current user when working with the Appwrite server-side API and SDKs. The JWT secret is valid for 15 minutes from its creation and will be invalid if the user will logout in that time frame.
     *
     * @return [io.appwrite.models.Jwt]
     */
    suspend fun createJWT(
    ): io.appwrite.models.Jwt {
        val path = "/account/jwt"

        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Jwt = {
            io.appwrite.models.Jwt.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Jwt::class.java,
            converter,
        )
    }


    /**
     * List Logs
     *
     * Get currently logged in user list of latest security activity logs. Each log returns user IP address, location and date and time of log.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Only supported methods are limit and offset
     * @return [io.appwrite.models.LogList]
     */
    @JvmOverloads
    suspend fun listLogs(
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val path = "/account/logs"

        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.LogList = {
            io.appwrite.models.LogList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.LogList::class.java,
            converter,
        )
    }


    /**
     * Update Name
     *
     * Update currently logged in user account name.
     *
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.Account<T>]
     */
    suspend fun <T> updateName(
        name: String,
        nestedType: Class<T>,
    ): io.appwrite.models.Account<T> {
        val path = "/account/name"

        val params = mutableMapOf<String, Any?>(
            "name" to name,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Account<T> = {
            io.appwrite.models.Account.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update Name
     *
     * Update currently logged in user account name.
     *
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.Account<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateName(
        name: String,
    ) = updateName(
        name,
        nestedType = classOf(),
    )

    /**
     * Update Password
     *
     * Update currently logged in user password. For validation, user is required to pass in the new password, and the old password. For users created with OAuth, Team Invites and Magic URL, oldPassword is optional.
     *
     * @param password New user password. Must be at least 8 chars.
     * @param oldPassword Current user password. Must be at least 8 chars.
     * @return [io.appwrite.models.Account<T>]
     */
    @JvmOverloads
    suspend fun <T> updatePassword(
        password: String,
        oldPassword: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Account<T> {
        val path = "/account/password"

        val params = mutableMapOf<String, Any?>(
            "password" to password,
            "oldPassword" to oldPassword,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Account<T> = {
            io.appwrite.models.Account.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update Password
     *
     * Update currently logged in user password. For validation, user is required to pass in the new password, and the old password. For users created with OAuth, Team Invites and Magic URL, oldPassword is optional.
     *
     * @param password New user password. Must be at least 8 chars.
     * @param oldPassword Current user password. Must be at least 8 chars.
     * @return [io.appwrite.models.Account<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updatePassword(
        password: String,
        oldPassword: String? = null,
    ) = updatePassword(
        password,
        oldPassword,
        nestedType = classOf(),
    )

    /**
     * Update Phone
     *
     * Update the currently logged in user&#039;s phone number. After updating the phone number, the phone verification status will be reset. A confirmation SMS is not sent automatically, however you can use the [POST /account/verification/phone](/docs/client/account#accountCreatePhoneVerification) endpoint to send a confirmation SMS.
     *
     * @param phone Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param password User password. Must be at least 8 chars.
     * @return [io.appwrite.models.Account<T>]
     */
    suspend fun <T> updatePhone(
        phone: String,
        password: String,
        nestedType: Class<T>,
    ): io.appwrite.models.Account<T> {
        val path = "/account/phone"

        val params = mutableMapOf<String, Any?>(
            "phone" to phone,
            "password" to password,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Account<T> = {
            io.appwrite.models.Account.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update Phone
     *
     * Update the currently logged in user&#039;s phone number. After updating the phone number, the phone verification status will be reset. A confirmation SMS is not sent automatically, however you can use the [POST /account/verification/phone](/docs/client/account#accountCreatePhoneVerification) endpoint to send a confirmation SMS.
     *
     * @param phone Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param password User password. Must be at least 8 chars.
     * @return [io.appwrite.models.Account<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updatePhone(
        phone: String,
        password: String,
    ) = updatePhone(
        phone,
        password,
        nestedType = classOf(),
    )

    /**
     * Get Account Preferences
     *
     * Get currently logged in user preferences as a key-value object.
     *
     * @return [io.appwrite.models.Preferences<T>]
     */
    suspend fun <T> getPrefs(
        nestedType: Class<T>,
    ): io.appwrite.models.Preferences<T> {
        val path = "/account/prefs"

        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Preferences<T> = {
            io.appwrite.models.Preferences.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Get Account Preferences
     *
     * Get currently logged in user preferences as a key-value object.
     *
     * @return [io.appwrite.models.Preferences<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun getPrefs(
    ) = getPrefs(
        nestedType = classOf(),
    )

    /**
     * Update Preferences
     *
     * Update currently logged in user account preferences. The object you pass is stored as is, and replaces any previous value. The maximum allowed prefs size is 64kB and throws error if exceeded.
     *
     * @param prefs Prefs key-value JSON object.
     * @return [io.appwrite.models.Account<T>]
     */
    suspend fun <T> updatePrefs(
        prefs: Any,
        nestedType: Class<T>,
    ): io.appwrite.models.Account<T> {
        val path = "/account/prefs"

        val params = mutableMapOf<String, Any?>(
            "prefs" to prefs,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Account<T> = {
            io.appwrite.models.Account.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update Preferences
     *
     * Update currently logged in user account preferences. The object you pass is stored as is, and replaces any previous value. The maximum allowed prefs size is 64kB and throws error if exceeded.
     *
     * @param prefs Prefs key-value JSON object.
     * @return [io.appwrite.models.Account<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updatePrefs(
        prefs: Any,
    ) = updatePrefs(
        prefs,
        nestedType = classOf(),
    )

    /**
     * Create Password Recovery
     *
     * Sends the user an email with a temporary secret key for password reset. When the user clicks the confirmation link he is redirected back to your app password reset URL with the secret key and email address values attached to the URL query string. Use the query string params to submit a request to the [PUT /account/recovery](/docs/client/account#accountUpdateRecovery) endpoint to complete the process. The verification link sent to the user&#039;s email address is valid for 1 hour.
     *
     * @param email User email.
     * @param url URL to redirect the user back to your app from the recovery email. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @return [io.appwrite.models.Token]
     */
    suspend fun createRecovery(
        email: String,
        url: String,
    ): io.appwrite.models.Token {
        val path = "/account/recovery"

        val params = mutableMapOf<String, Any?>(
            "email" to email,
            "url" to url,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * Create Password Recovery (confirmation)
     *
     * Use this endpoint to complete the user account password reset. Both the **userId** and **secret** arguments will be passed as query parameters to the redirect URL you have provided when sending your request to the [POST /account/recovery](/docs/client/account#accountCreateRecovery) endpoint.Please note that in order to avoid a [Redirect Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md) the only valid redirect URLs are the ones from domains you have set when adding your platforms in the console interface.
     *
     * @param userId User ID.
     * @param secret Valid reset token.
     * @param password New user password. Must be at least 8 chars.
     * @param passwordAgain Repeat new user password. Must be at least 8 chars.
     * @return [io.appwrite.models.Token]
     */
    suspend fun updateRecovery(
        userId: String,
        secret: String,
        password: String,
        passwordAgain: String,
    ): io.appwrite.models.Token {
        val path = "/account/recovery"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
            "password" to password,
            "passwordAgain" to passwordAgain,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * List Sessions
     *
     * Get currently logged in user list of active sessions across different devices.
     *
     * @return [io.appwrite.models.SessionList]
     */
    suspend fun listSessions(
    ): io.appwrite.models.SessionList {
        val path = "/account/sessions"

        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.SessionList = {
            io.appwrite.models.SessionList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.SessionList::class.java,
            converter,
        )
    }


    /**
     * Delete Sessions
     *
     * Delete all sessions from the user account and remove any sessions cookies from the end client.
     *
     * @return [Any]
     */
    suspend fun deleteSessions(
    ): Any {
        val path = "/account/sessions"

        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
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
     * Use this endpoint to allow a new user to register an anonymous account in your project. This route will also create a new session for the user. To allow the new user to convert an anonymous account to a normal account, you need to update its [email and password](/docs/client/account#accountUpdateEmail) or create an [OAuth2 session](/docs/client/account#accountCreateOAuth2Session).
     *
     * @return [io.appwrite.models.Session]
     */
    suspend fun createAnonymousSession(
    ): io.appwrite.models.Session {
        val path = "/account/sessions/anonymous"

        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Create Email Session
     *
     * Allow the user to login into their account by providing a valid email and password combination. This route will create a new session for the user.A user is limited to 10 active sessions at a time by default. [Learn more about session limits](/docs/authentication#limits).
     *
     * @param email User email.
     * @param password User password. Must be at least 8 chars.
     * @return [io.appwrite.models.Session]
     */
    suspend fun createEmailSession(
        email: String,
        password: String,
    ): io.appwrite.models.Session {
        val path = "/account/sessions/email"

        val params = mutableMapOf<String, Any?>(
            "email" to email,
            "password" to password,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Create Magic URL session
     *
     * Sends the user an email with a secret key for creating a session. If the provided user ID has not be registered, a new user will be created. When the user clicks the link in the email, the user is redirected back to the URL you provided with the secret key and userId values attached to the URL query string. Use the query string parameters to submit a request to the [PUT /account/sessions/magic-url](/docs/client/account#accountUpdateMagicURLSession) endpoint to complete the login process. The link sent to the user&#039;s email address is valid for 1 hour. If you are on a mobile device you can leave the URL parameter empty, so that the login completion will be handled by your Appwrite instance by default.A user is limited to 10 active sessions at a time by default. [Learn more about session limits](/docs/authentication#limits).
     *
     * @param userId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param url URL to redirect the user back to your app from the magic URL login. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @return [io.appwrite.models.Token]
     */
    @JvmOverloads
    suspend fun createMagicURLSession(
        userId: String,
        email: String,
        url: String? = null,
    ): io.appwrite.models.Token {
        val path = "/account/sessions/magic-url"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "url" to url,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * Create Magic URL session (confirmation)
     *
     * Use this endpoint to complete creating the session with the Magic URL. Both the **userId** and **secret** arguments will be passed as query parameters to the redirect URL you have provided when sending your request to the [POST /account/sessions/magic-url](/docs/client/account#accountCreateMagicURLSession) endpoint.Please note that in order to avoid a [Redirect Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md) the only valid redirect URLs are the ones from domains you have set when adding your platforms in the console interface.
     *
     * @param userId User ID.
     * @param secret Valid verification token.
     * @return [io.appwrite.models.Session]
     */
    suspend fun updateMagicURLSession(
        userId: String,
        secret: String,
    ): io.appwrite.models.Session {
        val path = "/account/sessions/magic-url"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Create OAuth2 Session
     *
     * Allow the user to login to their account using the OAuth2 provider of their choice. Each OAuth2 provider should be enabled from the Appwrite console first. Use the success and failure arguments to provide a redirect URL&#039;s back to your app when login is completed.If there is already an active session, the new session will be attached to the logged-in account. If there are no active sessions, the server will attempt to look for a user with the same email address as the email received from the OAuth2 provider and attach the new session to the existing user. If no matching user is found - the server will create a new user.A user is limited to 10 active sessions at a time by default. [Learn more about session limits](/docs/authentication#limits).
     *
     * @param provider OAuth2 Provider. Currently, supported providers are: amazon, apple, auth0, authentik, autodesk, bitbucket, bitly, box, dailymotion, discord, disqus, dropbox, etsy, facebook, github, gitlab, google, linkedin, microsoft, notion, okta, paypal, paypalSandbox, podio, salesforce, slack, spotify, stripe, tradeshift, tradeshiftBox, twitch, wordpress, yahoo, yammer, yandex, zoom.
     * @param success URL to redirect back to your app after a successful login attempt.  Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @param failure URL to redirect back to your app after a failed login attempt.  Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @param scopes A list of custom OAuth2 scopes. Check each provider internal docs for a list of supported scopes. Maximum of 100 scopes are allowed, each 4096 characters long.
     */
    @JvmOverloads
    suspend fun createOAuth2Session(
        activity: ComponentActivity,
        provider: String,
        success: String? = null,
        failure: String? = null,
        scopes: List<String>? = null,
    ) {
        val path = "/account/sessions/oauth2/{provider}"
            .replace("{provider}", provider)

        val params = mutableMapOf<String, Any?>(
            "success" to success,
            "failure" to failure,
            "scopes" to scopes,
            "project" to client.config["project"],
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
     * Create Phone session
     *
     * Sends the user an SMS with a secret key for creating a session. If the provided user ID has not be registered, a new user will be created. Use the returned user ID and secret and submit a request to the [PUT /account/sessions/phone](/docs/client/account#accountUpdatePhoneSession) endpoint to complete the login process. The secret sent to the user&#039;s phone is valid for 15 minutes.A user is limited to 10 active sessions at a time by default. [Learn more about session limits](/docs/authentication#limits).
     *
     * @param userId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param phone Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @return [io.appwrite.models.Token]
     */
    suspend fun createPhoneSession(
        userId: String,
        phone: String,
    ): io.appwrite.models.Token {
        val path = "/account/sessions/phone"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "phone" to phone,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * Create Phone Session (confirmation)
     *
     * Use this endpoint to complete creating a session with SMS. Use the **userId** from the [createPhoneSession](/docs/client/account#accountCreatePhoneSession) endpoint and the **secret** received via SMS to successfully update and confirm the phone session.
     *
     * @param userId User ID.
     * @param secret Valid verification token.
     * @return [io.appwrite.models.Session]
     */
    suspend fun updatePhoneSession(
        userId: String,
        secret: String,
    ): io.appwrite.models.Session {
        val path = "/account/sessions/phone"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Get Session
     *
     * Use this endpoint to get a logged in user&#039;s session using a Session ID. Inputting &#039;current&#039; will return the current session being used.
     *
     * @param sessionId Session ID. Use the string 'current' to get the current device session.
     * @return [io.appwrite.models.Session]
     */
    suspend fun getSession(
        sessionId: String,
    ): io.appwrite.models.Session {
        val path = "/account/sessions/{sessionId}"
            .replace("{sessionId}", sessionId)

        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Update OAuth Session (Refresh Tokens)
     *
     * Access tokens have limited lifespan and expire to mitigate security risks. If session was created using an OAuth provider, this route can be used to &quot;refresh&quot; the access token.
     *
     * @param sessionId Session ID. Use the string 'current' to update the current device session.
     * @return [io.appwrite.models.Session]
     */
    suspend fun updateSession(
        sessionId: String,
    ): io.appwrite.models.Session {
        val path = "/account/sessions/{sessionId}"
            .replace("{sessionId}", sessionId)

        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Delete Session
     *
     * Use this endpoint to log out the currently logged in user from all their account sessions across all of their different devices. When using the Session ID argument, only the unique session ID provided is deleted.
     *
     * @param sessionId Session ID. Use the string 'current' to delete the current device session.
     * @return [Any]
     */
    suspend fun deleteSession(
        sessionId: String,
    ): Any {
        val path = "/account/sessions/{sessionId}"
            .replace("{sessionId}", sessionId)

        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
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
     * Update Status
     *
     * Block the currently logged in user account. Behind the scene, the user record is not deleted but permanently blocked from any access. To completely delete a user, use the Users API instead.
     *
     * @return [io.appwrite.models.Account<T>]
     */
    suspend fun <T> updateStatus(
        nestedType: Class<T>,
    ): io.appwrite.models.Account<T> {
        val path = "/account/status"

        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Account<T> = {
            io.appwrite.models.Account.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update Status
     *
     * Block the currently logged in user account. Behind the scene, the user record is not deleted but permanently blocked from any access. To completely delete a user, use the Users API instead.
     *
     * @return [io.appwrite.models.Account<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateStatus(
    ) = updateStatus(
        nestedType = classOf(),
    )

    /**
     * Create Email Verification
     *
     * Use this endpoint to send a verification message to your user email address to confirm they are the valid owners of that address. Both the **userId** and **secret** arguments will be passed as query parameters to the URL you have provided to be attached to the verification email. The provided URL should redirect the user back to your app and allow you to complete the verification process by verifying both the **userId** and **secret** parameters. Learn more about how to [complete the verification process](/docs/client/account#accountUpdateEmailVerification). The verification link sent to the user&#039;s email address is valid for 7 days.Please note that in order to avoid a [Redirect Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md), the only valid redirect URLs are the ones from domains you have set when adding your platforms in the console interface.
     *
     * @param url URL to redirect the user back to your app from the verification email. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @return [io.appwrite.models.Token]
     */
    suspend fun createVerification(
        url: String,
    ): io.appwrite.models.Token {
        val path = "/account/verification"

        val params = mutableMapOf<String, Any?>(
            "url" to url,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * Create Email Verification (confirmation)
     *
     * Use this endpoint to complete the user email verification process. Use both the **userId** and **secret** parameters that were attached to your app URL to verify the user email ownership. If confirmed this route will return a 200 status code.
     *
     * @param userId User ID.
     * @param secret Valid verification token.
     * @return [io.appwrite.models.Token]
     */
    suspend fun updateVerification(
        userId: String,
        secret: String,
    ): io.appwrite.models.Token {
        val path = "/account/verification"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * Create Phone Verification
     *
     * Use this endpoint to send a verification SMS to the currently logged in user. This endpoint is meant for use after updating a user&#039;s phone number using the [accountUpdatePhone](/docs/client/account#accountUpdatePhone) endpoint. Learn more about how to [complete the verification process](/docs/client/account#accountUpdatePhoneVerification). The verification code sent to the user&#039;s phone number is valid for 15 minutes.
     *
     * @return [io.appwrite.models.Token]
     */
    suspend fun createPhoneVerification(
    ): io.appwrite.models.Token {
        val path = "/account/verification/phone"

        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * Create Phone Verification (confirmation)
     *
     * Use this endpoint to complete the user phone verification process. Use the **userId** and **secret** that were sent to your user&#039;s phone number to verify the user email ownership. If confirmed this route will return a 200 status code.
     *
     * @param userId User ID.
     * @param secret Valid verification token.
     * @return [io.appwrite.models.Token]
     */
    suspend fun updatePhoneVerification(
        userId: String,
        secret: String,
    ): io.appwrite.models.Token {
        val path = "/account/verification/phone"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


}