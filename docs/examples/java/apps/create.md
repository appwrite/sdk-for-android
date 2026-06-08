```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Apps;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Apps apps = new Apps(client);

apps.create(
    "<APP_ID>", // appId 
    "<NAME>", // name 
    List.of(), // redirectUris 
    false, // enabled (optional)
    "public", // type (optional)
    false, // deviceFlow (optional)
    "<TEAM_ID>", // teamId (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

```
