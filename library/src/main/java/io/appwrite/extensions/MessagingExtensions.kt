package io.appwrite.extensions

import io.appwrite.models.Notification
import io.appwrite.services.Messaging

private val callbacks: MutableList<(Notification) -> Unit> = mutableListOf()

internal fun onNotificationReceived(notification: Notification) {
    callbacks.forEach { it(notification) }
}

fun Messaging.onNotificationReceived(callback: (Notification) -> Unit) {
    callbacks.add(callback)
}