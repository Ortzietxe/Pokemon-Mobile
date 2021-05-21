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

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class ElegirInicial extends AppCompatActivity {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final int SOLICITUD_PERMISO_WRITE_SD = 0;
    private static final int SOLICITUD_PERMISO_READ_SD = 1;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_inicial);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (comprobarPermisos()){
            if (sdDisponible()) {
            }
            else
                Toast.makeText(ElegirInicial.this,
                        "Tarjeta NO lista para poder escribir",
                        Toast.LENGTH_SHORT).show();
        }
        else {
            solicitarPermiso(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    "Sin este permiso no se puede ESCRIBIR en el dispositivo externo",
                    SOLICITUD_PERMISO_WRITE_SD, ElegirInicial.this);
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public boolean comprobarPermisos (){
        //Comprobamos que tenemos permiso para realizar la operación.
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean sdDisponible (){
        boolean sdDisponible = false;
        boolean sdAccesoEscritura= false;
        //Comprobamos el estado de la memoria externa
        String estado = Environment.getExternalStorageState();
        Log.i("Memoria", estado);
        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponible = true;
            sdAccesoEscritura = true;
        } else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            sdDisponible = true;
            sdAccesoEscritura = false;
        } else {
            sdDisponible = false;
            sdAccesoEscritura = false;
        }
        if (sdDisponible &&sdAccesoEscritura)
            return true;
        else
            return false;
    }

    private static void solicitarPermiso (final String permiso,
                                          String justificacion,
                                          final int requestCode,
                                          final Activity actividad){
        if (ActivityCompat.shouldShowRequestPermissionRationale(actividad, permiso)){
            //Informamos al usuario para qué y por qué
            //se necesitan los permisos
            new AlertDialog.Builder(actividad)
                    .setTitle("Solicitud de permiso")
                    .setMessage(justificacion)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    ActivityCompat.requestPermissions(actividad,
                                            new String[]{permiso},requestCode);
                                }
                            }).show();
        }
        else {
            //Muestra el cuadro de dialogo para la solicitud de permisos y
            //registra el permiso según respuesta del usuario
            ActivityCompat.requestPermissions(actividad,
                    new String[]{permiso}, requestCode);
        }
    }
    /*private void escribirEnSD (){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "lista_pokemon.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("" + "0");
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }
    }
    private void leerDeSD(){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "lista_pokemon.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {
                texto = texto + linea + "\n";
                Toast.makeText(Plaza.this,"" + texto,Toast.LENGTH_SHORT).show();
                linea = br.readLine();
            }
            br.close();
            Log.i("Ficheros", texto);
        } catch (Exception ex) {
            Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
        }
    }*/
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == SOLICITUD_PERMISO_WRITE_SD){
            if (grantResults.length >= 1 &&
                    grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Log.e("AAAA", "Escribir Memoria SD");
                sdDisponible();
            }else {
                Toast.makeText(this,
                        "No se puede ESCRIBIR en memoria SD",
                        Toast.LENGTH_LONG ).show();
            }
        }
        else if (requestCode == SOLICITUD_PERMISO_READ_SD){
            if (grantResults.length == 1 &&
                    grantResults[0]==PackageManager.PERMISSION_GRANTED){
            }else {
                Toast.makeText(this,
                        "No se puede LEER de memoria SD",
                        Toast.LENGTH_LONG ).show();
            }
        }
    }

    public void seleccionarHariyama(View view) {
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "lista_pokemon.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("hariyama,");
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }

        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "pokemon_seleccionado.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("hariyama");
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }

        Intent intent = new Intent(ElegirInicial.this, Plaza.class);
        startActivity(intent);
        finish();
    }

    public void seleccionarBlaziken(View view) {
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "lista_pokemon.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("blaziken,");
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }

        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "pokemon_seleccionado.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("blaziken");
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }

        Intent intent = new Intent(ElegirInicial.this, Plaza.class);
        startActivity(intent);
        finish();
    }

    public void seleccionarVenusaur(View view) {
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "lista_pokemon.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("venusaur,");
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }

        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "pokemon_seleccionado.txt");
            OutputStreamWriter osw =
                    new OutputStreamWriter(new FileOutputStream(f));
            osw.write("venusaur");
            osw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
        }

        Intent intent = new Intent(ElegirInicial.this, Plaza.class);
        startActivity(intent);
        finish();
    }
}