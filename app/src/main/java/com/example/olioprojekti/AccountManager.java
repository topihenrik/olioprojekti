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

    // CHECKS IF USERNAME AND PASSWORD ARE CORRECT.
    public Account login(String name, String password, String json) {
        if (!(json == "")) {
            Type userListType = new TypeToken<ArrayList<Account>>(){}.getType();
            arrayList = gson.fromJson(json, userListType);
        }
        for (Account x : arrayList) {
            if (name.equals(x.getUserName())) {
                if (name.equals(x.getUserName()) && x.getPassword().equals(PasswordHash.generatePassword(password, x.getSalt()) )){
                    Log.d("LogStatus:","LOGGED IN");
                    return(x);
                } else {
                    Log.d("LogStatus:","WRONG USERNAME OR PASSWORD");
                }
            } else if (!name.equals(x.getUserName())){
                Log.d("LogStatus:","username not found");
            }
        }
        return(null);
    }

    // CREATES A NEW ACCOUNT OBJECT FOR A NEW USER.
    public Account register(String fName, String lName, String userName, String eMail, String passWord, String userAddress, String Weight, String Height) {
        byte[] salt = PasswordHash.getSalt();
        String generatedPassword = PasswordHash.generatePassword(passWord, salt);
        Account account = new Account(fName, lName, userName, eMail, generatedPassword, userAddress, Weight, Height, salt);
        return account;
    }

}

