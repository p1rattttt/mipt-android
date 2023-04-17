package com.p1rat.android.screen.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

sealed class SignUpEvent {
    data class ChangeUsername(val newUsername: String) : SignUpEvent()
    data class ChangePassword(val newPassword: String) : SignUpEvent()
    data class ChangeEmail(val newEmail: String) : SignUpEvent()
    object ChangeKeepSigned : SignUpEvent()
    object ChangeEmailAboutPricing : SignUpEvent()
}

data class SignUpState(
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var keepSigned: Boolean = true,
    var emailAboutPricing: Boolean = true
)

class SignUpScreenViewModel : ViewModel() {
    private val _viewState: MutableLiveData<SignUpState> = MutableLiveData(SignUpState())
    val viewState: LiveData<SignUpState> = _viewState

    fun obtainEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.ChangeEmail -> {
                _viewState.postValue(_viewState.value?.copy(email = event.newEmail))
            }
            is SignUpEvent.ChangePassword -> {
                _viewState.postValue(_viewState.value?.copy(password = event.newPassword))
            }
            is SignUpEvent.ChangeUsername -> {
                _viewState.postValue(_viewState.value?.copy(username = event.newUsername))
            }
            SignUpEvent.ChangeKeepSigned -> {
                val prev = _viewState.value?.keepSigned
                _viewState.postValue(prev?.let { _viewState.value?.copy(keepSigned = !it) })

            }
            SignUpEvent.ChangeEmailAboutPricing -> {
                val prev = _viewState.value?.emailAboutPricing
                _viewState.postValue(prev?.let { _viewState.value?.copy(emailAboutPricing = !it) })
            }
            else -> {}
        }
    }
}