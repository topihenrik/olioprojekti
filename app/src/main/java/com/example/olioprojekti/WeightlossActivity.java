package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class WeightlossActivity extends AppCompatActivity {
    static ArrayList<WeightData> weightDataArrayList = new ArrayList<>();

    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weightloss_);
        mEditText = findViewById(R.id.edit_text);
        mTextView = findViewById(R.id.BMI_textview);
    }

    //Calculates approximate BMI from given input in kilograms and by using the users weight
    public double calculateBMI(String text){
        double constant = 1.3;
        double height = (Double.parseDouble(DataHandler.getInstance().getAccount().getHeight()))/100;
        try {
            double weight = Double.parseDouble(text);
            weight = (constant*weight);
            height = Math.pow(height,2.5);
            double result = Math.round((weight/height)*10)/10.0;
            if(result<0){
                mTextView.setText("Could not calculate BMI - check your input value!");
            }
            else if(result==0){
                mTextView.setText("Could not calculate BMI - check your input value!");
            }
            else if(height==0){
                mTextView.setText("Could not calculate BMI - check your height!");
            }
            else{
                mTextView.setText("Your current BMI (rounded) is "+result+".");
            }
            return result;
        } catch (NumberFormatException nfe){
            mTextView.setText("Characters not allowed, only numbers!");
        }
        return 0;
    }

    // Saves the inputted data to an object and appends that object to an array that is saved to a file
    public void saveWeightData(View v) {
        String text = mEditText.getText().toString();
        Date currentTime = Calendar.getInstance().getTime();
        String dateToday = currentTime.toString();

        calculateBMI(text);

        WeightData data_input = new WeightData(dateToday, text);
        weightDataArrayList.add(data_input);
        DataHandler.getInstance().getAccount().setWeightDataArrayList(weightDataArrayList);
        DataHandler.getInstance().updateAccount(this);
        mEditText.getText().clear();
        Toast.makeText(WeightlossActivity.this, "Data added!", Toast.LENGTH_SHORT).show();
    }




}