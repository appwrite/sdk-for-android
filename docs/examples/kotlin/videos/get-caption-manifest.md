```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Videos
import io.appwrite.enums.VideoOutput

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val videos = Videos(client)

val result = videos.getCaptionManifest(
    videoId = "<VIDEO_ID>", 
    output = VideoOutput.HLS,
    captionId = "<CAPTION_ID>", 
)
```
