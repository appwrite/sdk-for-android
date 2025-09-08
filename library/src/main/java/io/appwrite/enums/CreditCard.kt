package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class CreditCard(val value: String) {
    @SerializedName("amex")
    AMERICAN_EXPRESS("amex"),
    @SerializedName("argencard")
    ARGENCARD("argencard"),
    @SerializedName("cabal")
    CABAL("cabal"),
    @SerializedName("cencosud")
    CENCOSUD("cencosud"),
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
    @SerializedName("unionpay")
    UNION_PAY("unionpay"),
    @SerializedName("visa")
    VISA("visa"),
    @SerializedName("mir")
    MIR("mir"),
    @SerializedName("maestro")
    MAESTRO("maestro"),
    @SerializedName("rupay")
    RUPAY("rupay");

    override fun toString() = value
}