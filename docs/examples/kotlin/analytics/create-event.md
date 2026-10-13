```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Analytics

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val analytics = Analytics(client)

val result = analytics.createEvent(
    propertyId = "<PROPERTY_ID>", 
    name = "<NAME>", 
    url = "https://example.com", 
    domain = "<DOMAIN>", // (optional)
    referrer = "<REFERRER>", // (optional)
    screenWidth = 0, // (optional)
    sessionHash = "<SESSION_HASH>", // (optional)
    scrollDepth = 0, // (optional)
    engagementTime = 0, // (optional)
    props = listOf(), // (optional)
    userId = "<USER_ID>", // (optional)
    ip = "<IP>", // (optional)
    userAgent = "<USER_AGENT>", // (optional)
)
```
