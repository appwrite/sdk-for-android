package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Session
 */
data class Session(
    /**
     * Session ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Session creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Session update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * User ID.
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * Session expiration date in ISO 8601 format.
     */
    @SerializedName("expire")
    val expire: String,

    /**
     * Session Provider.
     */
    @SerializedName("provider")
    val provider: String,

    /**
     * Session Provider User ID.
     */
    @SerializedName("providerUid")
    val providerUid: String,

    /**
     * Session Provider Access Token.
     */
    @SerializedName("providerAccessToken")
    val providerAccessToken: String,

    /**
     * The date of when the access token expires in ISO 8601 format.
     */
    @SerializedName("providerAccessTokenExpiry")
    val providerAccessTokenExpiry: String,

    /**
     * Session Provider Refresh Token.
     */
    @SerializedName("providerRefreshToken")
    val providerRefreshToken: String,

    /**
     * IP in use when the session was created.
     */
    @SerializedName("ip")
    val ip: String,

    /**
     * Operating system code name. View list of [available options](https://github.com/appwrite/appwrite/blob/master/docs/lists/os.json).
     */
    @SerializedName("osCode")
    val osCode: String,

    /**
     * Operating system name.
     */
    @SerializedName("osName")
    val osName: String,

    /**
     * Operating system version.
     */
    @SerializedName("osVersion")
    val osVersion: String,

    /**
     * Client type.
     */
    @SerializedName("clientType")
    val clientType: String,

    /**
     * Client code name. View list of [available options](https://github.com/appwrite/appwrite/blob/master/docs/lists/clients.json).
     */
    @SerializedName("clientCode")
    val clientCode: String,

    /**
     * Client name.
     */
    @SerializedName("clientName")
    val clientName: String,

    /**
     * Client version.
     */
    @SerializedName("clientVersion")
    val clientVersion: String,

    /**
     * Client engine name.
     */
    @SerializedName("clientEngine")
    val clientEngine: String,

    /**
     * Client engine name.
     */
    @SerializedName("clientEngineVersion")
    val clientEngineVersion: String,

    /**
     * Device name.
     */
    @SerializedName("deviceName")
    val deviceName: String,

    /**
     * Device brand name.
     */
    @SerializedName("deviceBrand")
    val deviceBrand: String,

    /**
     * Device model name.
     */
    @SerializedName("deviceModel")
    val deviceModel: String,

    /**
     * Country two-character ISO 3166-1 alpha code.
     */
    @SerializedName("countryCode")
    val countryCode: String,

    /**
     * Country name.
     */
    @SerializedName("countryName")
    val countryName: String,

    /**
     * Returns true if this the current user session.
     */
    @SerializedName("current")
    val current: Boolean,

    /**
     * Returns a list of active session factors.
     */
    @SerializedName("factors")
    val factors: List<String>,

    /**
     * Secret used to authenticate the user. Only included if the request was made with an API key
     */
    @SerializedName("secret")
    val secret: String,

    /**
     * Most recent date in ISO 8601 format when the session successfully passed MFA challenge.
     */
    @SerializedName("mfaUpdatedAt")
    val mfaUpdatedAt: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "userId" to userId as Any,
        "expire" to expire as Any,
        "provider" to provider as Any,
        "providerUid" to providerUid as Any,
        "providerAccessToken" to providerAccessToken as Any,
        "providerAccessTokenExpiry" to providerAccessTokenExpiry as Any,
        "providerRefreshToken" to providerRefreshToken as Any,
        "ip" to ip as Any,
        "osCode" to osCode as Any,
        "osName" to osName as Any,
        "osVersion" to osVersion as Any,
        "clientType" to clientType as Any,
        "clientCode" to clientCode as Any,
        "clientName" to clientName as Any,
        "clientVersion" to clientVersion as Any,
        "clientEngine" to clientEngine as Any,
        "clientEngineVersion" to clientEngineVersion as Any,
        "deviceName" to deviceName as Any,
        "deviceBrand" to deviceBrand as Any,
        "deviceModel" to deviceModel as Any,
        "countryCode" to countryCode as Any,
        "countryName" to countryName as Any,
        "current" to current as Any,
        "factors" to factors as Any,
        "secret" to secret as Any,
        "mfaUpdatedAt" to mfaUpdatedAt as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Session(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            userId = (if (map.containsKey("userId")) map["userId"] else "") as String,
            expire = (if (map.containsKey("expire")) map["expire"] else "") as String,
            provider = (if (map.containsKey("provider")) map["provider"] else "") as String,
            providerUid = (if (map.containsKey("providerUid")) map["providerUid"] else "") as String,
            providerAccessToken = (if (map.containsKey("providerAccessToken")) map["providerAccessToken"] else "") as String,
            providerAccessTokenExpiry = (if (map.containsKey("providerAccessTokenExpiry")) map["providerAccessTokenExpiry"] else "") as String,
            providerRefreshToken = (if (map.containsKey("providerRefreshToken")) map["providerRefreshToken"] else "") as String,
            ip = (if (map.containsKey("ip")) map["ip"] else "") as String,
            osCode = (if (map.containsKey("osCode")) map["osCode"] else "") as String,
            osName = (if (map.containsKey("osName")) map["osName"] else "") as String,
            osVersion = (if (map.containsKey("osVersion")) map["osVersion"] else "") as String,
            clientType = (if (map.containsKey("clientType")) map["clientType"] else "") as String,
            clientCode = (if (map.containsKey("clientCode")) map["clientCode"] else "") as String,
            clientName = (if (map.containsKey("clientName")) map["clientName"] else "") as String,
            clientVersion = (if (map.containsKey("clientVersion")) map["clientVersion"] else "") as String,
            clientEngine = (if (map.containsKey("clientEngine")) map["clientEngine"] else "") as String,
            clientEngineVersion = (if (map.containsKey("clientEngineVersion")) map["clientEngineVersion"] else "") as String,
            deviceName = (if (map.containsKey("deviceName")) map["deviceName"] else "") as String,
            deviceBrand = (if (map.containsKey("deviceBrand")) map["deviceBrand"] else "") as String,
            deviceModel = (if (map.containsKey("deviceModel")) map["deviceModel"] else "") as String,
            countryCode = (if (map.containsKey("countryCode")) map["countryCode"] else "") as String,
            countryName = (if (map.containsKey("countryName")) map["countryName"] else "") as String,
            current = (if (map.containsKey("current")) map["current"] else false) as Boolean,
            factors = (if (map.containsKey("factors")) map["factors"] else listOf<Any?>()) as List<String>,
            secret = (if (map.containsKey("secret")) map["secret"] else "") as String,
            mfaUpdatedAt = (if (map.containsKey("mfaUpdatedAt")) map["mfaUpdatedAt"] else "") as String,
        )
    }
}
