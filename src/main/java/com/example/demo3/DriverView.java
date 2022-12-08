package com.example.demo3;

import javafx.beans.property.SimpleStringProperty;


public class DriverView {


    private final SimpleStringProperty driver_id;
    private final SimpleStringProperty first_name;
    private final SimpleStringProperty last_name;
    private final SimpleStringProperty email;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty phone_number;

    private final SimpleStringProperty license_number;


    public DriverView(String driver_id, String first_name, String  laseName, String email, String  gender, String phoneNumber,
                      String license_number){
        this.driver_id = new SimpleStringProperty(driver_id);
        this.first_name =new SimpleStringProperty(first_name);
        this.last_name =new SimpleStringProperty(laseName);
        this.email =new SimpleStringProperty(email);
        this.gender =new SimpleStringProperty(gender);
        this.phone_number =new SimpleStringProperty(phoneNumber);
        this.license_number =new SimpleStringProperty(license_number);

    }


    public String getDriver_id() {
        return driver_id.get();
    }

    public void setDriver_id(String Transaction_Number) {
        this.driver_id.set(Transaction_Number);
    }


    public String getFirst_name() {
        return first_name.get();
    }

    public void setFirst_name(String account_Number) {
        this.first_name.set(account_Number);
    }

    public String getLast_name()  {
        return last_name.get();
    }



    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getGender() {
        return gender.get();
    }

    public void setMiddle_name(String income_deposit) {
        this.gender.set(income_deposit);
    }

    public String getPhoneNumber() {
        return phone_number.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone_number.set(phoneNumber);
    }

    public String getLicense_number() {
        return license_number.get();
    }

    public void setLicense_number(String license_number) {
        this.license_number.set(license_number);
    }



    @Override
    public String toString() {
        return "DriverView{" +
                "driverId=" + driver_id +
                ", firstName=" + first_name +
                ", laseName=" + last_name +
                ", email=" + email +
                ", gender=" + gender +
                ", phoneNumber=" + phone_number +
                ", licenseNumber=" + license_number +
                '}';
    }

}
