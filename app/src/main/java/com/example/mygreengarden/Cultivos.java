package com.example.mygreengarden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;


public class Cultivos extends AppCompatActivity implements View.OnClickListener{

    private Button buttonFrijoles, buttonLechuga, buttonTomate;
    String agua, energiaElectrica, abono;
    private ImageView imageViewAtras, imageViewCasita;

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultivos);

        bundle = getIntent().getExtras();
        agua = bundle.getString("nutrienteAgua");
        energiaElectrica = bundle.getString("nutrienteEnergia");
        abono = bundle.getString("nutrienteAbono");

        buttonFrijoles = findViewById(R.id.buttonFrijoles);
        buttonLechuga = findViewById(R.id.buttonLechuga);
        buttonTomate = findViewById(R.id.buttonTomate);
        imageViewAtras = findViewById(R.id.imageViewAtras);
        imageViewCasita = findViewById(R.id.imageViewCasita);

        buttonFrijoles.setOnClickListener(this);
        buttonLechuga.setOnClickListener(this);
        buttonTomate.setOnClickListener(this);

        imageViewAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cultivos.this,NutrientesPlanta.class);
                startActivity(intent);
            }
        });

        imageViewCasita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cultivos.this,Bienvenida.class);
                startActivity(intent);
            }

        });

    }

    @Override
    public void onClick(View v) {
        if ((v == buttonFrijoles && agua != null) || (v == buttonLechuga && agua != null) || (v == buttonTomate && agua != null)){
            Intent intent = new Intent(Cultivos.this, Agua.class);
            startActivity(intent);
            finish();
        } else if ((v == buttonFrijoles && energiaElectrica != null) || (v == buttonLechuga && energiaElectrica != null) || (v == buttonTomate && energiaElectrica != null)) {
            Intent intent = new Intent(Cultivos.this, EnergiaElectrica.class);
            startActivity(intent);
            finish();
        } else if ((v == buttonFrijoles && abono != null) || (v == buttonLechuga && abono != null) || (v == buttonTomate && abono != null)) {
            Intent intent = new Intent(Cultivos.this, Abono.class);
            startActivity(intent);
            finish();
        }
    }
}

