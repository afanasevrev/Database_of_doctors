package com.example.client.medical_record;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MedicalRecord {
    public StringProperty id;
    public StringProperty patient_first_name;
    public StringProperty doctor_first_name;
    public StringProperty diagnosis;
    public StringProperty prescription;
    public MedicalRecord(String id, String patient_first_name, String doctor_first_name, String diagnosis, String prescription) {
        this.id = new SimpleStringProperty(this, "id", id);
        this.patient_first_name = new SimpleStringProperty(this, "patient_first_name", patient_first_name);
        this.doctor_first_name = new SimpleStringProperty(this, "doctor_first_name", doctor_first_name);
        this.diagnosis = new SimpleStringProperty(this, "diagnosis", diagnosis);
        this.prescription = new SimpleStringProperty(this, "prescription", prescription);
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
    public String getPatient_first_name() {
        return patient_first_name.get();
    }
    public StringProperty patient_first_nameProperty() {
        return patient_first_name;
    }
    public void setPatient_first_name(String patient_first_name) {
        this.patient_first_name.set(patient_first_name);
    }
    public String getDoctor_first_name() {
        return doctor_first_name.get();
    }
    public StringProperty doctor_first_nameProperty() {
        return doctor_first_name;
    }
    public void setDoctor_first_name(String doctor_first_name) {
        this.doctor_first_name.set(doctor_first_name);
    }
    public String getDiagnosis() {
        return diagnosis.get();
    }
    public StringProperty diagnosisProperty() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis.set(diagnosis);
    }
    public String getPrescription() {
        return prescription.get();
    }
    public StringProperty prescriptionProperty() {
        return prescription;
    }
    public void setPrescription(String prescription) {
        this.prescription.set(prescription);
    }
}
