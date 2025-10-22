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
        rellenarRadioGroup();
        setListeners();
    }

    private void cargarArrays() {
        // OBTIENE ACESO A LOS RECURSOS
        Resources res = getResources();
        // RELLENA LOS CONTENEDORES
        opcionesTransporte = res.getStringArray(R.array.Transporte);
        opcionesHotel = res.getStringArray(R.array.Hotel);
        opcionesComida = res.getStringArray(R.array.Comida);
        opcionesOcio = res.getStringArray(R.array.Ocio);
    }

    private void rellenarRadioGroup() {
        rellenarSeccion(opcionesTransporte, rgTransporte);
        rellenarSeccion(opcionesHotel, rgHotel);
        rellenarSeccion(opcionesComida, rgComida);
        rellenarSeccion(opcionesOcio, rgOcio);
    }

    private void rellenarSeccion(String[] listaOpciones, RadioGroup rg) {
        // CREO RADIO BUTTON DENTRO DE RADIOGROUP DESDE LISTA, CONTENEDOR
        for (String opcion : listaOpciones) {
            RadioButton rgBtn = new RadioButton(this);
            rgBtn.setText(opcion);
            // LE ASIGNO UNA ID A CADA UNO DE LOS CREADOS
            rgBtn.setId(View.generateViewId());
            rg.addView(rgBtn);
        }
    }

    private void setListeners() {
        // INSTANCIA DEL OYENTE
        Oyente o = new Oyente(this);
        // METO AL OYENTE A RADIOGROUP
        rgTransporte.setOnCheckedChangeListener(o);
        rgHotel.setOnCheckedChangeListener(o);
        rgComida.setOnCheckedChangeListener(o);
        rgOcio.setOnCheckedChangeListener(o);

        // METO AL OYENTE AL EDITTEXT
        etTrasporte.addTextChangedListener(o);
        etHotel.addTextChangedListener(o);
        etComida.addTextChangedListener(o);
        etOcio.addTextChangedListener(o);
    }

    public void calcularValores() {
        double sumaTotal = 0.0;

        sumaTotal += calcular(rgTransporte, etTrasporte);
        sumaTotal += calcular(rgHotel, etHotel);
        sumaTotal += calcular(rgComida, etComida);
        sumaTotal += calcular(rgOcio, etOcio);

        suma.setText(sumaTotal + "");

    }

    private double calcular(RadioGroup rgTransporte, EditText etTrasporte) {
        return 0;
    }
}