```java
import android.util.Log;

import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Oauth2;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Oauth2 oauth2 = new Oauth2(client);

oauth2.createToken(
    "<GRANT_TYPE>", // grant_type 
    "<CODE>", // code (optional)
    "<REFRESH_TOKEN>", // refresh_token (optional)
    "<DEVICE_CODE>", // device_code (optional)
    "<CLIENT_ID>", // client_id (optional)
    "<CLIENT_SECRET>", // client_secret (optional)
    "<CODE_VERIFIER>", // code_verifier (optional)
    "https://example.com", // redirect_uri (optional)
    List.of(), // resource (optional)
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
