package com.example.babycarev1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class PrintActivity extends AppCompatActivity {

    protected ListView lista1;
    private ArrayList<String> datos;
    private ArrayAdapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);

        lista1 = (ListView) findViewById(R.id.lista1_print);
        adaptador = new ArrayAdapter(PrintActivity.this, android.R.layout.simple_list_item_1, datos);
        lista1.setAdapter(adaptador);

    }
}