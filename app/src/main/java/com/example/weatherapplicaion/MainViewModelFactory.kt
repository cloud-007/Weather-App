package com.example.weatherapplicaion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapplicaion.reposatory.Reposatory

class MainViewModelFactory(private val reposatory: Reposatory) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(reposatory) as T
    }
}