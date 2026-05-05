package com.example.event_master.data.repository.evento

import com.example.event_master.ui.components.Evento
import kotlinx.coroutines.flow.Flow

interface EventoRepository {
    interface UsuarioRepository {
        fun obtenerTodosUsuarios(): Flow<List<Evento>>
        suspend fun obtenerPorId(id: Int): Evento?
        suspend fun insertarUsuario(usuario: Evento)
        suspend fun borrarUsuario(usuario: Evento)
    }
}