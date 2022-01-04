package io.appwrite.models

/**
 * Log
 */
data class Log(
    /**
     * Event name.
     *
     */
    val event: String,

    /**
     * User ID.
     *
     */
    val userId: String,

    /**
     * User Email.
     *
     */
    val userEmail: String,

    /**
     * User Name.
     *
     */
    val userName: String,

    /**
     * API mode when event triggered.
     *
     */
    val mode: String,

    /**
     * IP session in use when the session was created.
     *
     */
    val ip: String,

    /**
     * Log creation time in Unix timestamp.
     *
     */
    val time: Long,

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
    val countryName: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Log(
            event = map["event"] as String,
            userId = map["userId"] as String,
            userEmail = map["userEmail"] as String,
            userName = map["userName"] as String,
            mode = map["mode"] as String,
            ip = map["ip"] as String,
            time = map["time"] as Long,
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
            countryName = map["countryName"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "event" to event as Any,
        "userId" to userId as Any,
        "userEmail" to userEmail as Any,
        "userName" to userName as Any,
        "mode" to mode as Any,
        "ip" to ip as Any,
        "time" to time as Any,
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
        "countryName" to countryName as Any
    )
}