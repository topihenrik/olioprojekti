package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SignUpActivity extends AppCompatActivity {
    AccountManager am = AccountManager.getInstance();
    EditText editFirstName, editLastName, editEmail, editUsername, editPassword, editHeight, editWeight, editAddress;
    private static final String FILE_NAME = "data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editHeight = findViewById(R.id.editHeight2);
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
        String credentials = am.register(editFirstName.getText().toString(), editLastName.getText().toString(), editEmail.getText().toString(), editUsername.getText().toString(), editPassword.getText().toString(), editHeight.getText().toString(), editWeight.getText().toString(), editAddress.getText().toString());
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write(credentials.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

