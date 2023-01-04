package com.example.food_delivery;

import com.example.food_delivery.DataBase.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import static com.example.food_delivery.Hash.hash;

public class controller_registration {


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
    private Button registration;

    @FXML
    void initialize() {
        registration.setOnAction(event -> {
            if (enter_password.getText().trim().equals(enter_password_again.getText().trim())) {
                if (!enter_login.getText().trim().equals("") && !enter_password.getText().trim().equals("") &&
                        !enter_password_again.getText().trim().equals("") && !enter_name.getText().trim().equals("")) {
                    try {
                        if (!DatabaseHandler.getUserLogin(enter_login.getText())) {
                            signUpNewUser();
                            invisible.setText("Регистрация прошла успешно");
                            openNewScene("authorisation.fxml");
                        } else
                            invisible.setText("Такой логин уже существует!");
                    } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }

                } else invisible.setText("Одно или нексолько полей не заполнены");
            } else
                invisible.setText("Проверьте верность введённых данных!");
        });
        menu.setOnAction(event -> openNewScene("main.fxml"));
        authorisation.setOnAction(event -> openNewScene("authorisation.fxml"));
    }


    private void signUpNewUser() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String login = enter_login.getText();
        String password = hash(enter_password.getText());
        String name = enter_name.getText();
        User user = new User(login, password, name, "user");
        dbHandler.signUpMaster(user);

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
