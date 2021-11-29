package com.example.weatherapplicaion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplicaion.Model.jsonFile.weather
import com.example.weatherapplicaion.reposatory.Reposatory
import kotlinx.coroutines.launch

class MainViewModel(private val reposatory: Reposatory) : ViewModel() {

    val myResponse: MutableLiveData<weather> = MutableLiveData()

    fun getData(city: String) {
        viewModelScope.launch {
            val response = reposatory.getData(city)
            myResponse.value = response
        }
    }
}