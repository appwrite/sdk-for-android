package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.models.*
import io.appwrite.enums.*
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
class Account(client: Client) : Service(client) {

    /**
     * Get the currently logged in user.
     *
     * @return [io.appwrite.models.User<T>]
     */
    suspend fun <T> get(
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Get the currently logged in user.
     *
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
    ): io.appwrite.models.User<Map<String, Any>> = get(
        nestedType = classOf(),
    )

    /**
     * Use this endpoint to allow a new user to register a new account in your project. After the user registration completes successfully, you can use the [/account/verfication](https://appwrite.io/docs/references/cloud/client-web/account#createVerification) route to start verifying the user email address. To allow the new user to login to their new account, you need to create a new [account session](https://appwrite.io/docs/references/cloud/client-web/account#createEmailSession).
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password New user password. Must be between 8 and 256 chars.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    suspend fun <T> create(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Use this endpoint to allow a new user to register a new account in your project. After the user registration completes successfully, you can use the [/account/verfication](https://appwrite.io/docs/references/cloud/client-web/account#createVerification) route to start verifying the user email address. To allow the new user to login to their new account, you need to create a new [account session](https://appwrite.io/docs/references/cloud/client-web/account#createEmailSession).
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password New user password. Must be between 8 and 256 chars.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
    ): io.appwrite.models.User<Map<String, Any>> = create(
        userId,
        email,
        password,
        name,
        nestedType = classOf(),
    )

    /**
     * Update currently logged in user account email address. After changing user address, the user confirmation status will get reset. A new confirmation email is not sent automatically however you can use the send confirmation email endpoint again to send the confirmation email. For security measures, user password is required to complete this request.
    * This endpoint can also be used to convert an anonymous account to a normal one, by passing an email address and a new password.
    * 
     *
     * @param email User email.
     * @param password User password. Must be at least 8 chars.
     * @return [io.appwrite.models.User<T>]
     */
    suspend fun <T> updateEmail(
        email: String,
        password: String,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/email"

        val apiParams = mutableMapOf<String, Any?>(
            "email" to email,
            "password" to password,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update currently logged in user account email address. After changing user address, the user confirmation status will get reset. A new confirmation email is not sent automatically however you can use the send confirmation email endpoint again to send the confirmation email. For security measures, user password is required to complete this request.This endpoint can also be used to convert an anonymous account to a normal one, by passing an email address and a new password.
     *
     * @param email User email.
     * @param password User password. Must be at least 8 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateEmail(
        email: String,
        password: String,
    ): io.appwrite.models.User<Map<String, Any>> = updateEmail(
        email,
        password,
        nestedType = classOf(),
    )

    /**
     * Get the list of identities for the currently logged in user.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: userId, provider, providerUid, providerEmail, providerAccessTokenExpiry
     * @return [io.appwrite.models.IdentityList]
     */
    @JvmOverloads
    suspend fun listIdentities(
        queries: List<String>? = null,
    ): io.appwrite.models.IdentityList {
        val apiPath = "/account/identities"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.IdentityList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.IdentityList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.IdentityList::class.java,
            converter,
        )
    }


    /**
     * Delete an identity by its unique ID.
     *
     * @param identityId Identity ID.
     * @return [Any]
     */
    suspend fun deleteIdentity(
        identityId: String,
    ): Any {
        val apiPath = "/account/identities/{identityId}"
            .replace("{identityId}", identityId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
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
     * Use this endpoint to create a JSON Web Token. You can use the resulting JWT to authenticate on behalf of the current user when working with the Appwrite server-side API and SDKs. The JWT secret is valid for 15 minutes from its creation and will be invalid if the user will logout in that time frame.
     *
     * @return [io.appwrite.models.Jwt]
     */
    suspend fun createJWT(
    ): io.appwrite.models.Jwt {
        val apiPath = "/account/jwts"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Jwt = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Jwt.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Jwt::class.java,
            converter,
        )
    }


    /**
     * Get the list of latest security activity logs for the currently logged in user. Each log returns user IP address, location and date and time of log.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @return [io.appwrite.models.LogList]
     */
    @JvmOverloads
    suspend fun listLogs(
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/account/logs"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.LogList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.LogList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.LogList::class.java,
            converter,
        )
    }


    /**
     * Enable or disable MFA on an account.
     *
     * @param mfa Enable or disable MFA.
     * @return [io.appwrite.models.User<T>]
     */
    suspend fun <T> updateMFA(
        mfa: Boolean,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/mfa"

        val apiParams = mutableMapOf<String, Any?>(
            "mfa" to mfa,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Enable or disable MFA on an account.
     *
     * @param mfa Enable or disable MFA.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateMFA(
        mfa: Boolean,
    ): io.appwrite.models.User<Map<String, Any>> = updateMFA(
        mfa,
        nestedType = classOf(),
    )

    /**
     * Add an authenticator app to be used as an MFA factor. Verify the authenticator using the [verify authenticator](/docs/references/cloud/client-web/account#updateMfaAuthenticator) method.
     *
     * @param type Type of authenticator. Must be `totp`
     * @return [io.appwrite.models.MfaType]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `CreateMFAAuthenticator` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.CreateMFAAuthenticator"),
        since = "1.8.0"
    )
    suspend fun createMfaAuthenticator(
        type: io.appwrite.enums.AuthenticatorType,
    ): io.appwrite.models.MfaType {
        val apiPath = "/account/mfa/authenticators/{type}"
            .replace("{type}", type.value)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MfaType = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.MfaType.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaType::class.java,
            converter,
        )
    }


    /**
     * Add an authenticator app to be used as an MFA factor. Verify the authenticator using the [verify authenticator](/docs/references/cloud/client-web/account#updateMfaAuthenticator) method.
     *
     * @param type Type of authenticator. Must be `totp`
     * @return [io.appwrite.models.MfaType]
     */
    suspend fun createMFAAuthenticator(
        type: io.appwrite.enums.AuthenticatorType,
    ): io.appwrite.models.MfaType {
        val apiPath = "/account/mfa/authenticators/{type}"
            .replace("{type}", type.value)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MfaType = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.MfaType.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaType::class.java,
            converter,
        )
    }


    /**
     * Verify an authenticator app after adding it using the [add authenticator](/docs/references/cloud/client-web/account#createMfaAuthenticator) method.
     *
     * @param type Type of authenticator.
     * @param otp Valid verification token.
     * @return [io.appwrite.models.User<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `UpdateMFAAuthenticator` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.UpdateMFAAuthenticator"),
        since = "1.8.0"
    )
    suspend fun <T> updateMfaAuthenticator(
        type: io.appwrite.enums.AuthenticatorType,
        otp: String,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/mfa/authenticators/{type}"
            .replace("{type}", type.value)

        val apiParams = mutableMapOf<String, Any?>(
            "otp" to otp,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Verify an authenticator app after adding it using the [add authenticator](/docs/references/cloud/client-web/account#createMfaAuthenticator) method.
     *
     * @param type Type of authenticator.
     * @param otp Valid verification token.
     * @return [io.appwrite.models.User<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `UpdateMFAAuthenticator` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.UpdateMFAAuthenticator"),
        since = "1.8.0"
    )
    @Throws(AppwriteException::class)
    suspend fun updateMfaAuthenticator(
        type: io.appwrite.enums.AuthenticatorType,
        otp: String,
    ): io.appwrite.models.User<Map<String, Any>> = updateMfaAuthenticator(
        type,
        otp,
        nestedType = classOf(),
    )

    /**
     * Verify an authenticator app after adding it using the [add authenticator](/docs/references/cloud/client-web/account#createMfaAuthenticator) method.
     *
     * @param type Type of authenticator.
     * @param otp Valid verification token.
     * @return [io.appwrite.models.User<T>]
     */
    suspend fun <T> updateMFAAuthenticator(
        type: io.appwrite.enums.AuthenticatorType,
        otp: String,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/mfa/authenticators/{type}"
            .replace("{type}", type.value)

        val apiParams = mutableMapOf<String, Any?>(
            "otp" to otp,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Verify an authenticator app after adding it using the [add authenticator](/docs/references/cloud/client-web/account#createMfaAuthenticator) method.
     *
     * @param type Type of authenticator.
     * @param otp Valid verification token.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateMFAAuthenticator(
        type: io.appwrite.enums.AuthenticatorType,
        otp: String,
    ): io.appwrite.models.User<Map<String, Any>> = updateMFAAuthenticator(
        type,
        otp,
        nestedType = classOf(),
    )

    /**
     * Delete an authenticator for a user by ID.
     *
     * @param type Type of authenticator.
     * @return [Any]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `DeleteMFAAuthenticator` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.DeleteMFAAuthenticator"),
        since = "1.8.0"
    )
    suspend fun deleteMfaAuthenticator(
        type: io.appwrite.enums.AuthenticatorType,
    ): Any {
        val apiPath = "/account/mfa/authenticators/{type}"
            .replace("{type}", type.value)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
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
     * Delete an authenticator for a user by ID.
     *
     * @param type Type of authenticator.
     * @return [Any]
     */
    suspend fun deleteMFAAuthenticator(
        type: io.appwrite.enums.AuthenticatorType,
    ): Any {
        val apiPath = "/account/mfa/authenticators/{type}"
            .replace("{type}", type.value)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
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
     * Begin the process of MFA verification after sign-in. Finish the flow with [updateMfaChallenge](/docs/references/cloud/client-web/account#updateMfaChallenge) method.
     *
     * @param factor Factor used for verification. Must be one of following: `email`, `phone`, `totp`, `recoveryCode`.
     * @return [io.appwrite.models.MfaChallenge]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `CreateMFAChallenge` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.CreateMFAChallenge"),
        since = "1.8.0"
    )
    suspend fun createMfaChallenge(
        factor: io.appwrite.enums.AuthenticationFactor,
    ): io.appwrite.models.MfaChallenge {
        val apiPath = "/account/mfa/challenge"

        val apiParams = mutableMapOf<String, Any?>(
            "factor" to factor,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MfaChallenge = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.MfaChallenge.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaChallenge::class.java,
            converter,
        )
    }


    /**
     * Begin the process of MFA verification after sign-in. Finish the flow with [updateMfaChallenge](/docs/references/cloud/client-web/account#updateMfaChallenge) method.
     *
     * @param factor Factor used for verification. Must be one of following: `email`, `phone`, `totp`, `recoveryCode`.
     * @return [io.appwrite.models.MfaChallenge]
     */
    suspend fun createMFAChallenge(
        factor: io.appwrite.enums.AuthenticationFactor,
    ): io.appwrite.models.MfaChallenge {
        val apiPath = "/account/mfa/challenge"

        val apiParams = mutableMapOf<String, Any?>(
            "factor" to factor,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MfaChallenge = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.MfaChallenge.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaChallenge::class.java,
            converter,
        )
    }


    /**
     * Complete the MFA challenge by providing the one-time password. Finish the process of MFA verification by providing the one-time password. To begin the flow, use [createMfaChallenge](/docs/references/cloud/client-web/account#createMfaChallenge) method.
     *
     * @param challengeId ID of the challenge.
     * @param otp Valid verification token.
     * @return [io.appwrite.models.Session]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `UpdateMFAChallenge` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.UpdateMFAChallenge"),
        since = "1.8.0"
    )
    suspend fun updateMfaChallenge(
        challengeId: String,
        otp: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/mfa/challenge"

        val apiParams = mutableMapOf<String, Any?>(
            "challengeId" to challengeId,
            "otp" to otp,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Complete the MFA challenge by providing the one-time password. Finish the process of MFA verification by providing the one-time password. To begin the flow, use [createMfaChallenge](/docs/references/cloud/client-web/account#createMfaChallenge) method.
     *
     * @param challengeId ID of the challenge.
     * @param otp Valid verification token.
     * @return [io.appwrite.models.Session]
     */
    suspend fun updateMFAChallenge(
        challengeId: String,
        otp: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/mfa/challenge"

        val apiParams = mutableMapOf<String, Any?>(
            "challengeId" to challengeId,
            "otp" to otp,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * List the factors available on the account to be used as a MFA challange.
     *
     * @return [io.appwrite.models.MfaFactors]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `ListMFAFactors` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.ListMFAFactors"),
        since = "1.8.0"
    )
    suspend fun listMfaFactors(
    ): io.appwrite.models.MfaFactors {
        val apiPath = "/account/mfa/factors"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.MfaFactors = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.MfaFactors.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaFactors::class.java,
            converter,
        )
    }


    /**
     * List the factors available on the account to be used as a MFA challange.
     *
     * @return [io.appwrite.models.MfaFactors]
     */
    suspend fun listMFAFactors(
    ): io.appwrite.models.MfaFactors {
        val apiPath = "/account/mfa/factors"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.MfaFactors = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.MfaFactors.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaFactors::class.java,
            converter,
        )
    }


    /**
     * Get recovery codes that can be used as backup for MFA flow. Before getting codes, they must be generated using [createMfaRecoveryCodes](/docs/references/cloud/client-web/account#createMfaRecoveryCodes) method. An OTP challenge is required to read recovery codes.
     *
     * @return [io.appwrite.models.MfaRecoveryCodes]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `GetMFARecoveryCodes` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.GetMFARecoveryCodes"),
        since = "1.8.0"
    )
    suspend fun getMfaRecoveryCodes(
    ): io.appwrite.models.MfaRecoveryCodes {
        val apiPath = "/account/mfa/recovery-codes"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.MfaRecoveryCodes = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.MfaRecoveryCodes.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaRecoveryCodes::class.java,
            converter,
        )
    }


    /**
     * Get recovery codes that can be used as backup for MFA flow. Before getting codes, they must be generated using [createMfaRecoveryCodes](/docs/references/cloud/client-web/account#createMfaRecoveryCodes) method. An OTP challenge is required to read recovery codes.
     *
     * @return [io.appwrite.models.MfaRecoveryCodes]
     */
    suspend fun getMFARecoveryCodes(
    ): io.appwrite.models.MfaRecoveryCodes {
        val apiPath = "/account/mfa/recovery-codes"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.MfaRecoveryCodes = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.MfaRecoveryCodes.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaRecoveryCodes::class.java,
            converter,
        )
    }


    /**
     * Generate recovery codes as backup for MFA flow. It's recommended to generate and show then immediately after user successfully adds their authehticator. Recovery codes can be used as a MFA verification type in [createMfaChallenge](/docs/references/cloud/client-web/account#createMfaChallenge) method.
     *
     * @return [io.appwrite.models.MfaRecoveryCodes]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `CreateMFARecoveryCodes` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.CreateMFARecoveryCodes"),
        since = "1.8.0"
    )
    suspend fun createMfaRecoveryCodes(
    ): io.appwrite.models.MfaRecoveryCodes {
        val apiPath = "/account/mfa/recovery-codes"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MfaRecoveryCodes = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.MfaRecoveryCodes.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaRecoveryCodes::class.java,
            converter,
        )
    }


    /**
     * Generate recovery codes as backup for MFA flow. It's recommended to generate and show then immediately after user successfully adds their authehticator. Recovery codes can be used as a MFA verification type in [createMfaChallenge](/docs/references/cloud/client-web/account#createMfaChallenge) method.
     *
     * @return [io.appwrite.models.MfaRecoveryCodes]
     */
    suspend fun createMFARecoveryCodes(
    ): io.appwrite.models.MfaRecoveryCodes {
        val apiPath = "/account/mfa/recovery-codes"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MfaRecoveryCodes = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.MfaRecoveryCodes.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaRecoveryCodes::class.java,
            converter,
        )
    }


    /**
     * Regenerate recovery codes that can be used as backup for MFA flow. Before regenerating codes, they must be first generated using [createMfaRecoveryCodes](/docs/references/cloud/client-web/account#createMfaRecoveryCodes) method. An OTP challenge is required to regenreate recovery codes.
     *
     * @return [io.appwrite.models.MfaRecoveryCodes]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `UpdateMFARecoveryCodes` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.UpdateMFARecoveryCodes"),
        since = "1.8.0"
    )
    suspend fun updateMfaRecoveryCodes(
    ): io.appwrite.models.MfaRecoveryCodes {
        val apiPath = "/account/mfa/recovery-codes"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MfaRecoveryCodes = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.MfaRecoveryCodes.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaRecoveryCodes::class.java,
            converter,
        )
    }


    /**
     * Regenerate recovery codes that can be used as backup for MFA flow. Before regenerating codes, they must be first generated using [createMfaRecoveryCodes](/docs/references/cloud/client-web/account#createMfaRecoveryCodes) method. An OTP challenge is required to regenreate recovery codes.
     *
     * @return [io.appwrite.models.MfaRecoveryCodes]
     */
    suspend fun updateMFARecoveryCodes(
    ): io.appwrite.models.MfaRecoveryCodes {
        val apiPath = "/account/mfa/recovery-codes"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MfaRecoveryCodes = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.MfaRecoveryCodes.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaRecoveryCodes::class.java,
            converter,
        )
    }


    /**
     * Update currently logged in user account name.
     *
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    suspend fun <T> updateName(
        name: String,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/name"

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update currently logged in user account name.
     *
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateName(
        name: String,
    ): io.appwrite.models.User<Map<String, Any>> = updateName(
        name,
        nestedType = classOf(),
    )

    /**
     * Update currently logged in user password. For validation, user is required to pass in the new password, and the old password. For users created with OAuth, Team Invites and Magic URL, oldPassword is optional.
     *
     * @param password New user password. Must be at least 8 chars.
     * @param oldPassword Current user password. Must be at least 8 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    suspend fun <T> updatePassword(
        password: String,
        oldPassword: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/password"

        val apiParams = mutableMapOf<String, Any?>(
            "password" to password,
            "oldPassword" to oldPassword,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update currently logged in user password. For validation, user is required to pass in the new password, and the old password. For users created with OAuth, Team Invites and Magic URL, oldPassword is optional.
     *
     * @param password New user password. Must be at least 8 chars.
     * @param oldPassword Current user password. Must be at least 8 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updatePassword(
        password: String,
        oldPassword: String? = null,
    ): io.appwrite.models.User<Map<String, Any>> = updatePassword(
        password,
        oldPassword,
        nestedType = classOf(),
    )

    /**
     * Update the currently logged in user's phone number. After updating the phone number, the phone verification status will be reset. A confirmation SMS is not sent automatically, however you can use the [POST /account/verification/phone](https://appwrite.io/docs/references/cloud/client-web/account#createPhoneVerification) endpoint to send a confirmation SMS.
     *
     * @param phone Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param password User password. Must be at least 8 chars.
     * @return [io.appwrite.models.User<T>]
     */
    suspend fun <T> updatePhone(
        phone: String,
        password: String,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/phone"

        val apiParams = mutableMapOf<String, Any?>(
            "phone" to phone,
            "password" to password,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update the currently logged in user&#039;s phone number. After updating the phone number, the phone verification status will be reset. A confirmation SMS is not sent automatically, however you can use the [POST /account/verification/phone](https://appwrite.io/docs/references/cloud/client-web/account#createPhoneVerification) endpoint to send a confirmation SMS.
     *
     * @param phone Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param password User password. Must be at least 8 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updatePhone(
        phone: String,
        password: String,
    ): io.appwrite.models.User<Map<String, Any>> = updatePhone(
        phone,
        password,
        nestedType = classOf(),
    )

    /**
     * Get the preferences as a key-value object for the currently logged in user.
     *
     * @return [io.appwrite.models.Preferences<T>]
     */
    suspend fun <T> getPrefs(
        nestedType: Class<T>,
    ): io.appwrite.models.Preferences<T> {
        val apiPath = "/account/prefs"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Preferences<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Preferences.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Get the preferences as a key-value object for the currently logged in user.
     *
     * @return [io.appwrite.models.Preferences<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun getPrefs(
    ): io.appwrite.models.Preferences<Map<String, Any>> = getPrefs(
        nestedType = classOf(),
    )

    /**
     * Update currently logged in user account preferences. The object you pass is stored as is, and replaces any previous value. The maximum allowed prefs size is 64kB and throws error if exceeded.
     *
     * @param prefs Prefs key-value JSON object.
     * @return [io.appwrite.models.User<T>]
     */
    suspend fun <T> updatePrefs(
        prefs: Any,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/prefs"

        val apiParams = mutableMapOf<String, Any?>(
            "prefs" to prefs,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update currently logged in user account preferences. The object you pass is stored as is, and replaces any previous value. The maximum allowed prefs size is 64kB and throws error if exceeded.
     *
     * @param prefs Prefs key-value JSON object.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updatePrefs(
        prefs: Any,
    ): io.appwrite.models.User<Map<String, Any>> = updatePrefs(
        prefs,
        nestedType = classOf(),
    )

    /**
     * Sends the user an email with a temporary secret key for password reset. When the user clicks the confirmation link he is redirected back to your app password reset URL with the secret key and email address values attached to the URL query string. Use the query string params to submit a request to the [PUT /account/recovery](https://appwrite.io/docs/references/cloud/client-web/account#updateRecovery) endpoint to complete the process. The verification link sent to the user's email address is valid for 1 hour.
     *
     * @param email User email.
     * @param url URL to redirect the user back to your app from the recovery email. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @return [io.appwrite.models.Token]
     */
    suspend fun createRecovery(
        email: String,
        url: String,
    ): io.appwrite.models.Token {
        val apiPath = "/account/recovery"

        val apiParams = mutableMapOf<String, Any?>(
            "email" to email,
            "url" to url,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * Use this endpoint to complete the user account password reset. Both the **userId** and **secret** arguments will be passed as query parameters to the redirect URL you have provided when sending your request to the [POST /account/recovery](https://appwrite.io/docs/references/cloud/client-web/account#createRecovery) endpoint.
    * 
    * Please note that in order to avoid a [Redirect Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md) the only valid redirect URLs are the ones from domains you have set when adding your platforms in the console interface.
     *
     * @param userId User ID.
     * @param secret Valid reset token.
     * @param password New user password. Must be between 8 and 256 chars.
     * @return [io.appwrite.models.Token]
     */
    suspend fun updateRecovery(
        userId: String,
        secret: String,
        password: String,
    ): io.appwrite.models.Token {
        val apiPath = "/account/recovery"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
            "password" to password,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * Get the list of active sessions across different devices for the currently logged in user.
     *
     * @return [io.appwrite.models.SessionList]
     */
    suspend fun listSessions(
    ): io.appwrite.models.SessionList {
        val apiPath = "/account/sessions"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.SessionList = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.SessionList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.SessionList::class.java,
            converter,
        )
    }


    /**
     * Delete all sessions from the user account and remove any sessions cookies from the end client.
     *
     * @return [Any]
     */
    suspend fun deleteSessions(
    ): Any {
        val apiPath = "/account/sessions"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
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
     * Use this endpoint to allow a new user to register an anonymous account in your project. This route will also create a new session for the user. To allow the new user to convert an anonymous account to a normal account, you need to update its [email and password](https://appwrite.io/docs/references/cloud/client-web/account#updateEmail) or create an [OAuth2 session](https://appwrite.io/docs/references/cloud/client-web/account#CreateOAuth2Session).
     *
     * @return [io.appwrite.models.Session]
     */
    suspend fun createAnonymousSession(
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/anonymous"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Allow the user to login into their account by providing a valid email and password combination. This route will create a new session for the user.
    * 
    * A user is limited to 10 active sessions at a time by default. [Learn more about session limits](https://appwrite.io/docs/authentication-security#limits).
     *
     * @param email User email.
     * @param password User password. Must be at least 8 chars.
     * @return [io.appwrite.models.Session]
     */
    suspend fun createEmailPasswordSession(
        email: String,
        password: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/email"

        val apiParams = mutableMapOf<String, Any?>(
            "email" to email,
            "password" to password,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Use this endpoint to create a session from token. Provide the **userId** and **secret** parameters from the successful response of authentication flows initiated by token creation. For example, magic URL and phone login.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param secret Valid verification token.
     * @return [io.appwrite.models.Session]
     */
    @Deprecated(
        message = "This API has been deprecated."
    )
    suspend fun updateMagicURLSession(
        userId: String,
        secret: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/magic-url"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Allow the user to login to their account using the OAuth2 provider of their choice. Each OAuth2 provider should be enabled from the Appwrite console first. Use the success and failure arguments to provide a redirect URL's back to your app when login is completed.
    * 
    * If there is already an active session, the new session will be attached to the logged-in account. If there are no active sessions, the server will attempt to look for a user with the same email address as the email received from the OAuth2 provider and attach the new session to the existing user. If no matching user is found - the server will create a new user.
    * 
    * A user is limited to 10 active sessions at a time by default. [Learn more about session limits](https://appwrite.io/docs/authentication-security#limits).
    * 
     *
     * @param provider OAuth2 Provider. Currently, supported providers are: amazon, apple, auth0, authentik, autodesk, bitbucket, bitly, box, dailymotion, discord, disqus, dropbox, etsy, facebook, figma, github, gitlab, google, linkedin, microsoft, notion, oidc, okta, paypal, paypalSandbox, podio, salesforce, slack, spotify, stripe, tradeshift, tradeshiftBox, twitch, wordpress, yahoo, yammer, yandex, zoho, zoom.
     * @param success URL to redirect back to your app after a successful login attempt.  Only URLs from hostnames in your project's platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @param failure URL to redirect back to your app after a failed login attempt.  Only URLs from hostnames in your project's platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @param scopes A list of custom OAuth2 scopes. Check each provider internal docs for a list of supported scopes. Maximum of 100 scopes are allowed, each 4096 characters long.
     */
    @JvmOverloads
    suspend fun createOAuth2Session(
        activity: ComponentActivity,
        provider: io.appwrite.enums.OAuthProvider,
        success: String? = null,
        failure: String? = null,
        scopes: List<String>? = null,
    ) {
        val apiPath = "/account/sessions/oauth2/{provider}"
            .replace("{provider}", provider.value)

        val apiParams = mutableMapOf<String, Any?>(
            "success" to success,
            "failure" to failure,
            "scopes" to scopes,
            "project" to client.config["project"],
        )
        val apiQuery = mutableListOf<String>()
        apiParams.forEach {
            when (it.value) {
                null -> {
                    return@forEach
                }
                is List<*> -> {
                    (it.value as List<*>).forEach { v ->
                        apiQuery.add("${it.key}[]=${v.toString()}")
                    }
                }
                else -> {
                   apiQuery.add("${it.key}=${it.value.toString()}")
                }
            }
        }

        val apiUrl = Uri.parse("${client.endpoint}${apiPath}?${apiQuery.joinToString("&")}")
        val callbackUrlScheme = "appwrite-callback-${client.config["project"]}"

        WebAuthComponent.authenticate(activity, apiUrl, callbackUrlScheme) {
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
                .domain(Uri.parse(client.endpoint).host!!)
                .httpOnly()
                .build()
            
            client.http.cookieJar.saveFromResponse(
                client.endpoint.toHttpUrl(),
                listOf(cookie)
            )
        }
    }


    /**
     * Use this endpoint to create a session from token. Provide the **userId** and **secret** parameters from the successful response of authentication flows initiated by token creation. For example, magic URL and phone login.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param secret Valid verification token.
     * @return [io.appwrite.models.Session]
     */
    @Deprecated(
        message = "This API has been deprecated."
    )
    suspend fun updatePhoneSession(
        userId: String,
        secret: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/phone"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Use this endpoint to create a session from token. Provide the **userId** and **secret** parameters from the successful response of authentication flows initiated by token creation. For example, magic URL and phone login.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param secret Secret of a token generated by login methods. For example, the `createMagicURLToken` or `createPhoneToken` methods.
     * @return [io.appwrite.models.Session]
     */
    suspend fun createSession(
        userId: String,
        secret: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/token"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Use this endpoint to get a logged in user's session using a Session ID. Inputting 'current' will return the current session being used.
     *
     * @param sessionId Session ID. Use the string 'current' to get the current device session.
     * @return [io.appwrite.models.Session]
     */
    suspend fun getSession(
        sessionId: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/{sessionId}"
            .replace("{sessionId}", sessionId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Use this endpoint to extend a session's length. Extending a session is useful when session expiry is short. If the session was created using an OAuth provider, this endpoint refreshes the access token from the provider.
     *
     * @param sessionId Session ID. Use the string 'current' to update the current device session.
     * @return [io.appwrite.models.Session]
     */
    suspend fun updateSession(
        sessionId: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/{sessionId}"
            .replace("{sessionId}", sessionId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }


    /**
     * Logout the user. Use 'current' as the session ID to logout on this device, use a session ID to logout on another device. If you're looking to logout the user on all devices, use [Delete Sessions](https://appwrite.io/docs/references/cloud/client-web/account#deleteSessions) instead.
     *
     * @param sessionId Session ID. Use the string 'current' to delete the current device session.
     * @return [Any]
     */
    suspend fun deleteSession(
        sessionId: String,
    ): Any {
        val apiPath = "/account/sessions/{sessionId}"
            .replace("{sessionId}", sessionId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
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
     * Block the currently logged in user account. Behind the scene, the user record is not deleted but permanently blocked from any access. To completely delete a user, use the Users API instead.
     *
     * @return [io.appwrite.models.User<T>]
     */
    suspend fun <T> updateStatus(
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/status"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Block the currently logged in user account. Behind the scene, the user record is not deleted but permanently blocked from any access. To completely delete a user, use the Users API instead.
     *
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateStatus(
    ): io.appwrite.models.User<Map<String, Any>> = updateStatus(
        nestedType = classOf(),
    )

    /**
     * Use this endpoint to register a device for push notifications. Provide a target ID (custom or generated using ID.unique()), a device identifier (usually a device token), and optionally specify which provider should send notifications to this target. The target is automatically linked to the current session and includes device information like brand and model.
     *
     * @param targetId Target ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param identifier The target identifier (token, email, phone etc.)
     * @param providerId Provider ID. Message will be sent to this target from the specified provider ID. If no provider ID is set the first setup provider will be used.
     * @return [io.appwrite.models.Target]
     */
    @JvmOverloads
    suspend fun createPushTarget(
        targetId: String,
        identifier: String,
        providerId: String? = null,
    ): io.appwrite.models.Target {
        val apiPath = "/account/targets/push"

        val apiParams = mutableMapOf<String, Any?>(
            "targetId" to targetId,
            "identifier" to identifier,
            "providerId" to providerId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Target = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Target.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Target::class.java,
            converter,
        )
    }


    /**
     * Update the currently logged in user's push notification target. You can modify the target's identifier (device token) and provider ID (token, email, phone etc.). The target must exist and belong to the current user. If you change the provider ID, notifications will be sent through the new messaging provider instead.
     *
     * @param targetId Target ID.
     * @param identifier The target identifier (token, email, phone etc.)
     * @return [io.appwrite.models.Target]
     */
    suspend fun updatePushTarget(
        targetId: String,
        identifier: String,
    ): io.appwrite.models.Target {
        val apiPath = "/account/targets/{targetId}/push"
            .replace("{targetId}", targetId)

        val apiParams = mutableMapOf<String, Any?>(
            "identifier" to identifier,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Target = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Target.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Target::class.java,
            converter,
        )
    }


    /**
     * Delete a push notification target for the currently logged in user. After deletion, the device will no longer receive push notifications. The target must exist and belong to the current user.
     *
     * @param targetId Target ID.
     * @return [Any]
     */
    suspend fun deletePushTarget(
        targetId: String,
    ): Any {
        val apiPath = "/account/targets/{targetId}/push"
            .replace("{targetId}", targetId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
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
     * Sends the user an email with a secret key for creating a session. If the provided user ID has not be registered, a new user will be created. Use the returned user ID and secret and submit a request to the [POST /v1/account/sessions/token](https://appwrite.io/docs/references/cloud/client-web/account#createSession) endpoint to complete the login process. The secret sent to the user's email is valid for 15 minutes.
    * 
    * A user is limited to 10 active sessions at a time by default. [Learn more about session limits](https://appwrite.io/docs/authentication-security#limits).
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param phrase Toggle for security phrase. If enabled, email will be send with a randomly generated phrase and the phrase will also be included in the response. Confirming phrases match increases the security of your authentication flow.
     * @return [io.appwrite.models.Token]
     */
    @JvmOverloads
    suspend fun createEmailToken(
        userId: String,
        email: String,
        phrase: Boolean? = null,
    ): io.appwrite.models.Token {
        val apiPath = "/account/tokens/email"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "phrase" to phrase,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * Sends the user an email with a secret key for creating a session. If the provided user ID has not been registered, a new user will be created. When the user clicks the link in the email, the user is redirected back to the URL you provided with the secret key and userId values attached to the URL query string. Use the query string parameters to submit a request to the [POST /v1/account/sessions/token](https://appwrite.io/docs/references/cloud/client-web/account#createSession) endpoint to complete the login process. The link sent to the user's email address is valid for 1 hour.
    * 
    * A user is limited to 10 active sessions at a time by default. [Learn more about session limits](https://appwrite.io/docs/authentication-security#limits).
    * 
     *
     * @param userId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param url URL to redirect the user back to your app from the magic URL login. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @param phrase Toggle for security phrase. If enabled, email will be send with a randomly generated phrase and the phrase will also be included in the response. Confirming phrases match increases the security of your authentication flow.
     * @return [io.appwrite.models.Token]
     */
    @JvmOverloads
    suspend fun createMagicURLToken(
        userId: String,
        email: String,
        url: String? = null,
        phrase: Boolean? = null,
    ): io.appwrite.models.Token {
        val apiPath = "/account/tokens/magic-url"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "url" to url,
            "phrase" to phrase,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * Allow the user to login to their account using the OAuth2 provider of their choice. Each OAuth2 provider should be enabled from the Appwrite console first. Use the success and failure arguments to provide a redirect URL's back to your app when login is completed. 
    * 
    * If authentication succeeds, `userId` and `secret` of a token will be appended to the success URL as query parameters. These can be used to create a new session using the [Create session](https://appwrite.io/docs/references/cloud/client-web/account#createSession) endpoint.
    * 
    * A user is limited to 10 active sessions at a time by default. [Learn more about session limits](https://appwrite.io/docs/authentication-security#limits).
     *
     * @param provider OAuth2 Provider. Currently, supported providers are: amazon, apple, auth0, authentik, autodesk, bitbucket, bitly, box, dailymotion, discord, disqus, dropbox, etsy, facebook, figma, github, gitlab, google, linkedin, microsoft, notion, oidc, okta, paypal, paypalSandbox, podio, salesforce, slack, spotify, stripe, tradeshift, tradeshiftBox, twitch, wordpress, yahoo, yammer, yandex, zoho, zoom.
     * @param success URL to redirect back to your app after a successful login attempt.  Only URLs from hostnames in your project's platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @param failure URL to redirect back to your app after a failed login attempt.  Only URLs from hostnames in your project's platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @param scopes A list of custom OAuth2 scopes. Check each provider internal docs for a list of supported scopes. Maximum of 100 scopes are allowed, each 4096 characters long.
     */
    @JvmOverloads
    suspend fun createOAuth2Token(
        activity: ComponentActivity,
        provider: io.appwrite.enums.OAuthProvider,
        success: String? = null,
        failure: String? = null,
        scopes: List<String>? = null,
    ) {
        val apiPath = "/account/tokens/oauth2/{provider}"
            .replace("{provider}", provider.value)

        val apiParams = mutableMapOf<String, Any?>(
            "success" to success,
            "failure" to failure,
            "scopes" to scopes,
            "project" to client.config["project"],
        )
        val apiQuery = mutableListOf<String>()
        apiParams.forEach {
            when (it.value) {
                null -> {
                    return@forEach
                }
                is List<*> -> {
                    (it.value as List<*>).forEach { v ->
                        apiQuery.add("${it.key}[]=${v.toString()}")
                    }
                }
                else -> {
                   apiQuery.add("${it.key}=${it.value.toString()}")
                }
            }
        }

        val apiUrl = Uri.parse("${client.endpoint}${apiPath}?${apiQuery.joinToString("&")}")
        val callbackUrlScheme = "appwrite-callback-${client.config["project"]}"

        WebAuthComponent.authenticate(activity, apiUrl, callbackUrlScheme) {
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
                .domain(Uri.parse(client.endpoint).host!!)
                .httpOnly()
                .build()
            
            client.http.cookieJar.saveFromResponse(
                client.endpoint.toHttpUrl(),
                listOf(cookie)
            )
        }
    }


    /**
     * Sends the user an SMS with a secret key for creating a session. If the provided user ID has not be registered, a new user will be created. Use the returned user ID and secret and submit a request to the [POST /v1/account/sessions/token](https://appwrite.io/docs/references/cloud/client-web/account#createSession) endpoint to complete the login process. The secret sent to the user's phone is valid for 15 minutes.
    * 
    * A user is limited to 10 active sessions at a time by default. [Learn more about session limits](https://appwrite.io/docs/authentication-security#limits).
     *
     * @param userId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param phone Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @return [io.appwrite.models.Token]
     */
    suspend fun createPhoneToken(
        userId: String,
        phone: String,
    ): io.appwrite.models.Token {
        val apiPath = "/account/tokens/phone"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "phone" to phone,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * Use this endpoint to send a verification message to your user email address to confirm they are the valid owners of that address. Both the **userId** and **secret** arguments will be passed as query parameters to the URL you have provided to be attached to the verification email. The provided URL should redirect the user back to your app and allow you to complete the verification process by verifying both the **userId** and **secret** parameters. Learn more about how to [complete the verification process](https://appwrite.io/docs/references/cloud/client-web/account#updateVerification). The verification link sent to the user's email address is valid for 7 days.
    * 
    * Please note that in order to avoid a [Redirect Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md), the only valid redirect URLs are the ones from domains you have set when adding your platforms in the console interface.
    * 
     *
     * @param url URL to redirect the user back to your app from the verification email. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @return [io.appwrite.models.Token]
     */
    suspend fun createVerification(
        url: String,
    ): io.appwrite.models.Token {
        val apiPath = "/account/verification"

        val apiParams = mutableMapOf<String, Any?>(
            "url" to url,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
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
        val apiPath = "/account/verification"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * Use this endpoint to send a verification SMS to the currently logged in user. This endpoint is meant for use after updating a user's phone number using the [accountUpdatePhone](https://appwrite.io/docs/references/cloud/client-web/account#updatePhone) endpoint. Learn more about how to [complete the verification process](https://appwrite.io/docs/references/cloud/client-web/account#updatePhoneVerification). The verification code sent to the user's phone number is valid for 15 minutes.
     *
     * @return [io.appwrite.models.Token]
     */
    suspend fun createPhoneVerification(
    ): io.appwrite.models.Token {
        val apiPath = "/account/verification/phone"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


    /**
     * Use this endpoint to complete the user phone verification process. Use the **userId** and **secret** that were sent to your user's phone number to verify the user email ownership. If confirmed this route will return a 200 status code.
     *
     * @param userId User ID.
     * @param secret Valid verification token.
     * @return [io.appwrite.models.Token]
     */
    suspend fun updatePhoneVerification(
        userId: String,
        secret: String,
    ): io.appwrite.models.Token {
        val apiPath = "/account/verification/phone"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }


}