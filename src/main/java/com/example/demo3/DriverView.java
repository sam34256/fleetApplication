package com.example.demo3;

import javafx.beans.property.SimpleStringProperty;


public class DriverView {

    private final SimpleStringProperty driverId;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty laseName;
    private final SimpleStringProperty email;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty phoneNumber;



    private final SimpleStringProperty licenseNumber;

    public DriverView(String driverId , String firstName , String  laseName, String email, String  gender, String phoneNumber,
                      String licenseNumber){
        this.driverId = new SimpleStringProperty(driverId);
        this.firstName =new SimpleStringProperty(firstName);
        this.laseName =new SimpleStringProperty(laseName);
        this.email =new SimpleStringProperty(email);
        this.gender =new SimpleStringProperty(gender);
        this.phoneNumber =new SimpleStringProperty(phoneNumber);
        this.licenseNumber =new SimpleStringProperty(licenseNumber);

    }


    public String getDriverId() {
        return driverId.get();
    }

    public void setDriverId(String Transaction_Number) {
        this.driverId.set(Transaction_Number);
    }


    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String account_Number) {
        this.firstName.set(account_Number);
    }

    public String getLaseName()  {
        return laseName.get();
    }

    public void setFirst_name(String Date_created) {
        this.laseName.set(Date_created);
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
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getLicenseNumber() {
        return licenseNumber.get();
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber.set(licenseNumber);
    }



    @Override
    public String toString() {
        return "DriverView{" +
                "driverId=" + driverId +
                ", firstName=" + firstName +
                ", laseName=" + laseName +
                ", email=" + email +
                ", gender=" + gender +
                ", phoneNumber=" + phoneNumber +
                ", licenseNumber=" + licenseNumber +
                '}';
    }

}
