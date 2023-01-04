package com.example.food_delivery;

import com.example.food_delivery.DataBase.DatabaseHandler;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import static com.example.food_delivery.DataBase.DatabaseHandler.Change;
import static com.example.food_delivery.DataBase.DatabaseHandler.Delete;

public class controller_menu_accounts {


    @FXML
    ObservableList<User> inform;

    @FXML
    private Button change_role_to_user;
    @FXML
    private Button change_role_to_worker;
    @FXML
    private TableColumn<User, String> column_id;
    @FXML
    private TableColumn<User, String> column_login;
    @FXML
    private TableColumn<User, String> column_name;
    @FXML
    private TableColumn<User, String> column_password;
    @FXML
    private TableColumn<User, String> column_role;
    @FXML
    private Button delete_id;
    @FXML
    private TextField enter_id;
    @FXML
    private TextField enter_login;
    @FXML
    private Button menu;
    @FXML
    private TableView<User> table;

    public void UpdateTable() throws SQLException, ClassNotFoundException {
        column_id.setCellValueFactory(new PropertyValueFactory<>("iduser"));
        column_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        column_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        inform = DatabaseHandler.getDataUser();
        table.setItems(inform);
    }


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        UpdateTable();
        menu.setOnAction(event -> openNewScene("main.fxml"));
        delete_id.setOnAction(event -> {
            try {
                Delete(enter_id.getText().trim());
                UpdateTable();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        change_role_to_user.setOnAction(actionEvent -> {
            try {
                Change(false, enter_login.getText().trim());
                UpdateTable();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        change_role_to_worker.setOnAction(actionEvent -> {
            try {
                Change(true, enter_login.getText().trim());
                UpdateTable();
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
