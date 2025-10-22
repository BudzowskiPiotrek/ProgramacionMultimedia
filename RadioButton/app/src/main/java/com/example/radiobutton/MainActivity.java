package com.example.radiobutton;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    public RadioGroup rgTransporte, rgHotel, rgComida, rgOcio;
    public EditText etTrasporte, etHotel, etComida, etOcio, suma;
    private String[] opcionesTransporte, opcionesHotel, opcionesComida, opcionesOcio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rgTransporte = (RadioGroup) findViewById(R.id.rgTransporte);
        rgHotel = (RadioGroup) findViewById(R.id.rgHotel);
        rgComida = (RadioGroup) findViewById(R.id.rgComida);
        rgOcio = (RadioGroup) findViewById(R.id.rgOcio);

        etTrasporte = (EditText) findViewById(R.id.etTrasporte);
        etHotel = (EditText) findViewById(R.id.etHotel);
        etComida = (EditText) findViewById(R.id.etComida);
        etOcio = (EditText) findViewById(R.id.etOcio);
        
        suma = (EditText) findViewById(R.id.suma);

        cargarArrays();

        rellenarContenedor();

        //setListeners();
    }

    private void cargarArrays() {
        Resources res = getResources();
        opcionesTransporte = res.getStringArray(R.array.Transporte);
        opcionesHotel = res.getStringArray(R.array.Hotel);
        opcionesComida = res.getStringArray(R.array.Comida);
        opcionesOcio = res.getStringArray(R.array.Ocio);
    }
    private void rellenarContenedor() {
        rellenarSeccion(opcionesTransporte, rgTransporte);
        rellenarSeccion(opcionesHotel, rgHotel);
        rellenarSeccion(opcionesComida, rgComida);
        rellenarSeccion(opcionesOcio, rgOcio);
    }
    private void rellenarSeccion(String[] listaOpciones, RadioGroup rg) {
        for (String opcion : listaOpciones) {
            RadioButton rgBtn = new RadioButton(this);
            rgBtn.setText(opcion);
            rgBtn.setId(View.generateViewId());
            rg.addView(rgBtn);
        }
    }

}