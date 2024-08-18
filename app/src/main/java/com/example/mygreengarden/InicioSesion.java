package com.example.mygreengarden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class InicioSesion extends AppCompatActivity {

    private TextView editTextNombre, editTextEmail, editTextPassword, textViewRegistrarAqui;
    private Button buttonIniciarSesion;
    private ImageView imageViewAtras;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewRegistrarAqui = findViewById(R.id.textViewRegistrarAqui);
        buttonIniciarSesion = findViewById(R.id.buttonIniciarSesion);
        imageViewAtras = findViewById(R.id.imageViewAtras);
        userManager = new UserManager(this);

        textViewRegistrarAqui.setOnClickListener(new  View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioSesion.this,Registrarse.class);
                startActivity(intent);
            }
        });

        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if(userManager.LoginUser(email, password)) {
                    Intent intent = new Intent(InicioSesion.this, PrincipalCategorias.class);
                    startActivity(intent);
                    finish(); // habilitar la opcion para no devolverme al login
                } else if (userManager.LoginUserNombre(nombre, password)) {
                    Intent intent = new Intent(InicioSesion.this, PrincipalCategorias.class);
                    startActivity(intent);
                    finish(); // habilitar la opcion para no devolverme al login
                } else {
                    // Mostrar mensaje de error adecuado dependiendo de la información disponible
                    if(email.isEmpty() || password.isEmpty()) {
                        Toast.makeText(InicioSesion.this, "Email o Password Inválidos", Toast.LENGTH_SHORT).show();
                    } else if(nombre.isEmpty() || password.isEmpty()) {
                        Toast.makeText(InicioSesion.this, "Nombre o Password Inválidos", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(InicioSesion.this, "Credenciales Inválidas", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        imageViewAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioSesion.this,Bienvenida.class);
                startActivity(intent);
            }
        });
    }
}