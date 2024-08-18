package com.example.mygreengarden;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private static final String PREF_NAME = "UserPrefs"; //UserPrefs es xml y se guardo los registros que el usuario vaya haciendo
    private static final String KEY_NOMBRE = "nombre";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    private SharedPreferences sharedPreferences; //aqui se va guardar UserPrefs
    private SharedPreferences.Editor editor; // modificar el archivo

    public UserManager (Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);//se obtiene instancia del SHELL PREFS archivo PREF_NAME Y ASEGURAR A LOS DATOS O PREFERENCIAS DEL ARCHIVO
        editor = sharedPreferences.edit(); //para modificar las preferencias

    }

    //método para registrar el usuario con las opciones
    public void registerUser (String nombre, String email, String password){
        editor.putString(KEY_NOMBRE, nombre);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password); //guardo el campo KEY_PASSWORD con el contenido password
        editor.apply(); //guarda los cambios de forma asincronica
    }

    public boolean LoginUser(String email, String password){
        String registeredEmail = sharedPreferences.getString(KEY_EMAIL, null);
        String registeredPassword = sharedPreferences.getString(KEY_PASSWORD, null);
        return email.equals(registeredEmail) && password.equals(registeredPassword);
    }

    public boolean LoginUserNombre(String nombre, String password){
        String registeredNombre = sharedPreferences.getString(KEY_NOMBRE, null);
        String registeredPassword = sharedPreferences.getString(KEY_PASSWORD, null);
        return nombre.equals(registeredNombre) && password.equals(registeredPassword);
    }
}
