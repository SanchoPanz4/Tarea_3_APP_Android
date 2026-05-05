package com.example.event_master.data.repository.evento


import com.example.event_master.data.local.AppDatabase
import com.example.event_master.data.local.entity.EventoEntity
import com.example.event_master.ui.components.Evento
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EventoRepositoryImpl @Inject constructor(
    private val database: AppDatabase
): EventoRepository{
    override fun obtenerTodosEventos(): Flow<List<Evento>> {
        return database.eventoDao().obtenerTodos().map { listaEntities ->
            listaEntities.map { entity -> entity.toDomain() }
        }
    }
    override suspend fun obtenerPorId(id: Int): Evento {
        return database.eventoDao().obtenerPorId(id).toDomain()
    }
    override suspend fun insertarEvento(usuario: Evento) {
        return database.eventoDao().insertarTodos(usuario.toEntity())
    }
    override suspend fun borrarEvento(usuario: Evento) {
        return database.eventoDao().borrar(usuario.toEntity())
    }
}
fun EventoEntity.toDomain() = Evento(
    id = this.id,
    nombre = this.nombre ?: "Sin nombre",
    detalle = this.detalle
)
fun Evento.toEntity() = EventoEntity(
    id = this.id,
    nombre = this.nombre,
    detalle = this.detalle
)

