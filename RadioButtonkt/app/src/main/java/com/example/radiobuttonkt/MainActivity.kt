package com.example.radiobuttonkt

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity


/**
 * @author CRISTOBAL PRIMERO DE SU NOMBRE
 * @version 1.0
 */
class MainActivity : AppCompatActivity() {
    var rgTransporte: RadioGroup? = null
    var rgHotel: RadioGroup? = null
    var rgComida: RadioGroup? = null
    var rgOcio: RadioGroup? = null
    var etTrasporte: EditText? = null
    var etHotel: EditText? = null
    var etComida: EditText? = null
    var etOcio: EditText? = null
    var suma: EditText? = null
    private lateinit var opcionesTransporte: Array<String?>
    private lateinit var opcionesHotel: Array<String?>
    private lateinit var opcionesComida: Array<String?>
    private lateinit var opcionesOcio: Array<String?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rgTransporte = findViewById<View?>(R.id.rgTransporte) as RadioGroup
        rgHotel = findViewById<View?>(R.id.rgHotel) as RadioGroup
        rgComida = findViewById<View?>(R.id.rgComida) as RadioGroup
        rgOcio = findViewById<View?>(R.id.rgOcio) as RadioGroup

        etTrasporte = findViewById<View?>(R.id.etTrasporte) as EditText
        etHotel = findViewById<View?>(R.id.etHotel) as EditText
        etComida = findViewById<View?>(R.id.etComida) as EditText
        etOcio = findViewById<View?>(R.id.etOcio) as EditText

        suma = findViewById<View?>(R.id.suma) as EditText

        cargarArrays()
        rellenarRadioGroup()
        setListeners()
    }

    private fun cargarArrays() {
        // OBTIENE ACESO A LOS RECURSOS
        val res = getResources()
        // RELLENA LOS CONTENEDORES
        opcionesTransporte = res.getStringArray(R.array.Transporte)
        opcionesHotel = res.getStringArray(R.array.Hotel)
        opcionesComida = res.getStringArray(R.array.Comida)
        opcionesOcio = res.getStringArray(R.array.Ocio)
    }

    private fun rellenarRadioGroup() {
        rellenarSeccion(opcionesTransporte, rgTransporte!!)
        rellenarSeccion(opcionesHotel, rgHotel!!)
        rellenarSeccion(opcionesComida, rgComida!!)
        rellenarSeccion(opcionesOcio, rgOcio!!)
    }

    private fun rellenarSeccion(listaOpciones: Array<String?>, rg: RadioGroup) {
        // CREO RADIO BUTTON DENTRO DE RADIOGROUP DESDE LISTA, CONTENEDOR
        for (opcion in listaOpciones) {
            val rgBtn = RadioButton(this)
            rgBtn.setText(opcion)
            // LE ASIGNO UNA ID A CADA UNO DE LOS CREADOS
            rgBtn.setId(View.generateViewId())
            rg.addView(rgBtn)
        }
    }

    private fun setListeners() {
        // INSTANCIA DEL OYENTE
        val o = Oyente(this)
        // METO AL OYENTE A RADIOGROUP
        rgTransporte!!.setOnCheckedChangeListener(o)
        rgHotel!!.setOnCheckedChangeListener(o)
        rgComida!!.setOnCheckedChangeListener(o)
        rgOcio!!.setOnCheckedChangeListener(o)

        // METO AL OYENTE AL EDITTEXT
        etTrasporte!!.addTextChangedListener(o)
        etHotel!!.addTextChangedListener(o)
        etComida!!.addTextChangedListener(o)
        etOcio!!.addTextChangedListener(o)
    }

    fun calcularValores() {
        // RESETEO DE SUMA AL 0.0
        var sumaTotal = 0.0
        // VAMOS A SUMAR LAS 4 GRUPOS CADA UNO POR SEPARADO
        sumaTotal += calcular(rgTransporte!!, etTrasporte!!)
        sumaTotal += calcular(rgHotel!!, etHotel!!)
        sumaTotal += calcular(rgComida!!, etComida!!)
        sumaTotal += calcular(rgOcio!!, etOcio!!)
        // CAMBIAMOS TOTAL DE SUMA EN EDIT TEXT SUMA
        suma!!.setText(sumaTotal.toString() + "")
    }

    private fun calcular(rg: RadioGroup, et: EditText): Double {
        // EXTRAEMOS LA ID DE RADIO QUE ESTE PULSADA
        val selectedId = rg.getCheckedRadioButtonId()
        // SI NO ESTA SELECCIONADO 0* LO QUE SEA ES 0
        if (selectedId == -1) {
            return 0.0
        }
        val selecionado = findViewById<RadioButton?>(selectedId)
        val textoRadio = selecionado.getText().toString()
        // SEPARARLO TEXTO DE NUMERO
        val precio = sacarPrecio(textoRadio)

        val textoCuantos = et.getText().toString()
        var numero = 0
        try {
            if (!textoCuantos.isEmpty()) {
                numero = textoCuantos.toInt()
            }
        } catch (e: NumberFormatException) {
            // POR SI NO METE NUMERO
        }
        return precio * numero
    }

    private fun sacarPrecio(texto: String): Double {
        try {
            val posicion = texto.lastIndexOf('-')
            if (posicion != -1) {
                val precio = texto.substring(posicion + 1).trim { it <= ' ' }
                return precio.toDouble()
            }
        } catch (e: Exception) {
        }
        return 0.0
    }
}