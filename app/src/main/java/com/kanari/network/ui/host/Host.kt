package com.kanari.network.ui.host

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kanari.network.ui.screens.chat.ChatScreen
import com.kanari.network.ui.screens.home.RootHomeScreen
import com.kanari.network.ui.screens.notifications.NotifiScreen
import com.kanari.network.ui.screens.search.RootSearchScreen

@Composable
fun Host(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "Home",
        Modifier.fillMaxSize()
    ) {
        composable( "Home") {
            RootHomeScreen(navController)
        }
        composable("Search") {
            RootSearchScreen(navController)
        }
        composable("Chat") {
            ChatScreen(navController)
        }
        composable("Noti") {
            NotifiScreen(navController)
        }

    }
}