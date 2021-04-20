package com.example.olioprojekti;

// ONCE THE USER HAS LOGGED IN, THIS IS WHERE THE ACCOUNT INFORMATION RESIDES.
// APPLICATION UPDATES THE USERS ACCOUNT INFORMATION THROUGH THIS CLASS.
public class DataHandler {
    private static DataHandler single = new DataHandler();
    private static Account account;
    public static DataHandler getInstance() {return single;}

    public void setAccount(Account account) {this.account = account;}
    public Account getAccount() {return this.account;}

}
