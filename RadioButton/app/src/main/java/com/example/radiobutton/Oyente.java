package com.example.radiobutton;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RadioGroup;

public class Oyente implements RadioGroup.OnCheckedChangeListener, TextWatcher {

    private MainActivity activity;

    public Oyente(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        activity.calcularValores();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        activity.calcularValores();
    }

    // DOS METODOS OBLIGATORIOS DE INTERFACE TEXTWATCHER, COMO NO LOS USARE NO SE DESAROLLAN
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}