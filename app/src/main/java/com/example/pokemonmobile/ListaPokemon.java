package com.example.pokemonmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ListaPokemon extends AppCompatActivity {
    LinearLayout caja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pokemon);

        this.getSupportActionBar().hide();

        caja = findViewById(R.id.lista);

        String lista = buscarPkmns();
        String[] todosLosPkmn = lista.split(",");

        for (String pkmn:todosLosPkmn) {
            agregarCuadroPokemon(pkmn);
        }
    }

    public void seleccion(View v) {
        String nombre = v.getTag().toString();
        seleccionarPkmn(nombre);
        Toast.makeText(getApplicationContext(),nombre + " es ahora el pokemon seleccionado",Toast.LENGTH_SHORT).show();
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

    private void seleccionarPkmn(String nombre) {
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "pokemon_seleccionado.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("" + nombre);
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }
    }

    private void agregarCuadroPokemon(String nombre) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        int screenHeight = displaymetrics.heightPixels;
        int screenWidth = displaymetrics.widthPixels;

        ImageView imageView = new ImageView(this);

        String uri = "@drawable/"+ nombre + "_cuadro";
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable imagenDra = ContextCompat.getDrawable(getApplicationContext(), imageResource);
        imageView.setImageDrawable(imagenDra);
        imageView.setTag(nombre);
        imageView.setOnClickListener(this::seleccion);

        int imgHeight = (int) (screenHeight* 0.5);
        int imgWidth =  (int) (screenWidth* 0.5);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(imgWidth, imgHeight);
        imageView.setLayoutParams(layoutParams);

        caja.addView(imageView);
    }
    public void volver(View view) {
        Intent intent = new Intent(ListaPokemon.this, Plaza.class);
        startActivity(intent);
        finish();
    }
}