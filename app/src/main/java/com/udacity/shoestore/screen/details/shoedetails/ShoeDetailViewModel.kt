package com.udacity.shoestore.screen.details.shoedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel : ViewModel() {

    private var _eventClicked = MutableLiveData<Pair<String, Shoe?>>()

    val eventClicked: LiveData<Pair<String, Shoe?>> get() = _eventClicked


    fun onSaveClicked(
        shoeName: String,
        companyName: String,
        shoeSize: String,
        shoeDescription: String
    ) {
        _eventClicked.value = Pair("Save", Shoe(shoeName, shoeSize, companyName, shoeDescription))
    }

    fun onCancelClicked() {
        _eventClicked.value = Pair("Cancel", null)
    }

}