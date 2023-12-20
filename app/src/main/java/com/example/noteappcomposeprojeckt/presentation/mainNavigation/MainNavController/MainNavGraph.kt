package com.example.noteappcomposeprojeckt.presentation.mainNavigation.MainNavController

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteappcomposeprojeckt.presentation.Screens.onBoordingScreen.OnBoordingScreen
import com.example.noteappcomposeprojeckt.presentation.mainNavigation.ScreensNavController.ScreensNavController
import com.example.noteappcomposeprojeckt.presentation.Screens.MainScreen.MainScreen

@SuppressLint("NewApi")
@Composable
fun MainNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreensNavController.OnBoordingScreen.route,
    ) {
        composable(route = ScreensNavController.OnBoordingScreen.route) {
            OnBoordingScreen(onBoordingScreenNavController =
            {navController.navigate(ScreensNavController.MainScreen.route)},
            )
        }
        composable(route = ScreensNavController.MainScreen.route) {
            MainScreen(callBackScreen = {navController.popBackStack()})
        }
    }
}