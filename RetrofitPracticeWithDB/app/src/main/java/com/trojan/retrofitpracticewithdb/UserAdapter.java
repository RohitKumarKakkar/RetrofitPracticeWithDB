package com.trojan.retrofitpracticewithdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.RecyclerHolder> {

    Context context;
    List<UserData> userData;

    public UserAdapter(Context context, List<UserData> userData) {
        this.context = context;
        this.userData = userData;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.singeltondesignrv, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        UserData user = userData.get(position);
        holder.tvname.setText(user.getName());
        holder.tvid.setText(user.getId());
        holder.tvemail.setText(user.getEmail());
        holder.tvphone.setText(user.getPhone());
        holder.tvdob.setText(user.getDob());
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {
        TextView tvname, tvid, tvemail, tvphone, tvdob;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            tvname = (itemView).findViewById(R.id.tvname);
            tvid = (itemView).findViewById(R.id.tvid);
            tvemail = (itemView).findViewById(R.id.tvemail);
            tvphone = (itemView).findViewById(R.id.tvphone);
            tvdob = (itemView).findViewById(R.id.tvdob);

        }
    }
}
