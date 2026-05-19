```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Presences

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val presences = Presences(client)

val result = presences.list(
    queries = listOf(), // (optional)
    total = false, // (optional)
    ttl = 0, // (optional)
)
```
