package com.example.pokemonmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Historial extends AppCompatActivity {
    ImageView rango;
    ImageView medallaBrock;
    ImageView medallaMaestra;
    ImageView medallaBrendan;
    ImageView medallaMisty;
    TextView victorias, derrotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        this.getSupportActionBar().hide();

        rango = findViewById(R.id.rango);
        medallaBrock = findViewById(R.id.medallaBrock);
        medallaMaestra = findViewById(R.id.medallaMaestra);
        medallaBrendan = findViewById(R.id.medallaBrendan);
        medallaMisty = findViewById(R.id.medallaMisty);
        victorias = findViewById(R.id.victorias);
        derrotas = findViewById(R.id.derrotas);

        buscarMedallaBrock();
        buscarMedallaMaestra();
        buscarMedallaBrendan();
        buscarMedallaMisty();

        buscarRango();
        buscarVictorias();
        buscarDerrotas();

    }
    private void buscarRango(){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "rango.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                texto = texto + linea;
                String uri = "@drawable/"+ texto;
                int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                Drawable imagenDra = ContextCompat.getDrawable(getApplicationContext(), imageResource);
                rango.setImageDrawable(imagenDra);
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
    }

    private void buscarDerrotas(){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "derrotas.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                texto = texto + linea;
                derrotas.setText(texto);
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
    }
    private void buscarVictorias(){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "victorias.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                texto = texto + linea;
                victorias.setText(texto);
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
    }

    public void buscarMedallaBrock(){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "medalla_brock.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                texto = texto + linea;
                medallaBrock.setAlpha(1f);
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
    }
    public void buscarMedallaMaestra(){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "medalla_maestra.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                texto = texto + linea;
                medallaMaestra.setAlpha(1f);
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
    }
    public void buscarMedallaBrendan(){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "medalla_brendan.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                texto = texto + linea;
                medallaBrendan.setAlpha(1f);
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
    }
    public void buscarMedallaMisty(){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "medalla_misty.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                texto = texto + linea;
                medallaMisty.setAlpha(1f);
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
    }

    public void volver(View view) {
        Intent intent = new Intent(Historial.this, Plaza.class);
        startActivity(intent);
        finish();
    }
}