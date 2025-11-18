package com.example.spinerjava;


import android.view.View;

/**
 * @author CRISTOBAL PRIMERO DE SU NOMBRE
 * @version 1.0
 */
public class OyenteExtraer implements View.OnClickListener {
    private final MainActivity activity;
    public int precio_a;
    public int precio_b;
    public int precio_c;

    public OyenteExtraer(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
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
            activity.resultado.setText(activity.getString(R.string.resultado) + activity.suma);
        }
    }
}
