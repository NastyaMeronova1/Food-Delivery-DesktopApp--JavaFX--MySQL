package com.example.food_delivery;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class newWindow {
    public static void openNewScene(String window, String title) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(newWindow.class.getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.getIcons().add(new Image((Objects.requireNonNull(Main.class.getResourceAsStream("image/logo.png")))));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
