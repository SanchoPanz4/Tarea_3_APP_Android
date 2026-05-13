package com.example.event_master.data.repository.actividad

import com.example.event_master.data.local.AppDatabase
import com.example.event_master.data.local.entity.ActividadEntity
import com.example.event_master.ui.model.Actividad
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ActividadRepositoryImpl @Inject constructor(
    private val db: AppDatabase
):ActividadRepository{
    override fun obtenerTodosActividad(): Flow<List<Actividad>>{
        return db.actividadDao().obtenerTodos().map {listaEntities ->
            listaEntities.map{entity -> entity.toDomain()}
        }
    }

    override suspend fun obtenerPorId(id: Int): Actividad{
        return db.actividadDao().obtenerPorId(id).toDomain()
    }

    override suspend fun buscarPorTipo(nombre: String): Actividad{
        return db.actividadDao().buscarPorTipo(nombre).toDomain()
    }
    override suspend fun insertarActividad(actividad: Actividad){
        return db.actividadDao().insertarActividad(actividad.toEntity())
    }
    override suspend fun borrarActividad(actividad: Actividad){
        return db.actividadDao().borrarActividad(actividad.toEntity())
    }
}

fun ActividadEntity.toDomain() = Actividad(
    id = this.id,
    tipo = this.tipo,
    eventoLista = this.eventoLista
)
fun Actividad.toEntity() = ActividadEntity(
    id = this.id,
    tipo = this.tipo,
    eventoLista = this.eventoLista
)