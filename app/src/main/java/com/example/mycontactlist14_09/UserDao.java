package com.example.mycontactlist14_09;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


@Dao
public interface UserDao {

     @Insert
    void registerUser(UserEntity userEntity);

     @Query("SELECT * from users where emailId=(:email) and password=(:password)")
     UserEntity login(String email,String password);
}