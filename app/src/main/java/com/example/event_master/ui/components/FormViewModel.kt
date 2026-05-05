package com.example.event_master.ui.components

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel

class CategoriaViewMdole: ViewModel(){
    var tipo by mutableStateOf("")

    var listEvento = mutableListOf<Evento>()
    val listaBase = mutableListOf<Evento>(
        Evento(0,"Concierto UDEC","Concierto foro udec, 24 septiembre 2026. 20:30 Horas")
    )
    var nombre by mutableStateOf("")
    var detalle by mutableStateOf("")
    var id = 0
    var idEvento: Int = 0

    var listActividad = mutableListOf<Actividad>(
        Actividad("Musica", listaBase)
    )

    fun addActividad(){
        val auxLE = mutableListOf<Evento>()
        listActividad.add(Actividad(tipo,auxLE))
    }
    fun addEvento(){
        listActividad[idEvento].eventoLista.add(Evento(id,nombre,detalle))
    }

}

class Actividad(val tipo: String,val eventoLista: MutableList<Evento> = mutableListOf<Evento>())
class Evento(val id: Int, val nombre: String, val detalle: String)


// Consultar al profe viavilidad, Crear una clase Actividad que sea de tipo lista e id(automatica),
// en la cual se guarden las actividades (Id, Nombre, Descripcion).
// Los tipos de eventos se mostraran en el inicio como tarjetas, con una lista (tarjetas) de las
// actividades, al clickear o seleccionar una de las actividades desplegara informacion o se
// avanzara a la pagina descriptiva