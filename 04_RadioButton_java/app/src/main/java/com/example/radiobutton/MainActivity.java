package com.example.radiobutton;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author CRISTOBAL PRIMERO DE SU NOMBRE
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {
    public RadioGroup rgTransporte, rgHotel, rgComida, rgOcio;
    public EditText etTrasporte, etHotel, etComida, etOcio, suma;
    private String[] opcionesTransporte, opcionesHotel, opcionesComida, opcionesOcio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        // RESETEO DE SUMA AL 0.0
        double sumaTotal = 0.0;
        // VAMOS A SUMAR LAS 4 GRUPOS CADA UNO POR SEPARADO
        sumaTotal += calcular(rgTransporte, etTrasporte);
        sumaTotal += calcular(rgHotel, etHotel);
        sumaTotal += calcular(rgComida, etComida);
        sumaTotal += calcular(rgOcio, etOcio);
        // CAMBIAMOS TOTAL DE SUMA EN EDIT TEXT SUMA
        suma.setText(sumaTotal + "");

    }

    private double calcular(RadioGroup rg, EditText et) {
        // EXTRAEMOS LA ID DE RADIO QUE ESTE PULSADA
        int selectedId = rg.getCheckedRadioButtonId();
        // SI NO ESTA SELECCIONADO 0* LO QUE SEA ES 0
        if (selectedId == -1) {
            return 0.0;
        }
        RadioButton selecionado = findViewById(selectedId);
        String textoRadio = selecionado.getText().toString();
        // SEPARARLO TEXTO DE NUMERO
        double precio = sacarPrecio(textoRadio);

        String textoCuantos = et.getText().toString();
        int numero = 0;
        try {
            if (!textoCuantos.isEmpty()) {
                numero = Integer.parseInt(textoCuantos);
            }
        } catch (NumberFormatException e) {
            // POR SI NO METE NUMERO
        }
        return precio * numero;
    }

    private double sacarPrecio(String texto) {
        try {
            int posicion = texto.lastIndexOf('-');
            if (posicion != -1) {
                String precio = texto.substring(posicion + 1).trim();
                return Double.parseDouble(precio);
            }
        } catch (Exception e) {
        }
        return 0.0;
    }
}