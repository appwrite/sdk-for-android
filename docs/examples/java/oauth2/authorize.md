```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Oauth2;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProjectQuery("<YOUR_PROJECT_ID>"); // Your project ID

Oauth2 oauth2 = new Oauth2(client);

oauth2.authorize(
    "<PROJECT_ID>", // project_id 
    "<CLIENT_ID>", // client_id 
    "https://example.com", // redirect_uri 
    "code", // response_type 
    "<SCOPE>", // scope 
    "<STATE>", // state (optional)
    "<NONCE>", // nonce (optional)
    "<CODE_CHALLENGE>", // code_challenge (optional)
    "s256", // code_challenge_method (optional)
    "<PROMPT>", // prompt (optional)
    0, // max_age (optional)
    "<AUTHORIZATION_DETAILS>", // authorization_details (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

```
