package com.example.mycontactlist14_09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addContact extends AppCompatActivity {
    EditText name,last,email,ph;
    Button save,back;
    String newString;
    DbHandlerI db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        db = new DbHandlerI(addContact.this);

        name = findViewById(R.id.fullName);
        last = findViewById(R.id.LastName);
        email = findViewById(R.id.Email);
        ph = findViewById(R.id.PhnNo);

        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    db.addUser(newString,name.getText().toString(),last.getText().toString(),email.getText().toString(),ph.getText().toString());
                Toast.makeText(addContact.this, "Contact Added..", Toast.LENGTH_SHORT).show();
            }
        });

        back = findViewById(R.id.goBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboard = new Intent(addContact.this, com.example.mycontactlist14_09.dashboard.class);
                dashboard.putExtra("STRING_I_NEED", newString);
                startActivity(dashboard);
            }
        });
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("STRING_I_NEED");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }

    }
}