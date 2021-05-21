package com.example.pokemonmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Plaza extends AppCompatActivity {

    int victorias = 0;
    String rango = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plaza);

        this.getSupportActionBar().hide();

        victorias = buscarVictorias();

        rango = buscarRango();

        switch(rango){
            case "bronce":
                if(victorias >= 10) {
                    actualizarRango("plata");
                    Toast.makeText(getApplicationContext(), "Has ascendido a la liga de plata", Toast.LENGTH_SHORT).show();
                }
                break;
            case "plata":
                if(victorias >= 30) {
                    actualizarRango("oro");
                    Toast.makeText(getApplicationContext(), "Has ascendido a la liga de oro", Toast.LENGTH_SHORT).show();
                }
                break;
            case "oro":
                if(victorias >= 50){
                    actualizarRango("diamante");
                    Toast.makeText(getApplicationContext(), "Has ascendido a la liga de diamante", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    public void irAvenida(View view) {
        Intent intent = new Intent(Plaza.this, Avenida.class);
        startActivity(intent);
        finish();
    }

    public void verHistorial(View view) {
        Intent intent = new Intent(Plaza.this, Historial.class);
        startActivity(intent);
        finish();
    }

    public void verPkmn(View view) {
        Intent intent = new Intent(Plaza.this, ListaPokemon.class);
        startActivity(intent);
        finish();
    }

    public void irZonaReclutamiento(View view) {

    }

    private int buscarVictorias(){
        int cantVictorias = 0;
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "victorias.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                texto = texto + linea;
                cantVictorias = Integer.parseInt(texto);
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
        return cantVictorias;
    }

    private String buscarRango() {
        String rango = "";
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "rango.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                rango = texto + linea;
                //Toast.makeText(getApplicationContext(),"" + texto,Toast.LENGTH_SHORT).show();
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
        return rango;
    }

    private void actualizarRango(String nuevoRango){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "rango.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("" + nuevoRango);
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }
    }
}