package io.appwrite.example_java;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import org.jetbrains.annotations.NotNull;
import io.appwrite.Client;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.extensions.JsonExtensionsKt;
import io.appwrite.models.Session;
import io.appwrite.services.Account;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Client client = new Client(getApplicationContext())
                .setEndpoint("https://demo.appwrite.io/v1")
                .setProject("6070749e6acd4");

        Account account = new Account(client);

        try {
            account.createSession("test7@test.com","password", new Continuation<Session>() {
                @NotNull
                @Override
                public CoroutineContext getContext() {
                    return EmptyCoroutineContext.INSTANCE;
                }

                @Override
                public void resumeWith(@NotNull Object o) {
                    try {
                        if (o instanceof Result.Failure) {
                            Result.Failure failure = (Result.Failure) o;
                            throw failure.exception;
                        } else {
                            Session session = (Session) o;
                            Log.d("RESPONSE", JsonExtensionsKt.toJson(session));
                        }
                    } catch (Throwable th) {
                        Log.e("ERROR", th.toString());
                    }
                }
            });
        } catch (AppwriteException e) {
            e.printStackTrace();
        }
    }
}