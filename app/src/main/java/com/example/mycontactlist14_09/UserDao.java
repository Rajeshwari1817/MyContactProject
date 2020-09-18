package com.example.mycontactlist14_09;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;


@Dao
public interface UserDao {

     @Insert
    void registerUser(UserEntity userEntity);

     @Query("SELECT * from users where emailId=(:email) and password=(:password)")
     UserEntity login(String email,String password);


     @Query("SELECT * from users")
     List<UserEntity> getAllUsers();

     @Insert
    void insertAll(UserEntity...user);
}
