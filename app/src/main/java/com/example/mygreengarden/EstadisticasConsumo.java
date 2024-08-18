package com.example.mygreengarden;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class EstadisticasConsumo extends AppCompatActivity {

    private TableLayout tableLayoutNutrientes;
    private Button buttonBorrarDatos;
    private ImageView imageViewAtras;
    private ImageView imageViewCasita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas_consumo);

        imageViewAtras=findViewById(R.id.imageViewAtras);
        imageViewCasita=findViewById(R.id.imageViewCasita);

        tableLayoutNutrientes = findViewById(R.id.tableLayoutNutrientes);
        buttonBorrarDatos = findViewById(R.id.buttonBorrarDatos);
        loadData();

        buttonBorrarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearData();

            }
        });

        imageViewAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EstadisticasConsumo.this,PrincipalCategorias.class);
                startActivity(intent);
            }
        });

        imageViewCasita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EstadisticasConsumo.this,Bienvenida.class);
                startActivity(intent);
            }
        });

    }

    //Funcion crear datos
    private void loadData(){
        SharedPreferences nutrientesPrefes = getSharedPreferences("NutrientesData", MODE_PRIVATE);
        int nutrientesIndex = nutrientesPrefes.getInt("index",0);
        for (int i = 0; i < nutrientesIndex; i++ ){
            String month = nutrientesPrefes.getString("month" + i,"");
            String service = nutrientesPrefes.getString("service" + i,"");
            String consumo = nutrientesPrefes.getString("consumo" + i, ""); // "" lleve el valor por cual esta en vacio
            String price = nutrientesPrefes.getString("price" + i, "");

            //Generar datos dentro de la tabla
            TableRow tableRow = new TableRow(this);

            TextView textViewMonth = new TextView(this);
            textViewMonth.setText(month);
            textViewMonth.setBackgroundResource(R.color.white);
            tableRow.addView(textViewMonth);

            TextView textViewService = new TextView(this);
            textViewService.setText(service);
            textViewService.setBackgroundResource(R.color.white);
            tableRow.addView(textViewService);

            TextView textViewConsumo = new TextView(this);
            textViewConsumo.setText(consumo);
            textViewConsumo.setBackgroundResource(R.color.white);
            tableRow.addView(textViewConsumo);

            TextView textViewPrice = new TextView(this);
            textViewPrice.setText(price);
            textViewPrice.setBackgroundResource(R.color.white);
            tableRow.addView(textViewPrice);

            tableLayoutNutrientes.addView(tableRow);


        }
    }

    private void clearData(){
        SharedPreferences nutrientesPrefes = getSharedPreferences("NutrientesData", MODE_PRIVATE);
        SharedPreferences.Editor nutrientesEditor = nutrientesPrefes.edit();
        nutrientesEditor.clear();
        nutrientesEditor.apply();
        tableLayoutNutrientes.removeAllViews();
        Toast.makeText(this, "Datos borrados.", Toast.LENGTH_SHORT).show();
    }



}