package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.registration.databinding.ActivityNextBinding;
import com.example.registration.databinding.ActivityRegistationBinding;

import java.util.Random;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityRegistationBinding binding;

    public String password;
    public String email;

    final String TAG = "T_T";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.registration.setOnClickListener(this);

    }

    public String checkPassword(String password) {
        if (password.isEmpty()) {
            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
            return "";
        }
        if (password.length() >= 8) {
            Log.v(TAG, "Password " + password);
            return this.password = password;
        } else {
            Toast.makeText(this, "Пароль должен содержать больше 8 символов", Toast.LENGTH_SHORT).show();
            return "";
        }

    }

    public String checkEmail(String email) {
        if (email.isEmpty()) {
            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
            return "";
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Log.v(TAG, "Email " + email);
            return this.email = email;

        } else {
            Toast.makeText(this, "Некорректная почта", Toast.LENGTH_SHORT).show();
            return "";
        }

    }


    public void onClick(View view) {
        password = checkPassword(binding.password.getText().toString());
        email = checkEmail(binding.email.getText().toString());
        if (password != "" && email != "") {
            switch (view.getId()) {
                case R.id.registration:
                    Intent intent = new Intent(MainActivity.this, Registation.class);
                    intent.putExtra("email", email);
                    Log.v(TAG, "Email putExtra: " + email);
                    startActivity(intent);
                    break;
            }
        } else {
          checkEmail(binding.email.getText().toString());
          checkPassword(binding.password.getText().toString());
        }
    }
}



