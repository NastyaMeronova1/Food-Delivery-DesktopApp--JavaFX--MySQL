package com.example.food_delivery;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class controller_main {


    @FXML
    private Button authorisation;

    @FXML
    private Button exit;

    @FXML
    private Button registration;

    @FXML
    private Button request_status;

    @FXML
    void initialize() {
        registration.setOnAction(event -> openNewScene("registration.fxml"));
        authorisation.setOnAction(event -> openNewScene("authorisation.fxml"));
        request_status.setOnAction(event -> openNewScene("one_info.fxml"));
        exit.setOnAction(event -> Platform.exit());
    }

    public void openNewScene(String window) {
        authorisation.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}



