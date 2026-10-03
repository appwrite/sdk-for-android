```java
import android.util.Log;

import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Apps;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Apps apps = new Apps(client);

apps.update(
    "<APP_ID>", // appId 
    "<NAME>", // name 
    "<DESCRIPTION>", // description (optional)
    "https://example.com", // clientUri (optional)
    "https://example.com", // logoUri (optional)
    "https://example.com", // privacyPolicyUrl (optional)
    "https://example.com", // termsUrl (optional)
    List.of(), // contacts (optional)
    "<TAGLINE>", // tagline (optional)
    List.of(), // tags (optional)
    List.of(), // images (optional)
    "https://example.com", // supportUrl (optional)
    "https://example.com", // dataDeletionUrl (optional)
    false, // enabled (optional)
    List.of(), // redirectUris (optional)
    List.of(), // postLogoutRedirectUris (optional)
    "public", // type (optional)
    false, // deviceFlow (optional)
    List.of(), // installationScopes (optional)
    "https://example.com", // installationRedirectUrl (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

```
