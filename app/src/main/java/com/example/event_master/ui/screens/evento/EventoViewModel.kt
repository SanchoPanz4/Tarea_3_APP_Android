package com.example.event_master.ui.screens.forms

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.event_master.data.repository.actividad.ActividadRepository
import com.example.event_master.data.repository.evento.EventoRepository
import com.example.event_master.ui.model.Actividad
import com.example.event_master.ui.model.Evento
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class EventoViewModel @Inject constructor(
    private val eventoRepository: EventoRepository,
    private val actividadRepository: ActividadRepository
): ViewModel(){

    var tipo by mutableStateOf("")
    var nombre by mutableStateOf("")
    var detalle by mutableStateOf("")
    var fecha by mutableStateOf(Date())

    val eventos: StateFlow<List<Evento>> = eventoRepository.obtenerTodosEventos()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val actividades: StateFlow<List<Actividad>> = actividadRepository.obtenerTodos()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun insertarEvento(onSuccess: () -> Unit = {}) {
        viewModelScope.launch {
            val nuevoEvento = Evento(
                id = 0,
                tipo = tipo,
                nombre = nombre,
                detalle = detalle,
                fecha = fecha.time
            )

            eventoRepository.insertarEvento(nuevoEvento)

            val listaActividades = actividades.value
            val actividadCorrespondiente = listaActividades.find { it.tipo == tipo }
            
            actividadCorrespondiente?.let { actividad ->
                val listaActualizada = actividad.eventoLista.toMutableList()
                listaActualizada.add(nuevoEvento)
                val actividadActualizada = actividad.copy(eventoLista = listaActualizada)
                actividadRepository.insertarActividad(actividadActualizada) // insertarActividad usa REPLACE en el DAO
            }

            resetForm()
            onSuccess()
        }
    }

    private fun resetForm()
    {
        tipo = ""
        nombre = ""
        detalle = ""
        fecha = Date()
    }
}
