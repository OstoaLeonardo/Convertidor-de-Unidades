package com.example.convertidordeunidades;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Tiempo extends MenuTopBar {

    Spinner spMedida1, spMedida2;
    EditText etValor1, etValor2;
    TextView tvTitulo;
    String[] medidas = {"Milisegundos", "Segundos", "Minutos", "Horas", "Dias", "Semanas", "Años"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo);

        setupToolbar();

        spMedida1 = (Spinner) findViewById(R.id.spMedida1);
        spMedida2 = (Spinner) findViewById(R.id.spMedida2);
        etValor1 = (EditText) findViewById(R.id.etValor1);
        etValor2 = (EditText) findViewById(R.id.etValor2);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);

        tvTitulo.setText(R.string.tiempo);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Tiempo.this, android.R.layout.simple_spinner_item, medidas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMedida1.setAdapter(adapter);
        spMedida2.setAdapter(adapter);

        spMedida1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convertirUnidades();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        spMedida2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convertirUnidades();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        etValor1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                convertirUnidades();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void convertirUnidades() {
        String medida1 = spMedida1.getSelectedItem().toString();
        String medida2 = spMedida2.getSelectedItem().toString();

        if(etValor1.getText().toString().isEmpty()) {
            etValor2.setText("");
            etValor2.setHint("0");
        } else {
            double valor1 = Double.parseDouble(etValor1.getText().toString());
            double valor2 = 0;

            switch (medida1) {
                case "Milisegundos":
                    switch (medida2) {
                        case "Milisegundos":
                            valor2 = valor1;
                            break;
                        case "Segundos":
                            valor2 = valor1 / 1000;
                            break;
                        case "Minutos":
                            valor2 = valor1 / 60000;
                            break;
                        case "Horas":
                            valor2 = valor1 / 3600000;
                            break;
                        case "Dias":
                            valor2 = valor1 / 86400000;
                            break;
                        case "Semanas":
                            valor2 = valor1 / 604800000;
                            break;
                        case "Años":
                            valor2 = valor1 / 31536e-7;
                            break;
                    }
                    break;
                case "Segundos":
                    switch (medida2) {
                        case "Milisegundos":
                            valor2 = valor1 * 1000;
                            break;
                        case "Segundos":
                            valor2 = valor1;
                            break;
                        case "Minutos":
                            valor2 = valor1 / 60;
                            break;
                        case "Horas":
                            valor2 = valor1 / 3600;
                            break;
                        case "Dias":
                            valor2 = valor1 / 86400;
                            break;
                        case "Semanas":
                            valor2 = valor1 / 604800;
                            break;
                        case "Años":
                            valor2 = valor1 / 31536000;
                            break;
                    }
                    break;
                case "Minutos":
                    switch (medida2) {
                        case "Milisegundos":
                            valor2 = valor1 * 60000;
                            break;
                        case "Segundos":
                            valor2 = valor1 * 60;
                            break;
                        case "Minutos":
                            valor2 = valor1;
                            break;
                        case "Horas":
                            valor2 = valor1 / 60;
                            break;
                        case "Dias":
                            valor2 = valor1 / 1440;
                            break;
                        case "Semanas":
                            valor2 = valor1 / 10080;
                            break;
                        case "Años":
                            valor2 = valor1 / 525600;
                            break;
                    }
                    break;
                case "Horas":
                    switch (medida2) {
                        case "Milisegundos":
                            valor2 = valor1 * 3600000;
                            break;
                        case "Segundos":
                            valor2 = valor1 * 3600;
                            break;
                        case "Minutos":
                            valor2 = valor1 * 60;
                            break;
                        case "Horas":
                            valor2 = valor1;
                            break;
                        case "Dias":
                            valor2 = valor1 / 24;
                            break;
                        case "Semanas":
                            valor2 = valor1 / 168;
                            break;
                        case "Años":
                            valor2 = valor1 / 8760;
                            break;
                    }
                    break;
                case "Dias":
                    switch (medida2) {
                        case "Milisegundos":
                            valor2 = valor1 * 86400000L;
                            break;
                        case "Segundos":
                            valor2 = valor1 * 86400;
                            break;
                        case "Minutos":
                            valor2 = valor1 * 1440;
                            break;
                        case "Horas":
                            valor2 = valor1 * 24;
                            break;
                        case "Dias":
                            valor2 = valor1;
                            break;
                        case "Semanas":
                            valor2 = valor1 / 7;
                            break;
                        case "Años":
                            valor2 = valor1 / 365;
                            break;
                    }
                    break;
                case "Semanas":
                    switch (medida2) {
                        case "Milisegundos":
                            valor2 = valor1 * 604800000L;
                            break;
                        case "Segundos":
                            valor2 = valor1 * 604800L;
                            break;
                        case "Minutos":
                            valor2 = valor1 * 10080L;
                            break;
                        case "Horas":
                            valor2 = valor1 * 168L;
                            break;
                        case "Dias":
                            valor2 = valor1 * 7L;
                            break;
                        case "Semanas":
                            valor2 = valor1;
                            break;
                        case "Años":
                            valor2 = valor1 * 52.143;
                            break;
                    }
                    break;
                case "Años":
                    switch (medida2) {
                        case "Milisegundos":
                            valor2 = valor1 * 31536000000L;
                            break;
                        case "Segundos":
                            valor2 = valor1 * 31536000;
                            break;
                        case "Minutos":
                            valor2 = valor1 * 525600;
                            break;
                        case "Horas":
                            valor2 = valor1 * 8760;
                            break;
                        case "Dias":
                            valor2 = valor1 * 365;
                            break;
                        case "Semanas":
                            valor2 = valor1 * 52.143;
                            break;
                        case "Años":
                            valor2 = valor1;
                            break;
                    }
                    break;
            }

            etValor2.setText(String.format("%.7f", valor2).replaceAll("\\.?0*$", ""));

            if (etValor2.getText().toString().endsWith(".0")) {
                etValor2.setText(etValor2.getText().toString().replace(".0", ""));
            }
        }
    }
}