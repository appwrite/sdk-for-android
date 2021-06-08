# Appwrite Kotlin SDK

![License](https://img.shields.io/github/license/appwrite/sdk-for-android.svg?style=flat-square)
![Version](https://img.shields.io/badge/api%20version-0.8.0-blue.svg?style=flat-square)
[![Twitter Account](https://img.shields.io/twitter/follow/appwrite_io?color=00acee&label=twitter&style=flat-square)](https://twitter.com/appwrite_io)
[![Discord](https://img.shields.io/discord/564160730845151244?label=discord&style=flat-square)](https://appwrite.io/discord)

**This SDK is compatible with Appwrite server version 0.7.x. For older versions, please check previous releases.**

Appwrite is an open-source backend as a service server that abstract and simplify complex and repetitive development tasks behind a very simple to use REST API. Appwrite aims to help you develop your apps faster and in a more secure way. Use the Flutter SDK to integrate your app with the Appwrite server to easily start interacting with all of Appwrite backend APIs and tools. For full API documentation and tutorials go to https://appwrite.io/docs

![Appwrite](https://appwrite.io/v1/images/console.png)

## Installation

### Gradle
Add this to your root level `build.gradle(.kts)` file:

```groovy
repositories {
    maven { 
        url = "https://maven.pkg.github.com/appwrite/sdk-for-android"
        credentials {
           username = GITHUB_USER
           password = GITHUB_TOKEN
       }
    }
}
```

Add this to your project's `build.gradle(.kts)` file:

```groovy
implementation(".appwrite:0.8.0")
```

### Maven
Add this to your project's `pom.xml` file:

```xml
<dependencies>
    <dependency>
        <groupId></groupId>
        <artifactId>appwrite</artifactId>
        <version>0.0.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```



### Add your Android Platform
To init your SDK and start interacting with Appwrite services, you need to add a new Flutter platform to your project. To add a new platform, go to your Appwrite console, choose the project you created in the step before, and click the 'Add Platform' button.

From the options, choose to add a new **Flutter** platform and add your app credentials, ignoring iOS.

Add your app <u>name</u> and <u>package name</u>, Your package name is generally the applicationId in your app-level build.gradle file. By registering your new app platform, you are allowing your app to communicate with the Appwrite API.

### OAuth
In order to capture the Appwrite OAuth callback url, the following activity needs to be added to your [AndroidManifest.xml](https://github.com/appwrite/playground-for-flutter/blob/master/android/app/src/main/AndroidManifest.xml). Be sure to relpace the **[PROJECT_ID]** string with your actual Appwrite project ID. You can find your Appwrite project ID in you project settings screen in your Appwrite console.

```xml
<manifest>
    <application>
        <activity android:name="io.appwrite.views.CallbackActivity" >
            <intent-filter android:label="android_web_auth">
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />
                <data android:scheme="appwrite-callback-[PROJECT_ID]" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```

### Init your SDK

<p>Initialize your SDK code with your project ID, which can be found in your project settings page.

```kotlin
import io.appwrite.Client
import io.appwrite.services.Account

val client = Client(context)
  .setEndpoint("https://[HOSTNAME_OR_IP]/v1") // Your API Endpoint
  .setProject("5df5acd0d48c2") // Your project ID
  .setSelfSigned(true) // Remove in production
```

Before starting to send any API calls to your new Appwrite instance, make sure your Android emulators has network access to the Appwrite server hostname or IP address.

When trying to connect to Appwrite from an emulator or a mobile device, localhost is the hostname for the device or emulator and not your local Appwrite instance. You should replace localhost with your private IP as the Appwrite endpoint's hostname. You can also use a service like [ngrok](https://ngrok.com/) to proxy the Appwrite API.

### Make Your First Request

<p>Once your SDK object is set, access any of the Appwrite services and choose any request to send. Full documentation for any service method you would like to use can be found in your SDK documentation or in the API References section.

```kotlin
// Register User
val accountService = Account(client)
val user = accountService.create(
    "email@example.com", 
    "password"
)
```

### Full Example

```kotlin
import io.appwrite.Client
import io.appwrite.services.Account

val client = Client(context)
  .setEndpoint("https://[HOSTNAME_OR_IP]/v1") // Your API Endpoint
  .setProject("5df5acd0d48c2") // Your project ID
  .setSelfSigned(true) // Remove in production

val accountService = Account(client)
val user = accountService.create(
    "email@example.com", 
    "password"
)
```

### Learn more
You can use following resources to learn more and get help
- 📜 [Appwrite Docs](https://appwrite.io/docs)
- 💬 [Discord Community](https://appwrite.io/discord)
        

## Contribution

This library is auto-generated by Appwrite custom [SDK Generator](https://github.com/appwrite/sdk-generator). To learn more about how you can help us improve this SDK, please check the [contribution guide](https://github.com/appwrite/sdk-generator/blob/master/CONTRIBUTING.md) before sending a pull-request.

## License

Please see the [BSD-3-Clause license](https://raw.githubusercontent.com/appwrite/appwrite/master/LICENSE) file for more information.