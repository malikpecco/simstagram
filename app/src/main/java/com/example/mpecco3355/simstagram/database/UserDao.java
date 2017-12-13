package com.example.mpecco3355.simstagram.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.arch.persistence.room.Delete;

import java.util.List;

/**
 * Created by mpecco3355 on 12/8/2017.
 */

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.FAIL)
    void addUser(User user);

    @Query("select * from user")
    public List<User> getAllUser();

    /** id the prgram fails add limit one to the end */
    @Query("select * from user where name = :name LIMIT 1")
    public User getUser(String name);

    @Query("select * from user where id = :id")
    public User getUser(int id);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(User user);

    @Query("delete from user where id = :id ")
    void delete(int id);

    @Insert
    void insertAll(User... users);

    @Insert
    long insert(User user);

    @Delete
    void delete(User user);
}
