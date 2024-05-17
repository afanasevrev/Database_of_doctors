package com.example.Server.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "specialty")
    private String specialty;
    @Column(name = "office")
    private String office;
    @Column(name = "phone")
    private String phone;
    public Doctor(){}
    public Doctor(String first_name, String specialty, String office, String phone) {
        this.first_name = first_name;
        this.specialty = specialty;
        this.office = office;
        this.phone = phone;
    }
}
