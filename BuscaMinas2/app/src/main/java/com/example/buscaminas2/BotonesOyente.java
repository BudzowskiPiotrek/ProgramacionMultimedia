package com.example.buscaminas2;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

public class BotonesOyente implements View.OnClickListener {
    private MainActivity activity;

    public BotonesOyente(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Button botonTocado = (Button) v;
        int idCasilla = (int) botonTocado.getTag();
        botonTocado.setEnabled(false);

        if (activity.minas.contains(idCasilla)) {
            botonTocado.setBackgroundColor(Color.parseColor("#FF0000"));
            activity.numAciertos += 1;
            activity.minas.remove(idCasilla);
            if (activity.numAciertos >= activity.numero / 4) {
                activity.finDelJuego(true);
            }
        } else {
            botonTocado.setBackgroundColor(Color.parseColor("#4CAF50"));
            activity.numFallidos += 1;
            if (activity.numFallidos >= (activity.numero / 2)) {
                activity.finDelJuego(false);
            }
        }
    }
}
