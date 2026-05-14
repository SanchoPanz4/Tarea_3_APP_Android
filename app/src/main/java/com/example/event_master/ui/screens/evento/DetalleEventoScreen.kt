package com.example.event_master.ui.screens.evento

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.event_master.R
import com.example.event_master.ui.navigation.Home
import com.example.event_master.ui.screens.forms.EventoViewModel

@Composable
fun DetalleEventoScreen(
    navController: NavHostController,
    categoriaEvento: String,
    idEvento: Int,
    formViewMdole: EventoViewModel = hiltViewModel()
) {
    val actividades by formViewMdole.actividades.collectAsStateWithLifecycle()

    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val actividad = actividades.find { it.tipo == categoriaEvento }
            val evento = actividad?.eventoLista?.getOrNull(idEvento)

            if (evento != null) {
                Text(text = "Categoría: ${actividad.tipo}")
                Text(text = "Evento: ${evento.nombre}")
                Text(text = "Detalle: ${evento.detalle}")
            } else {
                Text(text = "Evento no encontrado")
            }

            Button(
                onClick = { navController.navigate(Home) },
            ) {
                Text(stringResource(R.string.app_name))
            }
        }
    }
}
