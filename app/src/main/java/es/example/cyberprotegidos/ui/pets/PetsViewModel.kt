package es.example.cyberprotegidos.ui.pets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PetsViewModel : ViewModel() {
    private val mascotasLiveData = MutableLiveData<List<Mascota>>()

    init {
        // Lista de mascotas
        val mascotas = listOf(
            Mascota("Luna", "Golden Retriever", 2),
            Mascota("Rocky", "Bulldog", 4),
            Mascota("Simba", "Persa", 1),
            Mascota("Coco", "Chihuahua", 3),
            Mascota("Max", "Labrador Retriever", 5),
            Mascota("Milo", "Schnauzer", 2),
            Mascota("Pelusa", "Poodle", 4),
            Mascota("Toby", "Beagle", 3),
            Mascota("Canela", "Dachshund", 1),
            Mascota("Rufus", "Rottweiler", 6)
        )
        mascotasLiveData.value = mascotas
    }

    fun getMascotas(): LiveData<List<Mascota>> {
        return mascotasLiveData
    }
}