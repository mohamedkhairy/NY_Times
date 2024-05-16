package com.example.home.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.ui.component.AppLoading
import com.example.core.ui.component.dialog.PixabayInfoDialog
import com.example.core.ui.component.scaffold.NYTimesScaffold
import com.example.home.presentation.components.ArticleCardItem
import com.example.home.presentation.components.PeriodsDropdownMenu
import com.example.sharedData.enums.Periods
import com.example.sharedData.model.Article
import com.example.utils.core.ActionState
import com.example.utils.core.UiState
import com.example.utils.core.toJsonString


@Composable
internal fun HomeSearchRoute(
    onImageClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    searchViewModel: HomeSearchViewModel = hiltViewModel(),
) {
    val searchResultUiState by searchViewModel.searchResultUiState.collectAsStateWithLifecycle()
    val actionState by searchViewModel.actionState.collectAsStateWithLifecycle()
    val searchQuery by searchViewModel.searchQuery.collectAsStateWithLifecycle()


    HomeSearchScreen(
        onImageClick = onImageClick,
        modifier = modifier,
        actionState = actionState,
        searchQuery = searchQuery,
        searchResultUiState = searchResultUiState,
        onPeriodChanged = searchViewModel::onPeriodChanged,
        onActionStateChanged = searchViewModel::onActionStateChanged
    )
}

@Composable
fun HomeSearchScreen(
    onImageClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    actionState: ActionState,
    searchQuery: String,
    searchResultUiState: UiState<List<Article>?>,
    onPeriodChanged: (String?) -> Unit = {},
    onActionStateChanged: (ActionState) -> Unit = {},


    ) {
//    var searchText by remember { mutableStateOf(searchQuery) }

    NYTimesScaffold(
        content = {


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(MaterialTheme.colorScheme.background)
            ) {

//                OutlinedTextField(
//                    value = searchText,
//                    onValueChange = {
//                        searchText = it
//                        onPeriodChanged(it)
//                    },
//                    label = { Text("Enter search keyword") },
//                    singleLine = true,
//                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
//                    keyboardActions = KeyboardActions(onSearch = {
//                        // Perform search operation here
//                        onPeriodChanged(searchText)
//                    }),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(bottom = 16.dp)
//                )



                when (searchResultUiState) {
                    is UiState.Error -> {
                        Log.d("hhhhh", "Error")

                        searchResultUiState.throwable?.printStackTrace()
                        ViewStateMessage("can't find any result")
                    }

                    is UiState.Ideal -> {
                        Log.d("hhhhh", "Ideal")

                        ViewStateMessage("Please, enter at least 2 chars")
                    }

                    is UiState.Loading -> {
                        Log.d("hhhhh", "Loading")

                        AppLoading(isLoading = searchResultUiState.isLoading)
                    }

                    is UiState.Success -> {
                        Log.d("hhhhh", "Success")
                        if (searchResultUiState.data.isNullOrEmpty()) {
                            ViewStateMessage("can't find any result")
                        } else {
                            SearchResultView(
                                onImageClick = onImageClick,
                                actionState = actionState,
                                articleList = searchResultUiState.data!!,
                                onActionStateChanged = onActionStateChanged
                            )

                        }
                    }
                    else ->{  Log.d("hhhhh", "else") }

                }


            }


        }, icon = {
            PeriodsDropdownMenu(
                listOf(Periods.LAST_DAY,Periods.LAST_WEEK,Periods.LAST_MONTH)
            ){
                onPeriodChanged(it)
            }

        }
    )


}

@Composable
internal fun SearchResultView(
    onImageClick: (String) -> Unit,
    actionState: ActionState,
    articleList: List<Article>,
    onActionStateChanged: (ActionState) -> Unit = {},
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.fillMaxWidth(),
        columns = GridCells.Fixed(2), // Set number of columns

    ) {
        items(items = articleList) { article ->
            ArticleCardItem(article = article, openDetails = {
                onActionStateChanged(ActionState.ACTION)
            })
            when (actionState) {
                ActionState.NONE -> {
                    PixabayInfoDialog(
                        visibility = false,
                        goToImageDetails = {},
                        onCancel = {})
                }

                ActionState.ACTION -> {
                    PixabayInfoDialog(
                        goToImageDetails = {
                            onImageClick(article.toJsonString())
                            Log.d("hhhhh", "${article.title}")
                            onActionStateChanged(ActionState.NONE)
                        },
                        onCancel = { onActionStateChanged(ActionState.NONE) }
                    )
                }
            }
        }
    }
}

@Composable
fun ViewStateMessage(msg: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = msg,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
fun PreviewImageSearchScreen() {
}
