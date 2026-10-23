```java
import android.util.Log;

import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.Permission;
import io.appwrite.Role;
import io.appwrite.services.Storage;
import java.util.List;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Storage storage = new Storage(client);

try {
    storage.updateFile(
        "<BUCKET_ID>", // bucketId
        "<FILE_ID>", // fileId
        "", // name (optional)
        List.of(Permission.read(Role.any())), // permissions (optional)
        new CoroutineCallback<>((result, error) -> {
            if (error != null) {
                error.printStackTrace();
                return;
            }

            Log.d("Appwrite", result.toString());
        })
    );
} catch (AppwriteException e) {
    e.printStackTrace();
}
```
