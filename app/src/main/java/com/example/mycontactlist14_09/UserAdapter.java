package com.example.mycontactlist14_09;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.uRow.setText(users.get(position).getFirst_name());
        holder.u_name.setText(users.get(position).getLast_name());
        holder.u_email.setText(users.get(position).getEmail());
        holder.u_phn.setText(users.get(position).getPhn());
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
        }
    }
}
