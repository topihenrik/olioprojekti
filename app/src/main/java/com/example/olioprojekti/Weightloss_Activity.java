package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Weightloss_Activity extends AppCompatActivity {
    private static final String FILE_NAME = "example.txt";
    static ArrayList<WeightData> weightDataArrayList = new ArrayList<>();

    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weightloss_);
        mEditText = findViewById(R.id.edit_text);
    }

    public class WeightData {
        String weight;
        String date;
        public WeightData(String date1, String weight1){
            date = date1;
            weight = weight1;
        }
    }

    public void save(View v) {
        Gson gson = new Gson();
        String text = mEditText.getText().toString();
        FileOutputStream fos = null;
        try {
            Date currentTime = Calendar.getInstance().getTime();
            String dateToday = currentTime.toString();
            WeightData data_input = new WeightData(dateToday, text);
            String json = gson.toJson(data_input);
            Log.d("asd", json);

            fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write(text.getBytes());


            mEditText.getText().clear();
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void load(View v){
        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while((text = br.readLine()) != null){
                sb.append(text).append("\n");
            }

            mEditText.setText(sb.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}