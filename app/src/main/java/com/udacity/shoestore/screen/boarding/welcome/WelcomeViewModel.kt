package com.udacity.shoestore.screen.boarding.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {


    private val _eventClicked = MutableLiveData<Boolean>()

    val eventClicked: LiveData<Boolean> get() = _eventClicked


    fun onContinueClicked() {
        _eventClicked.value = true
    }

    fun onEventCompleted() {
        _eventClicked.value = false
    }

}