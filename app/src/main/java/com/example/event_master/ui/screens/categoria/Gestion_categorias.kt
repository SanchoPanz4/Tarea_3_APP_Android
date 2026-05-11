package com.example.event_master.ui.screens.categoria

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
import androidx.navigation.NavHostController
import com.example.event_master.R
import com.example.event_master.ui.components.CategoriaViewMdole
import com.example.event_master.ui.navigation.Home

@Composable
fun GestionCategoriaScreen(formViewMdole: CategoriaViewMdole, navController: NavHostController){

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
                value = formViewMdole.tipo,
                onValueChange = {formViewMdole.tipo = it},
                label = { Text((stringResource(R.string.tipo_label))) },
                isError = formViewMdole.tipo.isBlank() || formViewMdole.tipo.length <5
            )
            Spacer(modifier = Modifier.size(22.dp))
            Button(onClick = {
                formViewMdole.addActividad()
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