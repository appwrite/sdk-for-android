```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.Permission;
import io.appwrite.Role;
import io.appwrite.services.Presences;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Presences presences = new Presences(client);

presences.upsert(
    "<PRESENCE_ID>", // presenceId 
    "<STATUS>", // status 
    List.of(Permission.read(Role.any())), // permissions (optional)
    "2020-10-15T06:38:00.000+00:00", // expiresAt (optional)
    Map.of("a", "b"), // metadata (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

```
