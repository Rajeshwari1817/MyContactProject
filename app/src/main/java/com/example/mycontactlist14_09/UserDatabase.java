package com.example.mycontactlist14_09;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class},version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();

}
