package com.example.food_delivery;

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
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.food_delivery.DataBase.DatabaseHandler.getRequestId;
import static com.example.food_delivery.DataBase.DatabaseHandler.signUpRequest;

public class controller_delivery {


    @FXML
    private Button dish_1;

    @FXML
    private Button dish_2;

    @FXML
    private Button dish_3;

    @FXML
    private Button dish_4;

    @FXML
    private Button do_order;

    @FXML
    private Button menu;
    @FXML
    private Label description;

    @FXML
    private TextField enter_name;

    @FXML
    private TextField enter_telephone_number;

    @FXML
    private Label summ;

    @FXML
    void initialize() {
        Food.total_summa = Food.summa_1 + Food.summa_2 + Food.summa_3 + Food.summa_4;
        description.setText(Food.desc_1 + Food.desc_2 + Food.desc_3 + Food.desc_4);
        summ.setText(Food.total_summa + ",00 Br");
        do_order.setOnAction(event -> {
            if (!enter_name.getText().equals("") && !enter_telephone_number.getText().equals("")) {
                try {
                    signUpNewReqest();
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Food.total_summa = 0;
                Food.summa_1 = 0;
                Food.summa_2 = 0;
                Food.summa_3 = 0;
                Food.summa_4 = 0;
                Food.desc_1 = "";
                Food.desc_2 = "";
                Food.desc_3 = "";
                Food.desc_4 = "";
                new_window();
                enter_name.setText("");
                enter_telephone_number.setText("");
                description.setText("");
                summ.setText("Сумма заказа: 00.00 Br");
            }
        });
        dish_1.setOnAction(event -> {
            Food.summa_1 = 0;
            Food.online = 1;
            Food.desc_1 = "Супы:";
            openNewScene("food_dynamic.fxml");
        });
        dish_2.setOnAction(event -> {
            Food.summa_2 = 0;
            Food.online = 2;
            Food.desc_2 = "\nВторые блюда:";
            openNewScene("food_dynamic.fxml");
        });
        dish_3.setOnAction(event -> {
            Food.summa_3 = 0;
            Food.online = 3;
            Food.desc_3 = "\nДесерты:";
            openNewScene("food_dynamic.fxml");
        });
        dish_4.setOnAction(event -> {
            Food.summa_4 = 0;
            Food.online = 4;
            Food.desc_4 = "\nНапитки:";
            openNewScene("food_dynamic.fxml");
        });
        menu.setOnAction(event -> {
            openNewScene("main.fxml");
            Food.total_summa = 0;
            Food.summa_1 = 0;
            Food.summa_2 = 0;
            Food.summa_3 = 0;
            Food.summa_4 = 0;
            Food.desc_1 = "";
            Food.desc_2 = "";
            Food.desc_3 = "";
            Food.desc_4 = "";
        });
    }

    private void signUpNewReqest() throws SQLException, ClassNotFoundException {
        String name = enter_name.getText();
        String telephone = enter_telephone_number.getText();
        String price = summ.getText();
        String desc = Food.desc_1 + Food.desc_2 + Food.desc_3 + Food.desc_4;
        Delivery delivery = new Delivery(name, telephone, price, desc, "Принят");
        signUpRequest(delivery);
        getRequestId(delivery);
    }

    private void new_window() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("info.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("№ Заявки");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
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
