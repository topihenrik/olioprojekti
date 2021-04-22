package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class WeightlossActivity extends AppCompatActivity {
    static ArrayList<WeightData> weightDataArrayList = new ArrayList<>();

    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weightloss_);
        mEditText = findViewById(R.id.edit_text);
    }

    public void saveWeightData(View v) {
        String text = mEditText.getText().toString();
        Date currentTime = Calendar.getInstance().getTime();
        String dateToday = currentTime.toString();
        WeightData data_input = new WeightData(dateToday, text);
        weightDataArrayList.add(data_input);
        DataHandler.getInstance().getAccount().setWeightDataArrayList(weightDataArrayList);
        DataHandler.getInstance().updateAccount(this);
        mEditText.getText().clear();
        Toast.makeText(WeightlossActivity.this, "Data added!", Toast.LENGTH_SHORT).show();

    }


}