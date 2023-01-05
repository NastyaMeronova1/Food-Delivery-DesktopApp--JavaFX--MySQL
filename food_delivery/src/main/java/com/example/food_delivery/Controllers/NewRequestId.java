package com.example.food_delivery.Controllers;

import com.example.food_delivery.Classes.Delivery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NewRequestId {

    @FXML
    private Button close;
    @FXML
    private Label text;

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        text.setText(text.getText() + Delivery.this_id);
    }
}
