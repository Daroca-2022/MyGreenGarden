package com.example.mygreengarden;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;


public class Bienvenida extends AppCompatActivity {

    private Button buttonComenzar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        buttonComenzar=findViewById(R.id.buttonComenzar);

        buttonComenzar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bienvenida.this,InicioSesion.class);
                startActivity(intent);
            }
        });

    }

}



