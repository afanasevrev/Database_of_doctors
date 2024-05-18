module com.example.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires log4j;
    requires spring.web;


    opens com.example.client to javafx.fxml;
    exports com.example.client;
}