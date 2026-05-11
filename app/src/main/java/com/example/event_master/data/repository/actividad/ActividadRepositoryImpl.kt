package com.example.event_master.data.repository.actividad

import com.example.event_master.data.local.AppDatabase
import com.example.event_master.data.local.entity.ActividadEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ActividadRepositoryImpl @Inject constructor(
    private val db: AppDatabase
):ActividadRepository{

    override fun obtenerTodos(): Flow<List<ActividadEntity>>{
        return db.actividadDao().obtenerTodos().map {listaEntities ->
            listaEntities.map{entity -> entity.toDomain()}
        }
    }


    override suspend fun obtenerPorId(id: Int): ActividadEntity{
        return db.actividadDao().obtenerPorId(id).toDomain()
    }
    override suspend fun obtenerPorId(actIDs: IntArray): List<ActividadEntity>{
        return db.actividadDao().obtenerPorId(actIDs)
    }
    override suspend fun buscarPorTipo(nombre: String): ActividadEntity{
        return db.actividadDao().buscarPorTipo(nombre).toDomain()
    }
    override suspend fun insertarActividad(vararg actividad: ActividadEntity){
        return db.actividadDao().insertarActividad(actividad.toEntity())
    }
    override suspend fun borrar(usuario: ActividadEntity){}
}

fun ActividadEntity.toDomain() = Actividad(
    id = this.id,
    tipo = this.tipo,
    eventoLista = this.eventoLista
)