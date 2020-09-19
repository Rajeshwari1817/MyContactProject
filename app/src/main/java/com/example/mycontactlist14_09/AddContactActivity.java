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
    //DbHandlerI db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        //db = new DbHandlerI(addContact.this);

        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.LastName);
        email = findViewById(R.id.Email);
        phn = findViewById(R.id.PhnNo);
        back=findViewById(R.id.goBack);


        final UserDatabase userDatabase = Room.databaseBuilder(getApplicationContext(),UserDatabase.class,"CONTACT")
                .allowMainThreadQueries()
                .build();


        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Save to Database
                //Log.d(TAG ,"onClick: f_name:"+first_name.getText().toString());
                //userDatabase.userDao().insertAll(new UserEntity("Rajeshwari","Brahmbhatt","raj10110.hj@gmailcom","4382701035"));
                UserEntity users =new UserEntity (first_name.getText().toString(),last_name.getText().toString(),email.getText().toString(),phn.getText().toString());
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
        /*if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("STRING_I_NEED");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }*/

    }
}