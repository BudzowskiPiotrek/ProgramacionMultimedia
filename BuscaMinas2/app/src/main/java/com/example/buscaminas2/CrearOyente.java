package com.example.buscaminas2;

import android.view.View;
import android.widget.Toast;

public class CrearOyente implements View.OnClickListener {
    private MainActivity activity;

    public CrearOyente(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        activity.numAciertos = 0;
        activity.numFallidos = 0;

        try {
            activity.numero = Integer.parseInt(activity.cantidad.getText().toString());

            if (activity.numero >= 4 && activity.numero <= 40) {
                activity.menu.setVisibility(View.GONE);
                activity.casillasJuego.setVisibility(View.VISIBLE);
                activity.crearMinas(activity.numero);
            } else {
                Toast.makeText(activity, R.string.error1, Toast.LENGTH_LONG).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(activity, R.string.error2, Toast.LENGTH_SHORT).show();
        }
    }
}
