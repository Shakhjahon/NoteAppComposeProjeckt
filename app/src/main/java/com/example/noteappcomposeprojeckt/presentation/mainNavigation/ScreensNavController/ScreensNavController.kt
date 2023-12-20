package com.example.noteappcomposeprojeckt.presentation.mainNavigation.ScreensNavController

sealed class ScreensNavController(val route: String) {
    object OnBoordingScreen : ScreensNavController(route = "OnBoordingScreen")
    object MainScreen : ScreensNavController(route = "MainScreen")
}
