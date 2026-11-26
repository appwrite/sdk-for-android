```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Videos
import io.appwrite.enums.ImageFormat

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val videos = Videos(client)

val result = videos.getThumbnail(
    videoId = "<VIDEO_ID>", 
    thumbnailId = "<THUMBNAIL_ID>", 
    width = 0, // (optional)
    height = 0, // (optional)
    output = ImageFormat.JPG, // (optional)
)
```
