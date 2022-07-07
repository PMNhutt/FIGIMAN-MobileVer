package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

import Model.User;
import DAO.UserDAO;

public class Register extends AppCompatActivity {
    ImageView btnBackLogin;

    TextInputEditText username;
    TextInputEditText password;
    Button registerBtn;

    UserDAO userDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnBackLogin = findViewById(R.id.back_to_login);
        btnBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        username = findViewById(R.id.username_register);
        password = findViewById(R.id.password_register);
        registerBtn = findViewById(R.id.register);

        userDAO = new UserDAO(Register.this);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userDAO.create(new User(username.getText().toString(), password.getText().toString()))) {
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                }
            }
        });
    }
}