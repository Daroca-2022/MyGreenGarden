package com.example.mygreengarden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class NutrientesPlanta extends AppCompatActivity {

    String agua = "agua";
    String energia = "energía";
    String abono = "abono";
    private Button buttonAccionAgua, buttonAccionEnergiaElectrica, buttonAccionAbono;
    private ImageView imageViewAtras, imageViewCasita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrientes_planta);

        buttonAccionAgua = findViewById(R.id.buttonAccionAgua);
        buttonAccionEnergiaElectrica = findViewById(R.id.buttonAccionEnergiaElectrica);
        buttonAccionAbono= findViewById(R.id.buttonAccionAbono);
        imageViewAtras = findViewById(R.id.imageViewAtras);
        imageViewCasita = findViewById(R.id.imageViewCasita);

        buttonAccionAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NutrientesPlanta.this,Cultivos.class);
                intent.putExtra("nutrienteAgua", agua);
                startActivity(intent);
            }
        });

        buttonAccionEnergiaElectrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NutrientesPlanta.this,Cultivos.class);
                intent.putExtra("nutrienteEnergia", energia);
                startActivity(intent);
            }
        });

        buttonAccionAbono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NutrientesPlanta.this,Cultivos.class);
                intent.putExtra("nutrienteAbono", abono);
                startActivity(intent);
            }
        });

        imageViewAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NutrientesPlanta.this,PrincipalCategorias.class);
                startActivity(intent);
            }
        });

        imageViewCasita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NutrientesPlanta.this,Bienvenida.class);
                startActivity(intent);
            }
        });

    }
}