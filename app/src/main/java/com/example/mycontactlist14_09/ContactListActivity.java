package com.example.mycontactlist14_09;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ContactListActivity extends AppCompatActivity {
TextView contactName,contactL_name,contactEmail,contactPhn;
Button btnDelete;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_contact_list);
         contactName = findViewById(R.id.contact_name);
         contactL_name = findViewById(R.id.contact_last_name);
         contactEmail = findViewById(R.id.contact_email_id);
         contactPhn = findViewById(R.id.contact_phn_no);
         btnDelete = findViewById(R.id.btnDelete);

         Intent intent = getIntent();
         int id = intent.getIntExtra("Id",  -1);
         String name = intent.getStringExtra("first_name");
         String L_name = intent.getStringExtra("L_name");
         String Eid = intent.getStringExtra("E_ID");
         String Pno = intent.getStringExtra("P_no");

         contactName.setText(name);
         contactL_name.setText(L_name);
         contactEmail.setText(Eid);
         contactPhn.setText(Pno);

        btnDelete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                  UserDatabase userDatabase = UserRepository.getDatabase();
                  UserEntity userById = userDatabase.userDao().getUserById(id);
                  userDatabase.userDao().delete(userById);
                  finish();
             }
        });

     }
}