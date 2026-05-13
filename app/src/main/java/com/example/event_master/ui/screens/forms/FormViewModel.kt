package com.example.event_master.ui.screens.forms

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.event_master.data.repository.evento.EventoRepository
import com.example.event_master.ui.model.Evento
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(
    private val eventoRepository: EventoRepository
): ViewModel(){
    var nombre by mutableStateOf("")
    var detalle by mutableStateOf("")
    var fecha by mutableStateOf(Date())
    val eventos: StateFlow<List<Evento>> = eventoRepository.obtenerTodosEventos()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun insertarEvento() {
        viewModelScope.launch {
            val nuevoEvento = Evento(
                id = 0,
                nombre = nombre,
                detalle = detalle,
                fecha = fecha.time
            )
            eventoRepository.insertarEvento(nuevoEvento)
            resetForm()
        }
    }
    private fun resetForm(){
        nombre = ""
        detalle = ""
        fecha = Date()
    }
}
