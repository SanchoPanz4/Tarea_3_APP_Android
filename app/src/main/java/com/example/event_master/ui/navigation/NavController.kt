package com.example.event_master.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.event_master.ui.screens.HomeScreen
import com.example.event_master.ui.screens.actividad.GestionActividadScreen
import com.example.event_master.ui.screens.evento.DetalleEventoScreen
import com.example.event_master.ui.screens.evento.RegistroEventoScreen
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object Gestion

@Serializable
data class Detalle(val categoriaEvento: String, val idEvento: Int)

@Serializable
object Registro

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home){
        composable<Home> {
            HomeScreen(navController = navController)
        }
        composable<Gestion> {
            GestionActividadScreen(navController = navController)
        }
        composable<Registro> {
            RegistroEventoScreen(navController = navController)
        }
        composable<Detalle> { backStackEntry ->
            val detailRoute: Detalle = backStackEntry.toRoute()
            DetalleEventoScreen(
                navController = navController,
                categoriaEvento = detailRoute.categoriaEvento,
                idEvento = detailRoute.idEvento
            )
        }
    }
}
