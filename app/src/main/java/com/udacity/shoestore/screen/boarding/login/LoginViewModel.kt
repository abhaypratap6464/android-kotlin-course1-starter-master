package com.udacity.shoestore.screen.boarding.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _eventClicked = MutableLiveData<Boolean>()
    val eventClicked: LiveData<Boolean> get() = _eventClicked


    fun onRegisterClicked() {
        _eventClicked.value = true
    }


    fun onLoginClicked() {
        _eventClicked.value = true
    }

    fun onEventCompleted() {
        _eventClicked.value = false
    }

}