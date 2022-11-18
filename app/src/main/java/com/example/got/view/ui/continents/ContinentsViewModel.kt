package com.example.got.view.ui.continents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.got.model.response.CharacterResponse
import com.example.got.model.response.NetworkResponse
import com.example.got.repository.Repository
import kotlinx.coroutines.launch

class ContinentsViewModel(val repository: Repository) : ViewModel() {

    private val _continentsResponse = MutableLiveData<CharacterResponse?>()
    val continentsResponse: LiveData<CharacterResponse?> = _continentsResponse
    private val _trataError = MutableLiveData<Unit>()
    val trataError: LiveData<Unit> = _trataError

    fun fillContinents() = viewModelScope.launch {
        when(val response = repository.catchContinents()){
            is NetworkResponse.Success -> {
                _continentsResponse.value = response.data
            }
            is NetworkResponse.Failed -> {
                _trataError.value = Unit
            }
        }
    }
}