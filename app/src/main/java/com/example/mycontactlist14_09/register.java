package com.example.mycontactlist14_09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Entity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText name, email, pwd, confirm_pwd;
    Button register;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.nam);
        email = findViewById(R.id.Email);
        pwd = findViewById(R.id.password);
        confirm_pwd = findViewById(R.id.ConfirmPassWord);
        register = findViewById(R.id.registerbtn);
        login = findViewById(R.id.Loginbtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating User Entity
                final UserEntity userEntity = new UserEntity();
                userEntity.setName(name.getText().toString());
                userEntity.setEmailId(email.getText().toString());
                userEntity.setPassword(pwd.getText().toString());
                userEntity.setConfirmPassword(confirm_pwd.getText().toString());
                if (validateInput(userEntity)) {
                    //Do insert operation
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    final UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Register User
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_SHORT).show();

                                }
                            });
                        }
                    }).start();

                } else {
                    Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this, MainActivity.class));
            }
        });
    }

    private Boolean validateInput(UserEntity userEntity) {
        if (userEntity.getName().isEmpty() ||
                userEntity.getPassword().isEmpty() ||
                userEntity.getConfirmPassword().isEmpty() ||
                userEntity.getName().isEmpty()) {
            return false;
        }
        return true;


    }
}





























