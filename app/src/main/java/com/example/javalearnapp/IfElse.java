package com.example.javalearnapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class IfElse extends AppCompatActivity {

    Button aufgabe1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_if_else);
        aufgabe1 = (Button) findViewById(R.id.aufgabe1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        aufgabe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAufgabe1IfElse();
            }
        });
    }


    public void openActivityAufgabe1IfElse(){
        Intent intent = new Intent(this, Aufgabe1IfElse.class);
        startActivity(intent);
    }
}
