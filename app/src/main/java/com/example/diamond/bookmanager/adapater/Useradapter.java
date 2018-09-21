package com.example.diamond.bookmanager.adapater;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diamond.bookmanager.R;
import com.example.diamond.bookmanager.model.User;

import java.util.List;

public class Useradapter extends RecyclerView.Adapter<Useradapter.ViewHolder> {
    private List<User> listuser;

    public Useradapter(List<User> user) {
        this.listuser = user;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = listuser.get(position);
        holder.tvname_user.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return listuser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tvname_user;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvname_user = itemView.findViewById(R.id.tvtname_user);

        }
    }
}
