package com.example.spinerjava;

import android.view.View;

/**
 * @author CRISTOBAL PRIMERO DE SU NOMBRE
 * @version 1.0
 */
public class OyenteExtraer implements View.OnClickListener {
    private final MainActivity activity;

    private static final int PRECIO_A = 80;
    private static final int PRECIO_B = 120;
    private static final int PRECIO_C = 310;

    public OyenteExtraer(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        int eurosIngresados = Integer.parseInt(activity.sEuros.getSelectedItem().toString());
        int centimosIngresados = Integer.parseInt(activity.sCentimos.getSelectedItem().toString());

        int total = (eurosIngresados * 100) + centimosIngresados;

        int idSeleccionado = activity.rg.getCheckedRadioButtonId();

        int precioBebida = 0;
        if (idSeleccionado == R.id.radio1) {
            precioBebida = PRECIO_A;
        } else if (idSeleccionado == R.id.radio2) {
            precioBebida = PRECIO_B;
        } else if (idSeleccionado == R.id.radio3) {
            precioBebida = PRECIO_C;
        } else {
            precioBebida = 0;
        }
        if (total >= precioBebida) {
            int cambio = total - precioBebida;
            activity.resultado.setText(activity.getString(R.string.resultado_correcto_toma_tu_cambio_en_centimos_es) + cambio);
        } else {
            activity.resultado.setText(R.string.resultado_incorrecto2);
        }
    }
}
