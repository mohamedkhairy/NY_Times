package com.example.home.presentation.screens

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.domain.useCase.MostPopularUseCase
import com.example.sharedData.model.Article
import com.example.utils.core.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mostPopularUseCase: MostPopularUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {


    val periodQuery = savedStateHandle.getStateFlow(key = PERIODS_QUERY, initialValue = "30")


    val resultUiState: StateFlow<UiState<List<Article>?>> =
        periodQuery.flatMapLatest { query ->
             mostPopularUseCase(query)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiState.Ideal(),
        )

    fun onPeriodChanged(query: String?) {
        savedStateHandle[PERIODS_QUERY] = query
    }


}

private const val PERIODS_QUERY = "periodQuery"
