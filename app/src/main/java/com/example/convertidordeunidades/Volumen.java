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

public class Volumen extends MenuTopBar {

    Spinner spMedida1, spMedida2;
    EditText etValor1, etValor2;
    TextView tvTitulo;
    String[] medidas = {"Mililitros", "Litros", "Galones", "Centímetros cúbicos", "Metros cúbicos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen);

        setupToolbar();

        spMedida1 = (Spinner) findViewById(R.id.spMedida1);
        spMedida2 = (Spinner) findViewById(R.id.spMedida2);
        etValor1 = (EditText) findViewById(R.id.etValor1);
        etValor2 = (EditText) findViewById(R.id.etValor2);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);

        tvTitulo.setText(R.string.volumen);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Volumen.this, android.R.layout.simple_spinner_item, medidas);
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
                case "Mililitros":
                    switch (medida2) {
                        case "Mililitros":
                            valor2 = valor1;
                            break;
                        case "Litros":
                            valor2 = valor1 * 0.001;
                            break;
                        case "Galones":
                            valor2 = valor1 * 0.000264172;
                            break;
                        case "Centímetros cúbicos":
                            valor2 = valor1;
                            break;
                        case "Metros cúbicos":
                            valor2 = valor1 * 0.000001;
                            break;
                    }
                    break;
                case "Litros":
                    switch (medida2) {
                        case "Mililitros":
                            valor2 = valor1 * 1000;
                            break;
                        case "Litros":
                            valor2 = valor1;
                            break;
                        case "Galones":
                            valor2 = valor1 * 0.264172;
                            break;
                        case "Centímetros cúbicos":
                            valor2 = valor1 * 1000;
                            break;
                        case "Metros cúbicos":
                            valor2 = valor1 * 0.001;
                            break;
                    }
                    break;
                case "Galones":
                    switch (medida2) {
                        case "Mililitros":
                            valor2 = valor1 * 3785.41;
                            break;
                        case "Litros":
                            valor2 = valor1 * 3.78541;
                            break;
                        case "Galones":
                            valor2 = valor1;
                            break;
                        case "Centímetros cúbicos":
                            valor2 = valor1 * 3785410;
                            break;
                        case "Metros cúbicos":
                            valor2 = valor1 * 0.00378541;
                            break;
                    }
                    break;
                case "Centímetros cúbicos":
                    switch (medida2) {
                        case "Mililitros":
                            valor2 = valor1;
                            break;
                        case "Litros":
                            valor2 = valor1 * 0.001;
                            break;
                        case "Galones":
                            valor2 = valor1 * 0.000264172;
                            break;
                        case "Centímetros cúbicos":
                            valor2 = valor1;
                            break;
                        case "Metros cúbicos":
                            valor2 = valor1 * 1e-6;
                            break;
                    }
                    break;
                case "Metros cúbicos":
                    switch (medida2) {
                        case "Mililitros":
                            valor2 = valor1 * 1000000;
                            break;
                        case "Litros":
                            valor2 = valor1 * 1000;
                            break;
                        case "Galones":
                            valor2 = valor1 * 264.172;
                            break;
                        case "Centímetros cúbicos":
                            valor2 = valor1 * 1000000;
                            break;
                        case "Metros cúbicos":
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