package com.example.mygreengarden;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class TuActividad extends AppCompatActivity implements View.OnClickListener {

    private Button buttonAdicionFrijoles, buttonUltimoRiego, buttonAccionTomate;
    private EditText editTextDateFrijoles, editTextDateLechuga, editTextDateTomate;
    private ImageButton imageButtonCalendario, imageButtonCalendarioLechuga, imageButtonCalendarioTomate;
    private TextView textViewProximaFechaFrijoles, textViewProximaFechaLechuga, textViewProximaFechaTomate;
    private ImageView imageViewAtras;
    private ImageView imageViewCasita;
    private Calendar calendar;
    private int dia, mes, ano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_actividad);

        buttonAdicionFrijoles = findViewById(R.id.buttonAdicionFrijoles);
        editTextDateFrijoles = findViewById(R.id.editTextDateFrijoles);
        imageButtonCalendario = findViewById(R.id.imageButtonCalendario);
        textViewProximaFechaFrijoles = findViewById(R.id.textViewProximaFechaFrijoles);
        buttonUltimoRiego = findViewById(R.id.buttonUltimoRiego);
        editTextDateLechuga = findViewById(R.id.editTextDateLechuga);
        imageButtonCalendarioLechuga = findViewById(R.id.imageButtonCalendarioLechuga);
        textViewProximaFechaLechuga = findViewById(R.id.textViewProximaFechaLechuga);
        buttonAccionTomate = findViewById(R.id.buttonAccionTomate);
        editTextDateTomate = findViewById(R.id.editTextDateTomate);
        imageButtonCalendarioTomate = findViewById(R.id.imageButtonCalendarioTomate);
        textViewProximaFechaTomate = findViewById(R.id.textViewProximaFechaTomate);
        imageViewAtras = findViewById(R.id.imageViewAtras);
        imageViewCasita = findViewById(R.id.imageViewCasita);

        // Inicializar el calendario
        calendar = Calendar.getInstance();

        // Escuchadores del botón
        imageButtonCalendario.setOnClickListener(this);
        imageButtonCalendarioLechuga.setOnClickListener(this);
        imageButtonCalendarioTomate.setOnClickListener(this);
        buttonAdicionFrijoles.setOnClickListener(this);
        buttonUltimoRiego.setOnClickListener(this);
        buttonAccionTomate.setOnClickListener(this);

        imageViewAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TuActividad.this, PrincipalCategorias.class);
                startActivity(intent);
            }
        });

        imageViewCasita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TuActividad.this, Bienvenida.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == imageButtonCalendario || v == imageButtonCalendarioLechuga || v == imageButtonCalendarioTomate) {
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            ano = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    calendar.set(year, month, dayOfMonth);

                    String fecha = dayOfMonth + "/" + (month + 1) + "/" + year;

                    if (v == imageButtonCalendario && editTextDateFrijoles != null) {
                        editTextDateFrijoles.setText("FECHA:  " + fecha);
                    } else if (v == imageButtonCalendarioLechuga && editTextDateLechuga != null) {
                        editTextDateLechuga.setText("FECHA:  " + fecha);
                    } else if (v == imageButtonCalendarioTomate && editTextDateTomate != null) {
                        editTextDateTomate.setText("FECHA:  " + fecha);
                    }
                }
            }, ano, mes, dia);
            datePickerDialog.show();
        }

        if (v == buttonAdicionFrijoles) {
            String fechaFrijoles = editTextDateFrijoles.getText().toString();
            if (!fechaFrijoles.isEmpty()) {
                // Obtener la fecha seleccionada
                String[] partesFecha = fechaFrijoles.replace("FECHA:  ", "").split("/");
                int diaSeleccionado = Integer.parseInt(partesFecha[0]);
                int mesSeleccionado = Integer.parseInt(partesFecha[1]) - 1; // Calendar.MONTH es 0-indexado
                int anoSeleccionado = Integer.parseInt(partesFecha[2]);

                // Establecer la fecha en el calendario
                calendar.set(anoSeleccionado, mesSeleccionado, diaSeleccionado);

                // Sumar 45 días a la fecha seleccionada
                calendar.add(Calendar.DAY_OF_MONTH, 45);

                // Obtener los nuevos valores de día, mes y año
                int nuevoDia = calendar.get(Calendar.DAY_OF_MONTH);
                int nuevoMes = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH es 0-indexado, por lo que sumamos 1
                int nuevoAno = calendar.get(Calendar.YEAR);

                // Actualizar el TextView con la nueva fecha
                textViewProximaFechaFrijoles.setText("Próxima fecha es: " + nuevoDia + "/" + nuevoMes + "/" + nuevoAno);
            } else {
                textViewProximaFechaFrijoles.setText("Por favor selecciona una fecha primero.");
            }
        }

        if (v == buttonUltimoRiego) {
            String fechaLechuga = editTextDateLechuga.getText().toString();
            if (!fechaLechuga.isEmpty()) {
                // Obtener la fecha seleccionada
                String[] partesFecha = fechaLechuga.replace("FECHA:  ", "").split("/");
                int diaSeleccionado = Integer.parseInt(partesFecha[0]);
                int mesSeleccionado = Integer.parseInt(partesFecha[1]) - 1; // Calendar.MONTH es 0-indexado
                int anoSeleccionado = Integer.parseInt(partesFecha[2]);

                // Establecer la fecha en el calendario
                calendar.set(anoSeleccionado, mesSeleccionado, diaSeleccionado);

                // Sumar 3 días a la fecha seleccionada
                calendar.add(Calendar.DAY_OF_MONTH, 3);

                // Obtener los nuevos valores de día, mes y año
                int nuevoDia = calendar.get(Calendar.DAY_OF_MONTH);
                int nuevoMes = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH es 0-indexado, por lo que sumamos 1
                int nuevoAno = calendar.get(Calendar.YEAR);

                // Actualizar el TextView con la nueva fecha
                textViewProximaFechaLechuga.setText("Próxima fecha es: " + nuevoDia + "/" + nuevoMes + "/" + nuevoAno);
            } else {
                textViewProximaFechaLechuga.setText("Por favor selecciona una fecha primero.");
            }
        }

        if (v == buttonAccionTomate) {
            String fechaTomate = editTextDateTomate.getText().toString();
            if (!fechaTomate.isEmpty()) {
                // Obtener la fecha seleccionada
                String[] partesFecha = fechaTomate.replace("FECHA:  ", "").split("/");
                int diaSeleccionado = Integer.parseInt(partesFecha[0]);
                int mesSeleccionado = Integer.parseInt(partesFecha[1]) - 1; // Calendar.MONTH es 0-indexado
                int anoSeleccionado = Integer.parseInt(partesFecha[2]);

                // Establecer la fecha en el calendario
                calendar.set(anoSeleccionado, mesSeleccionado, diaSeleccionado);

                // Sumar 1 día a la fecha seleccionada
                calendar.add(Calendar.DAY_OF_MONTH, 1);

                // Obtener los nuevos valores de día, mes y año
                int nuevoDia = calendar.get(Calendar.DAY_OF_MONTH);
                int nuevoMes = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH es 0-indexado, por lo que sumamos 1
                int nuevoAno = calendar.get(Calendar.YEAR);

                // Actualizar el TextView con la nueva fecha
                textViewProximaFechaTomate.setText("Próxima fecha es: " + nuevoDia + "/" + nuevoMes + "/" + nuevoAno);
            } else {
                textViewProximaFechaTomate.setText("Por favor selecciona una fecha primero.");
            }
        }
    }
}