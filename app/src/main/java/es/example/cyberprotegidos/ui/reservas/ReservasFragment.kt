package es.example.cyberprotegidos.ui.reservas

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.example.cyberprotegidos.databinding.FragmentReservasBinding
import es.example.cyberprotegidos.ui.formulario.FormActivity
import es.example.cyberprotegidos.ui.formulario.FormViewModel

class ReservasFragment : Fragment() {

    private var _binding: FragmentReservasBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReservaAdapter
    private lateinit var viewModel: ReservasViewModel
    private lateinit var botonFormulario: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReservasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = binding.recyclerView
        adapter = ReservaAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ReservasViewModel::class.java)

        viewModel.getMascotas().observe(viewLifecycleOwner) { mascotas ->
            adapter.setMascotas(mascotas)
            adapter.notifyDataSetChanged()
        }

        botonFormulario = binding.fab
        botonFormulario.setOnClickListener {
            // Aquí se ejecutará el código cuando se presione el botón

            // Crear una instancia de la actividad FormActivity
            val intent = Intent(requireContext(), FormActivity::class.java)

            // Iniciar la actividad
            startActivity(intent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}