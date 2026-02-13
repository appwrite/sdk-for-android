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
class Organizations(client: Client) : Service(client) {

    /**
     * Delete an organization.
     *
     * @param organizationId Team ID.
     * @return [Any]
     */
    suspend fun delete(
        organizationId: String,
    ): Any {
        val apiPath = "/organizations/{organizationId}"
            .replace("{organizationId}", organizationId)

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


    /**
     * Get a billing address using it's ID.
     *
     * @param organizationId Organization ID
     * @param billingAddressId Unique ID of billing address
     * @return [io.appwrite.models.BillingAddress]
     */
    suspend fun getBillingAddress(
        organizationId: String,
        billingAddressId: String,
    ): io.appwrite.models.BillingAddress {
        val apiPath = "/organizations/{organizationId}/billing-addresses/{billingAddressId}"
            .replace("{organizationId}", organizationId)
            .replace("{billingAddressId}", billingAddressId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.BillingAddress = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.BillingAddress.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.BillingAddress::class.java,
            converter,
        )
    }


    /**
     * Get estimation for deleting an organization.
     *
     * @param organizationId Team ID.
     * @return [io.appwrite.models.EstimationDeleteOrganization]
     */
    suspend fun estimationDeleteOrganization(
        organizationId: String,
    ): io.appwrite.models.EstimationDeleteOrganization {
        val apiPath = "/organizations/{organizationId}/estimations/delete-organization"
            .replace("{organizationId}", organizationId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.EstimationDeleteOrganization = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.EstimationDeleteOrganization.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.EstimationDeleteOrganization::class.java,
            converter,
        )
    }


    /**
     * Submit feedback about downgrading from a paid plan to a lower tier. This helps the team understand user experience and improve the platform.
     * 
     *
     * @param organizationId Organization Unique ID
     * @param reason Feedback reason
     * @param message Feedback message
     * @param fromPlanId Plan downgrading from
     * @param toPlanId Plan downgrading to
     * @return [io.appwrite.models.DowngradeFeedback]
     */
    suspend fun createDowngradeFeedback(
        organizationId: String,
        reason: String,
        message: String,
        fromPlanId: String,
        toPlanId: String,
    ): io.appwrite.models.DowngradeFeedback {
        val apiPath = "/organizations/{organizationId}/feedbacks/downgrade"
            .replace("{organizationId}", organizationId)

        val apiParams = mutableMapOf<String, Any?>(
            "reason" to reason,
            "message" to message,
            "fromPlanId" to fromPlanId,
            "toPlanId" to toPlanId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DowngradeFeedback = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.DowngradeFeedback.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DowngradeFeedback::class.java,
            converter,
        )
    }


    /**
     * Get an organization's payment method using it's payment method ID.
     *
     * @param organizationId Organization ID
     * @param paymentMethodId Unique ID of payment method
     * @return [io.appwrite.models.PaymentMethod]
     */
    suspend fun getPaymentMethod(
        organizationId: String,
        paymentMethodId: String,
    ): io.appwrite.models.PaymentMethod {
        val apiPath = "/organizations/{organizationId}/payment-methods/{paymentMethodId}"
            .replace("{organizationId}", organizationId)
            .replace("{paymentMethodId}", paymentMethodId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.PaymentMethod = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.PaymentMethod.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.PaymentMethod::class.java,
            converter,
        )
    }


}