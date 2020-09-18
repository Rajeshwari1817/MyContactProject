package com.example.mycontactlist14_09;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class dashboard extends AppCompatActivity {

    private static final String TAG = "dashboard";

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;
    List<UserEntity> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView =findViewById(R.id.recycler_view);

       // users = new ArrayList<>();

     /*   for(int i=0;i<100;i++) {
            User user = new User("RAJESHWARI ","BRAHMBHATT","raj10110.hj@gmail.com","4382701035");
            users.add(user);
        }*/
      UserDatabase userDatabase = Room.databaseBuilder(getApplicationContext(),UserDatabase.class,"CONTACT")
              .allowMainThreadQueries()
              .build();

        List<UserEntity> users = userDatabase.userDao().getAllUsers();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: pressed!");
                startActivity(new Intent(dashboard.this,addContact.class));
            }
        });

       /* if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("STRING_I_NEED");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }
        Toast.makeText(this, ""+newString, Toast.LENGTH_SHORT).show();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(dashboard.this,addContact.class);
                i.putExtra("STRING_I_NEED", newString);
                startActivity(i);
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
               //         .setAction("Action", null).show();
            }
        });*/
    }
}