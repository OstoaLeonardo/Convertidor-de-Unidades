package com.example.convertidordeunidades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends MenuTopBar {

    private Button btnLongitud, btnPeso, btnVolumen, btnTemperatura, btnMoneda, btnTiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbarMain();

        btnLongitud = (Button) findViewById(R.id.btnLongitud);
        btnPeso = (Button) findViewById(R.id.btnPeso);
        btnVolumen = (Button) findViewById(R.id.btnVolumen);
        btnTemperatura = (Button) findViewById(R.id.btnTemperatura);
        btnMoneda = (Button) findViewById(R.id.btnMoneda);
        btnTiempo = (Button) findViewById(R.id.btnTiempo);

        btnLongitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Longitud.class);
                startActivity(intent);
            }
        });

        btnPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Peso.class);
                startActivity(intent);
            }
        });

        btnVolumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Volumen.class);
                startActivity(intent);
            }
        });

        btnTemperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Temperatura.class);
                startActivity(intent);
            }
        });

        btnMoneda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Moneda.class);
                startActivity(intent);
            }
        });

        btnTiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Tiempo.class);
                startActivity(intent);
            }
        });
    }
}