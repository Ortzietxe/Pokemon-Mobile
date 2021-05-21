package com.example.pokemonmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CaminoPueblo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camino_pueblo);

        this.getSupportActionBar().hide();
    }
    public void irAvenida(View view) {
        Intent intent = new Intent(CaminoPueblo.this, Avenida.class);
        startActivity(intent);
        finish();
    }
    public void irSupervivencia(View view) {
        Intent intent = new Intent(CaminoPueblo.this, SeleccionSupervivencia.class);
        startActivity(intent);
    }
    public void irPueblo(View view) {
        /*Intent intent = new Intent(CaminoPueblo.this, Avenida.class);
        startActivity(intent);
        finish();*/
    }
}