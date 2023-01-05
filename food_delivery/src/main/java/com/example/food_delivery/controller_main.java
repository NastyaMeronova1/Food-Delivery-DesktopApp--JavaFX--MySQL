package com.example.food_delivery;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static com.example.food_delivery.new_window.openNewScene;

public class controller_main {

    @FXML
    private Button authorisation;

    @FXML
    private Button registration;

    @FXML
    private Button request_status;

    @FXML
    void autho(ActionEvent event) {
        authorisation.getScene().getWindow().hide();
        openNewScene("authorisation.fxml", "Авторизация еды");
    }

    @FXML
    void check(ActionEvent event) {
        request_status.getScene().getWindow().hide();
        openNewScene("one_info.fxml", "Статус заказа");
    }

    @FXML
    void reg(ActionEvent event) {
        registration.getScene().getWindow().hide();
        openNewScene("registration.fxml", "Регистрация");
    }

    @FXML
    void out(ActionEvent event) {
        Platform.exit();
    }
}



