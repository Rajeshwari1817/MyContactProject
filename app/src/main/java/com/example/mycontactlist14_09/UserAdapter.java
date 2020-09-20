package com.example.mycontactlist14_09;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<UserEntity> users;
    Context context;
    UserEntity userEntity=new UserEntity();
    public Button ButtonDelete;



    public UserAdapter(List<UserEntity> users, Context context) {
        this.users = users;
        this.context=context;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);
        //holder.ButtonDelete.setOnClickListener(getDeleteOnClickListener(userEntity));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, final int position) {
        holder.uRow.setText(users.get(position).getFirst_name());
        holder.u_name.setText(users.get(position).getLast_name());
        holder.u_email.setText(users.get(position).getEmail());
        holder.u_phn.setText(users.get(position).getPhn());

        UserEntity user = users.get(position);

        holder.uRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ContactListActivity.class);
                intent.putExtra("Id",users.get(position).getId());
                intent.putExtra("first_name",users.get(position).getFirst_name());
                intent.putExtra("L_name",users.get(position).getLast_name());
                intent.putExtra("E_ID",users.get(position).getEmail());
                intent.putExtra("P_no",users.get(position).getPhn());

                context.startActivity(intent);

            }
        });
    }
    private View.OnClickListener getDeleteOnClickListener(final UserEntity userEntity) {
        return view -> {
            UserDatabase database = UserDatabase.getUserDatabase(view.getContext());
            database.userDao().delete(userEntity);
        };
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView uRow;
        public TextView u_name;
        public TextView u_email;
        public TextView u_phn;

        public ViewHolder(View itemView) {
            super(itemView);
            uRow = itemView.findViewById(R.id.uRow);
            u_name = itemView.findViewById(R.id.ul_name);
            u_email= itemView.findViewById(R.id.uEmail);
            u_phn = itemView.findViewById(R.id.uPhn);

            ButtonDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
