package com.example.pokemonmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ZonaLideres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona_lideres);

        this.getSupportActionBar().hide();
    }

    public void irAvenida(View view) {
        Intent intent = new Intent(ZonaLideres.this, Avenida.class);
        startActivity(intent);
        finish();
    }

    public void combatirMisty(View view) {
        Intent intent = new Intent(ZonaLideres.this, Conversacion.class);
        intent.putExtra("nombre", "Misty");
        intent.putExtra("momento", "inicioCombate");
        startActivity(intent);

    }

    public void combatirBrendan(View view) {
        Intent intent = new Intent(ZonaLideres.this, Conversacion.class);
        intent.putExtra("nombre", "Brendan");
        intent.putExtra("momento", "inicioCombate");
        startActivity(intent);

    }

    public void combatirBrock(View view) {
        Intent intent = new Intent(ZonaLideres.this, Conversacion.class);
        intent.putExtra("nombre", "Brock");
        intent.putExtra("momento", "inicioCombate");
        startActivity(intent);

    }

    public void combatirMaestra(View view) {
        Intent intent = new Intent(ZonaLideres.this, Conversacion.class);
        intent.putExtra("nombre", "Maestra");
        intent.putExtra("momento", "inicioCombate");
        startActivity(intent);

    }
}