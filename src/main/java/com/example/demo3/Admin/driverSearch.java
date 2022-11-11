package com.example.demo3.Admin;

public class driverSearch {
    String Account_number, First_name, Last_name;

    public driverSearch(String Account_number, String First_name, String Last_name){
        this.Account_number = Account_number;
        this.First_name = First_name;
        this.Last_name =Last_name;
    }

    public String getAccount_number() {
        return Account_number;
    }

    public void setAccount_number(String account_number) {
        Account_number = account_number;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

}
