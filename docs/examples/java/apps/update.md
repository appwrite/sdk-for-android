```java
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
    false, // enabled (optional)
    List.of(), // redirectUris (optional)
    "public", // type (optional)
    false, // deviceFlow (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

```
