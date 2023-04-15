package com.lx.project.android.helppet.user_cases.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.textfield.TextInputEditText;
import com.lx.project.android.helppet.R;
import com.lx.project.android.helppet.user_cases.register.ui.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {
    private RegisterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.viewModel = new ViewModelProvider(RegisterActivity.this).get(RegisterViewModel.class);

        TextInputEditText nameInput = findViewById(R.id.nameInputRegister);
        TextInputEditText emailInput = findViewById(R.id.emailInputRegister);
        TextInputEditText pwdInput = findViewById(R.id.passwordInputRegister);
        TextInputEditText pwdConfirmInput = findViewById(R.id.passwordInputRegisterConfirm);

        //Add action to register button
        AppCompatButton btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(V -> {
            //Get text from inputs
            String name = nameInput.getText().toString();
            String email = emailInput.getText().toString();
            String pwd = pwdInput.getText().toString();
            String pwdConfirm = pwdConfirmInput.getText().toString();

            this.viewModel.registerUser(name, email, pwd, pwdConfirm);
        });
    }
}