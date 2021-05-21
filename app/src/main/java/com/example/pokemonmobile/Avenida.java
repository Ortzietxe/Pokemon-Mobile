package com.example.pokemonmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Avenida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avenida);

        this.getSupportActionBar().hide();
    }

    public void irLideres(View view) {
        Intent intent = new Intent(Avenida.this, ZonaLideres.class);
        startActivity(intent);
        finish();
    }

    public void irPlaza(View view) {
        Intent intent = new Intent(Avenida.this, Plaza.class);
        startActivity(intent);
        finish();
    }
    public void irCaminoPueblo(View view) {
        Intent intent = new Intent(Avenida.this, CaminoPueblo.class);
        startActivity(intent);
        finish();
    }
    public void irCombates(View view) {
        Intent intent = new Intent(Avenida.this, ZonaCombates.class);
        startActivity(intent);
        finish();
    }
}