package com.example.food_delivery.Controllers;


import com.example.food_delivery.Classes.Food;
import com.example.food_delivery.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static com.example.food_delivery.DataBase.DatabaseHandler.getDbConnection;
import static com.example.food_delivery.newWindow.openNewScene;

public class UserMenu {

    @FXML
    private RadioButton dish_1_1;

    @FXML
    private RadioButton dish_1_2;

    @FXML
    private RadioButton dish_1_3;

    @FXML
    private RadioButton dish_2_1;

    @FXML
    private RadioButton dish_2_2;

    @FXML
    private RadioButton dish_2_3;

    @FXML
    private RadioButton dish_3_1;

    @FXML
    private RadioButton dish_3_2;

    @FXML
    private RadioButton dish_3_3;

    @FXML
    private RadioButton dish_4_1;

    @FXML
    private RadioButton dish_4_2;

    @FXML
    private RadioButton dish_4_3;

    @FXML
    private RadioButton dish_5_1;

    @FXML
    private RadioButton dish_5_2;

    @FXML
    private RadioButton dish_5_3;

    @FXML
    private RadioButton dish_6_1;

    @FXML
    private RadioButton dish_6_2;

    @FXML
    private RadioButton dish_6_3;

    @FXML
    private ImageView image_1;

    @FXML
    private ImageView image_2;

    @FXML
    private ImageView image_3;

    @FXML
    private ImageView image_4;

    @FXML
    private ImageView image_5;

    @FXML
    private ImageView image_6;

    @FXML
    private Button menu;

    @FXML
    private Label title;

    @FXML
    private Label name_1;

    @FXML
    private Label name_2;

    @FXML
    private Label name_3;

    @FXML
    private Label name_4;

    @FXML
    private Label name_5;

    @FXML
    private Label name_6;

    @FXML
    private Label price_1;

    @FXML
    private Label price_2;

    @FXML
    private Label price_3;

    @FXML
    private Label price_4;

    @FXML
    private Label price_5;

    @FXML
    private Label price_6;

    @FXML
    void buttonMenu(ActionEvent event) {
        menu.getScene().getWindow().hide();
        openNewScene("NewRequest.fxml", "Выбор категории");
    }

    @FXML
    void makeOrder(ActionEvent event) {
        double price1 = Double.parseDouble(price_1.getText()), price2 = Double.parseDouble(price_2.getText()), price3 = Double.parseDouble(price_3.getText()), price4 = Double.parseDouble(price_4.getText()), price5 = Double.parseDouble(price_5.getText()), price6 = Double.parseDouble(price_6.getText());

        String desc = "";
        int summa = 0;

        if (dish_1_1.isSelected()) {
            summa += price1;
            desc += "\n" + name_1.getText() + " - 1шт. по " + price_1.getText() + " Br";
        } else if (dish_1_2.isSelected()) {
            summa += 2 * price1;
            desc += "\n" + name_1.getText() + " - 2шт. по " + price_1.getText() + " Br";
        } else if (dish_1_3.isSelected()) {
            summa += 3 * price1;
            desc += "\n" + name_1.getText() + " - 3шт. по " + price_1.getText() + " Br";
        }

        if (dish_2_1.isSelected()) {
            summa += price2;
            desc += "\n" + name_2.getText() + " - 1шт. по " + price_2.getText() + " Br";
        } else if (dish_2_2.isSelected()) {
            summa += 2 * price2;
            desc += "\n" + name_2.getText() + " - 2шт. по " + price_2.getText() + " Br";
        } else if (dish_2_3.isSelected()) {
            summa += 3 * price2;
            desc += "\n" + name_2.getText() + " - 3шт. по " + price_2.getText() + " Br";
        }
        if (dish_3_1.isSelected()) {
            summa += price3;
            desc += "\n" + name_3.getText() + " - 1шт. по " + price_3.getText() + " Br";
        } else if (dish_3_2.isSelected()) {
            summa += 2 * price3;
            desc += "\n" + name_3.getText() + " - 2шт. по " + price_3.getText() + " Br";
        } else if (dish_3_3.isSelected()) {
            summa += 3 * price3;
            desc += "\n" + name_3.getText() + " - 3шт. по " + price_3.getText() + " Br";
        }

        if (dish_4_1.isSelected()) {
            summa += price4;
            desc += "\n" + name_4.getText() + " - 1шт. по " + price_4.getText() + " Br";
        } else if (dish_4_2.isSelected()) {
            summa += 2 * price4;
            desc += "\n" + name_4.getText() + " - 2шт. по " + price_4.getText() + " Br";
        } else if (dish_4_3.isSelected()) {
            summa += 3 * price4;
            desc += "\n" + name_4.getText() + " - 3шт. по " + price_4.getText() + " Br";
        }
        if (dish_5_1.isSelected()) {
            summa += price5;
            desc += "\n" + name_5.getText() + " - 1шт. по " + price_5.getText() + " Br";
        } else if (dish_5_2.isSelected()) {
            summa += 2 * price5;
            desc += "\n" + name_5.getText() + " - 2шт. по " + price_5.getText() + " Br";
        } else if (dish_5_3.isSelected()) {
            summa += 3 * price5;
            desc += "\n" + name_5.getText() + " - 3шт. по " + price_5.getText() + " Br";
        }
        if (dish_6_1.isSelected()) {
            summa += price6;
            desc += "\n" + name_6.getText() + " - 1шт. по " + price_6.getText() + " Br";
        } else if (dish_6_2.isSelected()) {
            summa += 2 * price6;
            desc += "\n" + name_6.getText() + " - 2шт. по " + price_6.getText() + " Br";
        } else if (dish_6_3.isSelected()) {
            summa += 3 * price6;
            desc += "\n" + name_6.getText() + " - 3шт. по " + price_6.getText() + " Br";
        }

        if (Food.online == 1) {
            Food.desc_1 = "\n\n" + title.getText() + ":" + desc;
            Food.summa_1 = summa;
        } else if (Food.online == 2) {
            Food.desc_2 = "\n\n" + title.getText() + ":" + desc;
            Food.summa_2 = summa;
        } else if (Food.online == 3) {
            Food.desc_3 = "\n\n" + title.getText() + ":" + desc;
            Food.summa_3 = summa;
        } else if (Food.online == 4) {
            Food.desc_4 = "\n\n" + title.getText() + ":" + desc;
            Food.summa_4 = summa;
        }
        menu.getScene().getWindow().hide();
        openNewScene("NewRequest.fxml", "Выбор категории");
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        reloadMenu();
        ToggleGroup a = new ToggleGroup();
        dish_1_1.setToggleGroup(a);
        dish_1_2.setToggleGroup(a);
        dish_1_3.setToggleGroup(a);
        ToggleGroup b = new ToggleGroup();
        dish_2_1.setToggleGroup(b);
        dish_2_2.setToggleGroup(b);
        dish_2_3.setToggleGroup(b);
        ToggleGroup c = new ToggleGroup();
        dish_3_1.setToggleGroup(c);
        dish_3_2.setToggleGroup(c);
        dish_3_3.setToggleGroup(c);
        ToggleGroup d = new ToggleGroup();
        dish_4_1.setToggleGroup(d);
        dish_4_2.setToggleGroup(d);
        dish_4_3.setToggleGroup(d);
        ToggleGroup e = new ToggleGroup();
        dish_5_1.setToggleGroup(e);
        dish_5_2.setToggleGroup(e);
        dish_5_3.setToggleGroup(e);
        ToggleGroup f = new ToggleGroup();
        dish_6_1.setToggleGroup(f);
        dish_6_2.setToggleGroup(f);
        dish_6_3.setToggleGroup(f);
    }

    public void reloadMenu() throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getDbConnection().prepareStatement("SELECT * FROM dish WHERE iddish = '" + Food.online + "'");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            title.setText(rs.getString("title"));
            name_1.setText(rs.getString("name_1"));
            name_2.setText(rs.getString("name_2"));
            name_3.setText(rs.getString("name_3"));
            name_4.setText(rs.getString("name_4"));
            name_5.setText(rs.getString("name_5"));
            name_6.setText(rs.getString("name_6"));
            price_1.setText(rs.getString("price_1") + ".00");
            price_2.setText(rs.getString("price_2") + ".00");
            price_3.setText(rs.getString("price_3") + ".00");
            price_4.setText(rs.getString("price_4") + ".00");
            price_5.setText(rs.getString("price_6") + ".00");
            price_6.setText(rs.getString("price_6") + ".00");
            image_1.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream(rs.getString("image_1")))));
            image_2.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream(rs.getString("image_2")))));
            image_3.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream(rs.getString("image_3")))));
            image_4.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream(rs.getString("image_4")))));
            image_5.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream(rs.getString("image_5")))));
            image_6.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream(rs.getString("image_6")))));
        }
    }
}

