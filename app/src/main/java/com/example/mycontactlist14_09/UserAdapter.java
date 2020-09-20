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
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

class UserAdapter extends ListAdapter<UserEntity, UserAdapter.ViewHolder> {
    public Button ButtonDelete;

    public UserAdapter() {
        super(UserEntity.DIFF_CALLBACK);
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
        UserEntity user = getItem(position);

        holder.uRow.setText(user.getFirst_name());
        holder.u_name.setText(user.getLast_name());
        holder.u_email.setText(user.getEmail());
        holder.u_phn.setText(user.getPhn());

        holder.uRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext() ,ContactListActivity.class);
                intent.putExtra("Id",user.getId());
                intent.putExtra("first_name",user.getFirst_name());
                intent.putExtra("L_name",user.getLast_name());
                intent.putExtra("E_ID",user.getEmail());
                intent.putExtra("P_no",user.getPhn());

                v.getContext().startActivity(intent);
            }
        });
    }
    private View.OnClickListener getDeleteOnClickListener(final UserEntity userEntity) {
        return view -> {
            UserDatabase userDatabase = UserRepository.getDatabase();
            userDatabase.userDao().delete(userEntity);
        };
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
