package io.appwrite.extensions

import kotlin.reflect.KClass
import kotlin.reflect.typeOf

inline fun <reified T : Any> classOf(): Class<T> {
    @Suppress("UNCHECKED_CAST")
    return (typeOf<T>().classifier!! as KClass<T>).java
}