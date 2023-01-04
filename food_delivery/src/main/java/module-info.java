module com.example.food_delivery {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.food_delivery to javafx.fxml;
    exports com.example.food_delivery;
    exports com.example.food_delivery.DataBase;
    opens com.example.food_delivery.DataBase to javafx.fxml;
}