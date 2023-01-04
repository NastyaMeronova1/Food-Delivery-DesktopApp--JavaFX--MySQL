package com.example.food_delivery;

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
    void initialize() {
        close.setOnAction(actionEvent ->
        {
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
        });
        text.setText(text.getText() + Delivery.this_id);
    }

}
