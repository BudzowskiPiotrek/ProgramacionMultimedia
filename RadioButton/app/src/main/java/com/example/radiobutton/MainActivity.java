package com.example.radiobutton;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public RadioButton rbTrasporte, rbHotel, rbComida, rbOcio;
    public EditText etTrasporte, etHotel, etComida, etOcio;
    private String[] opcionesTransporte, opcionesHotel, opcionesComida, opcionesOcio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rbTrasporte = (RadioButton) findViewById(R.id.rbTransporte);
        rbHotel = (RadioButton) findViewById(R.id.rbHotel);
        rbComida = (RadioButton) findViewById(R.id.rbComida);
        rbOcio = (RadioButton) findViewById(R.id.rbOcio);
        etTrasporte = (EditText) findViewById(R.id.etTrasporte);
        etHotel = (EditText) findViewById(R.id.etHotel);
        etComida = (EditText) findViewById(R.id.etComida);
        etOcio = (EditText) findViewById(R.id.etOcio);

        cargarArrays();

        rellenarContenedor();

        setListeners();
    }


    private void cargarArrays() {
        Resources res = getResources();
        opcionesTransporte = res.getStringArray(R.array.Transporte);
        opcionesHotel = res.getStringArray(R.array.Hotel);
        opcionesComida = res.getStringArray(R.array.Comida);
        opcionesOcio = res.getStringArray(R.array.Ocio);
    }

    private void rellenarContenedor() {
    }

    private void setListeners() {
    }
}