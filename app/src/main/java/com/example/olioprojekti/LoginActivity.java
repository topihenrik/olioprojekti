package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    AccountManager am = AccountManager.getInstance();
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button) findViewById(R.id.backToMain);
        username = (EditText) findViewById(R.id.editUsername2);
        password = (EditText) findViewById(R.id.editPassword2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBackToMainIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(goBackToMainIntent);
            }
        });
    }

    public void loadRegisterActivity(View v) {
        finish();
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    public void loginButton(View v) {
        am.login(username.getText().toString(), password.getText().toString());


    }
}