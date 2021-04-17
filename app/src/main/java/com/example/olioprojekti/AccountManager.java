package com.example.olioprojekti;


import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class AccountManager {
    Account account;

    ArrayList<Account> arrayList = new ArrayList<Account>();



    private static AccountManager am = new AccountManager();

    public static AccountManager getInstance() {
        return am;
    }

    public void login(String name, String password) {
        for (Account x : arrayList) {
            if (name.equals(x.getUserName())) {
                if (name.equals(x.getUserName()) && x.getPassword().equals(PasswordHash.generatePassword(password, x.getSalt()) )){
                    System.out.println("LOGGED IN");
                } else {
                    System.out.println("WRONG USERNAME OR PASSWORD");
                }
            } else if (!name.equals(x.getUserName())){
                System.out.println("username not found");
            }
        }
    }

    public String register(String fName, String lName, String userName, String eMail, String passWord, String userAddress, String Weight, String Height) {
        byte[] salt = PasswordHash.getSalt();
        String generatedPassword = PasswordHash.generatePassword(passWord, salt);
        account = new Account(fName, lName, userName, eMail, generatedPassword, userAddress, Weight, Height, salt);
        Gson gson = new Gson();
        String json = gson.toJson(account);
        return json;
    }

}

