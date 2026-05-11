package com.example.event_master.ui.model


data class Actividad(
    var id : Int,
    val tipo: String,
    val eventoLista: MutableList<Evento>
)
