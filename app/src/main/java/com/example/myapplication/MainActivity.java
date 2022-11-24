package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton imgb_play, imgb_quit, imgb_profile;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgb_play = findViewById(R.id.imgb_play);
        imgb_quit = findViewById(R.id.imgb_quit);
        imgb_profile = findViewById(R.id.imgb_profile);


        imgb_play.setOnClickListener(this);
        imgb_quit.setOnClickListener(this);
        imgb_profile.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.imgb_quit:
                finish();
                break;

            case R.id.imgb_profile:
                onCambiar(null);

            default: break;
        }

    }
    public void onCambiar(View v){

        //Crea un intent para abrir la segunda activity

        Intent i= new Intent(this, ProfileActivity.class);

        //Se puede enviar parámetros en el intent


        //ejecutar el intent para abrir SegundaActivity
        startActivity(i);


    }
}