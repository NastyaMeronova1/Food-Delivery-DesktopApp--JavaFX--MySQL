package com.example.food_delivery.Controllers;

import com.example.food_delivery.Classes.Delivery;
import com.example.food_delivery.Classes.Food;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import static com.example.food_delivery.DataBase.DatabaseHandler.getRequestId;
import static com.example.food_delivery.DataBase.DatabaseHandler.signUpRequest;
import static com.example.food_delivery.newWindow.openNewScene;

public class NewRequest {


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
    void firstDish() {
        Food.summa_1 = 0;
        Food.online = 1;
        Food.desc_1 = "Супы:";
        dish_1.getScene().getWindow().hide();
        openNewScene("FoodCategory.fxml", "Супы");
    }


    @FXML
    void secondDish() {
        Food.summa_2 = 0;
        Food.online = 2;
        Food.desc_2 = "\nВторые блюда:";
        dish_2.getScene().getWindow().hide();
        openNewScene("FoodCategory.fxml", "Вторые блюда");
    }

    @FXML
    void thirdDish() {
        Food.summa_3 = 0;
        Food.online = 3;
        Food.desc_3 = "\nДесерты:";
        dish_3.getScene().getWindow().hide();
        openNewScene("FoodCategory.fxml", "Десерты");
    }


    @FXML
    void fourthDish() {
        Food.summa_4 = 0;
        Food.online = 4;
        Food.desc_4 = "\nНапитки:";
        dish_4.getScene().getWindow().hide();
        openNewScene("FoodCategory.fxml", "Напитки");
    }

    @FXML
    void initialize() {
        Food.total_summa = Food.summa_1 + Food.summa_2 + Food.summa_3 + Food.summa_4;
        description.setText(Food.desc_1 + Food.desc_2 + Food.desc_3 + Food.desc_4);
        summ.setText(Food.total_summa + ",00 Br");
    }

    @FXML
    void makeOrder() throws SQLException, ClassNotFoundException {
        if (enter_name.getText().length() >= 4 && !enter_telephone_number.getText().equals("") && Food.total_summa != 0) {
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
            openNewScene("NewRequestId.fxml", "Номер вашего заказа");
        }
    }

    @FXML
    void buttonMenu() {
        menu.getScene().getWindow().hide();
        openNewScene("Start.fxml", "Доставка еды");
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
