package com.example.javalearnapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class Variable extends AppCompatActivity {

    private Button a1;
    private Button a2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable);
        a1 = (Button) findViewById(R.id.a1);
        a2 = (Button) findViewById(R.id.a2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAufgabe1();
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAufgabe2();
            }
        });
    }

    public void openActivityAufgabe1(){
        Intent intent = new Intent(this, Aufgabe1.class);
        startActivity(intent);
    }

    public void openActivityAufgabe2(){
        Intent intent2 = new Intent(this, Aufgabe2.class);
        startActivity(intent2);
    }

}
