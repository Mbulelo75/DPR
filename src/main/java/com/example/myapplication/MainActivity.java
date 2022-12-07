package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button login = (Button)findViewById(R.id.btnLogin);
        final Button signUp = (Button)findViewById(R.id.btnSignUpUser);

        final EditText etUserName = findViewById(R.id.etUserName);
        final EditText etPassword = findViewById(R.id.etPassword);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(MainActivity.this,User_SignUp.class);
                MainActivity.this.startActivity(signUpIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"testandroid","snaro","snaro");

                    Statement statement = connection.createStatement();
                    String sql = "SELECT * FROM login WHERE name=? and password=?";
                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1,etUserName.getText().toString());
                    pst.setString(2,etPassword.getText().toString());
                    ResultSet resultSet = pst.executeQuery();

                    Intent ProfileIntent = new Intent(MainActivity.this,PROFILE.class);
                    MainActivity.this.startActivity(ProfileIntent);

                }catch(Exception e){
                    TextView Error = (TextView)findViewById(R.id.tvError);
                    Error.setText(e.toString());


                }
            }
        });




    }


    private void changeLauncher() {
        String s = getApplicationContext().getPackageName();
        ComponentName cm = new ComponentName(s, s + ".AliasActivity");
        ComponentName cm2 = new ComponentName(s, s + ".LauncherActivity");
        PackageManager pm = this.getPackageManager();
        pm.setComponentEnabledSetting(cm, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP );
        pm.setComponentEnabledSetting(cm2, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }
}