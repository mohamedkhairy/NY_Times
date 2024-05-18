package com.example.details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.details.screens.DetailsRoute
import com.example.sharedData.model.Article
import com.example.utils.core.jsonParse

const val DETAILS_ROUTE_BASE = "details_route"

const val ARTICLE_DETAILS_ARG = "ARTICLE_DETAILS_ARG"

const val DETAILS_ROUTE = "$DETAILS_ROUTE_BASE?$ARTICLE_DETAILS_ARG={$ARTICLE_DETAILS_ARG}"

fun NavController.navigateToDetails(article: String?, navOptions: NavOptions? = null) {
    val route = if (!article.isNullOrEmpty()) {
        "${DETAILS_ROUTE_BASE}?${ARTICLE_DETAILS_ARG}=$article"
    } else {
        DETAILS_ROUTE_BASE
    }
    navigate(route, navOptions)
}


fun NavGraphBuilder.detailsScreen(
    onBackClick: () -> Unit
) {
    composable(
        route = DETAILS_ROUTE,
        arguments = listOf(
            navArgument(ARTICLE_DETAILS_ARG) {
                type = NavType.StringType
            },
        ),
    ) {

        val article = it.arguments?.getString(ARTICLE_DETAILS_ARG)
        DetailsRoute(
            article = article?.jsonParse<Article>(),
            onBackClick = onBackClick
        )
    }
}
