package com.example.event_master.data.repository

interface AppContainer {
    val usuarioRepository : UsuarioRepository
}
class AppDataContainer(private val context: Context) : AppContainer {
    override val usuarioRepository: UsuarioRepository by lazy {
        UsuarioRepositoryImpl(AppDatabase.getDatabase(context))
    }
}