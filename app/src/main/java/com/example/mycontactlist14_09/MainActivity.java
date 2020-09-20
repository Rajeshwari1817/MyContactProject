package com.example.mycontactlist14_09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button signIn;
    EditText email, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.Email);
        pwd = findViewById(R.id.password);
        signIn = findViewById(R.id.signinbtn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emailIdText = email.getText().toString();
                final String passwordText = pwd.getText().toString();

                if (emailIdText.isEmpty() || passwordText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), " Fill all Fields", Toast.LENGTH_SHORT).show();
                } else {
                    //Perform Query
                    UserDatabase userDatabase = UserRepository.getDatabase();
                    final UserDao userDao = userDatabase.userDao();
                    UserEntity userEntity = userDao.login(emailIdText, passwordText);

                    if (userEntity == null) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "InValid User", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        String name = userEntity.name;
                        startActivity(new Intent(MainActivity.this, dashboard.class).putExtra("name", name));
                    }
                }
            }
        });


    }
}