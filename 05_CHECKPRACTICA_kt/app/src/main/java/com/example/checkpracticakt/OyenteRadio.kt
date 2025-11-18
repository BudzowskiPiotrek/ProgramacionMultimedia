package com.example.checkpracticakt

import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.util.Log.i


class OyenteRadio(private val activity: MainActivity) :
    RadioGroup.OnCheckedChangeListener {

    override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
        val selecionado: RadioButton? = activity.findViewById(checkedId)
        if (selecionado != null) {
            val texto = selecionado.text


            if (texto.toString().equals("hombre", ignoreCase = true)) {
                activity.limpiarContenedor()
                activity.rellenarCheck(activity.opciones)
            } else {
                activity.rellenarCheck(activity.opciones2)
            }
        }
    }

}