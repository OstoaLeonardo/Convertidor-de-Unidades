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

public class Peso extends MenuTopBar {

    Spinner spMedida1, spMedida2;
    EditText etValor1, etValor2;
    TextView tvTitulo;
    String[] medidas = {"Libras", "Miligramos", "Gramos", "Kilogramos", "Toneladas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso);

        setupToolbar();

        spMedida1 = (Spinner) findViewById(R.id.spMedida1);
        spMedida2 = (Spinner) findViewById(R.id.spMedida2);
        etValor1 = (EditText) findViewById(R.id.etValor1);
        etValor2 = (EditText) findViewById(R.id.etValor2);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);

        tvTitulo.setText(R.string.peso);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Peso.this, android.R.layout.simple_spinner_item, medidas);
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
                case "Libras":
                    switch (medida2) {
                        case "Libras":
                            valor2 = valor1;
                            break;
                        case "Miligramos":
                            valor2 = valor1 * 453592.37;
                            break;
                        case "Gramos":
                            valor2 = valor1 * 453.59237;
                            break;
                        case "Kilogramos":
                            valor2 = valor1 * 0.45359237;
                            break;
                        case "Toneladas":
                            valor2 = valor1 * 0.00045359237;
                            break;
                    }
                    break;
                case "Miligramos":
                    switch (medida2) {
                        case "Libras":
                            valor2 = valor1 / 453592.37;
                            break;
                        case "Miligramos":
                            valor2 = valor1;
                            break;
                        case "Gramos":
                            valor2 = valor1 / 1000;
                            break;
                        case "Kilogramos":
                            valor2 = valor1 / 1000000;
                            break;
                        case "Toneladas":
                            valor2 = valor1 / 1000000000;
                            break;
                    }
                    break;
                case "Gramos":
                    switch (medida2) {
                        case "Libras":
                            valor2 = valor1 * 0.00220462;
                            break;
                        case "Miligramos":
                            valor2 = valor1 * 1000;
                            break;
                        case "Gramos":
                            valor2 = valor1;
                            break;
                        case "Kilogramos":
                            valor2 = valor1 * 0.001;
                            break;
                        case "Toneladas":
                            valor2 = valor1 * 0.000001;
                            break;
                    }
                    break;
                case "Kilogramos":
                    switch (medida2) {
                        case "Libras":
                            valor2 = valor1 * 2.20462 ;
                            break;
                        case "Miligramos":
                            valor2 = valor1 * 1000000;
                            break;
                        case "Gramos":
                            valor2 = valor1 * 100;
                            break;
                        case "Kilogramos":
                            valor2 = valor1;
                            break;
                        case "Toneladas":
                            valor2 = valor1 * 0.001;
                            break;
                    }
                    break;
                case "Toneladas":
                    switch (medida2) {
                        case "Libras":
                            valor2 = valor1 * 2204.62;
                            break;
                        case "Miligramos":
                            valor2 = valor1 * 1e+9;
                            break;
                        case "Gramos":
                            valor2 = valor1 * 1e+6;
                            break;
                        case "Kilogramos":
                            valor2 = valor1 * 1000;
                            break;
                        case "Toneladas":
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