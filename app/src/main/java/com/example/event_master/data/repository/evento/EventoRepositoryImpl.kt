package com.example.event_master.data.repository.evento


import com.example.event_master.data.local.AppDatabase
import com.example.event_master.data.local.entity.EventoEntity
import com.example.event_master.ui.model.Evento
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.sql.Date
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
    override suspend fun insertarEvento(evento: Evento) {
        return database.eventoDao().insertarTodos(evento.toEntity())
    }
    override suspend fun borrarEvento(evento: Evento) {
        return database.eventoDao().borrar(evento.toEntity())
    }
}
fun EventoEntity.toDomain() = Evento(
    id = this.id,
    nombre = this.nombre?: "Sin nombre",
    detalle = this.detalle ?: "Sin detalle",
    tipo = this.tipo?: "Sin tipo",
    fecha = this.fecha.time
)
fun Evento.toEntity() = EventoEntity(
    id = this.id,
    tipo = this.tipo,
    nombre = this.nombre,
    detalle = this.detalle,
    fecha = Date(this.fecha)
)

