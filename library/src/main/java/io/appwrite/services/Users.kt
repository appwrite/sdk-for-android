package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Users service allows you to manage your project users.
**/
class Users(client: Client) : Service(client) {

    /**
     * Delete Authenticator
     *
     * 
     *
     * @param userId User ID.
     * @param provider Provider.
     * @param otp Valid verification token.
     * @return [io.appwrite.models.User<T>]
     */
    suspend fun <T> deleteAuthenticator(
        userId: String,
        provider: AuthenticatorProvider,
        otp: String,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/{userId}/mfa/{provider}"
            .replace("{userId}", userId)
            .replace("{provider}", provider.value)

        val apiParams = mutableMapOf<String, Any?>(
            "otp" to otp,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Delete Authenticator
     *
     * 
     *
     * @param userId User ID.
     * @param provider Provider.
     * @param otp Valid verification token.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteAuthenticator(
        userId: String,
        provider: AuthenticatorProvider,
        otp: String,
    ): io.appwrite.models.User<Map<String, Any>> = deleteAuthenticator(
        userId,
        provider,
        otp,
        nestedType = classOf(),
    )

    /**
     * List Providers
     *
     * 
     *
     * @param userId User ID.
     * @return [io.appwrite.models.MfaProviders]
     */
    suspend fun listProviders(
        userId: String,
    ): io.appwrite.models.MfaProviders {
        val apiPath = "/users/{userId}/providers"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MfaProviders = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.MfaProviders.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaProviders::class.java,
            converter,
        )
    }


}