package com.example.food_delivery.Controllers;

import com.example.food_delivery.Classes.Delivery;
import com.example.food_delivery.DataBase.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import static com.example.food_delivery.new_window.openNewScene;

public class controller_one_info {

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
    void back(ActionEvent event) {
        menu.getScene().getWindow().hide();
        openNewScene("main.fxml", "Доставка еды");
    }

    @FXML
    void status(ActionEvent event) throws SQLException, ClassNotFoundException {
        DatabaseHandler.getRequestInfo(enter_number.getText().trim());
        label_name.setText("   " + Delivery.this_name);
        label_title.setText("   " + Delivery.this_summ);
        label_status.setText("   " + Delivery.this_status);
    }
}
