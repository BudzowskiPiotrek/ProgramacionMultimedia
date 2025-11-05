package com.example.checkpracticakt

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup

/**
 * @author CRISTOBAL PRIMERO DE SU NOMBRE
 * @version 1.0
 */
class MainActivity : AppCompatActivity() {

    public lateinit var opciones: Array<String?>
    public lateinit var opciones2: Array<String?>
    public lateinit var contenedor: LinearLayout
    var suma: TextView? = null
    var rq: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contenedor = findViewById(R.id.lb)
        suma = findViewById(R.id.suma)
        suma?.text = "0"
        rq = findViewById<View?>(R.id.rg) as RadioGroup

        val res = getResources()
        opciones = res.getStringArray(R.array.listaopciones)
        opciones2 = res.getStringArray(R.array.listamujer)
        rellenarCheck(opciones)
        oyenteRadio()
    }

    private fun oyenteRadio() {
        val oyente = OyenteRadio(this)
        rq!!.setOnCheckedChangeListener(oyente)
    }

    public fun rellenarCheck(opciones: Array<String?>) {
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