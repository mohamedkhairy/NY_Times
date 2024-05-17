package com.example.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.ui.component.ViewStateMessage
import com.example.core.ui.component.dialog.PixabayInfoDialog
import com.example.core.ui.component.scaffold.NYTimesScaffold
import com.example.home.presentation.components.ArticleCardItem
import com.example.home.presentation.components.PeriodsDropdownMenu
import com.example.home.presentation.components.shimmerLoading.HomeShimmer
import com.example.home.domain.enums.Periods.Companion.periodList
import com.example.sharedData.model.Article
import com.example.utils.core.ActionState
import com.example.utils.core.UiState
import com.example.utils.core.toJsonString


@Composable
internal fun HomeScreenRoute(
    onArticleClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    searchViewModel: HomeViewModel = hiltViewModel(),
) {
    val searchResultUiState by searchViewModel.searchResultUiState.collectAsStateWithLifecycle()
    val actionState by searchViewModel.actionState.collectAsStateWithLifecycle()
    val periodQuery by searchViewModel.periodQuery.collectAsStateWithLifecycle()


    HomeScreen(
        onArticleClick = onArticleClick,
        actionState = actionState,
        periodQuery = periodQuery,
        searchResultUiState = searchResultUiState,
        onPeriodChanged = searchViewModel::onPeriodChanged,
        onActionStateChanged = searchViewModel::onActionStateChanged
    )
}

@Composable
fun HomeScreen(
    onArticleClick: (String) -> Unit,
    actionState: ActionState,
    periodQuery: String,
    searchResultUiState: UiState<List<Article>?>,
    onPeriodChanged: (String?) -> Unit = {},
    onActionStateChanged: (ActionState) -> Unit = {},


    ) {

    NYTimesScaffold(
        content = {


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(MaterialTheme.colorScheme.background)
            ) {

                when (searchResultUiState) {
                    is UiState.Error -> {
                        ViewStateMessage("can't find any result")
                    }

                    is UiState.Ideal -> {
                        ViewStateMessage("Please, enter at least 2 chars")
                    }

                    is UiState.Loading -> {
                        HomeShimmer()
                    }

                    is UiState.Success -> {
                        if (searchResultUiState.data.isNullOrEmpty()) {
                            ViewStateMessage("can't find any result")
                        } else {
                            ArticlesResultView(
                                onImageClick = onArticleClick,
                                actionState = actionState,
                                articleList = searchResultUiState.data!!,
                                onActionStateChanged = onActionStateChanged
                            )

                        }
                    }
                }


            }


        }, icon = {
            PeriodsDropdownMenu(
                periodList(),
                periodQuery
            ){
                onPeriodChanged(it)
            }

        }
    )


}

@Composable
internal fun ArticlesResultView(
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
                            onActionStateChanged(ActionState.NONE)
                        },
                        onCancel = { onActionStateChanged(ActionState.NONE) }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewImageSearchScreen() {
}
