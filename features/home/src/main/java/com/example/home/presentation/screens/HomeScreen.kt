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
import com.example.core.ui.component.scaffold.NYTimesScaffold
import com.example.home.domain.enums.Periods.Companion.periodList
import com.example.home.presentation.components.ArticleCardItem
import com.example.home.presentation.components.PeriodsDropdownMenu
import com.example.home.presentation.components.shimmerLoading.HomeShimmer
import com.example.sharedData.model.Article
import com.example.utils.core.UiState
import com.example.utils.core.toJsonString


@Composable
internal fun HomeScreenRoute(
    onArticleClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val resultUiState by homeViewModel.resultUiState.collectAsStateWithLifecycle()
    val periodQuery by homeViewModel.periodQuery.collectAsStateWithLifecycle()


    HomeScreen(
        onArticleClick = onArticleClick,
        periodQuery = periodQuery,
        resultUiState = resultUiState,
        onPeriodChanged = homeViewModel::onPeriodChanged,
    )
}

@Composable
fun HomeScreen(
    onArticleClick: (String) -> Unit,
    periodQuery: String,
    resultUiState: UiState<List<Article>?>,
    onPeriodChanged: (String?) -> Unit = {},
    ) {

    NYTimesScaffold(
        content = {


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(MaterialTheme.colorScheme.background)
            ) {

                when (resultUiState) {
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
                        if (resultUiState.data.isNullOrEmpty()) {
                            ViewStateMessage("can't find any result")
                        } else {
                            ArticlesResultView(
                                onArticleClick = onArticleClick,
                                articleList = resultUiState.data!!,
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
    onArticleClick: (String) -> Unit,
    articleList: List<Article>,
    ) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.fillMaxWidth(),
        columns = GridCells.Fixed(2), // Set number of columns

    ) {
        items(items = articleList) { article ->
            ArticleCardItem(article = article, openDetails = {
                onArticleClick(it.toJsonString())
            })
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
}
