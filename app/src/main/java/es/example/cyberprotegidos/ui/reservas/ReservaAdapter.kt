package es.example.cyberprotegidos.ui.reservas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import es.example.cyberprotegidos.R

// Define la clase MascotaAdapter y extiende la clase
// RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>. Esta clase maneja el conjunto de datos
// de Mascota y lo une con la vista que se va a mostrar en la lista.
class ReservaAdapter(private var reservas: List<Reserva>) :

    // Se define la clase interna MascotaViewHolder, que extiende de la clase
    // RecyclerView.ViewHolder.
    RecyclerView.Adapter<ReservaAdapter.MascotaViewHolder>() {

    // Esta clase almacena las referencias de los elementos de la vista
    // (los widgets o views) que se muestran en cada elemento de la lista.
    inner class MascotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.textViewSalaName)
        val razaTextView: TextView = itemView.findViewById(R.id.textViewSalaType)
        val edadTextView: TextView = itemView.findViewById(R.id.textViewSalaAge)
        val adoptButton: Button = itemView.findViewById(R.id.buttonVer)
    }

    constructor() : this(emptyList())

    // El método onCreateViewHolder() se encarga de crear una nueva instancia de MascotaViewHolder,
    // inflando el diseño de vista desde el archivo de diseño XML que se proporciona en el
    // parámetro viewType.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_reserva, parent, false)
        return MascotaViewHolder(itemView)
    }

    // El método onBindViewHolder() se llama para establecer los datos del objeto Mascota en la
    // vista MascotaViewHolder.
    override fun onBindViewHolder(holder: ReservaAdapter.MascotaViewHolder, position: Int) {
        val currentPet = reservas[position]
        holder.nombreTextView.text = currentPet.nombre
        holder.razaTextView.text = currentPet.raza
        holder.edadTextView.text = "%s %d".format("Edad: ", currentPet.edad)

        holder.adoptButton.setOnClickListener {
            Toast.makeText(holder.itemView.context, "¡Has adoptado a ${currentPet.nombre}!", Toast.LENGTH_SHORT).show()
        }
    }

    // El método getItemCount() devuelve el número de elementos en la lista de Mascotas
    // proporcionado en el constructor de MascotaAdapter.
    override fun getItemCount() = reservas.size

    fun setMascotas(reservas: List<Reserva>) {
        this.reservas = reservas
    }
}