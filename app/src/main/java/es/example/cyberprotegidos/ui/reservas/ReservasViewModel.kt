package es.example.cyberprotegidos.ui.reservas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReservasViewModel : ViewModel() {
    private val mascotasLiveData = MutableLiveData<List<Reserva>>()

    init {
        // Lista de mascotas
        val reservas = listOf(
            Reserva("Tutoria", "Ampiter", "12345678L", 123456789, "1@gmail.com", "12/02/03", "25/09/2006", 2, "Ta guay"),
            Reserva("Congreso", "Manueh", "12345678L", 123456789, "1@gmail.com", "12/02/06", "25/09/2006", 30, "Cacota"),
        )
        mascotasLiveData.value = reservas
    }

    fun getMascotas(): LiveData<List<Reserva>> {
        return mascotasLiveData
    }
}