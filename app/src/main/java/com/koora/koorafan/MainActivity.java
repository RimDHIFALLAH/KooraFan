package com.koora.koorafan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.koora.koorafan.utils.SharedPreferencesUtil;

public class MainActivity extends AppCompatActivity {
    Context _context;
    EditText txtName, txtEmail, txtAge, txtPassword;
    CheckBox cbRemember;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        _context = this;

        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtAge = findViewById(R.id.txtAge);
        txtPassword = findViewById(R.id.txtPassword);
        btnNext = findViewById(R.id.btnNext);
        cbRemember = findViewById(R.id.remember_me);

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txtName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter your Name!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (txtEmail.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter your Email!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (txtAge.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter your Age!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (txtPassword.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter your Password!", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                    Intent intent = new Intent(_context, SecondActivity.class);
                    intent.putExtra("name", txtName.getText().toString());
                    intent.putExtra("email", txtEmail.getText().toString());
                    intent.putExtra("age", txtAge.getText().toString());
                    intent.putExtra("password", txtPassword.getText().toString());
                    saveUserToShared();
                    if (cbRemember.isChecked()) {
                        SharedPreferencesUtil.writeStringToShared(_context, getString(R.string.remember_user), "true");
                    }
                    startActivity(intent);
                    finish();


                }
            }
        });
    }
    private void saveUserToShared() {
        SharedPreferencesUtil.writeStringToShared(_context, "name", txtName.getText().toString());
        SharedPreferencesUtil.writeStringToShared(_context, "email", txtEmail.getText().toString());
        SharedPreferencesUtil.writeStringToShared(_context, "age", txtAge.getText().toString());
    }
}