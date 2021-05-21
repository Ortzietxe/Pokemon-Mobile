package com.example.pokemonmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FinalSupervivencia1 extends AppCompatActivity {

    String lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_supervivencia1);
    }

    public void capturar(View view) {
        buscarPkmns();

        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "lista_pokemon.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write(lista +   "charizard_negro,");
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }
    }

    private String buscarPkmns() {
        String lista = "";
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "lista_pokemon.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String linea = br.readLine();
            while (linea != null) {
                lista = lista + linea;
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", lista);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
        return lista;
    }

}