import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Account
import io.appwrite.enums.OAuthProvider

val client = Client(context)
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val account = Account(client)

account.createOAuth2Session(
    provider = OAuthProvider.AMAZON,
    success = "{$example}", // (optional)
    failure = "{$example}", // (optional)
    scopes = listOf(), // (optional)
)