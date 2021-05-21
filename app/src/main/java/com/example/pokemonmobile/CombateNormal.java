package com.example.pokemonmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CombateNormal extends AppCompatActivity {
    int max = 3;
    int min = 1;
    int range = max - min + 1;
    String ataqueRival, nomPokemonRival, nombreRival, totalVidasRival, modo;
    TextView vidasRestantesRival, vidasRestantesAliado, vidasTotalesRival, vidasTotalesAliado;
    ImageView pokemonAliado, pokemonRival;
    int vidasRival, vidasAliado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combate_normal);
        this.getSupportActionBar().hide();

        vidasRestantesRival = findViewById(R.id.vidasRestantesRival);
        vidasRestantesAliado = findViewById(R.id.vidasRestantesAliado);
        vidasTotalesRival = findViewById(R.id.vidasTotalesRival);
        vidasTotalesAliado = findViewById(R.id.vidasTotalesAliado);
        pokemonAliado = findViewById(R.id.pokemonAliado);
        pokemonRival = findViewById(R.id.pokemonRival);

        buscarPkmnAliado();

        Bundle extras = getIntent().getExtras();
        nombreRival = extras.getString("nombre");
        modo = extras.getString("modo");
        nomPokemonRival = extras.getString("nomPokemonRival");
        totalVidasRival = extras.getString("vidas");
        switch (nomPokemonRival){
            case "pokemon1":
                pokemonRival.setImageResource(R.drawable.hitmonchan_delante);

                break;
            case "pokemon2":
                pokemonRival.setImageResource(R.drawable.primeape_delante);

                break;
            case "pokemon3":
                pokemonRival.setImageResource(R.drawable.hitmonlee_delante);

                break;
            case "pokemon4":
                pokemonRival.setImageResource(R.drawable.kangaskhan_delante);

                break;
            case "pokemon5":
                pokemonRival.setImageResource(R.drawable.rhydon_delante);

                break;
            case "pokemon6":
                pokemonRival.setImageResource(R.drawable.hariyama_delante);

                break;
            default:
                String uri = "@drawable/"+ nomPokemonRival + "_delante";
                int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                Drawable imagenDra = ContextCompat.getDrawable(getApplicationContext(), imageResource);
                pokemonRival.setImageDrawable(imagenDra);
                break;
        }
        vidasTotalesRival.setText("/" + totalVidasRival);
        vidasRestantesRival.setText(totalVidasRival);
        if(modo != null) {
            if (modo.equals("supervivencia")) {
                vidasTotalesAliado.setText("/9");
                vidasRestantesAliado.setText("" + Supervivencia1.vidasTotales);
            }
        }
    }

    private void quitarVidaRival() {
        vidasRival = Integer.parseInt(vidasRestantesRival.getText().toString());
        vidasRival--;
        if (vidasRival != 0){
            parpadeo(pokemonRival);
            vidasRestantesRival.setText("" + vidasRival);
        }
        else{
            parpadeo(pokemonRival);
            actualizarVictorias();
            Intent intent;
            if(modo != null) {
                if (modo.equals("supervivencia")) {
                    Supervivencia1.contSupervivencia++;
                    intent = new Intent(CombateNormal.this, Supervivencia1.class);
                } else {
                    intent = new Intent(CombateNormal.this, Conversacion.class);
                    intent.putExtra("nombre", "" + nombreRival);
                    intent.putExtra("momento", "finalCombate");
                }
            }else{
                intent = new Intent(CombateNormal.this, Conversacion.class);
                intent.putExtra("nombre", "" + nombreRival);
                intent.putExtra("momento", "finalCombate");
            }
            startActivity(intent);
            finish();
        }
    }

    private void quitarVidaAliado() {
        vidasAliado = Integer.parseInt(vidasRestantesAliado.getText().toString());
        vidasAliado--;

        if (vidasAliado != 0){
            parpadeo(pokemonAliado);
            vidasRestantesAliado.setText("" +vidasAliado);
        }
        else{
            parpadeo(pokemonAliado);
            actualizarDerrotas();
            Intent intent = new Intent(CombateNormal.this, Plaza.class);
            startActivity(intent);
            finish();
        }
    }

    public void piedra(View view) {
        ataqueRival = turnoDelOponente();
        switch (ataqueRival){
            case "piedra":
                //empate();
                break;
            case "papel":
                quitarVidaAliado();
                break;
            case "tijera":
                quitarVidaRival();
                break;
        }
    }

    public void papel(View view) {
        ataqueRival = turnoDelOponente();
        switch (ataqueRival){
            case "piedra":
                quitarVidaRival();
                break;
            case "papel":
                //empate();
                break;
            case "tijera":
                quitarVidaAliado();
                break;
        }
    }
    public void tijera(View view) {
        ataqueRival = turnoDelOponente();
        switch (ataqueRival){
            case "piedra":
                quitarVidaAliado();
                break;
            case "papel":
                quitarVidaRival();
                break;
            case "tijera":
                //empate();
                break;
        }
    }
    public String turnoDelOponente() {
        int rand = (int) (Math.random() * range) + min;
        switch (rand){
            case 1:
                return "piedra";
            case 2:
                return "papel";
            case 3:
                return "tijera";
            default:
                return "piedra";
        }
    }

    private void buscarPkmnAliado(){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "pokemon_seleccionado.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                texto = texto + linea;
                String uri = "@drawable/"+ texto + "_detras";
                int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                Drawable imagenDra = ContextCompat.getDrawable(getApplicationContext(), imageResource);
                pokemonAliado.setImageDrawable(imagenDra);
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
    }
    private void actualizarVictorias(){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "victorias.txt");
            int cantidad = buscarVictorias() + 1;
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("" + cantidad);
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }
    }

    private void actualizarDerrotas(){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "derrotas.txt");
            int cantidad = buscarDerrotas() + 1;
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("" + cantidad);
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }
    }

    private int buscarDerrotas(){
        int cantDerrotas = 0;
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "derrotas.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                texto = texto + linea;
                cantDerrotas = Integer.parseInt(texto);
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
        return cantDerrotas;
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

    public void huir(View view){
        new AlertDialog.Builder(this)
                .setMessage("¿Realmente deseas huir de la pelea?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Intent intent = new Intent(CombateNormal.this, Avenida.class);
                        startActivity(intent);
                        finish();
                    }})
                .setNegativeButton("No", null).show();
    }

    public void parpadeo(ImageView pkmn){
        Animation myFadeInAnimation = AnimationUtils.loadAnimation(CombateNormal.this, R.anim.tween);
        pkmn.startAnimation(myFadeInAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pkmn.clearAnimation();
            }
        }, 1500);
    }
}