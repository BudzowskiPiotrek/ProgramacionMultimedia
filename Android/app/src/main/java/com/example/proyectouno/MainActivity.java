package com.example.proyectouno;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText et1, et2;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv3 = (TextView) findViewById(R.id.tv3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    //Este método se ejecutará cuando se presione el botón
    public void sumar(View view) {
        int nro1 = Integer.parseInt(et1.getText().toString());
        int nro2 = Integer.parseInt(et2.getText().toString());
        int suma = nro1 + nro2;
        String resu = String.valueOf(suma);
        tv3.setText(resu);
    }

}