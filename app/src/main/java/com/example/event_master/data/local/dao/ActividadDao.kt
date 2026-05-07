package com.example.event_master.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.event_master.data.local.entity.ActividadEntity
import kotlinx.coroutines.flow.Flow


interface ActividadDao {
    @Query("select * from ActividadEntity") //agregar elementos
    fun obtenerTodos(): Flow<List<ActividadEntity>>

    @Query("SELECT * FROM ActividadEntity WHERE id = :id")
    suspend fun obtenerPorId(id: Int): ActividadEntity

    @Query("SELECT * FROM ActividadEntity WHERE id IN (:actIDs)")
    suspend fun obtenerPorId(actIDs: IntArray): List<ActividadEntity>

    @Query("SELECT * FROM ActividadEntity WHERE tipo LIKE :nombre LIMIT 1") //nombre del tipo
    suspend fun buscarPorTipo(nombre: String): ActividadEntity

    @Insert
    suspend fun insertarActividad(vararg actividad: ActividadEntity)

    @Delete
    suspend fun borrar(usuario: ActividadEntity)


}