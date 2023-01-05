package com.example.food_delivery.Controllers;

import com.example.food_delivery.Classes.User;
import com.example.food_delivery.DataBase.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

import static com.example.food_delivery.DataBase.DatabaseHandler.Change;
import static com.example.food_delivery.DataBase.DatabaseHandler.Delete;
import static com.example.food_delivery.new_window.openNewScene;

public class controller_menu_accounts {


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
    private TextField enter_id;
    @FXML
    private TextField enter_login;
    @FXML
    private Button menu;
    @FXML
    private TableView<User> table;

    @FXML
    void change_to_user(ActionEvent event) throws SQLException, ClassNotFoundException {
        Change(false, enter_login.getText().trim());
        UpdateTable();
    }

    @FXML
    void change_to_worker(ActionEvent event) throws SQLException, ClassNotFoundException {

        Change(true, enter_login.getText().trim());
        UpdateTable();

    }

    @FXML
    void del(ActionEvent event) throws SQLException, ClassNotFoundException {
        Delete(enter_id.getText().trim());
        UpdateTable();
    }

    @FXML
    void back(ActionEvent event) {
        menu.getScene().getWindow().hide();
        openNewScene("main.fxml", "Доставка еды");
    }

    public void UpdateTable() throws SQLException, ClassNotFoundException {
        column_id.setCellValueFactory(new PropertyValueFactory<>("iduser"));
        column_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        column_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        table.setItems(DatabaseHandler.getDataUser());
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        UpdateTable();
    }
}
