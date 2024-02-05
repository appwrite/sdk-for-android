package io.appwrite.android.ui.accounts

import android.text.Editable
import androidx.activity.ComponentActivity
import androidx.lifecycle.*
import io.appwrite.ID
import io.appwrite.android.utils.Client.client
import io.appwrite.android.utils.Event
import io.appwrite.enums.OAuthProvider
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.toJson
import io.appwrite.services.Account
import kotlinx.coroutines.launch

class AccountsViewModel : ViewModel() {

    private val _error = MutableLiveData<Event<Exception>>().apply {
        value = null
    }
    val error: LiveData<Event<Exception>> = _error

    private val _response = MutableLiveData<Event<String>>().apply {
        value = null
    }
    val response: LiveData<Event<String>> = _response

    private val accountService by lazy {
        Account(client)
    }

    fun onLogin(email: Editable, password: Editable) {
        viewModelScope.launch {
            try {
                val session = accountService.createEmailPasswordSession(
                    email.toString(),
                    password.toString()
                )
                _response.postValue(Event(session.toJson()))
            } catch (e: AppwriteException) {
                _error.postValue(Event(e))
            }
        }

    }

    fun onSignup(email: Editable, password: Editable, name: Editable) {
        viewModelScope.launch {
            try {
                val user = accountService.create(
                    ID.unique(),
                    email.toString(),
                    password.toString(),
                    name.toString()
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
                accountService.createOAuth2Session(
                    activity,
                    OAuthProvider.FACEBOOK,
                    "appwrite-callback-6070749e6acd4://demo.appwrite.io/auth/oauth2/success",
                    "appwrite-callback-6070749e6acd4://demo.appwrite.io/auth/oauth2/failure"
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
                val account = accountService.get()
                _response.postValue(Event(account.toJson()))
            } catch (e: AppwriteException) {
                _error.postValue(Event(e))
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            try {
                val result = accountService.deleteSession("current")
                _response.postValue(Event(result.toJson()))
            } catch (e: AppwriteException) {
                _error.postValue(Event(e))
            }
        }
    }
}