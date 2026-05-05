package com.example.event_master.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
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
    val formViewModel = CategoriaViewMdole()
    NavHost(navController = navController, startDestination = Home)
    {
        composable<Home>
        {
            HomeScreen(formViewModel = formViewModel,navController = navController)
        }
        composable<Detalle>
        {backStackEntry ->
            val args = backStackEntry.toRoute<Detalle>()
            DetalleScreen(navController = navController,formViewMdole = formViewModel,args.Tipo, args.idEvento)
        }
        composable<Gestion>
        {backStackEntry->
            val args = backStackEntry.toRoute<Gestion>()
            GestionCategoriaScreen(formViewMdole = formViewModel, navController = navController)
        }
        composable<Registro>
        {backStackEntry ->
            val args = backStackEntry.toRoute<Registro>()
            RegistroEventoScreen(formViewModel , navController = navController)
        }
    }
}