package com.example.mpecco3355.simstagram;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.mpecco3355.simstagram.database.AppDatabase;

/**
 * Created by mpecco3355 on 12/8/2017.
 */

public class App extends Application {

    private static  App INSTANCE;
    public static AppDatabase db;
    public static int loginUser ;

    public  static  App get(){
        return  INSTANCE;

    }



    @Override
    public void onCreate() {
        super.onCreate();
        db =  Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database") .build();

        INSTANCE = this;

    }

    public  AppDatabase getDb(){

        return db;
    }



}
