package com.example.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * Контроллер для файла main.fxml
 */
public class MedicalRecordsController {
    //Врачи
    @FXML
    private TextField textFieldDoctorFirstName = new TextField();
    @FXML
    private TextField textFieldDoctorSpecialty = new TextField();
    @FXML
    private TextField textFieldDoctorOffice = new TextField();
    @FXML
    private TextField textFieldDoctorPhone = new TextField();
    @FXML
    private Button buttonCreateDoctor = new Button();

    //------------------------------------------------------------//
    //Пациенты
    @FXML
    private TextField textFieldPatientFirstName = new TextField();
    @FXML
    private TextField textFieldPatientAddress = new TextField();
    @FXML
    private TextField textFieldPatientInsuranceNumber = new TextField();
    @FXML
    private TextField textFieldPatientSection = new TextField();
    @FXML
    private Button buttonCreatePatient = new Button();

    //------------------------------------------------------------//
    //Медицинские карты
    
}