package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    EditText editFirstName, editLastName, editEmail, editUsername, editPassword, editHeight, editWeight, editAddress;
    String[] registerCredentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editHeight = findViewById(R.id.editPassword);
        editWeight = findViewById(R.id.editWeight);
        editAddress = findViewById(R.id.editAddress);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBackToLoginIntent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(goBackToLoginIntent);
            }
        });
    }

    public void registerClick (View view) {
        registerCredentials = new String[]{editFirstName.getText().toString(), editLastName.getText().toString(), editEmail.getText().toString(), editUsername.getText().toString(), editUsername.getText().toString(), editPassword.getText().toString(), editHeight.getText().toString(), editWeight.getText().toString(), editAddress.getText().toString()};
        for (int i = 0; i < registerCredentials.length; i++) {
            System.out.println(registerCredentials[i]);
        }
    }


}