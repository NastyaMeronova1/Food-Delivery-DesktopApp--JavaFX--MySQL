package com.example.food_delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class controller_instance_info {

    @FXML
    private Button close;
    @FXML
    private Label text;

    @FXML
    void close_this(ActionEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        text.setText(text.getText() + Delivery.this_id);
    }
}
