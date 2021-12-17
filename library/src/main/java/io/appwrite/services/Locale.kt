package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Locale(client: Client) : Service(client) {

    /**
     * Get User Locale
     *
     * Get the current user location based on IP. Returns an object with user
     * country code, country name, continent name, continent code, ip address and
     * suggested currency. You can use the locale header to get the data in a
     * supported language.
     * 
     * ([IP Geolocation by DB-IP](https://db-ip.com))
     *
     * @return [io.appwrite.models.Locale]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun get(): io.appwrite.models.Locale {
        val path = "/locale"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Locale = {
            io.appwrite.models.Locale.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Locale::class.java,
            convert = convert
        )
    }
    
    /**
     * List Continents
     *
     * List of all continents. You can use the locale header to get the data in a
     * supported language.
     *
     * @return [io.appwrite.models.ContinentList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getContinents(): io.appwrite.models.ContinentList {
        val path = "/locale/continents"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.ContinentList = {
            io.appwrite.models.ContinentList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.ContinentList::class.java,
            convert = convert
        )
    }
    
    /**
     * List Countries
     *
     * List of all countries. You can use the locale header to get the data in a
     * supported language.
     *
     * @return [io.appwrite.models.CountryList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getCountries(): io.appwrite.models.CountryList {
        val path = "/locale/countries"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.CountryList = {
            io.appwrite.models.CountryList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.CountryList::class.java,
            convert = convert
        )
    }
    
    /**
     * List EU Countries
     *
     * List of all countries that are currently members of the EU. You can use the
     * locale header to get the data in a supported language.
     *
     * @return [io.appwrite.models.CountryList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getCountriesEU(): io.appwrite.models.CountryList {
        val path = "/locale/countries/eu"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.CountryList = {
            io.appwrite.models.CountryList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.CountryList::class.java,
            convert = convert
        )
    }
    
    /**
     * List Countries Phone Codes
     *
     * List of all countries phone codes. You can use the locale header to get the
     * data in a supported language.
     *
     * @return [io.appwrite.models.PhoneList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getCountriesPhones(): io.appwrite.models.PhoneList {
        val path = "/locale/countries/phones"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.PhoneList = {
            io.appwrite.models.PhoneList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.PhoneList::class.java,
            convert = convert
        )
    }
    
    /**
     * List Currencies
     *
     * List of all currencies, including currency symbol, name, plural, and
     * decimal digits for all major and minor currencies. You can use the locale
     * header to get the data in a supported language.
     *
     * @return [io.appwrite.models.CurrencyList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getCurrencies(): io.appwrite.models.CurrencyList {
        val path = "/locale/currencies"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.CurrencyList = {
            io.appwrite.models.CurrencyList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.CurrencyList::class.java,
            convert = convert
        )
    }
    
    /**
     * List Languages
     *
     * List of all languages classified by ISO 639-1 including 2-letter code, name
     * in English, and name in the respective language.
     *
     * @return [io.appwrite.models.LanguageList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getLanguages(): io.appwrite.models.LanguageList {
        val path = "/locale/languages"
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.LanguageList = {
            io.appwrite.models.LanguageList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.LanguageList::class.java,
            convert = convert
        )
    }
    
}