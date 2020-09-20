package com.example.mycontactlist14_09;

import android.content.Context;

import androidx.room.Room;

public class UserRepository {

    private static UserDatabase userDatabase = null;

    private UserRepository(){};

    public static void makeDatabase(Context context) {
        if (userDatabase == null) {
            userDatabase = Room.databaseBuilder(context, UserDatabase.class, "userDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
    }
    public static UserDatabase getDatabase() {
        return userDatabase;
    }
}
