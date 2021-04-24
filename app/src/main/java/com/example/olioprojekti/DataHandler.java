package com.example.olioprojekti;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;

// ONCE THE USER HAS LOGGED IN, THIS IS WHERE THE ACCOUNT INFORMATION RESIDES.
// APPLICATION UPDATES THE USERS ACCOUNT INFORMATION THROUGH THIS CLASS.
public class DataHandler {
    private static final String FILE_NAME = "data.json";
    private String json;

    private static Account account = null;
    public void setAccount(Account account) {this.account = account;}
    public Account getAccount() {return this.account;}

    private ArrayList<Account> arrayList = new ArrayList<>();

    private static DataHandler single = new DataHandler();
    public static DataHandler getInstance() {return single;}

    Gson gson = new Gson();
    public void updateAccount(Context context) {
        FileInputStream fis = null;
        try {
            fis = context.openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text);
            }
            json = sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Type userListType = new TypeToken<ArrayList<Account>>(){}.getType();
        arrayList = gson.fromJson(json, userListType);
        int i = 0;
        for (Account x : arrayList) {
            if (this.account.getUserName().equals(x.getUserName())) {
                Log.d("Status:", "RIGHT USERNAME");
                break;
            }
            Log.d("Status:", "WRONG USERNAME!");
        i = i + 1;
        }

        arrayList.set(i, account);

        try {
            FileOutputStream fos = null;
            json = gson.toJson(arrayList);
            fos = context.openFileOutput(FILE_NAME, context.MODE_PRIVATE);
            fos.write(json.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return;
    }





}
