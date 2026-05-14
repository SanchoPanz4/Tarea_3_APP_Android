package com.example.event_master.ui.screens.evento

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
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.event_master.R
import com.example.event_master.ui.navigation.Home
import com.example.event_master.ui.screens.forms.EventoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroEventoScreen(formViewMdole: EventoViewModel = hiltViewModel(), navController: NavHostController) {
    val actividades by formViewMdole.actividades.collectAsStateWithLifecycle()
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Dropdown para seleccionar tipo de actividad existente
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryEditable, true),
                    value = formViewMdole.tipo,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(stringResource(R.string.tipo_label)) },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    isError = formViewMdole.tipo.isBlank()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    actividades.forEach { actividad ->
                        DropdownMenuItem(
                            text = { Text(actividad.tipo) },
                            onClick = {
                                formViewMdole.tipo = actividad.tipo
                                expanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.size(22.dp))

            TextField(
                value = formViewMdole.nombre,
                onValueChange = { formViewMdole.nombre = it },
                label = { Text((stringResource(R.string.nombre_label))) },
                isError = formViewMdole.nombre.isBlank() || formViewMdole.nombre.length < 5
            )
            Spacer(modifier = Modifier.size(22.dp))

            TextField(
                value = formViewMdole.detalle,
                onValueChange = { formViewMdole.detalle = it },
                label = { Text((stringResource(R.string.descripcion_label))) },
                isError = formViewMdole.detalle.isBlank() || formViewMdole.detalle.length < 5
            )
            Spacer(modifier = Modifier.size(22.dp))

            Button(
                onClick = {
                    formViewMdole.insertarEvento {
                        navController.navigate(Home)
                    }
                },
                enabled = formViewMdole.tipo.isNotBlank() && formViewMdole.nombre.isNotBlank()
            ) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "icono",
                    tint = Color.White
                )

                Text(stringResource(R.string.agregarActividad_label))
            }
            Button(
                onClick = { navController.navigate(Home) },
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
