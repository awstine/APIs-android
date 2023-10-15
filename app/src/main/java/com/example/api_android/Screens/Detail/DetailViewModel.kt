package com.example.api_android.Screens.Detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_android.ThroneUtil.Resource
import com.example.api_android.data.remote.Repository.ThroneRepository
import com.example.api_android.data.remote.ThroneResponce
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val throneRepository: ThroneRepository,
) : ViewModel() {
    private val _characterDetailsUiState = MutableStateFlow(CharacterDetailsUiState())
    val characterDetailsUiState = _characterDetailsUiState.asStateFlow()

    fun getCharacterDetails(name: String) {
        viewModelScope.launch {
            _characterDetailsUiState.update {
                it.copy(
                    isLoading = true,
                )
            }

            //Added <*> after resource
            when (val result = throneRepository.) {
                is Resource.Error<*> -> {
                    _characterDetailsUiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message,
                        )
                    }
                }

                is Resource.Success<*> -> {
                    _characterDetailsUiState.update {
                        it.copy(
                            isLoading = false,
                            data = result.data?.firstOrNull(),
                        )
                    }
                }
            }
        }
    }
}

data class CharacterDetailsUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: ThroneResponce? = null,
)