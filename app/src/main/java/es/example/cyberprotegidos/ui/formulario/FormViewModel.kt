package es.example.cyberprotegidos.ui.formulario

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is localizacion Fragment"
    }
    val text: LiveData<String> = _text
}