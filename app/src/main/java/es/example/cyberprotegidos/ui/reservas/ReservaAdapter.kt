package es.example.cyberprotegidos.ui.reservas

import android.app.AlertDialog
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
        val tipoTextView: TextView = itemView.findViewById(R.id.textViewReservaTipo)
        val fechaIniTextView: TextView = itemView.findViewById(R.id.textViewReservaFechaIni)
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

    private fun mostrarDetallesReserva(holder: ReservaAdapter.MascotaViewHolder, reserva: Reserva) {
        val dialogBuilder = AlertDialog.Builder(holder.itemView.context)
        dialogBuilder.setTitle("DETALLES DE LA RESERVA")
        dialogBuilder.setMessage("DATOS SALA \nTipo: ${reserva.tipo}\nFecha de inicio: ${reserva.fechaIni}" +
                "\nFecha de finalización: ${reserva.fechaFin}\nNúmero de personas: ${reserva.numPersonas}" +
                "\n\nDATOS CLIENTE \nNombre: ${reserva.nombre}\nDNI: ${reserva.dni}\nTelefono: ${reserva.telefono}" +
                "\nEmail: ${reserva.email}\nComentario: ${reserva.comentario}")
        dialogBuilder.setPositiveButton("Volver") { dialog, _ ->
            dialog.dismiss()
        }

        dialogBuilder.setNegativeButton("Eliminar") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = dialogBuilder.create()
        dialog.show()
    }

    // El método onBindViewHolder() se llama para establecer los datos del objeto Mascota en la
    // vista MascotaViewHolder.
    override fun onBindViewHolder(holder: ReservaAdapter.MascotaViewHolder, position: Int) {
        val currentReserva = reservas[position]
        holder.tipoTextView.text = currentReserva.tipo
        holder.fechaIniTextView.text = currentReserva.fechaIni

        holder.adoptButton.setOnClickListener {
            mostrarDetallesReserva(holder, currentReserva)
        }
    }

    // El método getItemCount() devuelve el número de elementos en la lista de Mascotas
    // proporcionado en el constructor de MascotaAdapter.
    override fun getItemCount() = reservas.size

    fun setMascotas(reservas: List<Reserva>) {
        this.reservas = reservas
    }
}