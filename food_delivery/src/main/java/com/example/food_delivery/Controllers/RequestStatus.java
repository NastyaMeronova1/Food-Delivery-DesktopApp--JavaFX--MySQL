package com.example.food_delivery.Controllers;

import com.example.food_delivery.Classes.Delivery;
import com.example.food_delivery.DataBase.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import static com.example.food_delivery.newWindow.openNewScene;

public class RequestStatus {

    @FXML
    private TextField enter_number;

    @FXML
    private Label label_name;

    @FXML
    private Label label_status;

    @FXML
    private Label label_title;

    @FXML
    private Button menu;

    @FXML
    void buttonMenu() {
        menu.getScene().getWindow().hide();
        openNewScene("Start.fxml", "Доставка еды");
    }

    @FXML
    void checkStatus() throws SQLException, ClassNotFoundException {
        DatabaseHandler.getRequestInfo(enter_number.getText().trim());
        label_name.setText("   " + Delivery.this_name);
        label_title.setText("   " + Delivery.this_summ);
        label_status.setText("   " + Delivery.this_status);
    }
}
