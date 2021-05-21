package com.example.pokemonmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Supervivencia1 extends AppCompatActivity {
    ImageView rival, fondo;
    int max = 6;
    int min = 1;
    int range = max - min + 1;
    Intent intent;
    public static int vidasTotales = 9;
    public static int contSupervivencia = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervivencia1);

        this.getSupportActionBar().hide();

        rival = findViewById(R.id.rival);
        fondo = findViewById(R.id.fondo);

        if (contSupervivencia < 6){
            if ((contSupervivencia % 2) == 0) {
                fondo.setImageResource(R.drawable.supervivencia_cueva1);
            }

            else {
                fondo.setImageResource(R.drawable.supervivencia_cueva2);
            }
        }else{
            Intent intent = new Intent(Supervivencia1.this, FinalSupervivencia1.class);
            startActivity(intent);
            finish();
        }

        intent = new Intent(Supervivencia1.this, Conversacion.class);

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
        intent.putExtra("modo", "supervivencia");
    }

    public void conversacion(View view) {
        startActivity(intent);
    }


    public void huir(View view){
        new AlertDialog.Builder(this)
                .setMessage("¿Realmente deseas huir de la supervivencia?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Intent intent = new Intent(Supervivencia1.this, CaminoPueblo.class);
                        startActivity(intent);
                        finish();
                    }})
                .setNegativeButton("No", null).show();
    }
}