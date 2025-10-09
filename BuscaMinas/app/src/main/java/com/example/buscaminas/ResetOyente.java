package com.example.buscaminas;

import android.view.View;

public class ResetOyente implements View.OnClickListener {
    private MainActivity activity;

    public ResetOyente(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        activity.resetGame();
    }
}
