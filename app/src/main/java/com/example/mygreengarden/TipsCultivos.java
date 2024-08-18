package com.example.mygreengarden;

public enum TipsCultivos {

    FRIJOLES("Frijoles"),

    LECHUGA("Lechuga"),

    TOMATE("Tomate");

    private  String nombre;

    TipsCultivos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}




