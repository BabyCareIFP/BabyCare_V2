package com.example.babycarev1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrimeraActivity extends AppCompatActivity {
    protected Button boton1, boton2, boton3;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_primera);

        boton1=(Button) findViewById(R.id.boton1_primera);
        boton2=(Button) findViewById(R.id.boton2_primera);
        boton3=(Button) findViewById(R.id.boton3_primera);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            pasarPantalla =new Intent(PrimeraActivity.this,LogInActivity.class);
            startActivity(pasarPantalla);
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla =new Intent(PrimeraActivity.this,RegistroActivity.class);
                startActivity(pasarPantalla);
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla =new Intent(PrimeraActivity.this,Ayuda1Activity.class);
                startActivity(pasarPantalla);
            }
        });
    }

}