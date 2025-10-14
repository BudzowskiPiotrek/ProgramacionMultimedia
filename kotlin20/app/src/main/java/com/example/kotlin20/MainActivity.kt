package com.example.kotlin20

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    // Las propiedades se declaran con 'lateinit' si se inicializan en onCreate
    private lateinit var cantidadPlantas: EditText
    private lateinit var columnaBotones: LinearLayout
    private lateinit var columnaDirecciones: LinearLayout

    // Variables de estado
    private var plantaActual: Int = 0
    private var direccion: String = "Mismo piso"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Los contenedores y componentes se inicializan usando findViewById
        columnaBotones = findViewById(R.id.columnaDerecha)
        columnaDirecciones = findViewById(R.id.columnaIzquierda)
        // Casteo explícito a EditText (en Kotlin se puede omitir si el tipo es obvio)
        cantidadPlantas = findViewById(R.id.EditText1)

    }


    fun crear(view: View) {
        // Uso de 'runCatching' o try-catch para manejar excepciones
        try {
            val textoCantidad = cantidadPlantas.text.toString()
            val numero =
                textoCantidad.toInt() // toInt() lanza NumberFormatException si no es un número

            if (numero in 1..10) { // Uso de rangos en Kotlin para 'numero > 0 && numero <= 10'
                construirPlantas(numero)
            } else {
                Toast.makeText(this, "Error: Introduce un número de 1 a 10.", Toast.LENGTH_LONG)
                    .show()
            }
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Error: Asegúrate de introducir solo números.", Toast.LENGTH_SHORT)
                .show()
        }
    }

    // BORRA TODO CONTENIDO DE CONTENEDOR IZQUIERDO POSTERIORMENTE CREA X BOTONES
    fun construirPlantas(numero: Int) {
        columnaBotones.removeAllViews()

        // COLUMNA DE BOTONES IZQUIERDA
        // Bucle for-downTo para iterar hacia abajo, incluido el 0
        for (i in numero downTo 0) {
            val btn = Button(this).apply {
                // Uso de 'apply' para configurar el botón de forma concisa
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                text = if (i == 0) "Planta Baja" else i.toString()
                tag = i
            }
        }
    }
}