package com.example.Server.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
/**
 * Класс сущность для медицинской карты
 */
@Setter
@Getter
@Entity
@Table(name = "medical_records")
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "prescription")
    private String prescription;
    public MedicalRecord() {}
    public MedicalRecord(Patient patient, Doctor doctor, String diagnosis, String prescription) {
        this.patient = patient;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }
}
