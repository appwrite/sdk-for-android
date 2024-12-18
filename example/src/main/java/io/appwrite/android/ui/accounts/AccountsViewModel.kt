package io.appwrite.android.ui.accounts

import androidx.activity.ComponentActivity
import androidx.lifecycle.*
import io.appwrite.ID
import io.appwrite.android.services.MessagingService
import io.appwrite.android.utils.Client.client
import io.appwrite.android.utils.Event
import io.appwrite.enums.OAuthProvider
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.toJson
import io.appwrite.models.Target
import io.appwrite.services.Account
import kotlinx.coroutines.launch

class AccountsViewModel : ViewModel() {

    private val _error = MutableLiveData<Event<Exception>>().apply { value = null }
    val error: LiveData<Event<Exception>> = _error

    private val _response = MutableLiveData<Event<String>>().apply { value = null }
    val response: LiveData<Event<String>> = _response

    private val _target = MutableLiveData<Event<Target>>().apply { value = null }
    val target: LiveData<Event<Target>> = _target

    private val account by lazy {
        val account = Account(client)

        MessagingService.account = account

        account
    }

    fun onLogin(
        email: String,
        password: String,
        token: String?,
    ) {
        viewModelScope.launch {
            try {
                val session = account.createEmailPasswordSession(
                    email,
                    password
                )

                if (token != null) {
                    val target = account.createPushTarget(ID.unique(), token)

                    _target.postValue(Event(target))
                }

                _response.postValue(Event(session.toJson()))
            } catch (e: AppwriteException) {
                _error.postValue(Event(e))
            }
        }

    }

    fun onSignup(email: String, password: String, name: String) {
        viewModelScope.launch {
            try {
                val user = account.create(
                    ID.unique(),
                    email,
                    password,
                    name
                )
                _response.postValue(Event(user.toJson()))
            } catch (e: AppwriteException) {
                _error.postValue(Event(e))
            }
        }

    }

    fun oAuthLogin(activity: ComponentActivity) {
        viewModelScope.launch {
            try {
                account.createOAuth2Session(
                    activity,
                    OAuthProvider.FACEBOOK,
                    "appwrite-callback-6070749e6acd4://cloud.appwrite.io/auth/oauth2/success",
                    "appwrite-callback-6070749e6acd4://cloud.appwrite.io/auth/oauth2/failure"
                )
            } catch (e: Exception) {
                _error.postValue(Event(e))
            } catch (e: AppwriteException) {
                _error.postValue(Event(e))
            }
        }
    }

    fun getUser() {
        viewModelScope.launch {
            try {
                val user = account.get()
                _response.postValue(Event(user.toJson()))
            } catch (e: AppwriteException) {
                _error.postValue(Event(e))
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            try {
                val result = account.deleteSession("current")
                _response.postValue(Event(result.toJson()))
            } catch (e: AppwriteException) {
                _error.postValue(Event(e))
            }
        }
    }
}