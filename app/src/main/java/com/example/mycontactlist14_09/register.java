package com.example.mycontactlist14_09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText name,mail,pass,pass1;
    Button register;
    TextView back;
    DbHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.fullName);
        mail = findViewById(R.id.Email);
        pass = findViewById(R.id.password);
        pass1 = findViewById(R.id.ConfirmPassWord);
        register = findViewById(R.id.registerbtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String nametxt = name.getText().toString();
                String mailtxt = mail.getText().toString();
                String passtxt = pass.getText().toString();
                String pass1txt = pass1.getText().toString();

                db = new DbHandler(register.this);
                if(passtxt.compareTo(pass1txt) == 0){
                    db.addUser(mailtxt,passtxt);
                    Toast.makeText(register.this, mailtxt+" Registered .", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(register.this, "Password's Does Not Match..", Toast.LENGTH_SHORT).show();

                }
            }
        });



        back = findViewById(R.id.loginText);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(register.this,MainActivity.class);
                startActivity(login);
            }
        });
    }
}