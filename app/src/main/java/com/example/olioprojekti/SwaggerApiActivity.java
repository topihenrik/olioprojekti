package com.example.olioprojekti;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class SwaggerApiActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    TextView swgPopTextDairy, swgPopTextMeat, swgPopTextPlant, swgPopTextRestaurant, swgPopTextTotal;
    Button swgPopButtonExit;
    TextView swgSBTextBeef, swgSBTextFish, swgSBTextPorkNPoultry, swgSBTextDairy, swgSBTextCheese, swgSBTextRice, swgSBTextEgg, swgSBTextWinterSalad;
    SeekBar swgSeekBarBeef, swgSeekBarFish, swgSeekBarPorkNPoultry, swgSeekBarDairy, swgSeekBarCheese, swgSeekBarRice, swgSeekBarEgg, swgSeekBarWinterSalad;
    EditText swgEditSpending;
    Spinner swgSpinnerDiet;
    Switch swgSwitchLowCarbonPref;
    String swgSwitchLowCaronPrefValue = "false";

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;


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

    // Generates Climate Diet results from user given information.
    public void swgSubmitButton(View view) {
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
        String resultJson = sa.readJsonPage(apiRequest);
        Toast.makeText(SwaggerApiActivity.this, "Carbon footprint calculated!", Toast.LENGTH_LONG).show();

        DataHandler.getInstance().saveDietData(resultJson);
        DataHandler.getInstance().updateAccount(this);
        createNewResultDialog(resultJson);
        return;
    }

    // Creates a pop up window for Climate Diet results.
    public void createNewResultDialog(String resultJson) {
        dialogBuilder = new AlertDialog.Builder(this);
        final View resultPopupView = getLayoutInflater().inflate(R.layout.popup, null);

        swgPopTextDairy = resultPopupView.findViewById(R.id.swgPopTextDairy);
        swgPopTextMeat = resultPopupView.findViewById(R.id.swgPopTextMeat);
        swgPopTextPlant = resultPopupView.findViewById(R.id.swgPopTextPlant);
        swgPopTextRestaurant = resultPopupView.findViewById(R.id.swgPopTextRestaurant);
        swgPopTextTotal = resultPopupView.findViewById(R.id.swgPopTextTotal);
        swgPopButtonExit = resultPopupView.findViewById(R.id.swgPopButtonExit);

        try {
            JSONObject jsonObject = new JSONObject(resultJson);
            swgPopTextDairy.setText("From dairy: " + Math.round(Double.parseDouble(jsonObject.getString("Dairy"))*100.0)/100.0 + " kg");
            swgPopTextMeat.setText("From meat: " + Math.round(Double.parseDouble(jsonObject.getString("Meat"))*100.0)/100.0 + " kg");
            swgPopTextPlant.setText("From plants: " + Math.round(Double.parseDouble(jsonObject.getString("Plant"))*100.0)/100.0 + " kg");
            swgPopTextRestaurant.setText("From restaurant: " + Math.round(Double.parseDouble(jsonObject.getString("Restaurant"))*100.0)/100.0 + " kg");
            swgPopTextTotal.setText("In total: " + Math.round(Double.parseDouble(jsonObject.getString("Total"))*100.0)/100.0 + " kg of CO2 / year.");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        dialogBuilder.setView(resultPopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        swgPopButtonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }


}


