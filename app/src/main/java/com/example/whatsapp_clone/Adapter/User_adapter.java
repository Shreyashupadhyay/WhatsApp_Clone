package com.example.whatsapp_clone.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp_clone.Models.Users;
import com.example.whatsapp_clone.R;
import com.example.whatsapp_clone.chat_details;
import com.example.whatsapp_clone.databinding.ActivityChatDetailsBinding;
import com.google.firebase.database.core.UserWriteRecord;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class User_adapter extends RecyclerView.Adapter<User_adapter.ViewHolder> {

    ArrayList<Users> list;
    Context context;

    public User_adapter(ArrayList<Users> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_show_user,parent,false);
        return new ViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users users = list.get(position);
        Picasso.get().load(users.getProfilepic()).placeholder(R.drawable.avatar).into(holder.image);
        holder.userName.setText(users.getUsername());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, chat_details.class);
                intent.putExtra("UserId" ,users.getUserID());
                intent.putExtra("profilePic",users.getProfilepic());
                intent.putExtra("userName",users.getUsername());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;

        TextView userName, lastMassage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            image = itemView.findViewById(R.id.profile_image);
            userName = itemView.findViewById(R.id.userNameList);
            lastMassage = itemView.findViewById(R.id.lastmassage);
        }
    }
}
