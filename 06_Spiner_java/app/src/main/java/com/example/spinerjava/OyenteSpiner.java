package com.example.spinerjava;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;

/**
 * @author CRISTOBAL PRIMERO DE SU NOMBRE
 * @version 1.0
 */

public class OyenteSpiner implements AdapterView.OnItemSelectedListener {
    private MainActivity activity;
    public int precio_a;
    public int precio_b;
    public int precio_c;


    public OyenteSpiner(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        int eurosIngresados = Integer.parseInt(activity.sEuros.getSelectedItem().toString());
        int centimosIngresados = Integer.parseInt(activity.sCentimos.getSelectedItem().toString());
        int total = (eurosIngresados * 100) + centimosIngresados;

        activity.suma += total;
        activity.resultado.setText(activity.getString(R.string.resultado) + activity.suma);
        activity.sEuros.setSelection(0);
        activity.sCentimos.setSelection(0);
        verSiPuedoSacar();
    }

    private void verSiPuedoSacar() {
        // NO ESTA TESTEADA ESTA PARTE, PERO DEBERIA FULURAR
        precio_a = Integer.parseInt(activity.getString(R.string.precio_a));
        precio_b = Integer.parseInt(activity.getString(R.string.precio_b));
        precio_c = Integer.parseInt(activity.getString(R.string.precio_c));

        int idSeleccionado = activity.rg.getCheckedRadioButtonId();

        int precioBebida = 0;
        if (idSeleccionado == R.id.radio1) {
            precioBebida = precio_a;
        } else if (idSeleccionado == R.id.radio2) {
            precioBebida = precio_b;
        } else if (idSeleccionado == R.id.radio3) {
            precioBebida = precio_c;
        } else {
            precioBebida = 0;
        }
        if (activity.suma >= precioBebida) {
            activity.suma -= precioBebida;
            activity.resultado.setText(activity.getString(R.string.resultado) + "activity.suma");
        }else {

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
