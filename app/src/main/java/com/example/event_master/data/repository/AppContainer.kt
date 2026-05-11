package com.example.event_master.data.repository

import android.content.Context
import com.example.event_master.data.local.AppDatabase
import com.example.event_master.data.repository.evento.EventoRepository
import com.example.event_master.data.repository.evento.EventoRepositoryImpl

interface AppContainer {
    val eventoRepository : EventoRepository
}
class AppDataContainer(private val context: Context) : AppContainer {
    override val eventoRepository: EventoRepository by lazy {
        EventoRepositoryImpl(AppDatabase.getDatabase(context))
    }
}