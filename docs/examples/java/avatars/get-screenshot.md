```java
import android.util.Log;

import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Avatars;
import io.appwrite.enums.BrowserTheme;
import io.appwrite.enums.Timezone;
import io.appwrite.enums.BrowserPermission;
import io.appwrite.enums.ImageFormat;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Avatars avatars = new Avatars(client);

avatars.getScreenshot(
    "https://example.com", // url 
    Map.of(
        "Accept-Language", "en-US,en;q=0.9"
    ), // headers (optional)
    1920L, // viewportWidth (optional)
    1080L, // viewportHeight (optional)
    2.0, // scale (optional)
    BrowserTheme.LIGHT, // theme (optional)
    "Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.15", // userAgent (optional)
    true, // fullpage (optional)
    "en-US", // locale (optional)
    Timezone.AFRICA_ABIDJAN, // timezone (optional)
    37.7749, // latitude (optional)
    -122.4194, // longitude (optional)
    100.0, // accuracy (optional)
    true, // touch (optional)
    BrowserPermission.GEOLOCATION, // permissions (optional)
    3L, // sleep (optional)
    800L, // width (optional)
    600L, // height (optional)
    85L, // quality (optional)
    ImageFormat.JPG, // output (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

```
