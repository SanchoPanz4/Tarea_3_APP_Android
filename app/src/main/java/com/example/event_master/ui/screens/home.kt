package com.example.event_master.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.event_master.R
import com.example.event_master.ui.components.CategoriaViewMdole
import com.example.event_master.ui.navigation.Detalle
import com.example.event_master.ui.navigation.Gestion
import com.example.event_master.ui.navigation.Registro


@Composable
fun HomeScreen(formViewModel: CategoriaViewMdole, navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {

                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Button(
                        onClick = {navController.navigate(Gestion)}
                    ) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "icono",
                            tint = Color.White
                        )
                        Text(stringResource(R.string.agregarActividad_label)) }
                    Spacer(modifier = Modifier.size(22.dp))
                    Button(
                        onClick = {navController.navigate(Registro)}
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "icono",
                            tint = Color.White
                        )
                        Text(stringResource(R.string.agregarEvento_label)) }
                }

            }
        }
        )
    { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 1),
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(formViewModel.listActividad){
                    Card(
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                ){
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = "icono",
                                    tint = Color.White
                                )
                                Text(it.tipo)
                            }


                            for(element in it.eventoLista) {
                                Card(
                                    onClick = {navController.navigate(Detalle(element.id, it.tipo), )}
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 20.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(element.nombre)
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}