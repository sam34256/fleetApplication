package com.example.demo3;

import javafx.beans.property.SimpleStringProperty;

public class DriverAvailabilityView {

    private final SimpleStringProperty driver_id,first_name, password;

    public DriverAvailabilityView(String saving_acc_number, String acc_number, String acc_bal) {

        this.driver_id =new SimpleStringProperty(saving_acc_number);
        this.first_name =new SimpleStringProperty(acc_number);
        this.password =new SimpleStringProperty(acc_bal);
}

    public String getDriver_id() {
        return driver_id.get();
    }

    public void setDriver_id(String saving_acc_number){
        this.driver_id.set(saving_acc_number);
    }

    public String getAccount_number() {
        return first_name.get();
    }

    public void setAccount_number(String acc_number){
        this.first_name.set(acc_number);
    }

    public String getPassword(){
            return password.get();
        }

    public void setPassword(String acc_number){
        this.password.set(acc_number);
    }

}

