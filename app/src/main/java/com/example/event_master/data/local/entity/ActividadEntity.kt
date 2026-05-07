package com.example.event_master.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.event_master.ui.components.Evento

@Entity
data class ActividadEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "tipo") val tipo: String,
    @ColumnInfo(name = "eventoLista") val eventoLista: MutableList<Evento>
)

/*
data class ActividadEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "tipo") val tipo: String,

)
 */