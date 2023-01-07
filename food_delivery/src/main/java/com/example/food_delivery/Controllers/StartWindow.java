package com.example.food_delivery.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static com.example.food_delivery.newWindow.openNewScene;

public class StartWindow {

    @FXML
    private Button authorisation;

    @FXML
    private Button registration;

    @FXML
    private Button request_status;

    @FXML
    void buttonAuthorisation() {
        authorisation.getScene().getWindow().hide();
        openNewScene("Authorisation.fxml", "Авторизация еды");
    }

    @FXML
    void buttonCheckStatus() {
        request_status.getScene().getWindow().hide();
        openNewScene("RequestStatus.fxml", "Статус заказа");
    }

    @FXML
    void buttonRegistration() {
        registration.getScene().getWindow().hide();
        openNewScene("Registration.fxml", "Регистрация");
    }

    @FXML
    void exitProgram() {
        Platform.exit();
    }
}
