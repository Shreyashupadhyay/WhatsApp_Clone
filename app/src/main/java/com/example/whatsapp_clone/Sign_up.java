package com.example.whatsapp_clone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.whatsapp_clone.Models.Users;
import com.example.whatsapp_clone.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_up extends AppCompatActivity {
    ActivitySignUpBinding binding;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


        getSupportActionBar().hide();

        progressDialog = new ProgressDialog(Sign_up.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're creating Your Account");

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!binding.txtusername.getText().toString().isEmpty() && !binding.txtEmail.getText().toString().isEmpty() && !binding.txtPassword.getText().toString().isEmpty()){
                    progressDialog.show();
                    mAuth.createUserWithEmailAndPassword(binding.txtEmail.getText().toString(), binding.txtPassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressDialog.dismiss();
                                    if(task.isSuccessful()){
//                                        try {
//                                            Users user = new Users(Binding.name.getText().toString(),Binding.inputEmail.getText().toString(),Binding.inputPassword.getText().toString());
//                                            String id = task.getResult().getUser().getUid();
//                                            database.getReference().child("Users").child(id).setValue(user);
//
//                                        }catch (NullPointerException ex){
//                                            ex.printStackTrace();
//
//                                        }
                                        Users user = new Users(binding.txtusername.getText().toString(),binding.txtEmail.getText().toString(),binding.txtPassword.getText().toString());
                                        String id = task.getResult().getUser().getUid();
                                        database.getReference().child("Users").child(id).setValue(user);
                                        Toast.makeText(Sign_up.this, "Sign_up Successfull", Toast.LENGTH_SHORT).show();

                                    }else{
                                         Toast.makeText(Sign_up.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                }else{
                    Toast.makeText(Sign_up.this, "Enter detail", Toast.LENGTH_SHORT).show();
                }

            }
        });
        binding.txtAlredyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Sign_up.this, "clicked A", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Sign_up.this,Sign_in.class);
            }
        });

    }
}