```java
import android.util.Log;

import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Functions;
import io.appwrite.enums.ExecutionMethod;
import java.util.Map;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Functions functions = new Functions(client);

try {
    functions.createExecution(
        "<FUNCTION_ID>", // functionId
        "<BODY>", // body (optional)
        false, // async (optional)
        "<PATH>", // path (optional)
        ExecutionMethod.GET, // method (optional)
        Map.of("a", "b"), // headers (optional)
        "<SCHEDULED_AT>", // scheduledAt (optional)
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
