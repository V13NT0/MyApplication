package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.modelo.Profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    Button b_back, b_edit;
    Intent i;
    protected TextView tv_name, tv_birth, tv_algo;
    Profile profile;
    protected SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        b_back = findViewById(R.id.b_back);
        b_edit = findViewById(R.id.b_edit);

        tv_name = findViewById(R.id.tv_name);
        tv_birth = findViewById(R.id.tv_birth);
        tv_algo = findViewById(R.id.tv_algo);

        b_back.setOnClickListener(this);
        b_edit.setOnClickListener(this);

        try {
            profile = new Profile();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        setTextView();

    }

    private void setTextView() {

        tv_name.setText(profile.getName());
        tv_birth.setText(profile.getBirth().toString());
        tv_algo.setText(profile.getInfo());

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.b_edit:
                onCambiar(null);
                break;

            default:
                finish();
                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        i = getIntent();
        String name = i.getStringExtra("name");
        String birth = i.getStringExtra("birth");
        String algo = i.getStringExtra("algo");

        setOnProfile(name,birth,algo);

        setTextView();

    }

    private void setOnProfile(String name, String birth, String algo) {

        profile.setName(String.valueOf(name));
        try {
            profile.setBirth(df.parse(String.valueOf(birth)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        profile.setInfo(algo);


    }

    private void show(View v, EditText et) {

        if (et.getVisibility() == v.GONE) {
            et.setVisibility(View.VISIBLE);
        }else et.setVisibility(View.GONE);

    }

    public void onCambiar(View v){

        //Crea un intent para abrir la segunda activity

        Intent i= new Intent(this, FormActivity.class);

        //Se puede enviar parámetros en el intent
        i.putExtra("name",tv_name.getText());
        i.putExtra("birth",tv_birth.getText());
        i.putExtra("algo",tv_algo.getText());

        //ejecutar el intent para abrir SegundaActivity
        startActivity(i);

        finish();

    }




}