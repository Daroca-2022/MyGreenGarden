package com.example.mygreengarden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class PrincipalConsejos extends AppCompatActivity {

    private TextView textViewIInfoCultivos;
    private ImageView imageViewAtras;
    private ImageView imageViewCasita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_consejos);

        textViewIInfoCultivos = findViewById(R.id.textViewIInfoTipsCultivos);
        Spinner spinnerCultivos = findViewById(R.id.spinnerCultivos);
        imageViewAtras = findViewById(R.id.imageViewAtras);
        imageViewCasita = findViewById(R.id.imageViewCasita);

        // Crear un array de strings con los nombres de los problemas, incluyendo la opción de seleccionar problema
        String[] cultivos = new String[TipsCultivos.values().length + 1];
        cultivos[0] = "seleccione el cultivo";
        for (int i = 0; i < TipsCultivos.values().length; i++) {
            cultivos[i + 1] = TipsCultivos.values()[i].getNombre();
        }

        // Configurar el spinner con los nombres de los problemas
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cultivos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCultivos.setAdapter(adapter);

        // Configurar el listener del spinner
        spinnerCultivos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override  // aqui se amplia la información como los encabezados y en el main la información
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { //id posiciones del arreglo
                if (position == 0) {
                    textViewIInfoCultivos.setText(" ");
                } else {
                    TipsCultivos cultivoSeleccionado = TipsCultivos.values()[position - 1]; //Cuando se cierra se devuelve a la posición inicial
                    InfoTipsCultivos infoCultivos = obtenerInfoCultivo(cultivoSeleccionado);// va mostrar los problemas
                    textViewIInfoCultivos.setText(infoCultivos.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textViewIInfoCultivos.setText("");
            }
        });

        imageViewAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalConsejos.this,PrincipalCategorias.class);
                startActivity(intent);
            }
        });

        imageViewCasita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalConsejos.this,Bienvenida.class);
                startActivity(intent);
            }

        });
    }

    private InfoTipsCultivos obtenerInfoCultivo(TipsCultivos cultivo) {
        switch (cultivo) {
            case FRIJOLES:  //descripción del problema en todos los return y luego el impacto
                return new InfoTipsCultivos(cultivo, "Al principio del periodo vegetativo, debe regar Frijol una o dos veces por semana. A medida que avance la temporada, deberá aumentar la frecuencia de riego. Es posible que tenga que regarlo dos veces al día o más durante el verano, dependiendo del clima.",
                        "Se adapta a una diversidad climas, aunque prefiere climas moderadamente fríos con temperaturas entre 16o y 25°C. ");
            case LECHUGA:
                return new InfoTipsCultivos(cultivo, "Requiere un riego regular para mantener el suelo ligeramente húmedo.",
                        "Dependiendo de la variedad, La lechuga puede crecer a una temperatura entre 45 a 64°F (7-18°C).");
            case TOMATE:
                return new InfoTipsCultivos(cultivo, ", Si es verano: 3 veces por semana. En caso de que no haga mucho calor o en invierno, con 8 veces al mes será suficiente.",
                        "Necesitan sol, ocho horas de luz solar directa al día como mínimo.");
            default:
                return null;
        }
    }
}

