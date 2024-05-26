package com.example.svkapp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.layout1.ControllePage
import java.util.Date


enum class Routes() {
    Home,
    Login,
    CreateControlle,
    CreateRouteBon,
    editControlle,
    EditRouteBon,
    ViewHistory,
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    navController: NavHostController = rememberNavController()

) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.name,
    ) {
        composable(Routes.Home.name) {
            HomePage(
                onHistoryClick = { navController.navigate(Routes.ViewHistory.name) },
                onNewControlClick = { navController.navigate(Routes.CreateControlle.name) },
                onLogin = { navController.navigate(Routes.Login.name) },
                )
        }
        composable(Routes.Login.name) {
            LoginPage()
        }
        composable(Routes.CreateControlle.name) {
            ControllePage(
                onAddLaadbon = { navController.navigate(Routes.CreateRouteBon.name) },
                onShowLaadbon = { navController.navigate(Routes.EditRouteBon.name) },
                onSave = { navController.navigateUp() },
                onBack = { navController.navigateUp() })
        }
        composable(Routes.editControlle.name) {
            ControllePage(
                onAddLaadbon = { navController.navigate(Routes.CreateRouteBon.name) },
                onShowLaadbon = { navController.navigate(Routes.EditRouteBon.name) },
                onSave = { navController.navigateUp() },
                onBack = { navController.navigateUp() })
        }
        composable(Routes.CreateRouteBon.name) {
            RouteBonPage(
                isNew = true,
                onSave = { navController.navigateUp() },
                onCancel = { navController.navigateUp() })
        }
        composable(Routes.EditRouteBon.name) {
            RouteBonPage(
                onSave = { navController.navigateUp() },
                onCancel = { navController.navigateUp() })
        }
        composable(Routes.ViewHistory.name) {
            HistoryPage(
                historieItems = listOf<HistoryItem>(
                    HistoryItem("1211145364", Date()),
                    HistoryItem("12111445664", Date()),
                    HistoryItem("121114231264", Date(), canEdit = false),
                ),
                onEditHistoryItem = { navController.navigate(Routes.editControlle.name) },
                //TODO different than show
                onSHowHistoryItem = { navController.navigate(Routes.editControlle.name) },
            )
        }
    }
}