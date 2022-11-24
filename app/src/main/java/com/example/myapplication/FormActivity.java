package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.modelo.Profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormActivity extends AppCompatActivity implements View.OnClickListener{

    Button b_back, b_save;
    Intent i;
    EditText et_name, et_birth, et_algo;
    Profile profile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        b_back = findViewById(R.id.b_back);
        b_save = findViewById(R.id.b_save);
        et_name = findViewById(R.id.et_name);
        et_birth = findViewById(R.id.et_birth);
        et_algo = findViewById(R.id.et_algo);

        b_back.setOnClickListener(this);
        b_save.setOnClickListener(this);

        setEditTextHints();


    }

    private void setEditTextHints() {

        i = getIntent();

        et_name.setText(i.getStringExtra("name"));
        et_birth.setText(i.getStringExtra("birth"));
        et_algo.setText(i.getStringExtra("algo"));

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.b_save:

                onSetProfileInfo(null);

                break;

            default:

                onRestoreProfile();

                finish();
                break;
        }

    }

    private void onRestoreProfile() {

        i = getIntent();

        String n, b, a;

        n = i.getStringExtra("name");
        b = i.getStringExtra("birth");
        a = i.getStringExtra("algo");

        i = new Intent(this,ProfileActivity.class);

        i.putExtra("name", n);
        i.putExtra("birth",b);
        i.putExtra("algo", a);

        startActivity(i);

    }


    private void show(View v, EditText et) {

        if (et.getVisibility() == v.GONE) {
            et.setVisibility(View.VISIBLE);
        }else et.setVisibility(View.GONE);

    }
    public void onSetProfileInfo(View v){

        i = new Intent(this,ProfileActivity.class);

        i.putExtra("name", String.valueOf(et_name.getText()));
        i.putExtra("birth", String.valueOf(et_birth.getText()));
        i.putExtra("algo", String.valueOf(et_algo.getText()));


        Toast.makeText(this, "Guardado", Toast.LENGTH_LONG).show();

        startActivity(i);

        finish();

    }





}