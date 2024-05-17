package com.example.nytimes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.details.navigation.detailsScreen
import com.example.details.navigation.navigateToDetails
import com.example.home.presentation.navigation.HOME_ROUTE
import com.example.home.presentation.navigation.homeScreen


@Composable
fun NavigationSystem() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        builder = {
            homeScreen(
                onArticleClick = {
                    navController.navigateToDetails(it)
                }
            )
            detailsScreen {
                navController.popBackStack(HOME_ROUTE, false)
            }
        }
    )

}





