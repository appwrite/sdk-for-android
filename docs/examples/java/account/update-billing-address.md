```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Account;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Account account = new Account(client);

account.updateBillingAddress(
    "<BILLING_ADDRESS_ID>", // billingAddressId 
    "<COUNTRY>", // country 
    "<CITY>", // city 
    "<STREET_ADDRESS>", // streetAddress 
    "<ADDRESS_LINE2>", // addressLine2 (optional)
    "<STATE>", // state (optional)
    "<POSTAL_CODE>", // postalCode (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

```
