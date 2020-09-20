package com.example.mycontactlist14_09;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface UserDao {

     @Insert
    void registerUser(UserEntity userEntity);

     @Query("SELECT * from users where emailId=(:email) and password=(:password)")
     UserEntity login(String email,String password);


     @Query("SELECT * from users")
    LiveData<List<UserEntity>> getAllUsers();

     @Insert
    void insertAll(UserEntity...user);

     @Delete
    void delete(UserEntity user);

    @Query("SELECT * FROM users WHERE id = :id")
    public UserEntity getUserById(int id);
}
