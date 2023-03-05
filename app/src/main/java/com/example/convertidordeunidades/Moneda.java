package com.example.convertidordeunidades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Moneda extends AppCompatActivity {

    Spinner spMedida1, spMedida2;
    EditText etValor1, etValor2;
    TextView tvTitulo;
    String[] medidas = {"Peso (MX)", "Dólar (USD)", "Euro (EUR)", "Yen (JPY)", "Libra esterlina (GBP)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneda);

        spMedida1 = (Spinner) findViewById(R.id.spMedida1);
        spMedida2 = (Spinner) findViewById(R.id.spMedida2);
        etValor1 = (EditText) findViewById(R.id.etValor1);
        etValor2 = (EditText) findViewById(R.id.etValor2);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);

        tvTitulo.setText(R.string.moneda);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Moneda.this, android.R.layout.simple_spinner_item, medidas);
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
                case "Peso (MX)":
                    switch (medida2) {
                        case "Peso (MX)":
                            valor2 = valor1;
                            break;
                        case "Dólar (USD)":
                            valor2 = valor1 * 0.054;
                            break;
                        case "Euro (EUR)":
                            valor2 = valor1 * 0.052;
                            break;
                        case "Yen (JPY)":
                            valor2 = valor1 * 7.42;
                            break;
                        case "Libra esterlina (GBP)":
                            valor2 = valor1 * 0.045;
                            break;
                    }
                    break;
                case "Dólar (USD)":
                    switch (medida2) {
                        case "Peso (MX)":
                            valor2 = valor1 * 18.39;
                            break;
                        case "Dólar (USD)":
                            valor2 = valor1;
                            break;
                        case "Euro (EUR)":
                            valor2 = valor1 * 0.95;
                            break;
                        case "Yen (JPY)":
                            valor2 = valor1 * 136.52;
                            break;
                        case "Libra esterlina (GBP)":
                            valor2 = valor1 * 0.84;
                            break;
                    }
                    break;
                case "Euro (EUR)":
                    switch (medida2) {
                        case "Peso (MX)":
                            valor2 = valor1 * 19.41;
                            break;
                        case "Dólar (USD)":
                            valor2 = valor1 * 1.06;
                            break;
                        case "Euro (EUR)":
                            valor2 = valor1;
                            break;
                        case "Yen (JPY)":
                            valor2 = valor1 * 144.07;
                            break;
                        case "Libra esterlina (GBP)":
                            valor2 = valor1 * 0.88;
                            break;
                    }
                    break;
                case "Yen (JPY)":
                    switch (medida2) {
                        case "Peso (MX)":
                            valor2 = valor1 * 0.13;
                            break;
                        case "Dólar (USD)":
                            valor2 = valor1 * 0.0073;
                            break;
                        case "Euro (EUR)":
                            valor2 = valor1 * 0.0069;
                            break;
                        case "Yen (JPY)":
                            valor2 = valor1;
                            break;
                        case "Libra esterlina (GBP)":
                            valor2 = valor1 * 0.0061;
                            break;
                    }
                    break;
                case "Libra esterlina (GBP)":
                    switch (medida2) {
                        case "Peso (MX)":
                            valor2 = valor1 * 22.00;
                            break;
                        case "Dólar (USD)":
                            valor2 = valor1 * 1.20;
                            break;
                        case "Euro (EUR)":
                            valor2 = valor1 * 1.13;
                            break;
                        case "Yen (JPY)":
                            valor2 = valor1 * 163.28;
                            break;
                        case "Libra esterlina (GBP)":
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