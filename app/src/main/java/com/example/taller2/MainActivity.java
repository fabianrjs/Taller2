package com.example.taller2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lanzarCamara(View v){
        startActivity( new Intent( this, Camara.class ) );
    }

    public void lanzarContactos(View v){
        startActivity( new Intent(this, Contactos.class) );
    }

    public void lanzarMapa(View v){
        startActivity( new Intent(this, Mapa.class) );
    }
}