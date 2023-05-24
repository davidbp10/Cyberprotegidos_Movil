package es.example.cyberprotegidos.ui.reservas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.example.cyberprotegidos.ui.formulario.FormActivity
import es.example.cyberprotegidos.MainActivity
import es.example.cyberprotegidos.databinding.FragmentReservasBinding
import es.example.cyberprotegidos.ui.api.ApiService
import es.example.cyberprotegidos.ui.reservas.Reserva
import es.example.cyberprotegidos.ui.reservas.ReservaAdapter
import es.example.cyberprotegidos.ui.reservas.ReservasViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReservasFragment : Fragment() {

    private var _binding: FragmentReservasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(ReservasViewModel::class.java)

        _binding = FragmentReservasBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val addReserva = binding.fab
        try {

            addReserva.setOnClickListener {
                val intent = Intent(activity, FormActivity::class.java)
                startActivity(intent)
            }

        }catch (ex:Exception){
            Log.e("TEST", "onCreateView: ${ex.message}", )
        }

        var reservas : List<Reserva>
        val recyclerView: RecyclerView = binding.recyclerView
        val context = requireContext()
        recyclerView.layoutManager = LinearLayoutManager(context)

        GlobalScope.launch(Dispatchers.IO) {
            reservas = fetchBookings(context)
            val adapter = ReservaAdapter(reservas, recyclerView)
            withContext(Dispatchers.Main){
                recyclerView.adapter = adapter
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    suspend private fun fetchBookings(context: Context): List<Reserva>{
        Thread.sleep(2000)
        Log.d("FETCH", "Función ejecutada");
        val service = ApiService(context)
        var reservas = service.getReservas()
        return reservas
    }
}