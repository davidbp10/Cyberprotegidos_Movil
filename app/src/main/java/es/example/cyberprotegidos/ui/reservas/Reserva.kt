package es.example.cyberprotegidos.ui.reservas

import java.util.Date

data class Reserva(val tipo: String , val nombre: String, val dni: String, val telefono: Int,
                   val email: String, val fechaIni: String, val fechaFin: String,
                   val numPersonas: Int, val comentario: String)
