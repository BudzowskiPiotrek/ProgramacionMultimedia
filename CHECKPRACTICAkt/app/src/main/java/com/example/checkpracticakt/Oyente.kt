package com.example.checkpracticakt

import android.widget.CompoundButton
import android.widget.TextView

/**
 * @author CRISTOBAL PRIMERO DE SU NOMBRE
 * @version 1.0
 */
class Oyente(private val activity: MainActivity) : CompoundButton.OnCheckedChangeListener {
    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        val cambio: Int = if (isChecked) {
            1
        } else {
            -1
        }
        actualizarContador(cambio)
    }

    private fun actualizarContador(cambio: Int) {
        val textView: TextView = activity.suma!!
        val textoActual = textView.text.toString().trim()
        var valorAux: Int = textoActual.toIntOrNull() ?: 0
        valorAux += cambio
        activity.suma!!.setText(valorAux.toString())
    }
}