package com.example.event_master.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.event_master.data.local.entity.EventoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EventoDao {
    @Query ("select * from EventoEntity")
    fun obtenerTodos(): Flow<List<EventoEntity>>

    @Query("SELECT * FROM EventoEntity WHERE id = :id")
    suspend fun obtenerPorId(id: Int): EventoEntity

    @Query("SELECT * FROM EventoEntity WHERE id IN (:userIds)")
    suspend fun obtenerPorId(userIds: IntArray): List<EventoEntity>

    @Query("SELECT * FROM EventoEntity WHERE nombre LIKE :first LIMIT 1")
    suspend fun buscarPorNombre(first: String, last: Int): EventoEntity

    @Insert
    suspend fun insertarTodos(vararg eventos: EventoEntity)

    @Delete
    suspend fun borrar(evento: EventoEntity)
}