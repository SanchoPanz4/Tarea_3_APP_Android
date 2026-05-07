package com.example.event_master.data.repository.actividad

import com.example.event_master.data.local.entity.ActividadEntity
import kotlinx.coroutines.flow.Flow

interface ActividadRepository {
        fun obtenerTodos(): Flow<List<ActividadEntity>>

        suspend fun obtenerPorId(id: Int): ActividadEntity
        suspend fun obtenerPorId(actIDs: IntArray): List<ActividadEntity>
        suspend fun buscarPorTipo(nombre: String): ActividadEntity
        suspend fun insertarActividad(vararg actividad: ActividadEntity)
        suspend fun borrar(usuario: ActividadEntity)


}