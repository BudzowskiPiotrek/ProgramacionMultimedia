package com.example.spinerjava;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * @author CRISTOBAL PRIMERO DE SU NOMBRE
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {

    public Spinner sEuros, sCentimos;
    String[] opciones = {"0", "10", "20", "30", "40", "50", "60", "70", "80", "90"};
    String[] opciones2 = {"0", "1", "2", "3", "4", "5"};
    public RadioGroup rg;
    public TextView resultado;
    public Button extraer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rg = (RadioGroup) findViewById(R.id.rg1);
        resultado = (TextView) findViewById(R.id.resultado);
        extraer = (Button) findViewById(R.id.extraer);
        sEuros = (Spinner) findViewById(R.id.euros);
        sCentimos = (Spinner) findViewById(R.id.centimos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones2);
        sEuros.setAdapter(adapter2);
        sCentimos.setAdapter(adapter);
        oyenteBoton();

    }

    private void oyenteBoton() {
        OyenteExtraer listener = new OyenteExtraer(this);
        extraer.setOnClickListener(listener);
    }
}