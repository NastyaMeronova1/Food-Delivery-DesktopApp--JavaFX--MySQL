package com.example.food_delivery.Controllers;

import com.example.food_delivery.Classes.Delivery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

import static com.example.food_delivery.DataBase.DatabaseHandler.*;
import static com.example.food_delivery.newWindow.openNewScene;


public class RequestsInfo {

    @FXML
    private TableColumn<Delivery, String> column_description;
    @FXML
    private TableColumn<Delivery, String> column_id;
    @FXML
    private TableColumn<Delivery, String> column_id_2;
    @FXML
    private TableColumn<Delivery, String> column_name;
    @FXML
    private TableColumn<Delivery, String> column_name_2;
    @FXML
    private TableColumn<Delivery, String> column_summ;
    @FXML
    private TableColumn<Delivery, String> column_summ_1;
    @FXML
    private TableColumn<Delivery, String> column_telephone_number;
    @FXML
    private TableColumn<Delivery, String> column_telephone_number_1;
    @FXML
    private TextField enter_id;
    @FXML
    private Button menu;
    @FXML
    private TableView<Delivery> table_1;
    @FXML
    private TableView<Delivery> table_2;

    @FXML
    void changeStatus(ActionEvent event) throws SQLException, ClassNotFoundException {
        ChangeRequest(enter_id.getText().trim());
        UpdateTables();
    }

    @FXML
    void buttonMenu(ActionEvent event) {
        menu.getScene().getWindow().hide();
        openNewScene("Start.fxml", "Доставка еды");
    }

    @FXML
    void deleteSecondTable(ActionEvent event) throws SQLException, ClassNotFoundException {
        DeleteAll();
        UpdateTables();
    }

    public void UpdateTables() throws SQLException, ClassNotFoundException {
        column_id.setCellValueFactory(new PropertyValueFactory<>("idrequest"));
        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_telephone_number.setCellValueFactory(new PropertyValueFactory<>("telephone_number"));
        column_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        column_summ.setCellValueFactory(new PropertyValueFactory<>("summ"));
        table_1.setItems(getDataRequest());

        column_id_2.setCellValueFactory(new PropertyValueFactory<>("idrequest"));
        column_name_2.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_telephone_number_1.setCellValueFactory(new PropertyValueFactory<>("telephone_number"));
        column_summ_1.setCellValueFactory(new PropertyValueFactory<>("summ"));
        table_2.setItems(getDataRequest_2());
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        UpdateTables();
    }
}
