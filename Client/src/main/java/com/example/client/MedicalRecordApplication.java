package com.example.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

public class MedicalRecordApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MedicalRecordApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Медицинская карта");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        BasicConfigurator.configure();
        launch();
    }
}