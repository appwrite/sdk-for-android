package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import java.io.File

class Avatars(client: Client) : Service(client) {

    /**
     * Get Browser Icon
     *
     * You can use this endpoint to show different browser icons to your users.
     * The code argument receives the browser code as it appears in your user
     * /account/sessions endpoint. Use width, height and quality arguments to
     * change the output settings.
     *
     * @param code Browser Code.
     * @param width Image width. Pass an integer between 0 to 2000. Defaults to 100.
     * @param height Image height. Pass an integer between 0 to 2000. Defaults to 100.
     * @param quality Image quality. Pass an integer between 0 to 100. Defaults to 100.
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getBrowser(
		code: String,
		width: Long? = null,
		height: Long? = null,
		quality: Long? = null
	): ByteArray {
        val path = "/avatars/browsers/{code}".replace("{code}", code)
        val params = mapOf<String, Any?>(
            "width" to width,
            "height" to height,
            "quality" to quality,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            path,
            params = params,
            responseType = ByteArray::class.java
        )
    }
    
    /**
     * Get Credit Card Icon
     *
     * The credit card endpoint will return you the icon of the credit card
     * provider you need. Use width, height and quality arguments to change the
     * output settings.
     *
     * @param code Credit Card Code. Possible values: amex, argencard, cabal, censosud, diners, discover, elo, hipercard, jcb, mastercard, naranja, targeta-shopping, union-china-pay, visa, mir, maestro.
     * @param width Image width. Pass an integer between 0 to 2000. Defaults to 100.
     * @param height Image height. Pass an integer between 0 to 2000. Defaults to 100.
     * @param quality Image quality. Pass an integer between 0 to 100. Defaults to 100.
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getCreditCard(
		code: String,
		width: Long? = null,
		height: Long? = null,
		quality: Long? = null
	): ByteArray {
        val path = "/avatars/credit-cards/{code}".replace("{code}", code)
        val params = mapOf<String, Any?>(
            "width" to width,
            "height" to height,
            "quality" to quality,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            path,
            params = params,
            responseType = ByteArray::class.java
        )
    }
    
    /**
     * Get Favicon
     *
     * Use this endpoint to fetch the favorite icon (AKA favicon) of any remote
     * website URL.
     * 
     *
     * @param url Website URL which you want to fetch the favicon from.
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFavicon(
		url: String
	): ByteArray {
        val path = "/avatars/favicon"
        val params = mapOf<String, Any?>(
            "url" to url,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            path,
            params = params,
            responseType = ByteArray::class.java
        )
    }
    
    /**
     * Get Country Flag
     *
     * You can use this endpoint to show different country flags icons to your
     * users. The code argument receives the 2 letter country code. Use width,
     * height and quality arguments to change the output settings.
     *
     * @param code Country Code. ISO Alpha-2 country code format.
     * @param width Image width. Pass an integer between 0 to 2000. Defaults to 100.
     * @param height Image height. Pass an integer between 0 to 2000. Defaults to 100.
     * @param quality Image quality. Pass an integer between 0 to 100. Defaults to 100.
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFlag(
		code: String,
		width: Long? = null,
		height: Long? = null,
		quality: Long? = null
	): ByteArray {
        val path = "/avatars/flags/{code}".replace("{code}", code)
        val params = mapOf<String, Any?>(
            "width" to width,
            "height" to height,
            "quality" to quality,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            path,
            params = params,
            responseType = ByteArray::class.java
        )
    }
    
    /**
     * Get Image from URL
     *
     * Use this endpoint to fetch a remote image URL and crop it to any image size
     * you want. This endpoint is very useful if you need to crop and display
     * remote images in your app or in case you want to make sure a 3rd party
     * image is properly served using a TLS protocol.
     *
     * @param url Image URL which you want to crop.
     * @param width Resize preview image width, Pass an integer between 0 to 2000.
     * @param height Resize preview image height, Pass an integer between 0 to 2000.
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getImage(
		url: String,
		width: Long? = null,
		height: Long? = null
	): ByteArray {
        val path = "/avatars/image"
        val params = mapOf<String, Any?>(
            "url" to url,
            "width" to width,
            "height" to height,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            path,
            params = params,
            responseType = ByteArray::class.java
        )
    }
    
    /**
     * Get User Initials
     *
     * Use this endpoint to show your user initials avatar icon on your website or
     * app. By default, this route will try to print your logged-in user name or
     * email initials. You can also overwrite the user name if you pass the 'name'
     * parameter. If no name is given and no user is logged, an empty avatar will
     * be returned.
     * 
     * You can use the color and background params to change the avatar colors. By
     * default, a random theme will be selected. The random theme will persist for
     * the user's initials when reloading the same theme will always return for
     * the same initials.
     *
     * @param name Full Name. When empty, current user name or email will be used. Max length: 128 chars.
     * @param width Image width. Pass an integer between 0 to 2000. Defaults to 100.
     * @param height Image height. Pass an integer between 0 to 2000. Defaults to 100.
     * @param color Changes text color. By default a random color will be picked and stay will persistent to the given name.
     * @param background Changes background color. By default a random color will be picked and stay will persistent to the given name.
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getInitials(
		name: String? = null,
		width: Long? = null,
		height: Long? = null,
		color: String? = null,
		background: String? = null
	): ByteArray {
        val path = "/avatars/initials"
        val params = mapOf<String, Any?>(
            "name" to name,
            "width" to width,
            "height" to height,
            "color" to color,
            "background" to background,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            path,
            params = params,
            responseType = ByteArray::class.java
        )
    }
    
    /**
     * Get QR Code
     *
     * Converts a given plain text to a QR code image. You can use the query
     * parameters to change the size and style of the resulting image.
     *
     * @param text Plain text to be converted to QR code image.
     * @param size QR code size. Pass an integer between 0 to 1000. Defaults to 400.
     * @param margin Margin from edge. Pass an integer between 0 to 10. Defaults to 1.
     * @param download Return resulting image with &#039;Content-Disposition: attachment &#039; headers for the browser to start downloading it. Pass 0 for no header, or 1 for otherwise. Default value is set to 0.
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getQR(
		text: String,
		size: Long? = null,
		margin: Long? = null,
		download: Boolean? = null
	): ByteArray {
        val path = "/avatars/qr"
        val params = mapOf<String, Any?>(
            "text" to text,
            "size" to size,
            "margin" to margin,
            "download" to download,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            path,
            params = params,
            responseType = ByteArray::class.java
        )
    }
    
}