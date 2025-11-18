package com.example.radiobuttonkt

import android.text.Editable
import android.text.TextWatcher
import android.widget.RadioGroup


class Oyente(private val activity: MainActivity) :
    RadioGroup.OnCheckedChangeListener,
    TextWatcher {

    override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
        activity.calcularValores()
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        activity.calcularValores()
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }


    override fun afterTextChanged(s: Editable?) {
    }
}