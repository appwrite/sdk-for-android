```java
import android.util.Log;

import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Oauth2;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Oauth2 oauth2 = new Oauth2(client);

oauth2.createDeviceAuthorization(
    "<CLIENT_ID>", // client_id (optional)
    "<SCOPE>", // scope (optional)
    "<AUTHORIZATION_DETAILS>", // authorization_details (optional)
    "", // resource (optional)
    "<AUDIENCE>", // audience (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

```
