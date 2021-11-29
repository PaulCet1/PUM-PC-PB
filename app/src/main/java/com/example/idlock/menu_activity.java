package com.example.idlock;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class menu_activity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button licznik_krokow = findViewById(R.id.licznik_krokow);
        Button maps = findViewById(R.id.button_mapa);
        Button stats = findViewById(R.id.button_stats);
        Button burned_calories = findViewById(R.id.burned_calories);
        Button opentraining = findViewById(R.id.opentraining);

        FloatingActionButton set1 = findViewById(R.id.sett_1);
        FloatingActionButton set2 = findViewById(R.id.sett_2);
        FloatingActionButton set3 = findViewById(R.id.sett_3);
        FloatingActionButton set4 = findViewById(R.id.sett_4);


       licznik_krokow.setOnClickListener(v -> {
           Toast.makeText(getApplicationContext(), "Funkcja licznik kroków", Toast.LENGTH_SHORT).show();






       });
        opentraining.setOnClickListener(v -> {Toast.makeText(getApplicationContext(), "Mapa!", Toast.LENGTH_SHORT).show();

            opentraining();

        });

       maps.setOnClickListener(v -> {Toast.makeText(getApplicationContext(), "Mapa!", Toast.LENGTH_SHORT).show();

       openmap();

       });

        stats.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Funkcja statystyki nie jest jeszcze wspierana!", Toast.LENGTH_SHORT).show());

        burned_calories.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Funkcja spalone kalorie nie jest jeszcze wspierana!", Toast.LENGTH_SHORT).show());
        set1.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Funkcja telefon", Toast.LENGTH_SHORT).show();
            opentelephone();

        });
        set2.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Funkcja aparat", Toast.LENGTH_SHORT).show();
            openCamera();

        });
        set3.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Odtwarzacz muzyki", Toast.LENGTH_SHORT).show();
            openAudioPlayer();

        });
        set4.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Autoobracanie ekranu", Toast.LENGTH_SHORT).show();
            openbrowser();

        });





        }
    public void opentraining(){
        Intent intenttraining = new Intent(this, MainActivity.class);
        startActivity(intenttraining);
    }

    public void openmap(){
        Intent intentmap = new Intent(this, mapactivity.class);
        startActivity(intentmap);
    }



    private void openbrowser() {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.google.com")));
    }

    private void openAudioPlayer() {
        Intent playerIntent = new Intent(Intent.ACTION_VIEW);
        playerIntent.setData(Uri.parse("spotify:library"));
        startActivity(playerIntent);
    }

    private void opentelephone() {
        Intent callintent = new Intent(Intent.ACTION_DIAL);
        startActivity(callintent);

    }

    private void openCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }




}
