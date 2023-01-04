package com.example.food_delivery;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import static com.example.food_delivery.DataBase.DatabaseHandler.getRole;
import static com.example.food_delivery.Hash.hash;

public class controller_authorisation {


    @FXML
    private Button authorisation;

    @FXML
    private TextField enter_login;

    @FXML
    private PasswordField enter_password;

    @FXML
    private Button menu;

    @FXML
    private Button registration;

    @FXML
    void initialize() {
        authorisation.setOnAction(event -> {
            String loginText = enter_login.getText().trim();
            String passText = enter_password.getText().trim();
            if (!loginText.equals("") && !passText.equals("")) {
                try {
                    loginUser(loginText, hash(passText));
                } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        menu.setOnAction(event -> openNewScene("main.fxml"));
        registration.setOnAction(event -> openNewScene("registration.fxml"));
    }

    private void loginUser(String loginText, String passText) throws SQLException, ClassNotFoundException {
        switch (getRole(loginText, passText)) {
            case "user" -> {
                openNewScene("menu-delivery.fxml");
                Food.total_summa = 0;
            }
            case "worker" -> openNewScene("menu-delivery-worker.fxml");
            case "admin" -> openNewScene("menu-accounts.fxml");
        }
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