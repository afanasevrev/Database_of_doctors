package com.example.client;

import com.example.client.doctor.Doctor;
import com.example.client.medical_record.MedicalRecord;
import com.example.client.patient.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.apache.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Контроллер для файла main.fxml
 */
public class MedicalRecordsController implements Initializable {
    private Logger logger = Logger.getLogger(MedicalRecordsController.class);
    private String url = "http://" + Variables.ip_server + ":" + Variables.port_server;
    private RestTemplate restTemplate = new RestTemplate();
    //------------------------------------------------------------//
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
    @FXML
    private TableView<Doctor> tableViewDoctor = new TableView<Doctor>();
    private ObservableList<Doctor> doctorsData = FXCollections.<Doctor>observableArrayList();
    @FXML
    private TableColumn<Doctor, String> tableColumnDoctorId = new TableColumn<Doctor, String>("ID");
    @FXML
    private TableColumn<Doctor, String> tableColumnDoctorFirstName = new TableColumn<Doctor, String>("Фамилия");
    @FXML
    private TableColumn<Doctor, String> tableColumnDoctorSpecialty = new TableColumn<Doctor, String>("Специальность");
    @FXML
    private TableColumn<Doctor, String> tableColumnDoctorOffice = new TableColumn<Doctor, String>("Раб. кабинет");
    @FXML
    private TableColumn<Doctor, String> tableColumnDoctorPhone = new TableColumn<Doctor, String>("Телефон");
    @FXML
    private Button buttonUpdateListDoctors = new Button();
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
    @FXML
    private TableView<Patient> tableViewPatient = new TableView<Patient>();
    private ObservableList<Patient> patientsData = FXCollections.<Patient>observableArrayList();
    @FXML
    private TableColumn<Patient, String> tableColumnPatientId = new TableColumn<Patient, String>("ID");
    @FXML
    private TableColumn<Patient, String> tableColumnPatientFirstName = new TableColumn<Patient, String>("Фамилия");
    @FXML
    private TableColumn<Patient, String> tableColumnPatientInsuranceNumber = new TableColumn<Patient, String>("Номер стр. полиса");
    @FXML
    private TableColumn<Patient, String> tableColumnPatientAddress = new TableColumn<Patient, String>("Адрес");
    @FXML
    private TableColumn<Patient, String> tableColumnPatientSection = new TableColumn<Patient, String>("Участок");
    @FXML
    private Button buttonUpdateListPatients = new Button();
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
    @FXML
    private TableView<MedicalRecord> tableViewMedicalRecord = new TableView<MedicalRecord>();
    private ObservableList<MedicalRecord> medicalRecordsData = FXCollections.<MedicalRecord>observableArrayList();
    @FXML
    private TableColumn<MedicalRecord, String> tableColumnMedicalRecordId = new TableColumn<MedicalRecord, String>("ID");
    @FXML
    private TableColumn<MedicalRecord, String> tableColumnMedicalRecordPatientFirstName = new TableColumn<MedicalRecord, String>("Пациент");
    @FXML
    private TableColumn<MedicalRecord, String> tableColumnMedicalRecordDoctorFirstName = new TableColumn<MedicalRecord, String>("Врач");
    @FXML
    private TableColumn<MedicalRecord, String> tableColumnMedicalRecordDiagnosis = new TableColumn<MedicalRecord, String>("Диагноз");
    @FXML
    private TableColumn<MedicalRecord, String> tableColumnMedicalRecordPrescription = new TableColumn<MedicalRecord, String>("Назначение");
    @FXML
    private Button buttonUpdateListMedicalRecords = new Button();
    /**
     * Инициализация при запуске формы
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewDoctor.setItems(doctorsData);
        tableColumnDoctorId.setCellValueFactory(cellData -> cellData.getValue().id);
        tableColumnDoctorFirstName.setCellValueFactory(cellData -> cellData.getValue().first_name);
        tableColumnDoctorSpecialty.setCellValueFactory(cellData -> cellData.getValue().specialty);
        tableColumnDoctorOffice.setCellValueFactory(cellData -> cellData.getValue().office);
        tableColumnDoctorPhone.setCellValueFactory(cellData -> cellData.getValue().phone);
        //------------------------------------------------------------//
        tableViewPatient.setItems(patientsData);
        tableColumnPatientId.setCellValueFactory(cellData -> cellData.getValue().id);
        tableColumnDoctorFirstName.setCellValueFactory(cellData -> cellData.getValue().first_name);
        tableColumnPatientInsuranceNumber.setCellValueFactory(cellData -> cellData.getValue().insurance_number);
        tableColumnPatientAddress.setCellValueFactory(cellData -> cellData.getValue().address);
        tableColumnPatientSection.setCellValueFactory(cellData -> cellData.getValue().section);
        //------------------------------------------------------------//
        tableViewMedicalRecord.setItems(medicalRecordsData);
        tableColumnMedicalRecordId.setCellValueFactory(cellData -> cellData.getValue().id);
        tableColumnMedicalRecordPatientFirstName.setCellValueFactory(cellData -> cellData.getValue().patient_first_name);
        tableColumnMedicalRecordDoctorFirstName.setCellValueFactory(cellData -> cellData.getValue().doctor_first_name);
        tableColumnMedicalRecordDiagnosis.setCellValueFactory(cellData -> cellData.getValue().diagnosis);
        tableColumnMedicalRecordPrescription.setCellValueFactory(cellData -> cellData.getValue().prescription);
    }
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
                textFieldDoctorFirstName.setText("");
                textFieldDoctorSpecialty.setText("");
                textFieldDoctorOffice.setText("");
                textFieldDoctorPhone.setText("");
            } catch (RuntimeException e) {
                logger.error(e);
            }
        } else {
            logger.info("Заполните все поля");
        }
    }
    /**
     * Реализуем кнопку "Добавить пациента"
     */
    @FXML
    private void setButtonCreatePatient() {
        if (!textFieldPatientFirstName.getText().isEmpty() &&
            !textFieldPatientAddress.getText().isEmpty() &&
            !textFieldPatientInsuranceNumber.getText().isEmpty() &&
            !textFieldPatientSection.getText().isEmpty()
        )
        {
           String url_create_patient = this.url + "/createPatient/"
                   + textFieldPatientFirstName.getText() + "&"
                   + textFieldPatientInsuranceNumber.getText() + "&"
                   + textFieldPatientAddress.getText() + "&"
                   + textFieldPatientSection.getText();
           ResponseEntity<String> response = null;
           try {
               response = restTemplate.exchange(url_create_patient, HttpMethod.GET, null, String.class);
               logger.info(response.getBody());
               textFieldPatientFirstName.setText("");
               textFieldPatientInsuranceNumber.setText("");
               textFieldPatientAddress.setText("");
               textFieldPatientSection.setText("");
           } catch (RuntimeException e) {
               logger.error(e);
           }
        } else {
            logger.info("Заполните все поля");
        }
    }
    /**
     * Реализуем кнопку "Добавить медицинскую карту"
     */
    @FXML
    private void setButtonCreateMedicalRecord() {
        if (!textFieldMedicalRecordPatientID.getText().isEmpty() &&
            !textFieldMedicalRecordDoctorID.getText().isEmpty() &&
            !textFieldMedicalRecordDiagnosis.getText().isEmpty() &&
            !textFieldMedicalRecordPrescription.getText().isEmpty())
        {
            String url_create_medical_record = this.url + "/createMedicalRecord/"
                    + textFieldMedicalRecordPatientID.getText() + "&"
                    + textFieldMedicalRecordDoctorID.getText() + "&"
                    + textFieldMedicalRecordDiagnosis.getText() + "&"
                    + textFieldMedicalRecordPrescription.getText();
            try {
                ResponseEntity<String> response = restTemplate.exchange(url_create_medical_record, HttpMethod.GET, null, String.class);
                logger.info(response.getBody());
                textFieldMedicalRecordPatientID.setText("");
                textFieldMedicalRecordDoctorID.setText("");
                textFieldMedicalRecordDiagnosis.setText("");
                textFieldMedicalRecordPrescription.setText("");
            } catch (RuntimeException e) {
                logger.error(e);
            }
        } else {
            logger.info("Заполните все поля");
        }
    }
    /**
     * Метод заполняет таблицу с врачами
     * предварительно направив на сервер GET - запрос
     */
    @FXML
    private void setButtonUpdateListDoctors() {
        String url_getDoctors = this.url + "/getDoctors";
        ResponseEntity<String> response = restTemplate.exchange(url_getDoctors, HttpMethod.GET, null, String.class);
        try {
            logger.info(response.getBody());
        } catch (RuntimeException e) {
            logger.error(e);
        }
    }
}