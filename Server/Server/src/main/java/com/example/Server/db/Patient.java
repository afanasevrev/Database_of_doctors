package com.example.Server.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
/**
 * Класс сущность для пациента
 */
@Setter
@Getter
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "insurance_number")
    private String insurance_number;
    @Column(name = "address")
    private String address;
    @Column(name = "section")
    private String section;
    public Patient() {}
    public Patient(String first_name, String insurance_number, String address, String section) {
        this.first_name = first_name;
        this.insurance_number = insurance_number;
        this.address = address;
        this.section = section;
    }
}
