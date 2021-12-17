package io.appwrite.models

/**
 * Session
 */
data class Session(
    /**
     * Session ID.
     *
     */
    val id: String,

    /**
     * User ID.
     *
     */
    val userId: String,

    /**
     * Session expiration date in Unix timestamp.
     *
     */
    val expire: Long,

    /**
     * Session Provider.
     *
     */
    val provider: String,

    /**
     * Session Provider User ID.
     *
     */
    val providerUid: String,

    /**
     * Session Provider Token.
     *
     */
    val providerToken: String,

    /**
     * IP in use when the session was created.
     *
     */
    val ip: String,

    /**
     * Operating system code name. View list of [available options](https://github.com/appwrite/appwrite/blob/master/docs/lists/os.json).
     *
     */
    val osCode: String,

    /**
     * Operating system name.
     *
     */
    val osName: String,

    /**
     * Operating system version.
     *
     */
    val osVersion: String,

    /**
     * Client type.
     *
     */
    val clientType: String,

    /**
     * Client code name. View list of [available options](https://github.com/appwrite/appwrite/blob/master/docs/lists/clients.json).
     *
     */
    val clientCode: String,

    /**
     * Client name.
     *
     */
    val clientName: String,

    /**
     * Client version.
     *
     */
    val clientVersion: String,

    /**
     * Client engine name.
     *
     */
    val clientEngine: String,

    /**
     * Client engine name.
     *
     */
    val clientEngineVersion: String,

    /**
     * Device name.
     *
     */
    val deviceName: String,

    /**
     * Device brand name.
     *
     */
    val deviceBrand: String,

    /**
     * Device model name.
     *
     */
    val deviceModel: String,

    /**
     * Country two-character ISO 3166-1 alpha code.
     *
     */
    val countryCode: String,

    /**
     * Country name.
     *
     */
    val countryName: String,

    /**
     * Returns true if this the current user session.
     *
     */
    val current: Boolean
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Session(
            id = map["\$id"] as String,
            userId = map["userId"] as String,
            expire = map["expire"] as Long,
            provider = map["provider"] as String,
            providerUid = map["providerUid"] as String,
            providerToken = map["providerToken"] as String,
            ip = map["ip"] as String,
            osCode = map["osCode"] as String,
            osName = map["osName"] as String,
            osVersion = map["osVersion"] as String,
            clientType = map["clientType"] as String,
            clientCode = map["clientCode"] as String,
            clientName = map["clientName"] as String,
            clientVersion = map["clientVersion"] as String,
            clientEngine = map["clientEngine"] as String,
            clientEngineVersion = map["clientEngineVersion"] as String,
            deviceName = map["deviceName"] as String,
            deviceBrand = map["deviceBrand"] as String,
            deviceModel = map["deviceModel"] as String,
            countryCode = map["countryCode"] as String,
            countryName = map["countryName"] as String,
            current = map["current"] as Boolean
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "userId" to userId as Any,
        "expire" to expire as Any,
        "provider" to provider as Any,
        "providerUid" to providerUid as Any,
        "providerToken" to providerToken as Any,
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
        "current" to current as Any
    )
}