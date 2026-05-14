package com.example.event_master.ui.screens.actividad

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.event_master.data.repository.actividad.ActividadRepository
import com.example.event_master.ui.model.Actividad
import com.example.event_master.ui.model.Evento
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActividadViewModel @Inject constructor(
    private val actividadRepository: ActividadRepository
): ViewModel(){
    var tipo  by mutableStateOf("")
    var eventoLista = mutableListOf<Evento>()
    var actividades: StateFlow<List<Actividad>> = actividadRepository.obtenerTodos().
    stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
        )
    fun insertarActividad(){
        viewModelScope.launch {
            val nuevaActividad = Actividad(
                id = 0,
                tipo = tipo,
                eventoLista = eventoLista
            )
            actividadRepository.insertarActividad(nuevaActividad)
            resetForm()
        }
    }
    private fun resetForm(){
        tipo = ""
    }
}

