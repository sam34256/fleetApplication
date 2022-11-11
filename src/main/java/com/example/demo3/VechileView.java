package com.example.demo3;


import javafx.beans.property.SimpleStringProperty;

public class VechileView {

    private final SimpleStringProperty vechile_number,making_model, vechile_year, oil_due_date, registeration_due_date, annual_checkup, mile_age, type, status;

    public VechileView(String vechile_number, String making_model, String vechile_year, String oil_due_date, String registeration_due_date,
                       String annual_checkup, String mile_age, String type, String status) {
        this.vechile_number = new SimpleStringProperty(vechile_number);
        this.making_model = new SimpleStringProperty(making_model);
        this.vechile_year = new SimpleStringProperty(vechile_year);
        this.oil_due_date = new SimpleStringProperty(oil_due_date);
        this.registeration_due_date = new SimpleStringProperty(registeration_due_date);
        this.annual_checkup = new SimpleStringProperty(annual_checkup);
        this.mile_age = new SimpleStringProperty(mile_age);
        this.type = new SimpleStringProperty(type);
        this.status = new SimpleStringProperty(status);
    }

    public String getAccount_number() {
        return vechile_number.get();
    }

    public void setAccount_number(String account_number) {
        this.vechile_number.set(account_number);
    }

    public String getMaking_model() {
        return making_model.get();
    }

    public void setMaking_model(String making_model) {
        this.making_model.set(making_model);
    }

    public String getVechile_year() {
        return vechile_year.get();
    }

    public void setVechile_year(String vechile_year) {
        this.vechile_year.set(vechile_year);
    }

    public String getOil_due_date() {
        return oil_due_date.get();
    }

    public void setOil_due_date(String oil_due_date) {
        this.oil_due_date.set(oil_due_date);
    }

    public String getRegisteration_due_date() {
        return registeration_due_date.get();
    }

    public void setRegisteration_due_date(String registeration_due_date) {
        this.registeration_due_date.set(registeration_due_date);
    }

    public String getAnnual_checkup() {
        return annual_checkup.get();
    }

    public void setAnnual_checkup(String annual_checkup) {
        this.annual_checkup.set(annual_checkup);
    }

    public String getMile_age() {
        return mile_age.get();
    }

    public void setMile_age(String mile_age) {
        this.mile_age.set(mile_age);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
