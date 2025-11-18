package com.example.a7listview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Ana", "García López"));
        listaPersonas.add(new Persona("Marcos", "Pérez Díaz"));
        listaPersonas.add(new Persona("Laura", "Ruiz Martínez"));

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        Button bGuardar = (Button) linearLayout.getChildAt(2);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNombre = (EditText) linearLayout.getChildAt(0);
                EditText etApellidos = (EditText) linearLayout.getChildAt(1);
                if (!etNombre.getText().toString().equals("") && !etApellidos.getText().toString().equals("")) {
                    listaPersonas.add(new Persona(etNombre.getText().toString(), etApellidos.getText().toString()));
                    actualizar(listaPersonas);
                }
            }
        });
    }

    //Introduce los datos en el listView
    void actualizar(ArrayList<Persona> listaPersonas) {
        Adaptador adaptador = new Adaptador(this, listaPersonas);
        ListView lstOpciones = (ListView) findViewById(R.id.lista);
        lstOpciones.setAdapter(adaptador);
    }
}