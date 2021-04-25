package com.example.olioprojekti;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

// TextFormChecker can be used to confirm that user inputs the information in right format.
public class TextFormChecker {
    static ArrayList<Account> arrayList = new ArrayList<>();

    private  static TextFormChecker single = new TextFormChecker();
    public static TextFormChecker getInstance() { return single;}

    public static boolean checkFirstNameFormat(String firstName) {
        if (firstName.matches("[a-zA-Z]+")) {
            return true;
        }
        return false;
    }

    public static boolean checkLastNameFormat(String lastName) {
        if (lastName.matches("[a-zA-Z]+")) {
            return true;
        }
        return false;
    }

    public static boolean checkPasswordFormat(String password) {
        if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}$")) {
            return true;
        }
        return false;
    }

    public static boolean checkWeightFormat(String weight) {
        if ((weight.matches("^[0-9]*$")) && !(weight.equals(""))) {
            return true;
        }
        return false;
    }

    public static boolean checkHeightFormat(String height) {
        if ((height.matches("^[0-9]*$")) && !(height.equals(""))) {
            return true;
        }
        return false;
    }

    // CHECKS IF USERNAME HAS ALREADY BEEN TAKEN OR IF THE USERNAME IS AN EMPTY STRING.
    public static boolean checkUsernameFormat(String username, String jsonAccounts) {
        boolean taken = false;
        if (username.equals("")) {
            return false;
        }
        Gson gson = new Gson();
        Log.d("WANTED USERNAME: ", username);
        Log.d("Json content: ", jsonAccounts);
        if (!(jsonAccounts == "")) {
            Type userListType = new TypeToken<ArrayList<Account>>(){}.getType();
            arrayList = gson.fromJson(jsonAccounts, userListType);
        }

        for (Account x : arrayList) {
            if (username.equals(x.getUsername())) {
                Log.d("TakenStatus:", "USERNAME IS TAKEN!");
                return false;
            }
            Log.d("USED USERNAME: ", x.getUsername());
            Log.d("TakenStatus:", "USERNAME IS NOT TAKEN!");

        }
        return true;
    }

    public static String getRegionID(String region, Context context) {
        String regionJson = null;
        // LOAD LIST OF REAGIONS from regionlist.json.
        try {
            InputStream is = context.getAssets().open("regionlist.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            regionJson = new String(buffer, "UTF-8");
            //Log.d("regionJson", regionJson);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (regionJson == null) {
                return null;
            }
        }

        JSONArray jsonArray  = null;
        JSONObject jsonObject = null;
        try {
            jsonArray = new JSONArray(regionJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                if(region.equals(jsonObject.getString("classificationItemName"))) {
                    return jsonObject.getString("code").replaceAll("\u0027", "");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


}
