package com.example.event_master.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.event_master.data.local.entity.ActividadEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ActividadDao {
    @Query("select * from ActividadEntity")
    fun obtenerTodos(): Flow<List<ActividadEntity>>

    @Query("SELECT * FROM ActividadEntity WHERE id = :id")
    suspend fun obtenerPorId(id: Int): ActividadEntity

    @Query("SELECT * FROM ActividadEntity WHERE tipo LIKE :nombre LIMIT 1")
    suspend fun buscarPorTipo(nombre: String): ActividadEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarActividad(vararg actividad: ActividadEntity)

    @Update
    suspend fun actualizarActividad(actividad: ActividadEntity)

    @Delete
    suspend fun borrar(usuario: ActividadEntity)
}
