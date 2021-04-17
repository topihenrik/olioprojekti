package com.example.olioprojekti;

public class Account {
    String firstName, lastName, username, email, password, address, weight, height;
    byte[] salt;

    public Account(String fName, String lName, String userName, String eMail, String passWord, String userAddress, String Weight, String Height, byte[] Salt) {
        firstName = fName;
        lastName = lName;
        username = userName;
        email = eMail;
        password = passWord;
        address = userAddress;
        weight = Weight;
        height = Height;
        salt = Salt;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getSalt() {
        return salt;
    }

}
