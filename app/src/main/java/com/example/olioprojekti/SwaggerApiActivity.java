package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class SwaggerApiActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    TextView swgSBTextBeef, swgSBTextFish, swgSBTextPorkNPoultry, swgSBTextDairy, swgSBTextCheese, swgSBTextRice, swgSBTextEgg, swgSBTextWinterSalad;
    SeekBar swgSeekBarBeef, swgSeekBarFish, swgSeekBarPorkNPoultry, swgSeekBarDairy, swgSeekBarCheese, swgSeekBarRice, swgSeekBarEgg, swgSeekBarWinterSalad;
    EditText swgEditSpending;
    Spinner swgSpinnerDiet;
    Switch swgSwitchLowCarbonPref;
    String swgSwitchLowCaronPrefValue = "false";


    SwaggerApi sa = new SwaggerApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_swagger_api);

        swgSBTextBeef = findViewById(R.id.swgSBTextBeef);
        swgSBTextFish = findViewById(R.id.swgSBTextFish);
        swgSBTextPorkNPoultry = findViewById(R.id.swgSBTextPorkNPoultry);
        swgSBTextDairy = findViewById(R.id.swgSBTextDairy);
        swgSBTextCheese = findViewById(R.id.swgSBTextCheese);
        swgSBTextRice = findViewById(R.id.swgSBTextRice);
        swgSBTextEgg = findViewById(R.id.swgSBTextEgg);
        swgSBTextWinterSalad = findViewById(R.id.swgSBTextWinterSalad);

        swgEditSpending = findViewById(R.id.swgEditSpending);

        swgSpinnerDiet = findViewById(R.id.swgSpinnerDiet);
        ArrayAdapter<CharSequence> spinnerDietAdapter = ArrayAdapter.createFromResource(this, R.array.dietOptions, android.R.layout.simple_spinner_item);
        spinnerDietAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        swgSpinnerDiet.setAdapter(spinnerDietAdapter);
        swgSpinnerDiet.setOnItemSelectedListener(this);

        swgSwitchLowCarbonPref = findViewById(R.id.swgSwitchLowCarbonPref);
        swgSwitchLowCarbonPref.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    swgSwitchLowCaronPrefValue = "true";
                } else {
                    swgSwitchLowCaronPrefValue = "false";
                }

            }
        });

        swgSeekBarBeef = findViewById(R.id.swgSeekBarBeef);
        swgSeekBarBeef.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                swgSBTextBeef.setText(String.valueOf(progress) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        swgSeekBarFish = findViewById(R.id.swgSeekBarFish);
        swgSeekBarFish.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                swgSBTextFish.setText(String.valueOf(progress) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        swgSeekBarPorkNPoultry = findViewById(R.id.swgSeekBarPorkNPoultry);
        swgSeekBarPorkNPoultry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                swgSBTextPorkNPoultry.setText(String.valueOf(progress) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        swgSeekBarDairy = findViewById(R.id.swgSeekBarDairy);
        swgSeekBarDairy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                swgSBTextDairy.setText(String.valueOf(progress) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        swgSeekBarCheese = findViewById(R.id.swgSeekBarCheese);
        swgSeekBarCheese.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                swgSBTextCheese.setText(String.valueOf(progress) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        swgSeekBarRice = findViewById(R.id.swgSeekBarRice);
        swgSeekBarRice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                swgSBTextRice.setText(String.valueOf(progress) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        swgSeekBarEgg = findViewById(R.id.swgSeekBarEgg);
        swgSeekBarEgg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                swgSBTextEgg.setText(String.valueOf(progress) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        swgSeekBarWinterSalad = findViewById(R.id.swgSeekBarWinterSalad);
        swgSeekBarWinterSalad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                swgSBTextWinterSalad.setText(String.valueOf(progress) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void swgSubmitButton(View view) {
        //public String generateApiRequest(String diet, String lowCarbonPreference, String beefLevel, String fishLevel, String porkPoultryLevel, String dairyLevel, String cheeseLevel, String riceLevel, String eggLevel, String winterSaladLevel, String restaurantSpending)
        String apiRequest = sa.generateApiRequest(
                swgSpinnerDiet.getSelectedItem().toString(),
                swgSwitchLowCaronPrefValue,
                swgSBTextBeef.getText().toString().replace("%", ""),
                swgSBTextFish.getText().toString().replace("%", ""),
                swgSBTextPorkNPoultry.getText().toString().replace("%", ""),
                swgSBTextDairy.getText().toString().replace("%", ""),
                swgSBTextCheese.getText().toString().replace("%", ""),
                swgSBTextRice.getText().toString().replace("%", ""),
                swgSBTextEgg.getText().toString().replace("%", ""),
                swgSBTextWinterSalad.getText().toString().replace("%", ""),
                swgEditSpending.getText().toString().replaceAll("[^0-9]",""));

        Log.d("ApiRequest: ", apiRequest);
        sa.readJsonPage(apiRequest);
        return;
    }


}


