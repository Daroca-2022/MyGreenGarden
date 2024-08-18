package com.example.mygreengarden;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class Agua extends AppCompatActivity {


    private EditText editTextConsumo, editTextPrice, editTextMonth;
    private Button buttonSave;
    private ImageView imageViewAtras, imageViewCasita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agua);

        editTextConsumo = findViewById(R.id.editTextConsumo);
        editTextPrice = findViewById(R.id.editTextPrice);
        editTextMonth = findViewById(R.id.editTextMonth);
        buttonSave = findViewById(R.id.buttonSave);
        imageViewAtras = findViewById(R.id.imageViewAtras);
        imageViewCasita = findViewById(R.id.imageViewCasita);


        buttonSave.setOnClickListener(v -> SaveWaterData()) ;  // para guardar los cambios

        imageViewAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Agua.this,NutrientesPlanta.class);
                startActivity(intent);
            }
        });

        imageViewCasita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Agua.this,Bienvenida.class);
                startActivity(intent);
            }

        });


    }



    private void SaveWaterData(){
        String consumo = editTextConsumo.getText().toString();
        String price = editTextPrice.getText().toString();
        String month = editTextMonth.getText().toString();
        String service = "Agua";
        String consumoWithM3 = consumo + "m\u00B3";

        double consumoValue = Double.parseDouble(consumo);
        double priceValue = Double.parseDouble(price);

        calcularEnergia(consumoValue, priceValue);

        if(consumo.isEmpty() || price.isEmpty() || month.isEmpty() ){
            Toast.makeText(this, "Por favor completar los campos", Toast.LENGTH_SHORT).show();//show() para que se inicie
            return;
        }

        //Guardar los datos en SharePreference
        SharedPreferences preferences = getSharedPreferences("NutrientesData", MODE_PRIVATE); //WaterData nombre del archivo de tipo privado
        SharedPreferences.Editor editor = preferences.edit();

        int index = preferences.getInt("index", 0); //se indica en que posición vamos a comenzar

        editor.putString("service" + index, service);
        editor.putString("consumo" + index,consumoWithM3);  //para registrarse
        editor.putString("price" + index,price);
        editor.putString("month" + index,month);

        editor.putInt("index", index+1);
        editor.apply();

        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show(); //mensaje de confirmacion
        finish();

    }

    public void calcularEnergia(double consumoValue, double priceValue) {
        double priceTotal = consumoValue * priceValue;

        TextView textViewResultado = findViewById(R.id.textViewResultado);
        textViewResultado.setText("TOTAL SERVICIO:  " + priceTotal);
    }

}