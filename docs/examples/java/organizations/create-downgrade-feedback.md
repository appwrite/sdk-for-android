```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Organizations;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Organizations organizations = new Organizations(client);

organizations.createDowngradeFeedback(
    "<ORGANIZATION_ID>", // organizationId 
    "<REASON>", // reason 
    "<MESSAGE>", // message 
    "<FROM_PLAN_ID>", // fromPlanId 
    "<TO_PLAN_ID>", // toPlanId 
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

```
