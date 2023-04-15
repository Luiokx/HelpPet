package com.lx.project.android.helppet.user_cases.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.lx.project.android.helppet.R;
import com.lx.project.android.helppet.user_cases.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Click to register
        findViewById(R.id.btnRegister).setOnClickListener(v -> {
            Intent window = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(window);
        });
    }
}