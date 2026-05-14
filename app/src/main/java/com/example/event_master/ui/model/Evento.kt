package com.example.event_master.ui.model

data class Evento(
    val id: Int,
    val tipo: String,
    val nombre: String,
    val detalle: String,
    val fecha: Long
)