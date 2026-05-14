package com.example.event_master.data.repository.evento

import com.example.event_master.ui.model.Evento
import kotlinx.coroutines.flow.Flow

interface EventoRepository {

        fun obtenerTodosEventos(): Flow<List<Evento>>
        suspend fun obtenerPorId(id: Int): Evento?

        suspend fun insertarEvento(evento: Evento)
        suspend fun borrarEvento(evento: Evento)

}