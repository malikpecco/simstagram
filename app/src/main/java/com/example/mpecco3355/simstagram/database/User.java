package com.example.mpecco3355.simstagram.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mpecco3355 on 12/8/2017.
 */


@Entity
public class User {

    @PrimaryKey(autoGenerate =  true)
    public int id;
    public String name;
    public String password;
    public  String email;


    public User(String name, String password, String email  ) {

        this.name = name;
        this.password  = password;
        this.email = email;

    }





}