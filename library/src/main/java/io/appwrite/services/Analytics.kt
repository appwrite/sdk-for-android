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
 *
 */
class Analytics(client: Client) : Service(client) {
    /**
     * Send a tracking event from a browser, native app, or server-side SDK.
     *
     * @param propertyId Analytics property ID.
     * @param name Event name. "pageview" is just a conventional event name; events are not modeled specially.
     * @param url Full page URL or screen identifier.
     * @param domain Hostname (e.g. example.com).
     * @param referrer Referrer URL.
     * @param screenWidth Viewport width in CSS pixels.
     * @param sessionHash Optional session hash (provided by SDK).
     * @param scrollDepth Scroll depth percentage 0-100.
     * @param engagementTime Engagement time in seconds, 0-4294967295.
     * @param props Custom string properties as a flat key=value list (max 32 entries, alternating key,value).
     * @param userId Override user ID. Requires API-key auth with analytics.write scope.
     * @param ip Override IP address. Requires API-key auth with analytics.write scope.
     * @param userAgent Override user agent. Requires API-key auth with analytics.write scope.
     * @return [Any]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createEvent(
        propertyId: String,
        name: String,
        url: String,
        domain: String? = null,
        referrer: String? = null,
        screenWidth: Long? = null,
        sessionHash: String? = null,
        scrollDepth: Long? = null,
        engagementTime: Long? = null,
        props: List<String>? = null,
        userId: String? = null,
        ip: String? = null,
        userAgent: String? = null,
    ): Any {
        if (propertyId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"propertyId\"")
        }
        val apiPath = ("/analytics/properties/{propertyId}/events"
            .replace("{propertyId}", propertyId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "url" to url,
            "domain" to domain,
            "referrer" to referrer,
            "screenWidth" to screenWidth,
            "sessionHash" to sessionHash,
            "scrollDepth" to scrollDepth,
            "engagementTime" to engagementTime,
            "props" to props,
            "userId" to userId,
            "ip" to ip,
            "userAgent" to userAgent,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
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
}
