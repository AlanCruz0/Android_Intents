package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetalleActividad.class);
                intent.putExtra("clave", "valor");
                startActivity(intent);
            }
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MiServicio.class);
                intent.putExtra("tarea", "realizar_algo");
                startService(intent);
            }
        });

        // Botón para el Intent Explícito 3 (Abrir pantalla de configuración de la aplicación)
        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:" + getPackageName()));
                startActivity(intent);
            }
        });

        // Botón para el Intent Explícito 4 (Iniciar actividad con acción personalizada)
        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActividadPersonalizada.class);
                intent.setAction("com.miapp.ACCION_PERSONALIZADA");
                startActivity(intent);
            }
        });

        // Botón para el Intent Implícito 1 (Compartir imagen)
        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                Uri imagenUri = Uri.parse("content://ruta_de_tu_imagen");
                intent.putExtra(Intent.EXTRA_STREAM, imagenUri);
                startActivity(Intent.createChooser(intent, "Compartir imagen"));
            }
        });

        // Botón para el Intent Implícito 2 (Abrir marcador de teléfono)
        Button btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+1234567890"));
                startActivity(intent);
            }
        });

        // Botón para el Intent Implícito 3 (Mostrar ubicación en mapa)
        Button btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=latitude,longitude(Label)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        // Botón para el Intent Implícito 4 (Abrir dirección de correo electrónico)
        Button btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:correo@ejemplo.com"));
                startActivity(intent);
            }
        });
    }
}