package com.example.mpecco3355.simstagram.database;

/**
 * Created by mpecco3355 on 12/8/2017.
 */

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Post",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "userId",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = { @Index(value = "id")}
)


public class Post {

    @PrimaryKey(autoGenerate = true)
    int id;

    public int userId;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] picture;


    String description;

    public Post(int userId, String description) {
        this.userId = userId;
        this.picture = picture;
        this.description = description;
    }


}
