package com.example.client.doctor;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class DoctorTemp {
    private String id;
    private String first_name;
    private String specialty;
    private String office;
    private String phone;
    public DoctorTemp() {}
    public DoctorTemp(String id, String first_name, String specialty, String office, String phone) {
        this.id = id;
        this.first_name = first_name;
        this.specialty = specialty;
        this.office = office;
        this.phone = phone;
    }
}
