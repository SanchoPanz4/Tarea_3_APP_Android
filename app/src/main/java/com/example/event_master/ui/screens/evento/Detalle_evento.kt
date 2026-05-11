package com.example.event_master.ui.screens.evento

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.event_master.R
import com.example.event_master.ui.components.CategoriaViewMdole
import com.example.event_master.ui.navigation.Home

@Composable
fun DetalleScreen(navController: NavHostController, formViewMdole: CategoriaViewMdole, categoriaEvento: String, idEvento: Int)
{
    Scaffold(

    ) {innerPadding->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            var aux : Int = 0
            for(element in formViewMdole.listActividad){
                if(element.tipo == categoriaEvento){
                    aux = formViewMdole.listActividad.indexOf(element)
                }
            }

            Text(text=formViewMdole.listActividad[aux].eventoLista[idEvento].detalle)

            Button(onClick = {navController.navigate(Home)},
            ) {

                Text(stringResource(R.string.app_name))
            }



        }
        }
    }