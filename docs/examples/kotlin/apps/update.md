```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Apps

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val apps = Apps(client)

val result = apps.update(
    appId = "<APP_ID>", 
    name = "<NAME>", 
    enabled = false, // (optional)
    redirectUris = listOf(), // (optional)
    type = "public", // (optional)
    deviceFlow = false, // (optional)
)
```
