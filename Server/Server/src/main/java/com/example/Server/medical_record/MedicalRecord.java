package com.example.Server.medical_record;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MedicalRecord {
    private String id;
    private String patient_first_name;
    private String doctor_first_name;
    private String diagnosis;
    private String prescription;
    public MedicalRecord() {}
    public MedicalRecord(String id, String patient_first_name, String doctor_first_name, String diagnosis, String prescription) {
        this.id = id;
        this.patient_first_name = patient_first_name;
        this.doctor_first_name = doctor_first_name;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }
}
