package com.example.checkpracticakt

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    private lateinit var opciones: Array<String?>
    var suma: TextView? = null
    private lateinit var contenedor: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contenedor = findViewById(R.id.lb)
        val res = getResources()
        opciones = res.getStringArray(R.array.listaopciones)
        rellenarCheck()
        setListeners()
    }

    private fun rellenarCheck() {
        for ( o in opciones){
            var chbx = CheckBox(this)
            chbx.setText(o)
            chbx.setId(View.generateViewId())
            contenedor.addView(chbx)
        }
    }
    private fun setListeners() {

    }
}