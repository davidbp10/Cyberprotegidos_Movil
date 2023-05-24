package es.example.cyberprotegidos.ui.api

import kotlinx.serialization.Serializable

@Serializable
data class ReservaRequest(val tipo: String, val nombre: String, val dni: String, val telefono: String,
                          val email: String, val fechaIni: String, val fechaFin: String,
                          val numPersonas: String, val comentario: String){

}
