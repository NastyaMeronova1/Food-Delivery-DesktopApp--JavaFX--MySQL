package com.example.food_delivery;

import com.example.food_delivery.DataBase.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class controller_one_info {

    @FXML
    private Button check_status;

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

    private void checkId() throws SQLException, ClassNotFoundException {
        DatabaseHandler.getRequestInfo(enter_number.getText().trim());
        label_name.setText("   " + Delivery.this_name);
        label_title.setText("   " + Delivery.this_summ);
        label_status.setText("   " + Delivery.this_status);
    }

    @FXML
    void initialize() {
        menu.setOnAction(actionEvent -> openNewScene("main.fxml"));
        check_status.setOnAction(actionEvent -> {
            try {
                checkId();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void openNewScene(String window) {
        menu.getScene().getWindow().hide();
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
