package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import DAO.AdminDAO;
import Model.User;
import DAO.UserDAO;

public class Login extends AppCompatActivity {
    Button btnLogin;
    TextView btnRegister;
    TextInputEditText username;
    TextInputEditText password;
    CheckBox rememberCheck;

    //handle remember me
    AdminDAO adminDAO;
    UserDAO userDAO;
    public static User userGlobal = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btnLogin = findViewById(R.id.login);
        //switch view to register activity
        btnRegister = findViewById(R.id.signin);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        //handle login
        username = findViewById(R.id.username_edit);
        password = findViewById(R.id.password_edit);

        //handle remember me
        adminDAO = new AdminDAO(Login.this);
        userDAO = new UserDAO(Login.this);
        rememberCheck = findViewById(R.id.rememberCheck);
        //load file save data
        loadData();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                //handle remember me
                boolean check = rememberCheck.isChecked();
                User loginUser = new User(user, pass);


                if (userDAO.Check(loginUser) ) {
                    saveData(user, pass, check);
                    userGlobal = loginUser;
                    Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Home.class);
                    intent.putExtra("LoginName", username.getText().toString());
//                    startActivity(intent);
                    startActivityForResult(intent, 1);
//                    finish();
                } else {
                    Toast.makeText(Login.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private  void saveData(String username, String pass, boolean check){
        SharedPreferences pref = getSharedPreferences("thongtin.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if (check){
            editor.putString("username", username);
            editor.putString("password", pass);
            editor.putBoolean("check", check);
        } else {
            editor.clear();
        }
        editor.commit();
    }

    private void loadData(){
        SharedPreferences pref = getSharedPreferences("thongtin.dat", MODE_PRIVATE);
        boolean check = pref.getBoolean("check", false);
        if (check){
            username.setText(pref.getString("username", ""));
            password.setText(pref.getString("password", ""));
            rememberCheck.setChecked(check);
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1) {
//            String mess = data.getStringExtra("Logout");
////            getData.setText(mess);
//        }
//    }

//    public void Login (View view) {
//        Toast.makeText(Login.this, "Ban vua nhan dang nhap", Toast.LENGTH_SHORT).show();
//    }
}