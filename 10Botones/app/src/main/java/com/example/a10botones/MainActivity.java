package com.example.a10botones;

import static com.example.a10botones.R.id.EditText1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText cantidadPlantas;
    private LinearLayout columnaBotones;
    private LinearLayout columnaDirecciones;
    private int plantaActual = 0;

    private String direccion = "Mismo piso";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Los conteneros
        columnaBotones = findViewById(R.id.columnaDerecha);
        columnaDirecciones = findViewById(R.id.columnaIzquierda);
        // Los componentes
        cantidadPlantas = (EditText) findViewById(EditText1);

    }

    public void crear(View view) {
        try {
            int numero = Integer.parseInt(cantidadPlantas.getText().toString());
            if (numero > 0 && numero <= 10) {
                construirPlantas(numero);
            } else {
                Toast.makeText(this, "Error: Introduce un número de 1 a 10.", Toast.LENGTH_LONG).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Error: Asegúrate de introducir solo números.", Toast.LENGTH_SHORT).show();
        }
    }

    public void construirPlantas(int numero) {
        columnaBotones.removeAllViews();
        // Columna de Botones
        for (int i = numero; i >= 0; i--) {
            Button btn = new Button(this);
            btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            btn.setText(i == 0 ? "Planta Baja" : i + "");
            btn.setTag(i);

            // añadir al cada boton su funcionamiento
            columnaBotones.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int plantaDeseada = (int) v.getTag();
                    if (plantaDeseada > plantaActual) {
                        direccion = "Subiendo";
                    } else if (plantaDeseada < plantaActual) {
                        direccion = "Bajando";
                    } else {
                        direccion = "Mismo piso";
                    }
                    plantaActual = plantaDeseada;
                    columnaDirecciones();
                }
            });
        }
        // Columna de Direcciones
        columnaDirecciones();
    }

    private void columnaDirecciones() {
        columnaDirecciones.removeAllViews();
        LinearLayout.LayoutParams paramsTxt = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView piso = new TextView(this);
        piso.setLayoutParams(paramsTxt);
        piso.setText("piso " + plantaActual);
        columnaDirecciones.addView(piso);

        TextView movimiento = new TextView(this);
        movimiento.setLayoutParams(paramsTxt);
        movimiento.setText("piso " + direccion);
        columnaDirecciones.addView(movimiento);
    }
}