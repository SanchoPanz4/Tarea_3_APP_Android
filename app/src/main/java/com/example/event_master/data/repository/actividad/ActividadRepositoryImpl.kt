package com.example.event_master.data.repository.actividad


import com.example.event_master.data.local.AppDatabase
import com.example.event_master.data.local.entity.ActividadEntity
import com.example.event_master.data.local.entity.EventoEntity
import com.example.event_master.ui.model.Actividad
import com.example.event_master.ui.model.Evento
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.sql.Date
import javax.inject.Inject

class ActividadRepositoryImpl @Inject constructor(
    private val db: AppDatabase
):ActividadRepository{

    override fun obtenerTodos(): Flow<List<Actividad>>{
        return db.actividadDao().obtenerTodos().map {listaEntities ->
            listaEntities.map{entity -> entity.toDomain()}
        }
    }
    override suspend fun obtenerPorId(id: Int): Actividad{
        return db.actividadDao().obtenerPorId(id).toDomain()
    }

    override suspend fun insertarActividad(actividad: Actividad){
        return db.actividadDao().insertarActividad(actividad.toEntity())
    }
    override suspend fun borrarActividad(actividad: Actividad){
        return db.actividadDao().borrar(actividad.toEntity())
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