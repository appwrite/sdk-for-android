```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Presences
import io.appwrite.Permission
import io.appwrite.Role

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val presences = Presences(client)

val result = presences.update(
    presenceId = "<PRESENCE_ID>", 
    status = "<STATUS>", // (optional)
    expiresAt = "2020-10-15T06:38:00.000+00:00", // (optional)
    metadata = mapOf( "a" to "b" ), // (optional)
    permissions = listOf(Permission.read(Role.any())), // (optional)
    purge = false, // (optional)
)
```
