```java
import android.util.Log;

import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Analytics;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Analytics analytics = new Analytics(client);

analytics.createEvent(
    "<PROPERTY_ID>", // propertyId 
    "<NAME>", // name 
    "https://example.com", // url 
    "<DOMAIN>", // domain (optional)
    "<REFERRER>", // referrer (optional)
    0L, // screenWidth (optional)
    "<SESSION_HASH>", // sessionHash (optional)
    0L, // scrollDepth (optional)
    0L, // engagementTime (optional)
    List.of(), // props (optional)
    "<USER_ID>", // userId (optional)
    "<IP>", // ip (optional)
    "<USER_AGENT>", // userAgent (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

```
