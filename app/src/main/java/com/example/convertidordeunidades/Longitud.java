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

public class Longitud extends AppCompatActivity {

    Spinner spMedida1, spMedida2;
    EditText etValor1, etValor2;
    TextView tvTitulo;
    String[] medidas = {"Milimetros","Centimetros", "Metros", "Kilometros"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longitud);

        int currentTheme = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if(currentTheme == Configuration.UI_MODE_NIGHT_YES) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.md_theme_dark_background));
        } else {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.md_theme_light_background));
        }

        spMedida1 = (Spinner) findViewById(R.id.spMedida1);
        spMedida2 = (Spinner) findViewById(R.id.spMedida2);
        etValor1 = (EditText) findViewById(R.id.etValor1);
        etValor2 = (EditText) findViewById(R.id.etValor2);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);

        tvTitulo.setText(getClass().getSimpleName());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Longitud.this, android.R.layout.simple_spinner_item, medidas);
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
                case "Milimetros":
                    switch (medida2) {
                        case "Milimetros":
                            valor2 = valor1;
                            break;
                        case "Centimetros":
                            valor2 = valor1 / 10;
                            break;
                        case "Metros":
                            valor2 = valor1 / 1000;
                            break;
                        case "Kilometros":
                            valor2 = valor1 / 1000000;
                            break;
                    }
                    break;
                case "Centimetros":
                    switch (medida2) {
                        case "Milimetros":
                            valor2 = valor1 * 10;
                            break;
                        case "Centimetros":
                            valor2 = valor1;
                            break;
                        case "Metros":
                            valor2 = valor1 / 100;
                            break;
                        case "Kilometros":
                            valor2 = valor1 / 100000;
                            break;
                    }
                    break;
                case "Metros":
                    switch (medida2) {
                        case "Milimetros":
                            valor2 = valor1 * 1000;
                            break;
                        case "Centimetros":
                            valor2 = valor1 * 100;
                            break;
                        case "Metros":
                            valor2 = valor1;
                            break;
                        case "Kilometros":
                            valor2 = valor1 / 1000;
                            break;
                    }
                    break;
                case "Kilometros":
                    switch (medida2) {
                        case "Milimetros":
                            valor2 = valor1 * 1000000;
                            break;
                        case "Centimetros":
                            valor2 = valor1 * 100000;
                            break;
                        case "Metros":
                            valor2 = valor1 * 1000;
                            break;
                        case "Kilometros":
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