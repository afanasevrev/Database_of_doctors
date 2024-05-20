module com.example.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires log4j;
    requires spring.web;
    requires static lombok;
    requires spring.core;
    requires com.google.gson;

    exports com.example.client.doctor;
    exports com.example.client.patient;
    exports com.example.client.medical_record;
    opens com.example.client to javafx.fxml;
    exports com.example.client;
}