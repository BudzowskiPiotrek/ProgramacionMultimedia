package com.example.buscaminas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    public LinearLayout menu;
    public GridLayout casillasJuego;
    public EditText cantidad;
    public Button empezar, reset;
    public Set<Integer> minas;
    public int numFallidos, numAciertos, numero;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.layout_menu);
        casillasJuego = findViewById(R.id.layout_juego);
        cantidad = (EditText) findViewById(R.id.editable_menu);
        empezar = (Button) findViewById(R.id.jugar_menu);
        reset = findViewById(R.id.resetear);

        reset.setOnClickListener(new ResetOyente(this));
        empezar.setOnClickListener(new CrearOyente(this));
    }

    public void crearMinas(int numero) {
        // CREO BOTONES MINAS Y CUALES SON Y NO MINAS
        inicializarMinas(numero);
        BotonesOyente oyenteBtns = new BotonesOyente(this);
        for (int i = 0; i < numero; i++) {
            Button btn = new Button(MainActivity.this);
            btn.setLayoutParams(new GridLayout.LayoutParams());
            btn.setTag(i);
            casillasJuego.addView(btn);
            btn.setOnClickListener(oyenteBtns);
        }
    }

    public void inicializarMinas(int numero) {
        // COMO LA COLECCION SET NO PERMITE REPETIDOS PUES BUCLE WHILE Y HASTA QUE TENGA SIZE/4 PARA PARAR WHILE
        minas = new HashSet<>();
        while (minas.size() != (int) (numero / 4)) {
            int num = (int) (Math.random() * numero);
            minas.add(num);
        }
    }

    public void resetGame() {
        // DESAPARECE BOTON DE RESET Y SE BORRA Y CREA DE NUEVO MINAS CON MISMO NUMERO QUE EN PRINCIPIO
        reset.setVisibility(View.GONE);
        numAciertos = 0;
        numFallidos = 0;
        casillasJuego.removeAllViews();
        crearMinas(numero);
    }

    public void finDelJuego(boolean victoria) {
        // SI TERMINA JUEGO SE DESAHILITARA TODOS LOS BOTONES PARA NO PODER MAS SEGUIR
        for (int i = 0; i < casillasJuego.getChildCount(); i++) {
            View child = casillasJuego.getChildAt(i);
            if (child instanceof Button) {
                child.setEnabled(false);
            }
        }
        // RECOGEMOS BOOLEANO PARA SABER SI GANO O NO
        String mensaje;
        if (victoria) {
            mensaje = getString(R.string.victoria);
        } else {
            mensaje = getString(R.string.derrota);
        }
        // SE IMPRIME RESULTADO Y APARECE BOTON DE RESETAR CON MISMA CANTIDAD DE CAMPOS
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
        reset.setVisibility(View.VISIBLE);
    }
}