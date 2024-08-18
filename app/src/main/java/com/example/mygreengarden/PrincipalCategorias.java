package com.example.mygreengarden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;


public class PrincipalCategorias extends AppCompatActivity {

    private Button buttonTuActividad;
    private Button buttonNutrientes;
    private Button buttonEstadisticas;
    private Button buttonConsejos;
    private ImageView imageViewAtras;
    private ImageView imageViewCasita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_categorias);

        buttonTuActividad=findViewById(R.id.buttonTuActividad);
        buttonNutrientes=findViewById(R.id.buttonNutrientes);
        buttonEstadisticas=findViewById(R.id.buttonEstadisticas);
        buttonConsejos=findViewById(R.id.buttonConsejos);
        imageViewAtras=findViewById(R.id.imageViewAtras);
        imageViewCasita=findViewById(R.id.imageViewCasita);

        buttonTuActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalCategorias.this,TuActividad.class);
                startActivity(intent);
            }
        });

        buttonNutrientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalCategorias.this,NutrientesPlanta.class);
                startActivity(intent);
            }
        });

        buttonEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalCategorias.this,EstadisticasConsumo.class);
                startActivity(intent);
            }
        });

        buttonConsejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalCategorias.this, PrincipalConsejos.class);
                startActivity(intent);
            }
        });

        imageViewAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalCategorias.this,InicioSesion.class);
                startActivity(intent);
            }
        });

        imageViewCasita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalCategorias.this,Bienvenida.class);
                startActivity(intent);
            }
        });

    }
}