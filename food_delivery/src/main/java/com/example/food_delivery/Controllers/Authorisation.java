package com.example.food_delivery.Controllers;

import com.example.food_delivery.Classes.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import static com.example.food_delivery.DataBase.DatabaseHandler.getRole;
import static com.example.food_delivery.Hash.hash;
import static com.example.food_delivery.newWindow.openNewScene;

public class Authorisation {

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
    void buttonAuthorisation(ActionEvent event) throws NoSuchAlgorithmException, SQLException, ClassNotFoundException {
        String loginText = enter_login.getText().trim();
        String passText = enter_password.getText().trim();
        if (!loginText.equals("") && !passText.equals("")) loginUser(loginText, hash(passText));
    }

    @FXML
    void HandleRegistration(ActionEvent event) {
        registration.getScene().getWindow().hide();
        openNewScene("Registration.fxml", "Регистрация");
    }

    @FXML
    void buttonMenu(ActionEvent event) {
        menu.getScene().getWindow().hide();
        openNewScene("Start.fxml", "Доставка еды");
    }


    private void loginUser(String loginText, String passText) throws SQLException, ClassNotFoundException {
        switch (getRole(loginText, passText)) {
            case "user" -> {
                authorisation.getScene().getWindow().hide();
                openNewScene("NewRequest.fxml", "Выбор категории");
                Food.total_summa = 0;
            }
            case "worker" -> {
                authorisation.getScene().getWindow().hide();
                openNewScene("RequestsInfo.fxml", "База данных заказов");
            }
            case "admin" -> {
                authorisation.getScene().getWindow().hide();
                openNewScene("AccountsInfo.fxml", "База данных аккаунтов");
            }
        }
    }
}