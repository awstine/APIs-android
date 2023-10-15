package com.example.api_android.Screens.List

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_android.Screens.Detail.CharacterDetailsUiState
import com.example.api_android.ThroneUtil.Resource
import com.example.api_android.data.remote.Repository.ThroneRepository
import com.example.api_android.data.remote.ThroneResponce
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.internal.threadName
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val ThroneRepository: ThroneRepository,
) : ViewModel() {
    private val _throneCharacterUiState = MutableStateFlow(ThroneCharactersUiState())
    val throneCharactersUiState = _throneCharacterUiState.asStateFlow()

    fun getThroneCharacters() {
        viewModelScope.launch {
            _throneCharacterUiState.update {
                it.copy(isLoading = true)
            }
            when (val result = _throneCharacterUiState.getThroneCharacters()) {
                is Resource.Error<*> -> {
                    _throneCharacterUiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message,
                        )
                    }
                }

                is Resource.Success<*> -> {
                    _throneCharacterUiState.update {
                        it.copy(
                            isLoading = false,
                            data = result.data ?: emptyList(),
                        )
                    }
                }
            }
        }
    }

    init {
        getThroneCharacters()
    }
}

data class ThroneCharactersUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: List<ThroneResponce> = emptyList(),
)

