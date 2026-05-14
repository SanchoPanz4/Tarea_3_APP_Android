package com.example.event_master.data.local.entity

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class EventoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "tipo") val tipo: String?,
    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "detalle") val detalle: String?,
    @ColumnInfo(name = "fecha") val fecha: Date
)
