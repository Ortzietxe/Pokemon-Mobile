package com.example.pokemonmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Conversacion extends AppCompatActivity {
    TextView dialogo, actividad;
    String nombre, momento, lista, modo;
    InputStream fraw = null;
    ImageView rival;
    Intent intent;
    int max = 6;
    int min = 1;
    int range = max - min + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversacion);

        //this.getSupportActionBar().hide();

        dialogo = findViewById(R.id.dialogo);
        rival = findViewById(R.id.rival);

        Bundle extras = getIntent().getExtras();
        momento = extras.getString("momento");
        nombre = extras.getString("nombre");
        modo = extras.getString("modo");

        switch (momento) {
            case "inicioCombate":
                intent = new Intent(Conversacion.this, CombateNormal.class);
                int rand = (int) (Math.random() * range) + min;

                if(modo != null) {
                    if (modo.equals("supervivencia")) {
                        intent.putExtra("modo", "supervivencia");
                    }
                }

                try {
                    switch (nombre) {
                        case "rival1":
                            rival.setImageResource(R.drawable.cara_rival1);
                            fraw = getResources().openRawResource(R.raw.intro_rival1);

                            intent.putExtra("nombre", "rival1");

                            intent.putExtra("vidas", "3");

                            intent.putExtra("nomPokemonRival", "pokemon" + rand);
                            break;
                        case "rival2":
                            rival.setImageResource(R.drawable.cara_rival2);
                            fraw = getResources().openRawResource(R.raw.intro_rival2);

                            intent.putExtra("nombre", "rival2");

                            intent.putExtra("vidas", "3");

                            intent.putExtra("nomPokemonRival", "pokemon" + rand);
                            break;
                        case "rival3":
                            rival.setImageResource(R.drawable.cara_rival3);
                            fraw = getResources().openRawResource(R.raw.intro_rival3);

                            intent.putExtra("nombre", "rival3");

                            intent.putExtra("vidas", "3");

                            intent.putExtra("nomPokemonRival", "pokemon" + rand);
                            break;
                        case "rival4":
                            rival.setImageResource(R.drawable.cara_rival4);
                            fraw = getResources().openRawResource(R.raw.intro_rival4);

                            intent.putExtra("nombre", "rival4");

                            intent.putExtra("vidas", "3");

                            intent.putExtra("nomPokemonRival", "pokemon" + rand);
                            break;
                        case "rival5":
                            rival.setImageResource(R.drawable.cara_rival5);
                            fraw = getResources().openRawResource(R.raw.intro_rival5);

                            intent.putExtra("nombre", "rival5");

                            intent.putExtra("vidas", "3");

                            intent.putExtra("nomPokemonRival", "pokemon" + rand);
                            break;
                        case "rival6":
                            rival.setImageResource(R.drawable.cara_rival6);
                            fraw = getResources().openRawResource(R.raw.intro_rival6);

                            intent.putExtra("nombre", "rival6");

                            intent.putExtra("vidas", "3");

                            intent.putExtra("nomPokemonRival", "pokemon" + rand);
                            break;
                        case "Misty":
                            rival.setImageResource(R.drawable.cara_misty);
                            fraw = getResources().openRawResource(R.raw.intro_rival_misty);

                            intent.putExtra("nombre", "Misty");

                            intent.putExtra("vidas", "1");

                            intent.putExtra("nomPokemonRival", "lapras");
                            break;
                        case "Brendan":
                            rival.setImageResource(R.drawable.cara_brendan);
                            fraw = getResources().openRawResource(R.raw.intro_rival_brendan);

                            intent.putExtra("nombre", "Brendan");

                            intent.putExtra("vidas", "6");

                            intent.putExtra("nomPokemonRival", "sceptile");
                            break;
                        case "Brock":
                            rival.setImageResource(R.drawable.cara_brock);
                            fraw = getResources().openRawResource(R.raw.intro_rival_brock);

                            intent.putExtra("nombre", "Brock");

                            intent.putExtra("vidas", "1");

                            intent.putExtra("nomPokemonRival", "onix");
                            break;
                        case "Maestra":
                            rival.setImageResource(R.drawable.cara_maestra);
                            fraw = getResources().openRawResource(R.raw.intro_rival_maestra);

                            intent.putExtra("nombre", "Maestra");

                            intent.putExtra("vidas", "6");

                            intent.putExtra("nomPokemonRival", "salamence");
                            break;
                    }
                    BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));

                    String linea = brin.readLine();
                    while (linea != null) {
                        dialogo.setText(linea);
                        linea = brin.readLine();
                    }
                    fraw.close();
                } catch (Exception ex) {
                    Log.e("Ficheros", "Error al leer fichero de recursos en Assets");
                }
                break;
            case "finalCombate":
                lista = buscarPkmns();
                try {
                    switch (nombre) {
                        case "rival1":
                            rival.setImageResource(R.drawable.cara_rival1);
                            fraw = getResources().openRawResource(R.raw.despedida_rival1);
                            break;
                        case "rival2":
                            rival.setImageResource(R.drawable.cara_rival2);
                            fraw = getResources().openRawResource(R.raw.despedida_rival2);
                            break;
                        case "rival3":
                            rival.setImageResource(R.drawable.cara_rival3);
                            fraw = getResources().openRawResource(R.raw.despedida_rival3);
                            break;
                        case "rival4":
                            rival.setImageResource(R.drawable.cara_rival4);
                            fraw = getResources().openRawResource(R.raw.despedida_rival4);
                            break;
                        case "rival5":
                            rival.setImageResource(R.drawable.cara_rival5);
                            fraw = getResources().openRawResource(R.raw.despedida_rival5);
                            break;
                        case "rival6":
                            rival.setImageResource(R.drawable.cara_rival6);
                            fraw = getResources().openRawResource(R.raw.despedida_rival6);
                            break;
                        case "Misty":
                            rival.setImageResource(R.drawable.cara_misty);
                            fraw = getResources().openRawResource(R.raw.despedida_rival_misty);
                            medallaMisty();
                            break;
                        case "Brendan":
                            rival.setImageResource(R.drawable.cara_brendan);
                            fraw = getResources().openRawResource(R.raw.despedida_rival_brendan);
                            medallaBrendan();
                            break;
                        case "Brock":
                            rival.setImageResource(R.drawable.cara_brock);
                            fraw = getResources().openRawResource(R.raw.despedida_rival_brock);
                            medallaBrock();
                            break;
                        case "Maestra":
                            rival.setImageResource(R.drawable.cara_maestra);
                            fraw = getResources().openRawResource(R.raw.despedida_rival_maestra);
                            medallaMaestra();
                            break;
                    }
                    BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));

                    String linea = brin.readLine();
                    while (linea != null) {
                        dialogo.setText(linea);
                        linea = brin.readLine();
                    }
                    fraw.close();
                } catch (Exception ex) {
                    Log.e("Ficheros", "Error al leer fichero de recursos en Assets");
                }
                intent = new Intent(Conversacion.this, Plaza.class);
                break;
        }
    }

    public void avanzar(View view) {
        startActivity(intent);
        finish();
    }

    public void medallaMisty() {
        buscarMedallaMisty();
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "medalla_misty.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("1");
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }
    }

    public void medallaBrendan() {
        buscarMedallaBrendan();
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "medalla_brendan.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("1");
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }
    }
    public void medallaBrock() {
        buscarMedallaBrock();
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "medalla_brock.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("1");
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }
    }
    public void medallaMaestra() {
        buscarMedallaMaestra();
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "medalla_maestra.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("1");
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

    private void nuevoPkmn(String nombre) {
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "lista_pokemon.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write(lista +  nombre + ",");
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }
    }


    public void buscarMedallaBrock(){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "medalla_brock.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            nuevoPkmn("onix");
            Toast.makeText(getApplicationContext(),"onix se ha unido a tu equipo",Toast.LENGTH_SHORT).show();

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

            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            nuevoPkmn("salamence");
            Toast.makeText(getApplicationContext(),"salamence se ha unido a tu equipo",Toast.LENGTH_SHORT).show();

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
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            nuevoPkmn("sceptile");
            Toast.makeText(getApplicationContext(),"sceptile se ha unido a tu equipo",Toast.LENGTH_SHORT).show();

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
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            nuevoPkmn("lapras");
            Toast.makeText(getApplicationContext(),"lapras se ha unido a tu equipo",Toast.LENGTH_SHORT).show();

            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
    }
}