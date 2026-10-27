# Appwrite Android SDK

![Maven Central](https://img.shields.io/maven-central/v/io.appwrite/sdk-for-android.svg?color=green&style=flat-square)
![License](https://img.shields.io/badge/license-BSD--3--Clause-blue.svg?style=flat-square)
![Version](https://img.shields.io/badge/api%20version-2.6.2-blue.svg?style=flat-square)
[![X Account](https://img.shields.io/badge/follow-%40appwrite-000000?logo=x&style=flat-square)](https://x.com/appwrite)
[![Discord](https://img.shields.io/discord/564160730845151244?label=discord&style=flat-square)](https://appwrite.io/discord)

**This SDK targets Appwrite server version 2.6.x as shipped on Appwrite Cloud.** Self-hosted releases can lag behind Cloud — if you run an older self-hosted build, use a matching older SDK from [previous releases](https://github.com/appwrite/sdk-for-android/releases) when APIs differ.

Appwrite is an open-source backend as a service server that abstracts and simplifies complex and repetitive development tasks behind a very simple to use REST API. Appwrite aims to help you develop your apps faster and in a more secure way. Use the Android SDK to integrate your app with the Appwrite server to easily start interacting with all of Appwrite backend APIs and tools. For full API documentation and tutorials go to [https://appwrite.io/docs](https://appwrite.io/docs)

![Appwrite](https://github.com/appwrite/appwrite/raw/main/public/images/github.png)

## Installation

The SDK requires Android 7.0 (API level 24) or later and is published to Maven Central as `io.appwrite:sdk-for-android`. Make sure `mavenCentral()` is among your repositories (new Android Studio projects include it in `settings.gradle.kts`), then add the dependency to your app module's build file.

Kotlin DSL (`build.gradle.kts`):

```kotlin
dependencies {
    implementation("io.appwrite:sdk-for-android:31.1.0")
}
```

Groovy (`build.gradle`):

```groovy
dependencies {
    implementation 'io.appwrite:sdk-for-android:31.1.0'
}
```

### Code shrinking (R8)

The SDK ships the R8 rules it needs, so no extra configuration is required. Your own classes that the SDK fills from JSON (the `nestedType` of documents, rows and preferences, and the `payloadType` of Realtime subscriptions) are read by Gson through reflection. Annotate them with `@Keep` so R8 keeps their fields:

```kotlin
@Keep
data class Note(val title: String, val body: String)
```

## Getting Started

### Install the SDK

Add SDK 31.0.1 to your app module's `build.gradle.kts`:

```kotlin
implementation("io.appwrite:sdk-for-android:31.0.1")
```

### Add your Android platform

To let your app talk to Appwrite, register it as a platform. In the [Appwrite Console](https://cloud.appwrite.io/console), open your project (create one if you haven't already), click **Add platform** and choose **Android**.

Enter your app's name and package name. The package name is the `applicationId` in your app module's `build.gradle.kts` file.

### Init your SDK

Initialize the client with your Appwrite endpoint and project ID, both of which are on your project's settings page.

```kotlin
import io.appwrite.Client

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1")
    .setProject("<PROJECT_ID>")
```

If you self-host Appwrite, use your own endpoint instead, such as `https://appwrite.example.com/v1`. On the Android emulator, `localhost` is the emulator itself: use `10.0.2.2` to reach your development machine, or a tunnel such as [ngrok](https://ngrok.com/). Call `.setSelfSigned(true)` only while developing against a server with a self-signed certificate.

### Make your first request

Service methods are `suspend` functions, so call them from a coroutine, for example `lifecycleScope` in an activity:

```kotlin
import androidx.lifecycle.lifecycleScope
import io.appwrite.ID
import io.appwrite.services.Account
import kotlinx.coroutines.launch

val account = Account(client)

lifecycleScope.launch {
    val user = account.create(
        userId = ID.unique(),
        email = "email@example.com",
        password = "password",
        name = "Walter O'Brien",
    )
}
```

### Error handling

Failed requests throw an `AppwriteException` with `message`, `code`, `type` and `response` properties:

```kotlin
import android.util.Log
import io.appwrite.exceptions.AppwriteException

lifecycleScope.launch {
    try {
        val user = account.get()
        Log.d("Appwrite", user.name)
    } catch (e: AppwriteException) {
        Log.e("Appwrite", "${e.code} ${e.type}: ${e.message}")
    }
}
```

### OAuth login

To create OAuth sessions with `createOAuth2Session` or `createOAuth2Token`, add the SDK's callback activity inside the `<application>` tag of your `AndroidManifest.xml`. Replace `<PROJECT_ID>` with your Appwrite project ID, which you can find in your project settings.

```xml
<activity android:name="io.appwrite.views.CallbackActivity" android:exported="true">
    <intent-filter android:label="android_web_auth">
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        <data android:scheme="appwrite-callback-<PROJECT_ID>" />
    </intent-filter>
</activity>
```

Then start the flow from your activity:

```kotlin
import io.appwrite.enums.OAuthProvider

lifecycleScope.launch {
    account.createOAuth2Session(
        activity = this@MainActivity,
        provider = OAuthProvider.GITHUB,
    )
}
```

### Using the SDK from Java

From Java, pass a `CoroutineCallback` as the last argument instead of calling the method from a coroutine. Request failures arrive as the callback's `error`; most methods also declare `AppwriteException`, which Java treats as checked, for invalid arguments. The callback runs on a background thread, so switch to the main thread before touching views.

```java
import android.util.Log;

import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Account;

Account account = new Account(client);

try {
    account.get(new CoroutineCallback<>((user, error) -> {
        if (error != null) {
            Log.e("Appwrite", error.getMessage());
            return;
        }

        Log.d("Appwrite", user.getName());
    }));
} catch (AppwriteException e) {
    Log.e("Appwrite", e.getMessage());
}
```

### Type safety with models

Methods that return rows, such as `listRows` and `getRow`, accept a `nestedType` so that each row's `data` is your own class:

```kotlin
import io.appwrite.services.TablesDB

data class Book(
    val name: String,
    val author: String,
    val releaseYear: String? = null,
    val genre: List<String>? = null,
    val isCheckedOut: Boolean,
)

val tablesDB = TablesDB(client)

val result = tablesDB.listRows(
    databaseId = "<DATABASE_ID>",
    tableId = "<TABLE_ID>",
    nestedType = Book::class.java,
)

for (row in result.rows) {
    val book = row.data
    Log.d("Appwrite", "${book.name} by ${book.author}")
}
```

From Java, pass the class before the callback:

```java
tablesDB.listRows(
    "<DATABASE_ID>",
    "<TABLE_ID>",
    Book.class,
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            Log.e("Appwrite", error.getMessage());
            return;
        }

        for (Row<Book> row : result.getRows()) {
            Log.d("Appwrite", row.getData().getName());
        }
    })
);
```

Use `appwrite types` from the [Appwrite CLI](https://appwrite.io/docs/tooling/command-line/installation) to generate these model classes from your database schema. Learn more about [type generation](https://appwrite.io/docs/products/databases/tablesdb/type-generation).

Every model also has `toMap()`, which is handy for logging or manual data handling:

```kotlin
val user = account.get()
Log.d("Appwrite", user.toMap().toString())
```

### Realtime client ownership

In SDK 31.0.1 and later, each `Client` owns its realtime connection, subscriptions, presence, and reconnect state. Separate clients can use different endpoints, projects, or JWTs independently. Configure `setJWT()` before creating a JWT-authenticated subscription.

`Realtime` objects created with the same client share that connection. Disconnecting it affects that client's realtime subscriptions. Close an individual subscription to stop only that subscription; use separate clients for independently managed connections.

## Push notifications

`Push` subscribes to topics over the Appwrite push broker. With no topic it subscribes to the signed-in user's own topic:

```kotlin
import io.appwrite.services.Push

val push = Push(client, context)

val subscription = push.subscribe { message ->
    Log.d("Appwrite", "${message.topic}: ${message.data}")
}
```

Keep `subscription` while you want messages, and call `subscription.unsubscribe()` when you stop listening, for example in your activity's `onDestroy()`.

### Background delivery

A subscription with `background = true` keeps delivering after the app is backgrounded, its process is killed, or the device restarts, until it is unsubscribed or `push.close()` is called (do this on sign-out). No service is kept running: a scheduled job and alarm wake the app every 15 to 60 seconds to reconnect, and the broker replays what was sent in between (`retry = true`). It reconnects with the credential saved at subscribe time, so use a session (`client.setSession(...)`), not a short-lived JWT.

While the app is not on screen, each message is also posted as a notification that opens your launch activity with `Push.EXTRA_TOPIC` and `Push.EXTRA_PAYLOAD` in its extras. It shows the title, body and image sent with `createPush`, falling back to the subscription's `title`, and to the raw payload as the body for messages that are not a JSON object. A push with neither a title nor a body, such as a data-only push, posts no notification; it still reaches your callback or `PushReceiver`.

On Android 13 and later it needs the `POST_NOTIFICATIONS` permission: the first background subscription asks for it from the visible activity (the one `Push` is created with, else the next one to resume), or call `Push.requestNotificationPermission(activity)` to ask yourself. Set its icon with `<meta-data android:name="io.appwrite.push.notification_icon" android:resource="@drawable/..." />` in your `<application>`.

While the app is on screen your callback shows the message, so no notification is posted unless the subscription passes `notifyInForeground = true`. To handle messages that arrive while no callback is listening in code, subclass `PushReceiver` and declare it with the `io.appwrite.push.MESSAGE` action (see its docs).

### Delivery while the app is closed

Messages sent while the app is closed arrive at the next scheduled wake-up. While the device is awake that is about every 15 seconds, or about every 60 seconds once exact alarms are allowed; without exact alarms the wake-ups are inexact, so battery saver can defer them further. In Doze (screen off and idle for a while) Android limits background alarms, exact ones included, to about one every nine minutes, so a closed app can take several minutes to receive a message: allowing exact alarms makes wake-ups punctual, it does not lift Doze. For immediate delivery, also in Doze, use `push.setForeground(true)` (see below).

The SDK uses exact alarms on its own whenever the app may schedule them. To allow it:

1. Declare the permissions in your app's `AndroidManifest.xml`. Both are optional and subject to Google Play policy: `SCHEDULE_EXACT_ALARM` needs a declaration in the Play Console, and `USE_EXACT_ALARM` is reserved for alarm, clock and calendar apps (the SDK does not use it).

   ```xml
   <uses-permission android:name="android.permission.SCHEDULE_EXACT_ALARM" />
   <uses-permission android:name="android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS" />
   ```

2. On Android 13 and later the user has to allow exact alarms, under Settings > Apps > Special app access > Alarms & reminders. Android 12 grants a declared `SCHEDULE_EXACT_ALARM` automatically, and older versions need nothing. Check with `Push.backgroundStatus(context)`: when `bestEffort` is true, explain why to the user, then from a user action open that screen with `Push.requestExactAlarms(context)`, or ask for the battery-optimisation exemption with `Push.requestIgnoreBatteryOptimizations(context)`. Both return false when there is nothing to ask, including when the permission is not declared. The SDK never opens these screens on its own.

If `backgroundRestricted` is true, the user restricted the app's background usage and messages can wait until the app is opened. Exact alarms don't lift it, and neither does foreground mode: Android stops a restricted app's foreground service once it leaves the screen. Ask the user to choose Unrestricted in the app's battery settings (Settings > Apps > your app > Battery); granting the battery optimisation exemption also lets the SDK's alarms and jobs run, and `bestEffort` then reflects only the exact-alarm state.

If the user force-stops the app (Settings > Force stop, and on some devices swiping it away from recents), Android cancels its alarms and jobs: nothing is delivered until the app is opened again, and the broker then replays what was sent meanwhile.

For immediate delivery even after a kill and during Doze, call `push.setForeground(true)` from the foreground: it adds a foreground service with a quiet ongoing notification. If you never enable it, you can remove the service from your merged manifest, so the Play Console does not ask you to declare it:

```xml
<service android:name="io.appwrite.services.PushService" tools:node="remove" />
<uses-permission android:name="android.permission.FOREGROUND_SERVICE_REMOTE_MESSAGING" tools:node="remove" />
```

### Opening a tapped notification

Read the `data` sent with `createPush` when the user taps a background notification:

```kotlin
// The tap that launched the app (reported once, so call it at startup).
push.getInitialNotification()?.let { openSale(it.data["saleId"]) }

// Taps while the app is running, including in the background.
val stop = push.onNotificationOpened { opened -> openSale(opened.data["saleId"]) }
```

A tap made while nothing listens is kept for `getInitialNotification()`. The tap intent still carries `Push.EXTRA_TOPIC` and `Push.EXTRA_PAYLOAD` for apps that read their activity's intent.

## Learn more

- [Android quick start](https://appwrite.io/docs/quick-starts/android) and [Java quick start](https://appwrite.io/docs/quick-starts/android-java)
- [Android SDK reference](https://appwrite.io/docs/references/cloud/client-android-kotlin/account)
- [Appwrite docs](https://appwrite.io/docs)
- [Discord community](https://appwrite.io/discord)

## Contribution

This library is auto-generated by the Appwrite [SDK Generator](https://github.com/appwrite/sdk-generator). To learn how you can help improve this SDK, please read the [contribution guide](https://github.com/appwrite/sdk-generator/blob/main/CONTRIBUTING.md) before sending a pull request.

## License

Please see the [BSD-3-Clause license](https://raw.githubusercontent.com/appwrite/appwrite/master/LICENSE) file for more information.
