```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Apps

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val apps = Apps(client)

val result = apps.create(
    appId = "<APP_ID>", 
    name = "<NAME>", 
    redirectUris = listOf(), 
    enabled = false, // (optional)
    type = "public", // (optional)
    deviceFlow = false, // (optional)
    teamId = "<TEAM_ID>", // (optional)
)
```
