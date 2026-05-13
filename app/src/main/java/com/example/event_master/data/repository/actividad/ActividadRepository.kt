package com.example.event_master.data.repository.actividad

import kotlinx.coroutines.flow.Flow
import com.example.event_master.ui.model.Actividad


interface ActividadRepository {
        fun obtenerTodosActividad(): Flow<List<Actividad>>
        suspend fun obtenerPorId(id: Int): Actividad
        //suspend fun obtenerPorId(actIDs: IntArray): List<Actividad>
        suspend fun buscarPorTipo(nombre: String): Actividad
        suspend fun insertarActividad(actividad: Actividad)
        suspend fun borrarActividad(actividad: Actividad)

}