package com.example.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.apache.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
/**
 * Контроллер для файла main.fxml
 */
public class MedicalRecordsController {
    private Logger logger = Logger.getLogger(MedicalRecordsController.class);
    private String url = "http://" + Variables.ip_server + ":" + Variables.port_server;
    private RestTemplate restTemplate = new RestTemplate();
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
    @FXML
    private TextField textFieldMedicalRecordPatientID = new TextField();
    @FXML
    private TextField textFieldMedicalRecordDoctorID = new TextField();
    @FXML
    private TextField textFieldMedicalRecordDiagnosis = new TextField();
    @FXML
    private TextField textFieldMedicalRecordPrescription = new TextField();
    @FXML
    private Button buttonCreateMedicalRecord = new Button();

    //------------------------------------------------------------//
    /**
     * Реализуем кнопку "Добавить врача"
     */
    @FXML
    private void setButtonCreateDoctor() {
        if (!textFieldDoctorFirstName.getText().isEmpty() && !textFieldDoctorSpecialty.getText().isEmpty()
        && !textFieldDoctorOffice.getText().isEmpty() && !textFieldDoctorPhone.getText().isEmpty()) {
            String url_create_doctor = this.url + "/createDoctor/"
                    + textFieldDoctorFirstName.getText() + "&"
                    + textFieldDoctorSpecialty.getText() + "&"
                    + textFieldDoctorOffice.getText() + "&"
                    + textFieldDoctorPhone.getText();
            ResponseEntity<String> response = null;
            try {
                response = restTemplate.exchange(url_create_doctor, HttpMethod.GET, null, String.class);
                logger.info(response.getBody());
            } catch (RuntimeException e) {
                logger.error(e);
            }
        } else {
            logger.info("Заполните все поля");
        }
    }
}