package com.example.got.view.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.got.model.response.CharacterResponse
import com.example.got.model.response.NetworkResponse
import com.example.got.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel(val repository: Repository) : ViewModel() {

    private val _characterResponse = MutableLiveData<CharacterResponse?>()
    val characterResponse: LiveData<CharacterResponse?> = _characterResponse
    private val _trataError = MutableLiveData<Unit>()
    val trataError: LiveData<Unit> = _trataError

    fun populaCharacters() = viewModelScope.launch {
        when(val response = repository.catchCharacters()){
            is NetworkResponse.Success -> {
                _characterResponse.value = response.data
            }
            is NetworkResponse.Failed -> {
                _trataError.value = Unit
            }
        }
    }

}