package com.example.food_delivery.Controllers;

import com.example.food_delivery.Classes.User;
import com.example.food_delivery.DataBase.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import static com.example.food_delivery.Hash.hash;
import static com.example.food_delivery.newWindow.openNewScene;

public class Registration {


    @FXML
    private Button authorisation;

    @FXML
    private TextField enter_login;

    @FXML
    private TextField enter_name;

    @FXML
    private PasswordField enter_password;

    @FXML
    private PasswordField enter_password_again;

    @FXML
    private Label invisible;

    @FXML
    private Button menu;

    @FXML
    void buttonAuthorisation(ActionEvent event) {
        authorisation.getScene().getWindow().hide();
        openNewScene("Authorisation.fxml", "Авторизация");
    }

    @FXML
    void buttonMenu(ActionEvent event) {
        menu.getScene().getWindow().hide();
        openNewScene("Start.fxml", "Доставка еды");
    }

    @FXML
    void buttonRegistration(ActionEvent event) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
        if (enter_password.getText().trim().equals(enter_password_again.getText().trim())) {
            if (!enter_login.getText().trim().equals("") && !enter_password.getText().trim().equals("") &&
                    !enter_password_again.getText().trim().equals("") && !enter_name.getText().trim().equals("")) {
                if (!DatabaseHandler.getUserLogin(enter_login.getText())) {
                    signUpNewUser();
                    invisible.setText("Регистрация прошла успешно");
                    authorisation.getScene().getWindow().hide();
                    openNewScene("Authorisation.fxml", "Авторизация");
                } else
                    invisible.setText("Такой логин уже существует!");
            } else invisible.setText("Одно или нексолько полей не заполнены");
        } else
            invisible.setText("Проверьте верность введённых данных!");
    }

    private void signUpNewUser() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String login = enter_login.getText();
        String password = hash(enter_password.getText());
        String name = enter_name.getText();
        User user = new User(login, password, name, "user");
        dbHandler.signUpMaster(user);
    }
}
