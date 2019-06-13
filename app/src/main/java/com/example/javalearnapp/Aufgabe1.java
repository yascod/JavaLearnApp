package com.example.javalearnapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Aufgabe1 extends AppCompatActivity {

    private Button eingabe;
    private CheckBox eins;
    private CheckBox zwei;
    private CheckBox drei;
    private TextView anzeige;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aufgabe1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        eingabe = findViewById(R.id.eingabe);
        eins = findViewById(R.id.checkBox1);
        zwei = findViewById(R.id.checkBox2);
        drei = findViewById(R.id.checkBox3);
        anzeige = findViewById(R.id.textView4);
        eingabe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (eins.isChecked() || zwei.isChecked() || drei.isChecked()) {
                     if (eins.isChecked() && zwei.isChecked() && drei.isChecked()||
                             eins.isChecked()&& zwei.isChecked()|| eins.isChecked()&&drei.isChecked()||
                             zwei.isChecked()&&drei.isChecked()){
                        anzeige.setText("Bitte nur eine Auswahl tätigen!");

                    }
                    else if (eins.isChecked()) {
                        eins.setTextColor(Color.RED);
                        anzeige.setTextColor(Color.RED);
                        anzeige.setText("Die Antwort ist falsch!");
                        eingabe.setText("Neuer Versuch");
                        eingabe.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                openActivityAufgabe1();
                            }
                        });
                    } else if (zwei.isChecked()) {
                        zwei.setTextColor(Color.RED);
                        anzeige.setTextColor(Color.RED);
                        anzeige.setText("Die Antwort ist falsch!");
                        eingabe.setText("Neuer Versuch");
                        eingabe.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                openActivityAufgabe1();
                            }
                        });
                    } else if (drei.isChecked()) {
                        drei.setTextColor(Color.GREEN);
                        anzeige.setTextColor(Color.GREEN);
                        anzeige.setText("Die Antwort ist richtig!");
                        eingabe.setText("Neuer Versuch");
                        eingabe.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                openActivityAufgabe1();
                            }
                        });
                    }

                } else if (!(eins.isChecked() || zwei.isChecked() || drei.isChecked())) {
                    anzeige.setText("Bitte eine Auswahl tätigen!");

                }

            }

        });



    }


    public void openActivityAufgabe1(){
        Intent intent2 = new Intent(this, Aufgabe1.class);
        startActivity(intent2);
    }



}
