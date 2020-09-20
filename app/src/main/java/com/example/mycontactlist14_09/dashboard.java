package com.example.mycontactlist14_09;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.util.Log;
import android.view.View;

import java.util.List;

public class dashboard extends AppCompatActivity {

    private static final String TAG = "dashboard";

    RecyclerView recyclerView;
    UserAdapter adapter;
    FloatingActionButton fab;
    List<UserEntity> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView =findViewById(R.id.recycler_view);

        UserDatabase userDatabase = UserRepository.getDatabase();

        adapter = new UserAdapter();
        LiveData<List<UserEntity>> allUsers = userDatabase.userDao().getAllUsers();

        allUsers.observe(this, adapter::submitList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: pressed!");
                startActivity(new Intent(dashboard.this, AddContactActivity.class));
            }
        });


    }
}