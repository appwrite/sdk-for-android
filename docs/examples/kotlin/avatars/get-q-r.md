import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Avatars

val client = Client(context)
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("5df5acd0d48c2") // Your project ID

val avatars = Avatars(client)

val result = avatars.getQR(
    text = "<TEXT>", 
    size = 1, // (optional)
    margin = 0, // (optional)
    download = false, // (optional)
)