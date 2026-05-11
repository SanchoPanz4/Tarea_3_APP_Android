package com.example.event_master.data.repository.actividad

import com.example.event_master.data.local.entity.ActividadEntity

import kotlinx.coroutines.flow.Flow
import com.example.event_master.ui.model.Actividad


interface ActividadRepository {
        fun obtenerTodos(): Flow<List<Actividad>>

        suspend fun obtenerPorId(id: Int): Actividad
        suspend fun obtenerPorId(actIDs: IntArray): List<Actividad>
        suspend fun buscarPorTipo(nombre: String): Actividad
        suspend fun insertarActividad(vararg actividad: Actividad)
        suspend fun borrar(usuario: Actividad)

}