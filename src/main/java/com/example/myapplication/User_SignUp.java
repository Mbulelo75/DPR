package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.DriverManager;

public class User_SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__sign_up);

        final Button signUpUser = (Button)findViewById(R.id.btnSignUpUser);
        final Button signUpLogin = (Button)findViewById(R.id.btnSignUp_Login);

        final EditText etUserName = findViewById(R.id.etUserName);
        final EditText etGender = findViewById(R.id.etGender);
        final EditText etCellNumber = findViewById(R.id.etCellNumber);
        final EditText etAddress = findViewById(R.id.etAddress);
        final EditText etPassword = findViewById(R.id.etPassword);


        signUpLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logMainInIntent = new Intent(User_SignUp.this,MainActivity.class);
                User_SignUp.this.startActivity(logMainInIntent);


            }
        });

        signUpUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"testandroid","root","ndarensnaro75$");

                }catch(Exception e){


                }
            }
        });

    }
}