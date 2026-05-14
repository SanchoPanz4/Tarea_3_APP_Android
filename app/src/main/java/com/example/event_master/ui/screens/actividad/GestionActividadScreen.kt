package com.example.event_master.ui.screens.actividad

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.event_master.R
import com.example.event_master.ui.navigation.Home

@Composable
fun GestionActividadScreen(formViewModel: ActividadViewModel = hiltViewModel(), navController: NavHostController)
{
    Scaffold(
    ) {innerPadding->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = formViewModel.tipo,
                onValueChange = {formViewModel.tipo = it},
                label = { Text((stringResource(R.string.tipo_label))) },
                isError = formViewModel.tipo.isBlank() || formViewModel.tipo.length <5
            )
            Spacer(modifier = Modifier.size(22.dp))
            Button(onClick = {
                formViewModel.insertarActividad()
            },
            ) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "icono",
                    tint = Color.White
                )
                Text(stringResource(R.string.agregarActividad_label))
            }
            Button(onClick = {navController.navigate(Home)},
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "icono",
                    tint = Color.White
                )
                Text(stringResource(R.string.app_name))
            }
        }
    }
}