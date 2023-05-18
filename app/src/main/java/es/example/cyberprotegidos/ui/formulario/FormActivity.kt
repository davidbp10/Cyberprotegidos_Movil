package es.example.cyberprotegidos.ui.formulario

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import es.example.cyberprotegidos.R
import es.example.cyberprotegidos.ui.reservas.ReservasViewModel

class FormActivity : AppCompatActivity() {

    private lateinit var tipoSalaEditText: EditText
    private lateinit var nombreEditText: EditText
    private lateinit var dniEditText: EditText
    private lateinit var telefonoEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var fechaInicioEditText: EditText
    private lateinit var fechaFinEditText: EditText
    private lateinit var numPersonasEditText: EditText
    private lateinit var comentarioEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        // Inicializar vistas
        tipoSalaEditText = findViewById<EditText>(R.id.tipo_sala_edittext)
        nombreEditText = findViewById(R.id.nombre_edittext)
        dniEditText = findViewById(R.id.dni_edittext)
        telefonoEditText = findViewById(R.id.telefono_edittext)
        emailEditText = findViewById(R.id.email_edittext)
        fechaInicioEditText = findViewById(R.id.fecha_inicio_edittext)
        fechaFinEditText = findViewById(R.id.fecha_fin_edittext)
        numPersonasEditText = findViewById(R.id.num_personas_edittext)
        comentarioEditText = findViewById(R.id.comentario_edittext)
        val botonFormulario = findViewById<Button>(R.id.botonFormulario)
        val botonVolver = findViewById<Button>(R.id.botonVolver)

        // Configurar el botón de envío
        botonFormulario.setOnClickListener {
            if (validateForm()) {
                // Los campos son válidos, realizar acciones adicionales aquí
                Toast.makeText(this, "Formulario enviado correctamente", Toast.LENGTH_SHORT).show()
            }
        }

        botonVolver.setOnClickListener {
            // Finaliza la actividad actual y vuelve a la actividad anterior
            finish()
        }
    }

    private fun validateForm(): Boolean {
        // Obtener los valores de los campos
        val tipoSala = tipoSalaEditText.text.toString()
        val nombre = nombreEditText.text.toString()
        val dni = dniEditText.text.toString()
        val telefono = telefonoEditText.text.toString()
        val email = emailEditText.text.toString()
        val fechaInicio = fechaInicioEditText.text.toString()
        val fechaFin = fechaFinEditText.text.toString()
        val numPersonas = numPersonasEditText.text.toString()
        val comentario = comentarioEditText.text.toString()

        // Validar cada campo individualmente
        if (tipoSala.isEmpty()) {
            tipoSalaEditText.error = "Campo requerido"
            return false
        }

        if (nombre.isEmpty()) {
            nombreEditText.error = "Campo requerido"
            return false
        }

        if (dni.isEmpty() || !isValidDni(dni)) {
            dniEditText.error = "DNI inválido"
            return false
        }

        if (telefono.isEmpty() || !isValidPhoneNumber(telefono)) {
            telefonoEditText.error = "Teléfono inválido"
            return false
        }

        if (email.isEmpty() || !isValidEmail(email)) {
            emailEditText.error = "Email inválido"
            return false
        }

        if (fechaInicio.isEmpty() || !isValidDate(fechaInicio)) {
            fechaInicioEditText.error = "Fecha de inicio inválida"
            return false
        }

        if (fechaFin.isEmpty() || !isValidDate(fechaFin)) {
            fechaFinEditText.error = "Fecha de fin inválida"
            return false
        }

        if (numPersonas.isEmpty()) {
            numPersonasEditText.error = "Campo requerido"
            return false
        }

        if (comentario.isEmpty()) {
            comentarioEditText.error = "Campo requerido"
            return false
        }

        // Si todos los campos son válidos, retornar true
        return true
    }

    private fun isValidDni(dni: String): Boolean {
        // Implementar lógica de validación del DNI aquí
        // Puedes usar expresiones regulares u otras validaciones específicas
        // En este ejemplo, solo se verifica que el DNI tenga una longitud de 9 caracteres
        return dni.length == 9
    }

    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        // Implementar lógica de validación del número de teléfono aquí
        // Puedes usar expresiones regulares u otras validaciones específicas
        // En este ejemplo, solo se verifica que el número de teléfono tenga una longitud de al menos 6 caracteres
        return phoneNumber.length >= 6
    }

    private fun isValidEmail(email: String): Boolean {
        // Utilizar la clase Patterns de Android para validar el formato del email
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidDate(date: String): Boolean {
        // Implementar lógica de validación de la fecha aquí
        // Puedes usar clases como SimpleDateFormat o otras validaciones específicas
        // En este ejemplo, se comprueba que la fecha tenga el formato "dd/MM/yyyy"
        // y que sea una fecha válida en el rango actual
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        dateFormat.isLenient = false

        try {
            val currentDate = Calendar.getInstance().time
            val parsedDate = dateFormat.parse(date)

            if (parsedDate != null && parsedDate.before(currentDate)) {
                // La fecha es anterior a la fecha actual
                return false
            }
        } catch (e: Exception) {
            // Ocurrió un error al parsear la fecha
            return false
        }

        return true
    }
}