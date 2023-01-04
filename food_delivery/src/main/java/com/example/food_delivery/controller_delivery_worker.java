package com.example.food_delivery;

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

import static com.example.food_delivery.DataBase.DatabaseHandler.*;


public class controller_delivery_worker {


    @FXML
    ObservableList<Delivery> info;


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
    private Button delete_all;
    @FXML
    private TextField enter_id;
    @FXML
    private Button menu;
    @FXML
    private TableView<Delivery> table_1;
    @FXML
    private Button change;
    @FXML
    private TableView<Delivery> table_2;

    public void UpdateTables() throws SQLException, ClassNotFoundException {
        column_id.setCellValueFactory(new PropertyValueFactory<>("idrequest"));
        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_telephone_number.setCellValueFactory(new PropertyValueFactory<>("telephone_number"));
        column_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        column_summ.setCellValueFactory(new PropertyValueFactory<>("summ"));
        info = getDataRequest();
        table_1.setItems(info);

        column_id_2.setCellValueFactory(new PropertyValueFactory<>("idrequest"));
        column_name_2.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_telephone_number_1.setCellValueFactory(new PropertyValueFactory<>("telephone_number"));
        column_summ_1.setCellValueFactory(new PropertyValueFactory<>("summ"));
        info = getDataRequest_2();
        table_2.setItems(info);
    }



    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        UpdateTables();
        menu.setOnAction(event -> openNewScene("main.fxml"));
        change.setOnAction(actionEvent -> {
            try {
                ChangeRequest(enter_id.getText().trim());
                UpdateTables();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        delete_all.setOnAction(actionEvent -> {
            try {
                DeleteAll();
                UpdateTables();
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
