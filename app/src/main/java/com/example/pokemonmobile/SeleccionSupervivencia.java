package com.example.pokemonmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SeleccionSupervivencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_supervivencia);

        //this.getSupportActionBar().hide();
    }

    public void volver(View view) {
        this.finish();
    }

    public void irSupervivencia1(View view) {
        Intent intent = new Intent(SeleccionSupervivencia.this, Supervivencia1.class);
        startActivity(intent);
        finish();
    }

    public void irSupervivencia5(View view) {
        Toast.makeText(getApplicationContext(),"PROXIMAMENTE",Toast.LENGTH_SHORT).show();
    }

    public void irSupervivencia2(View view) {
        Toast.makeText(getApplicationContext(),"PROXIMAMENTE",Toast.LENGTH_SHORT).show();
    }

    public void irSupervivencia3(View view) {
        Toast.makeText(getApplicationContext(),"PROXIMAMENTE",Toast.LENGTH_SHORT).show();
    }

    public void irSupervivencia4(View view) {
        Toast.makeText(getApplicationContext(),"PROXIMAMENTE",Toast.LENGTH_SHORT).show();
    }
}