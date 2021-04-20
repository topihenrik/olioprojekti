package com.example.olioprojekti;

public class DataHandler {
    private static DataHandler single = new DataHandler();
    private static Account account;
    public static DataHandler getInstance() {return single;}

    public void setAccount(Account account) {this.account = account;}
    public Account getAccount() {return this.account;}

}
