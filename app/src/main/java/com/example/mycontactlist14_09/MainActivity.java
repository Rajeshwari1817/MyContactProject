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
    Button signin;
    EditText user, pass;
    TextView register;
    DbHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.Email);
        pass = findViewById(R.id.password);

        signin = findViewById(R.id.signinbtn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = user.getText().toString();
                String password = pass.getText().toString();
                db = new DbHandler(MainActivity.this);

                if (db.checkUser(name,password) == true) {
                   Intent dashboard = new Intent(MainActivity.this, com.example.mycontactlist14_09.dashboard.class);
                    dashboard.putExtra("STRING_I_NEED", name);
                   startActivity(dashboard);
                } else {
                    Toast.makeText(MainActivity.this, "WRONG USERNAME OR PASSWORD!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        register = findViewById(R.id.registerText);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this, register.class);
                startActivity(register);
               // Toast.makeText(MainActivity.this, "Register clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}