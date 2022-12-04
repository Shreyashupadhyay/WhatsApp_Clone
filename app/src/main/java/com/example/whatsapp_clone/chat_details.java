package com.example.whatsapp_clone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.example.whatsapp_clone.Adapter.chatAdapter;
import com.example.whatsapp_clone.Models.massageModel;
import com.example.whatsapp_clone.databinding.ActivityChatDetailsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class chat_details extends AppCompatActivity {
    ActivityChatDetailsBinding binding;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityChatDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        firebaseDatabase = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        final  String senderId = auth.getUid();
        String recieveId = getIntent().getStringExtra("UserId");
        String userName = getIntent().getStringExtra("userName");
        String profilePic = getIntent().getStringExtra("profilePic");

        binding.userName.setText(userName);
        Picasso.get().load(profilePic).placeholder(R.drawable.avatar).into(binding.profileImage);
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chat_details.this,MainActivity.class);
                startActivity(intent);
            }
        });
        final ArrayList<massageModel> massageModels = new ArrayList<>();
        final chatAdapter chatAdapter = new chatAdapter(massageModels,this,recieveId);

        binding.charRecyclerView.setAdapter(chatAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.charRecyclerView.setLayoutManager(layoutManager);
    }
}