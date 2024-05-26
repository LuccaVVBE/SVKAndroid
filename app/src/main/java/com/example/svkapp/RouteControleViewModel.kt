package com.example.svkapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class RouteControleViewModel : ViewModel() {
    //todo : echte data toevoegen in routecontorlestate!
    private val _uiState = MutableStateFlow(RouteControleState("","","", emptyList()))
    val uiState : StateFlow<RouteControleState> = _uiState.asStateFlow()

    fun setRouteNummer(newRouteNummer:String){
        _uiState.update {
            it.copy(routeNummer = newRouteNummer)
        }
    }

    fun setTransporteur(newTransporteur: String) {
        _uiState.update {
            it.copy(transporteur = newTransporteur)
        }
    }

    fun setNummerplaat(newNummerplaat: String) {
        _uiState.update {
            it.copy(nummerPlaat = newNummerplaat)
        }
    }
}

