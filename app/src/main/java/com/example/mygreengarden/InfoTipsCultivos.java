package com.example.mygreengarden;

public class InfoTipsCultivos {
    private TipsCultivos cultivo;
    private String riego;
    private String luz;


    public InfoTipsCultivos(TipsCultivos cultivo, String riego, String luz) {
        this.cultivo = cultivo;
        this.riego = riego;
        this.luz = luz;
    }

    public TipsCultivos getCultivo() {
        return cultivo;
    }

    public String getRiego() {
        return riego;
    }

    public String getLuz() {
        return luz;
    }

    @Override
    public String toString () {
        return cultivo.getNombre() + "\n\nRiego: " + riego + "\n\nLuz: " + luz;
    }
}





