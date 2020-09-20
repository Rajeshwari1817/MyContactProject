package com.example.mycontactlist14_09;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {
    private static final String TAG = "dashboard";

    EditText first_name,last_name,email,phn;
    Button save,back;
    String newString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.LastName);
        email = findViewById(R.id.Email);
        phn = findViewById(R.id.PhnNo);
        back=findViewById(R.id.goBack);

        UserDatabase userDatabase = UserRepository.getDatabase();

        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity users = new UserEntity(first_name.getText().toString(),last_name.getText().toString(),email.getText().toString(),phn.getText().toString());
                userDatabase.userDao().insertAll(users);
                startActivity(new Intent(AddContactActivity.this,dashboard.class));
                Toast.makeText(AddContactActivity.this, "Contact Added..", Toast.LENGTH_SHORT).show();
            }
        });

        back = findViewById(R.id.goBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboard = new Intent(AddContactActivity.this, com.example.mycontactlist14_09.dashboard.class);
                dashboard.putExtra("STRING_I_NEED", newString);
                startActivity(dashboard);
            }
        });

    }
}