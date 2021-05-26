package com.udacity.shoestore.screen.details.instruction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionViewModel : ViewModel() {

    private val _eventClicked = MutableLiveData<Boolean>()

    val eventClicked: LiveData<Boolean> get() = _eventClicked


    fun onContinueClicked() {
        _eventClicked.value = true
    }

    fun onEventCompleted() {
        _eventClicked.value = false
    }
}