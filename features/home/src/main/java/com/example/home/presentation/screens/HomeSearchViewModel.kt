package com.example.home.presentation.screens

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.domain.useCase.MostPopularUseCase
import com.example.sharedData.model.Article
import com.example.utils.core.ActionState
import com.example.utils.core.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class HomeSearchViewModel @Inject constructor(
    private val mostPopularUseCase: MostPopularUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {


    val searchQuery = savedStateHandle.getStateFlow(key = PERIODS_QUERY, initialValue = "30")
    val actionState = savedStateHandle.getStateFlow(key = ACTION, initialValue = ActionState.NONE)


//    init {
//        callMost()
//    }
    val searchResultUiState: StateFlow<UiState<List<Article>?>> =
        searchQuery.flatMapLatest { query ->
            Log.d("xxx", "query $query")
             mostPopularUseCase(query)
//            ddd.onEach {
//                Log.d("xxx", "ddd $it")
//
//            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiState.Ideal(),
        )

//    fun callMost(){
//        mostPopularUseCase(searchQuery.value)
//            .onEach {
//
//                when(it){
//                    is UiState.Error -> {
//                        Log.d("xxx", "Error onEach")
//                        it.throwable?.printStackTrace()
//                        Log.d("xxx", "Error onEach ${it.throwable?.message}")
//
//
//                    }
//                    is UiState.Ideal -> {
//                        Log.d("xxx", "IDEAL onEach")
//
//                    }
//                    is UiState.Loading -> {
//                        Log.d("xxx", "LOADING onEach")
//                    }
//                    is UiState.Success -> {
//                        Log.d("xxx", "SUCCESS onEach")
//
//
//                    }
//                }
//
//            }
//           .launchIn(viewModelScope)
//    }
////    fun onPeriodChanged(query: String?) {
////        searchQuery.flatMapLatest { query ->
////            if (query.length < SEARCH_QUERY_MIN_LENGTH) {
////                flowOf(UiState.Ideal())
////            } else {
////                mostPopularUseCase(query).collect()
////            }
////        }.stateIn(
////            scope = viewModelScope,
////            started = SharingStarted.WhileSubscribed(5_000),
////            initialValue = UiState.Ideal(),
////        )
////    }
    fun onPeriodChanged(query: String?) {
        savedStateHandle[PERIODS_QUERY] = query
    }

    fun onActionStateChanged(actionState: ActionState) {
        savedStateHandle[ACTION] = actionState
    }

}

private const val SEARCH_QUERY_MIN_LENGTH = 0
private const val PERIODS_QUERY = "periodQuery"
private const val ACTION = "action_state"