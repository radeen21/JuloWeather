package com.example.navigation

sealed class NavigationFlow {
    class HomeFlow(val title: String) : NavigationFlow()
    class AddCityFlow(val title: String) : NavigationFlow()
}
