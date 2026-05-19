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
class Presences(client: Client) : Service(client) {

    /**
     * List presence logs. Expired entries are filtered out automatically.
     * 
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @param ttl TTL (seconds) for caching list responses. Responses are stored in an in-memory key-value cache, keyed per project, collection, schema version (attributes and indexes), caller authorization roles, and the exact query — so users with different permissions never share cached entries. Schema changes invalidate cached entries automatically; document writes do not, so choose a TTL you are comfortable serving as stale data. Set to 0 to disable caching. Must be between 0 and 86400 (24 hours).
     * @return [io.appwrite.models.PresenceList<T>]
     */
    @JvmOverloads
    suspend fun <T> list(
        queries: List<String>? = null,
        total: Boolean? = null,
        ttl: Long? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.PresenceList<T> {
        val apiPath = "/presences"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
            "ttl" to ttl,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.PresenceList<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.PresenceList.from(map = it as Map<String, Any>, nestedType)
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
     * List presence logs. Expired entries are filtered out automatically.
     * 
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @param ttl TTL (seconds) for caching list responses. Responses are stored in an in-memory key-value cache, keyed per project, collection, schema version (attributes and indexes), caller authorization roles, and the exact query — so users with different permissions never share cached entries. Schema changes invalidate cached entries automatically; document writes do not, so choose a TTL you are comfortable serving as stale data. Set to 0 to disable caching. Must be between 0 and 86400 (24 hours).
     * @return [io.appwrite.models.PresenceList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
        total: Boolean? = null,
        ttl: Long? = null,
    ): io.appwrite.models.PresenceList<Map<String, Any>> = list(
        queries,
        total,
        ttl,
        nestedType = classOf(),
    )

    /**
     * Get a presence log by its unique ID. Entries whose `expiresAt` is in the past are treated as not found.
     * 
     *
     * @param presenceId Presence unique ID.
     * @return [io.appwrite.models.Presence<T>]
     */
    suspend fun <T> get(
        presenceId: String,
        nestedType: Class<T>,
    ): io.appwrite.models.Presence<T> {
        val apiPath = "/presences/{presenceId}"
            .replace("{presenceId}", presenceId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Presence<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Presence.from(map = it as Map<String, Any>, nestedType)
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
     * Get a presence log by its unique ID. Entries whose `expiresAt` is in the past are treated as not found.
     * 
     *
     * @param presenceId Presence unique ID.
     * @return [io.appwrite.models.Presence<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        presenceId: String,
    ): io.appwrite.models.Presence<Map<String, Any>> = get(
        presenceId,
        nestedType = classOf(),
    )

    /**
     * Create or update a presence log by its user ID.
     * 
     *
     * @param presenceId Presence unique ID.
     * @param status Presence status.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param expiresAt Presence expiry datetime.
     * @param metadata Presence metadata object.
     * @return [io.appwrite.models.Presence<T>]
     */
    @JvmOverloads
    suspend fun <T> upsert(
        presenceId: String,
        status: String,
        permissions: List<String>? = null,
        expiresAt: String? = null,
        metadata: Any? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Presence<T> {
        val apiPath = "/presences/{presenceId}"
            .replace("{presenceId}", presenceId)

        val apiParams = mutableMapOf<String, Any?>(
            "status" to status,
            "permissions" to permissions,
            "expiresAt" to expiresAt,
            "metadata" to metadata,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Presence<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Presence.from(map = it as Map<String, Any>, nestedType)
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
     * Create or update a presence log by its user ID.
     * 
     *
     * @param presenceId Presence unique ID.
     * @param status Presence status.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param expiresAt Presence expiry datetime.
     * @param metadata Presence metadata object.
     * @return [io.appwrite.models.Presence<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun upsert(
        presenceId: String,
        status: String,
        permissions: List<String>? = null,
        expiresAt: String? = null,
        metadata: Any? = null,
    ): io.appwrite.models.Presence<Map<String, Any>> = upsert(
        presenceId,
        status,
        permissions,
        expiresAt,
        metadata,
        nestedType = classOf(),
    )

    /**
     * Update a presence log by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     * 
     *
     * @param presenceId Presence unique ID.
     * @param status Presence status.
     * @param expiresAt Presence expiry datetime.
     * @param metadata Presence metadata object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param purge When true, purge cached responses used by list presences endpoint.
     * @return [io.appwrite.models.Presence<T>]
     */
    @JvmOverloads
    suspend fun <T> update(
        presenceId: String,
        status: String? = null,
        expiresAt: String? = null,
        metadata: Any? = null,
        permissions: List<String>? = null,
        purge: Boolean? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Presence<T> {
        val apiPath = "/presences/{presenceId}"
            .replace("{presenceId}", presenceId)

        val apiParams = mutableMapOf<String, Any?>(
            "status" to status,
            "expiresAt" to expiresAt,
            "metadata" to metadata,
            "permissions" to permissions,
            "purge" to purge,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Presence<T> = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Presence.from(map = it as Map<String, Any>, nestedType)
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
     * Update a presence log by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     * 
     *
     * @param presenceId Presence unique ID.
     * @param status Presence status.
     * @param expiresAt Presence expiry datetime.
     * @param metadata Presence metadata object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param purge When true, purge cached responses used by list presences endpoint.
     * @return [io.appwrite.models.Presence<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
        presenceId: String,
        status: String? = null,
        expiresAt: String? = null,
        metadata: Any? = null,
        permissions: List<String>? = null,
        purge: Boolean? = null,
    ): io.appwrite.models.Presence<Map<String, Any>> = update(
        presenceId,
        status,
        expiresAt,
        metadata,
        permissions,
        purge,
        nestedType = classOf(),
    )

    /**
     * Delete a presence log by its unique ID.
     * 
     *
     * @param presenceId Presence unique ID.
     * @return [Any]
     */
    suspend fun delete(
        presenceId: String,
    ): Any {
        val apiPath = "/presences/{presenceId}"
            .replace("{presenceId}", presenceId)

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


}
