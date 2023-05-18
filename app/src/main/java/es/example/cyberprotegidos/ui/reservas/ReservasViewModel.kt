package es.example.cyberprotegidos.ui.reservas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReservasViewModel : ViewModel() {
    private val mascotasLiveData = MutableLiveData<List<Reserva>>()

    init {
        // Lista de mascotas
        val reservas = listOf(
            Reserva("Luna", "Golden Retriever", 2),
            Reserva("Rocky", "Bulldog", 4),
            Reserva("Simba", "Persa", 1),
            Reserva("Coco", "Chihuahua", 3),
            Reserva("Max", "Labrador Retriever", 5),
            Reserva("Milo", "Schnauzer", 2),
            Reserva("Pelusa", "Poodle", 4),
            Reserva("Toby", "Beagle", 3),
            Reserva("Canela", "Dachshund", 1),
            Reserva("Rufus", "Rottweiler", 6)
        )
        mascotasLiveData.value = reservas
    }

    fun getMascotas(): LiveData<List<Reserva>> {
        return mascotasLiveData
    }
}