package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Locale service allows you to customize your app based on your users&#039; location.
**/
class Locale : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * Get User Locale
     *
     * Get the current user location based on IP. Returns an object with user country code, country name, continent name, continent code, ip address and suggested currency. You can use the locale header to get the data in a supported language.([IP Geolocation by DB-IP](https://db-ip.com))
     *
     * @return [io.appwrite.models.Locale]
     */
    suspend fun get(
    ): io.appwrite.models.Locale {
        val path = "/locale"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Locale = {
                io.appwrite.models.Locale.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Locale::class.java,
            converter,
        )
    }


    /**
     * List Continents
     *
     * List of all continents. You can use the locale header to get the data in a supported language.
     *
     * @return [io.appwrite.models.ContinentList]
     */
    suspend fun listContinents(
    ): io.appwrite.models.ContinentList {
        val path = "/locale/continents"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ContinentList = {
                io.appwrite.models.ContinentList.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.ContinentList::class.java,
            converter,
        )
    }


    /**
     * List Countries
     *
     * List of all countries. You can use the locale header to get the data in a supported language.
     *
     * @return [io.appwrite.models.CountryList]
     */
    suspend fun listCountries(
    ): io.appwrite.models.CountryList {
        val path = "/locale/countries"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.CountryList = {
                io.appwrite.models.CountryList.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.CountryList::class.java,
            converter,
        )
    }


    /**
     * List EU Countries
     *
     * List of all countries that are currently members of the EU. You can use the locale header to get the data in a supported language.
     *
     * @return [io.appwrite.models.CountryList]
     */
    suspend fun listCountriesEU(
    ): io.appwrite.models.CountryList {
        val path = "/locale/countries/eu"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.CountryList = {
                io.appwrite.models.CountryList.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.CountryList::class.java,
            converter,
        )
    }


    /**
     * List Countries Phone Codes
     *
     * List of all countries phone codes. You can use the locale header to get the data in a supported language.
     *
     * @return [io.appwrite.models.PhoneList]
     */
    suspend fun listCountriesPhones(
    ): io.appwrite.models.PhoneList {
        val path = "/locale/countries/phones"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.PhoneList = {
                io.appwrite.models.PhoneList.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.PhoneList::class.java,
            converter,
        )
    }


    /**
     * List Currencies
     *
     * List of all currencies, including currency symbol, name, plural, and decimal digits for all major and minor currencies. You can use the locale header to get the data in a supported language.
     *
     * @return [io.appwrite.models.CurrencyList]
     */
    suspend fun listCurrencies(
    ): io.appwrite.models.CurrencyList {
        val path = "/locale/currencies"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.CurrencyList = {
                io.appwrite.models.CurrencyList.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.CurrencyList::class.java,
            converter,
        )
    }


    /**
     * List Languages
     *
     * List of all languages classified by ISO 639-1 including 2-letter code, name in English, and name in the respective language.
     *
     * @return [io.appwrite.models.LanguageList]
     */
    suspend fun listLanguages(
    ): io.appwrite.models.LanguageList {
        val path = "/locale/languages"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.LanguageList = {
                io.appwrite.models.LanguageList.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.LanguageList::class.java,
            converter,
        )
    }


}