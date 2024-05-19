package com.example.client.patient;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Patient {
    public StringProperty id;
    public StringProperty first_name;
    public StringProperty insurance;
    public StringProperty address;
    public StringProperty section;
    public Patient(String id, String first_name, String insurance, String address, String section) {
        this.id = new SimpleStringProperty(this, "id", id);
        this.first_name = new SimpleStringProperty(this, "first_name", first_name);
        this.insurance = new SimpleStringProperty(this, "insurance", insurance);
        this.address = new SimpleStringProperty(this, "address", address);
        this.section = new SimpleStringProperty(this, "section", section);
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
    public String getInsurance() {
        return insurance.get();
    }
    public StringProperty insuranceProperty() {
        return insurance;
    }
    public void setInsurance(String insurance) {
        this.insurance.set(insurance);
    }
    public String getAddress() {
        return address.get();
    }
    public StringProperty addressProperty() {
        return address;
    }
    public void setAddress(String address) {
        this.address.set(address);
    }
    public String getSection() {
        return section.get();
    }
    public StringProperty sectionProperty() {
        return section;
    }
    public void setSection(String section) {
        this.section.set(section);
    }
}
