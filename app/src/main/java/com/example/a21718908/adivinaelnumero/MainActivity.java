package com.example.a21718908.adivinaelnumero;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int contIntentos = 5;
    private int numero = generarRandom();
    private TextView pista;
    private TextView opcionUsu;
    private TextView intentos;
    private Button boton;
    private RelativeLayout lay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pista = findViewById(R.id.textoPista);
        opcionUsu = findViewById(R.id.editText);
        intentos = findViewById(R.id.textView2);
        boton = findViewById(R.id.btnProbar);
        lay = findViewById(R.id.layout);

        String mensaje = String.format(getResources().getString(R.string.intentos), contIntentos);
        intentos.setText(mensaje);

    }
    public void pulsarBoton(View view){

        contIntentos--;

        String mensaje3 = String.format(getResources().getString(R.string.intentos), contIntentos);
        intentos.setText(mensaje3);

        int seleccion = Integer.parseInt(opcionUsu.getText().toString());

        if(comprobar(seleccion)){
            acabarPrograma(true);
        }else if(!comprobar(seleccion) && contIntentos == 0){
            acabarPrograma(false);
        }





    }

    private void acabarPrograma(boolean mensaje) {
        boton.setEnabled(false);
        boton.setText(getResources().getString(R.string.btnPruebaNumero));

        if(mensaje == true){
            pista.setText(getResources().getString(R.string.textoPistaVictoria));
            lay.setBackgroundColor(Color.GREEN);

        }else{
            String mensaje2 =String.format(getResources().getString(R.string.textoPistaDerrota),numero);
            pista.setText(mensaje2);
            lay.setBackgroundColor(Color.RED);
        }

    }

    private boolean comprobar(int seleccion) {

        boolean acierto = true;

        if(seleccion < numero){
            pista.setText(getResources().getString(R.string.textoPista1));
            acierto = false;
        }else if(seleccion > numero){
            pista.setText(getResources().getString(R.string.textoPista2));
            acierto = false;
        }

        return acierto;
    }

    public int generarRandom(){
        Random randomGenerar = new Random();

     return randomGenerar.nextInt(100 + 1) - 1;
    }

}
