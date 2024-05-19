package com.example.client.doctor;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Doctor {
    public StringProperty id;
    public StringProperty first_name;
    public StringProperty specialty;
    public StringProperty office;
    public StringProperty phone;
    public Doctor(String id, String first_name, String specialty, String office, String phone) {
        this.id = new SimpleStringProperty(this, "id", id);
        this.first_name = new SimpleStringProperty(this, "first_name", first_name);
        this.specialty = new SimpleStringProperty(this, "specialty", specialty);
        this.office = new SimpleStringProperty(this, "office", office);
        this.phone = new SimpleStringProperty(this, "phone", phone);
    }
    public String getId() {
        return id.get();
    }
    public StringProperty idProperty() {
        return id;
    }
    public void setId(String id) {
        this.id.set(id);
    }
    public String getFirst_name() {
        return first_name.get();
    }
    public StringProperty first_nameProperty() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name.set(first_name);
    }
    public String getSpecialty() {
        return specialty.get();
    }
    public StringProperty specialtyProperty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty.set(specialty);
    }
    public String getOffice() {
        return office.get();
    }
    public StringProperty officeProperty() {
        return office;
    }
    public void setOffice(String office) {
        this.office.set(office);
    }
    public String getPhone() {
        return phone.get();
    }
    public StringProperty phoneProperty() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone.set(phone);
    }
}
