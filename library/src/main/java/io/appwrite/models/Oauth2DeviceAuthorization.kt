package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 Device Authorization
 */
data class Oauth2DeviceAuthorization(
    /**
     * Device verification code used by the client to poll the token endpoint.
     */
    @SerializedName("device_code")
    val device_code: String,

    /**
     * Short code the end user enters on the verification page.
     */
    @SerializedName("user_code")
    val user_code: String,

    /**
     * URL where the end user enters the user code.
     */
    @SerializedName("verification_uri")
    val verification_uri: String,

    /**
     * Verification URL with the user code prefilled as a query parameter.
     */
    @SerializedName("verification_uri_complete")
    val verification_uri_complete: String,

    /**
     * Lifetime of the device code and user code in seconds.
     */
    @SerializedName("expires_in")
    val expires_in: Long,

    /**
     * Minimum polling interval for the token endpoint in seconds.
     */
    @SerializedName("interval")
    val interval: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "device_code" to device_code as Any,
        "user_code" to user_code as Any,
        "verification_uri" to verification_uri as Any,
        "verification_uri_complete" to verification_uri_complete as Any,
        "expires_in" to expires_in as Any,
        "interval" to interval as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2DeviceAuthorization(
            device_code = (if (map.containsKey("device_code")) map["device_code"] else "") as String,
            user_code = (if (map.containsKey("user_code")) map["user_code"] else "") as String,
            verification_uri = (if (map.containsKey("verification_uri")) map["verification_uri"] else "") as String,
            verification_uri_complete = (if (map.containsKey("verification_uri_complete")) map["verification_uri_complete"] else "") as String,
            expires_in = ((if (map.containsKey("expires_in")) map["expires_in"] else 0) as Number).toLong(),
            interval = ((if (map.containsKey("interval")) map["interval"] else 0) as Number).toLong(),
        )
    }
}
