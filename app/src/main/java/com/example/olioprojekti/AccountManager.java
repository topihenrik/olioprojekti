package com.example.olioprojekti;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class AccountManager {
    Account account;
    Gson gson = new Gson();
    static ArrayList<Account> arrayList = new ArrayList<Account>();

    private static AccountManager am = new AccountManager();

    public static AccountManager getInstance() {
        return am;
    }

    // Checks if username and password are correct.
    public Account login(String name, String password, String json) {
        if (!(json == "")) {
            Type userListType = new TypeToken<ArrayList<Account>>(){}.getType();
            arrayList = gson.fromJson(json, userListType);
        }
        for (Account accountX : arrayList) {
            if (name.equals(accountX.getUsername())) {
                if (name.equals(accountX.getUsername()) && accountX.getPassword().equals(PasswordHash.generatePassword(password, accountX.getSalt()) )){
                    Log.d("LogStatus:","LOGGED IN");
                    return(accountX);
                } else {
                    Log.d("LogStatus:","WRONG USERNAME OR PASSWORD");
                }
            } else if (!name.equals(accountX.getUsername())){
                Log.d("LogStatus:","username not found");
            }
        }
        return(null);
    }

    // Creates a new Account object for a new user.
    public Account register(String fName, String lName, String userName, String eMail, String passWord, String userRegion, String userRegionID, String Weight, String Height) {
        byte[] salt = PasswordHash.getSalt();
        String generatedPassword = PasswordHash.generatePassword(passWord, salt);
        Account account = new Account(fName, lName, userName, eMail, generatedPassword, userRegion, userRegionID, Weight, Height, salt);
        return account;
    }

}

