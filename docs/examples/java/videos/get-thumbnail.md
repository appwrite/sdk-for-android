```java
import android.util.Log;

import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Videos;
import io.appwrite.enums.ImageFormat;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Videos videos = new Videos(client);

try {
    videos.getThumbnail(
        "<VIDEO_ID>", // videoId
        "<THUMBNAIL_ID>", // thumbnailId
        0L, // width (optional)
        0L, // height (optional)
        ImageFormat.JPG, // output (optional)
        new CoroutineCallback<>((result, error) -> {
            if (error != null) {
                error.printStackTrace();
                return;
            }

            Log.d("Appwrite", result.toString());
        })
    );
} catch (AppwriteException e) {
    e.printStackTrace();
}
```
