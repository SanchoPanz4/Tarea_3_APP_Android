package com.example.event_master.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.event_master.ui.screens.HomeScreen
import com.example.event_master.ui.screens.list.ListScreen
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Detalle(val idEvento: Int,val Tipo: String)
@Serializable
object Gestion

@Serializable
object Registro


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(navController)
        }
        composable<Guest> { backstackEntry ->
            val args = backstackEntry.toRoute<Guest>()
            GuestScreen(name = args.name)
        }
        composable<Form> {
            FormScreen(navController = navController)
        }
        composable<ListUser> {
            ListScreen()
        }
    }
}