package com.example.event_master.ui.model

import com.example.event_master.ui.components.Evento

data class Actividad(
    var id : Int,
    val tipo: String,
    val eventoLista: MutableList<Evento>
)
