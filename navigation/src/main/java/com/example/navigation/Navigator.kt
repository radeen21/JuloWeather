package com.example.navigation

import androidx.navigation.NavController

class Navigator {
    lateinit var navController: NavController

    fun navigateToFlow(navigationFlow: NavigationFlow) = when (navigationFlow) {
        is NavigationFlow.HomeFlow -> navController.navigate(NavGraphMainDirections.actionAuthNavHome(navigationFlow.title))
    }
}