package com.example.buscaminas;

import android.annotation.SuppressLint;
import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private LinearLayout menu;
    private GridLayout casillasJuego;
    private EditText cantidad;
    private Button empezar;
    private Set<Integer> minas;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.layout_menu);
        casillasJuego = findViewById(R.id.layout_juego);
        cantidad = (EditText) findViewById(R.id.editable_menu);
        empezar = (Button) findViewById(R.id.jugar_menu);

        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int numero = Integer.parseInt(cantidad.getText().toString());
                    if (numero > 4 && numero <= 40) {
                        menu.setVisibility(View.GONE);
                        casillasJuego.setVisibility(View.VISIBLE);
                        crearMinas(numero);
                    } else {
                        Toast.makeText(MainActivity.this, "Error: Introduce un número de 4 a 40.", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Error: Asegúrate de introducir solo números.", Toast.LENGTH_SHORT).show();
                }
            }

            private void crearMinas(int numero) {
                inicializarMinas(numero);
                for (int i = 0; i < numero; i++) {
                    Button btn = new Button(MainActivity.this);
                    btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    btn.setTag(i);
                    casillasJuego.addView(btn);
                }
            }

            private void inicializarMinas(int numero) {
                minas = new HashSet<>();
                while (minas.size() != (int) (numero / 4)) {
                    int num = (int) (Math.random() * numero);
                    minas.add(num);
                }
            }
        });


    }
}