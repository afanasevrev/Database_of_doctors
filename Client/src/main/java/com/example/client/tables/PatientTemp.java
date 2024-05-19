package com.example.client.tables;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class PatientTemp {
    private String id;
    private String first_name;
    private String insurance_number;
    private String address;
    private String section;
    public PatientTemp() {}
    public PatientTemp(String id, String first_name, String insurance_number, String address, String section) {
        this.id = id;
        this.first_name = first_name;
        this.insurance_number = insurance_number;
        this.address = address;
        this.section = section;
    }
}
