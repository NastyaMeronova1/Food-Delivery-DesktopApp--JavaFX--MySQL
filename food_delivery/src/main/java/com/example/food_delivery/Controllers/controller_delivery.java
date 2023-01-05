package com.example.food_delivery.Controllers;

import com.example.food_delivery.Classes.Delivery;
import com.example.food_delivery.Classes.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import static com.example.food_delivery.DataBase.DatabaseHandler.getRequestId;
import static com.example.food_delivery.DataBase.DatabaseHandler.signUpRequest;
import static com.example.food_delivery.new_window.openNewScene;

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
    void first_dish(ActionEvent event) {
        Food.summa_1 = 0;
        Food.online = 1;
        Food.desc_1 = "Супы:";
        dish_1.getScene().getWindow().hide();
        openNewScene("food_dynamic.fxml", "Супы");
    }

    @FXML
    void fourth_dish(ActionEvent event) {
        Food.summa_4 = 0;
        Food.online = 4;
        Food.desc_4 = "\nНапитки:";
        dish_4.getScene().getWindow().hide();
        openNewScene("food_dynamic.fxml", "Напитки");
    }

    @FXML
    void second_dish(ActionEvent event) {
        Food.summa_2 = 0;
        Food.online = 2;
        Food.desc_2 = "\nВторые блюда:";
        dish_2.getScene().getWindow().hide();
        openNewScene("food_dynamic.fxml", "Вторые блюда");
    }

    @FXML
    void third_dish(ActionEvent event) {
        Food.summa_3 = 0;
        Food.online = 3;
        Food.desc_3 = "\nДесерты:";
        dish_3.getScene().getWindow().hide();
        openNewScene("food_dynamic.fxml", "Десерты");
    }

    @FXML
    void initialize() {
        Food.total_summa = Food.summa_1 + Food.summa_2 + Food.summa_3 + Food.summa_4;
        description.setText(Food.desc_1 + Food.desc_2 + Food.desc_3 + Food.desc_4);
        summ.setText(Food.total_summa + ",00 Br");
    }

    @FXML
    void make_order(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (!enter_name.getText().equals("") && !enter_telephone_number.getText().equals("")) {
            signUpNewReqest();
            Food.total_summa = 0;
            Food.summa_1 = 0;
            Food.summa_2 = 0;
            Food.summa_3 = 0;
            Food.summa_4 = 0;
            Food.desc_1 = "";
            Food.desc_2 = "";
            Food.desc_3 = "";
            Food.desc_4 = "";
            enter_name.setText("");
            enter_telephone_number.setText("");
            description.setText("");
            summ.setText("Сумма заказа: 00.00 Br");
            openNewScene("info.fxml", "Номер вашего заказа");
        }
    }

    @FXML
    void back(ActionEvent event) {
        menu.getScene().getWindow().hide();
        openNewScene("main.fxml", "Доставка еды");
        Food.total_summa = 0;
        Food.summa_1 = 0;
        Food.summa_2 = 0;
        Food.summa_3 = 0;
        Food.summa_4 = 0;
        Food.desc_1 = "";
        Food.desc_2 = "";
        Food.desc_3 = "";
        Food.desc_4 = "";
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
}
