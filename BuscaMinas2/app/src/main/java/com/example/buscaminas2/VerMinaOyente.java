package com.example.buscaminas2;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class VerMinaOyente implements View.OnClickListener {
    private MainActivity activity;
    private int contador = 0;

    public VerMinaOyente(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        CheckBox cb = (CheckBox) v;
        boolean verMinas = cb.isChecked();
        if (!activity.minas.isEmpty()) {
            for (int i = 0; i < activity.casillasJuego.getChildCount(); i++) {
                View child = activity.casillasJuego.getChildAt(i);
                if (child instanceof Button) {
                    if (activity.minas.contains(child.getTag())) {
                        if (verMinas&& contador<1) {
                            child.setBackgroundColor(Color.parseColor("#FF0000"));
                            contador++;
                            break;
                        } else {
                            child.setBackgroundColor(Color.parseColor("#EEEEEE"));
                            break;
                        }

                    }
                }
            }
        }
    }
}



