package com.example.demo3.Admin;

import javafx.beans.property.SimpleStringProperty;

public class DriverAvailabilityView {

    private final SimpleStringProperty driverId, firstName, vechileId;

    public DriverAvailabilityView(String saving_acc_number, String acc_number, String acc_bal) {

        this.driverId =new SimpleStringProperty(saving_acc_number);
        this.firstName =new SimpleStringProperty(acc_number);
        this.vechileId =new SimpleStringProperty(acc_bal);

}

    public String getDriverId() {
        return driverId.get();
    }

    public void setDriverId(String saving_acc_number){
        this.driverId.set(saving_acc_number);
    }

    public String getAccount_number() {
        return firstName.get();
    }

    public void setAccount_number(String acc_number){
        this.firstName.set(acc_number);
    }

    public String getVechileId(){
            return vechileId.get();
        }

    public void setVechileId(String acc_number){
        this.vechileId.set(acc_number);
    }

}

