package com.example.myapplication.modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Profile {

    String name;
    Date birth;
    String info;

    protected SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");


    public Profile() throws ParseException {

        this.name = "User";
        this.birth = df.parse("11/11/2011");
        this.info = "...";

    }

    public Profile(String name, Date birth, String info){

        this.name = name;
        this.birth = birth;
        this.info = info;

    }

    public String getName() {
        return this.name;
    }

    public Date getBirth() {
        return this.birth;
    }

    public String getInfo() {
        return this.info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
