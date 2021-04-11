package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText editFirstName, editLastName, editEmail, editUsername, editPassword, editHeight, editWeight, editAddress;
    String[] registerCredentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editHeight = findViewById(R.id.editPassword);
        editWeight = findViewById(R.id.editWeight);
        editAddress = findViewById(R.id.editAddress);
    }

    public void registerClick (View view) {
        registerCredentials = new String[]{editFirstName.getText().toString(), editLastName.getText().toString(), editEmail.getText().toString(), editUsername.getText().toString(), editUsername.getText().toString(), editPassword.getText().toString(), editHeight.getText().toString(), editWeight.getText().toString(), editAddress.getText().toString()};
    }


}