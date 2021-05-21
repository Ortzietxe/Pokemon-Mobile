package com.example.pokemonmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ZonaCombates extends AppCompatActivity {
    ImageView rival, fondo;
    int max = 6;
    int min = 1;
    int range = max - min + 1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona_combates);

        this.getSupportActionBar().hide();

        rival = findViewById(R.id.rival);
        fondo = findViewById(R.id.fondo);

        buscarRango();

        intent = new Intent(ZonaCombates.this, Conversacion.class);

        int rand = (int) (Math.random() * range) + min;

        switch (rand) {
            case 1:
                rival.setImageResource(R.drawable.rival1);
                intent.putExtra("nombre", "rival1");
                break;
            case 2:
                rival.setImageResource(R.drawable.rival2);
                intent.putExtra("nombre", "rival2");
                break;
            case 3:
                rival.setImageResource(R.drawable.rival3);
                intent.putExtra("nombre", "rival3");
                break;
            case 4:
                rival.setImageResource(R.drawable.rival4);
                intent.putExtra("nombre", "rival4");
                break;
            case 5:
                rival.setImageResource(R.drawable.rival5);
                intent.putExtra("nombre", "rival5");
                break;
            case 6:
                rival.setImageResource(R.drawable.rival6);
                intent.putExtra("nombre", "rival6");
                break;
        }
        intent.putExtra("momento", "inicioCombate");
    }

    public void conversacion(View view) {
        startActivity(intent);
    }

    public void irAvenida(View view) {
        Intent intent = new Intent(ZonaCombates.this, Avenida.class);
        startActivity(intent);
        finish();
    }

    private void buscarRango() {
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "rango.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                texto = texto + linea;
                //Toast.makeText(getApplicationContext(),"" + texto,Toast.LENGTH_SHORT).show();

                switch(texto){
                    case "bronce":
                        fondo.setImageResource(R.drawable.arena1);
                        break;
                    case "plata":
                        fondo.setImageResource(R.drawable.arena2);
                        break;
                    case "oro":
                        fondo.setImageResource(R.drawable.arena3);
                        break;
                    case "diamante":
                        fondo.setImageResource(R.drawable.arena4);
                        break;
                }
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
    }
}

