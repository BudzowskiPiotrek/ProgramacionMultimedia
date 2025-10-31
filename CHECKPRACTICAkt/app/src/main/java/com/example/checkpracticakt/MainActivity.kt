package com.example.checkpracticakt

import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout

/**
 * @author CRISTOBAL PRIMERO DE SU NOMBRE
 * @version 1.0
 */
class MainActivity : AppCompatActivity() {

    private lateinit var opciones: Array<String?>
    var suma: TextView? = null
    private lateinit var contenedor: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contenedor = findViewById(R.id.lb)
        suma = findViewById(R.id.suma)
        suma?.text = "0"
        val res = getResources()
        opciones = res.getStringArray(R.array.listaopciones)
        rellenarCheck()
    }

    private fun rellenarCheck() {
        val oyente = Oyente(this)
        for (opcionTexto in opciones) {
            if (opcionTexto != null) {
                var chbx = CheckBox(this)
                chbx.setText(opcionTexto)
                chbx.setOnCheckedChangeListener(oyente)
                contenedor.addView(chbx)
            }
        }
    }
}