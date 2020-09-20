package com.example.mycontactlist14_09;

import android.content.Context;
import android.widget.Button;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class},version = 2)
public abstract class UserDatabase extends RoomDatabase {


    private static  final  String UserDatabaseName= "user";
    private static  UserDatabase userDatabase;

    public static synchronized UserDatabase getUserDatabase(Context context){

    if(userDatabase == null){
        userDatabase = Room.databaseBuilder(context , UserDatabase.class, UserDatabaseName)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
      return userDatabase;


    }

    public abstract UserDao userDao();

}
