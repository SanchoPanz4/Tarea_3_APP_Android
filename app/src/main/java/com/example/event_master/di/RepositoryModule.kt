package com.example.event_master.di

import com.example.event_master.data.repository.evento.EventoRepository
import com.example.event_master.data.repository.evento.EventoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindEventRepository(
        eventoRepositoryImpl: EventoRepositoryImpl
    ): EventoRepository
}
