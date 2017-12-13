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
public interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPost(Post post);

    /* @Query("select * from post")
     *public List<Post> getAllPost();
 */
    @Query("select * from post where id = :id")
    public List<Post> findPostForUser(int id);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updatePost(Post post);

    @Query("delete from post where id = :id")
    void delete(int id);
    @Insert
    void insertAll(Post... posts);

    @Insert
    long insert(Post post);

    @Delete
    void delete(Post post);
}
