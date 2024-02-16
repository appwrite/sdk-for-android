package io.appwrite.enums

enum class CreditCard(val value: String) {
    AMERICAN_EXPRESS("amex"),
    ARGENCARD("argencard"),
    CABAL("cabal"),
    CONSOSUD("censosud"),
    DINERS_CLUB("diners"),
    DISCOVER("discover"),
    ELO("elo"),
    HIPERCARD("hipercard"),
    JCB("jcb"),
    MASTERCARD("mastercard"),
    NARANJA("naranja"),
    TARJETA_SHOPPING("targeta-shopping"),
    UNION_CHINA_PAY("union-china-pay"),
    VISA("visa"),
    MIR("mir"),
    MAESTRO("maestro");

    override fun toString() = value
}