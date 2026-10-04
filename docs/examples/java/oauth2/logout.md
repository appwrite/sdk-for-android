```java
import android.util.Log;

import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Oauth2;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Oauth2 oauth2 = new Oauth2(client);

oauth2.logout(
    "<ID_TOKEN_HINT>", // id_token_hint (optional)
    "<LOGOUT_HINT>", // logout_hint (optional)
    "<CLIENT_ID>", // client_id (optional)
    "https://example.com", // post_logout_redirect_uri (optional)
    "<STATE>", // state (optional)
    "<UI_LOCALES>", // ui_locales (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

```
