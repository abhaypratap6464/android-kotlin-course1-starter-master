package com.udacity.shoestore.screen.details.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {

    private val _eventClicked = MutableLiveData<Boolean>()

    val eventClicked: LiveData<Boolean> get() = _eventClicked

    fun onFloatingButtonClicked() {
        _eventClicked.value = true
    }

    fun onEventCompleted() {
        _eventClicked.value = false
    }
}