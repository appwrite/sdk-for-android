package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class CreditCard(val value: String) {
    @SerializedName("amex")
    AMERICAN_EXPRESS("amex"),
    @SerializedName("argencard")
    ARGENCARD("argencard"),
    @SerializedName("cabal")
    CABAL("cabal"),
    @SerializedName("censosud")
    CONSOSUD("censosud"),
    @SerializedName("diners")
    DINERS_CLUB("diners"),
    @SerializedName("discover")
    DISCOVER("discover"),
    @SerializedName("elo")
    ELO("elo"),
    @SerializedName("hipercard")
    HIPERCARD("hipercard"),
    @SerializedName("jcb")
    JCB("jcb"),
    @SerializedName("mastercard")
    MASTERCARD("mastercard"),
    @SerializedName("naranja")
    NARANJA("naranja"),
    @SerializedName("targeta-shopping")
    TARJETA_SHOPPING("targeta-shopping"),
    @SerializedName("union-china-pay")
    UNION_CHINA_PAY("union-china-pay"),
    @SerializedName("visa")
    VISA("visa"),
    @SerializedName("mir")
    MIR("mir"),
    @SerializedName("maestro")
    MAESTRO("maestro");

    override fun toString() = value
}