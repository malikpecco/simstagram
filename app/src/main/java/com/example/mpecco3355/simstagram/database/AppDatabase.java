package com.example.mpecco3355.simstagram.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by mpecco3355 on 12/8/2017.
 */

@Database(entities = {User.class,  Post.class, //follow.class
}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract UserDao userDAO();
    public abstract PostDao postDAO();
   // public abstract FollowDAO followDAO();

}
