package com.example.javalearnapp;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Aufgabe1IfElse extends AppCompatActivity {

    private Button lsg;
    private EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aufgabe1_if_else);
        lsg = findViewById(R.id.lsg2);
        txt = findViewById(R.id.editText4);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lsg.setOnClickListener(new View.OnClickListener() {

            String eingabe = "out";

            public void onClick(View v) {
                if(txt.getText().toString().equals(eingabe)){
                    Toast.makeText(Aufgabe1IfElse.this, "Die Lösung ist Richtig!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Aufgabe1IfElse.this, "Die Lösung ist Falsch!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
