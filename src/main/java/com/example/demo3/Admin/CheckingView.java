package com.example.demo3.Admin;

import javafx.beans.property.SimpleStringProperty;

public class CheckingView {
    private final SimpleStringProperty Checking_account_number, Account_number, account_balance;

    public CheckingView(String checking_acc_number, String account_number, String account_bal) {

        this.Checking_account_number =new SimpleStringProperty(checking_acc_number);
        this.Account_number =new SimpleStringProperty(account_number);
        this.account_balance =new SimpleStringProperty(account_bal);

    }

    public String getChecking_account_number() {
        return Checking_account_number.get();
    }

    public void setChecking_account_number(String checking_acc_number){
        this.Checking_account_number.set(checking_acc_number);
    }

    public String getAccount_number() {
        return Account_number.get();
    }

    public void setAccount_number(String account_number){
        this.Account_number.set(account_number);
    }

    public String getAccount_balance(){
        return account_balance.get();
    }

    public void setAccount_balance(String account_bal){
        this.account_balance.set(account_bal);
    }


}
