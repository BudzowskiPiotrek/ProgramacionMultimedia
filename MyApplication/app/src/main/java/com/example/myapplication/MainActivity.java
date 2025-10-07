package com.example.myapplication;

import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText cantidadPlantas;
    private LinearLayout derecho;
    private LinearLayout izquierdo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cantidadPlantas = (EditText) findViewById(R.id.textEdit);
        derecho = findViewById(R.id.derecho);
        izquierdo = findViewById(R.id.izquierdo);


    }

    public void crear(View view) {
        int numeroAux =  Integer.parseInt(cantidadPlantas.getText().toString());

        
    }
}