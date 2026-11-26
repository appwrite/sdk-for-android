```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Videos
import io.appwrite.Permission
import io.appwrite.Role

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val videos = Videos(client)

val result = videos.update(
    videoId = "<VIDEO_ID>", 
    name = "<NAME>", // (optional)
    permissions = listOf(Permission.read(Role.any())), // (optional)
)
```
