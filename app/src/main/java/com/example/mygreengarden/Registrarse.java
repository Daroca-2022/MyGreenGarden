package com.example.mygreengarden;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class Registrarse extends AppCompatActivity {

    private EditText editTextNombre, editTextEmail, editTextPassword, editTextConfirmarPassword;
    private ImageView imageViewAtras, imageViewCasita;
    private CheckBox checkBoxTerms;
    private Button buttonRegistrarse;

    //clase para los datos del usuario es decir lo que estan creando usuarios
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmarPassword = findViewById(R.id.editTextConfirmarPassword);
        checkBoxTerms = findViewById(R.id.checkBoxTerms);
        imageViewAtras = findViewById(R.id.imageViewAtras);
        imageViewCasita = findViewById(R.id.imageViewCasita);
        buttonRegistrarse = findViewById(R.id.buttonRegistrarse);


        userManager = new UserManager(this);//acceso a esos datos

        buttonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String confirmarPassword = editTextConfirmarPassword.getText().toString().trim();

                if(TextUtils.isEmpty(nombre)) {
                    Toast.makeText(Registrarse.this, "Ingrese un nombre", Toast.LENGTH_SHORT).show();
                }  else if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Registrarse.this, "Ingrese un correo electrónico", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    Toast.makeText(Registrarse.this, "Ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Registrarse.this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(confirmarPassword)) {
                    Toast.makeText(Registrarse.this, "Confirmar la contraseña", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmarPassword)){
                    Toast.makeText(Registrarse.this, "Error al confirmar la contraseña", Toast.LENGTH_SHORT).show();
                } else if (!checkBoxTerms.isChecked()) {
                    Toast.makeText(Registrarse.this, "Debe aceptar los Términos y Condiciones", Toast.LENGTH_SHORT).show();
                } else {
                    registrarUsuario(nombre, email, password);
                }

            }

            private boolean isValidEmail(CharSequence target) {
                return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
            }

            private void registrarUsuario(String nombre, String email, String password) {
                userManager.registerUser(nombre, email, password);
                Toast.makeText(Registrarse.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        imageViewAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrarse.this,InicioSesion.class);
                startActivity(intent);
            }
        });

        imageViewCasita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrarse.this,Bienvenida.class);
                startActivity(intent);
            }
        });
    }
}