package com.example.food_delivery.DataBase;

import com.example.food_delivery.Delivery;
import com.example.food_delivery.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class DatabaseHandler {

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery", "root", "root");
    }

    public static void signUpRequest(Delivery delivery) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO request(name, telephone_number, description, summ, status) " + "VALUES(?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, delivery.getName());
        prSt.setString(2, delivery.getTelephone_number());
        prSt.setString(3, delivery.getDescription());
        prSt.setString(4, delivery.getSumm());
        prSt.setString(5, delivery.getStatus());
        prSt.executeUpdate();
    }

    public static ObservableList<User> getDataUser() throws SQLException, ClassNotFoundException {
        ObservableList<User> list = FXCollections.observableArrayList();
        PreparedStatement ps = getDbConnection().prepareStatement("SELECT * FROM user");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new User(rs.getString("iduser"), rs.getString("login"), rs.getString("password"), rs.getString("name"), rs.getString("role")));
        }
        return list;
    }

    public static ObservableList<Delivery> getDataRequest() throws SQLException, ClassNotFoundException {
        ObservableList<Delivery> list = FXCollections.observableArrayList();
        PreparedStatement ps = getDbConnection().prepareStatement("SELECT * FROM request WHERE status = 'Принят'");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new Delivery(rs.getString("idrequest"), rs.getString("name"), rs.getString("telephone_number"), rs.getString("description"), rs.getString("summ"), rs.getString("status")));
        }
        return list;
    }

    public static ObservableList<Delivery> getDataRequest_2() throws SQLException, ClassNotFoundException {
        ObservableList<Delivery> list = FXCollections.observableArrayList();
        PreparedStatement ps = getDbConnection().prepareStatement("SELECT * FROM request WHERE status = 'Выполнен'");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new Delivery(rs.getString("idrequest"), rs.getString("name"), rs.getString("telephone_number"), rs.getString("description"), rs.getString("summ"), rs.getString("status")));
        }
        return list;
    }


    public static void getRequestId(Delivery delivery) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getDbConnection().prepareStatement("SELECT idrequest FROM request WHERE name = '" + delivery.getName() + "' AND telephone_number = '" + delivery.getTelephone_number() + "'");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Delivery.this_id = rs.getString("idrequest");
        }
    }

    public static void Delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM user WHERE iduser = '" + id + "' AND role != 'admin'";
        PreparedStatement pst = getDbConnection().prepareStatement(sql);
        pst.execute();
    }

    public static void Change(boolean flag, String login) throws SQLException, ClassNotFoundException {
        String sql;
        if (flag) sql = "UPDATE user SET role = 'worker' WHERE login = '" + login + "' AND role !='admin'";
        else sql = "UPDATE user SET role = 'user' WHERE login = '" + login + "' AND role !='admin'";
        PreparedStatement pst = getDbConnection().prepareStatement(sql);
        pst.execute();
    }

    public static boolean getUserLogin(String login) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM user WHERE login='" + login + "'";

        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        ResultSet resSet = prSt.executeQuery();
        int counter = 0;
        while (true) {
            try {
                if (!resSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }
        if (counter >= 1) {
            System.out.println("Такой уже логин существует");
            return true;
        } else return false;
    }

    public static void getRequestInfo(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getDbConnection().prepareStatement("SELECT * FROM request WHERE idrequest = " + id);
        ResultSet rs = ps.executeQuery();
        Delivery.this_name = "";
        Delivery.this_summ = "";
        Delivery.this_status = "";
        while (rs.next()) {
            Delivery.this_name = rs.getString("name");
            Delivery.this_summ = rs.getString("description");
            Delivery.this_status = rs.getString("status");
        }
    }

    public static String getRole(String login, String password) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM user WHERE login='" + login + "' AND password='" + password + "'";
        String role = "";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        ResultSet resSet = prSt.executeQuery();
        while (resSet.next()) {
            role = resSet.getString("role");
        }
        return role;
    }

    public static void ChangeRequest(String id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE food_delivery.request SET status = 'Выполнен' WHERE idrequest = " + id;
        PreparedStatement pst = getDbConnection().prepareStatement(sql);
        pst.execute();
    }

    public static void DeleteAll() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM request WHERE status = 'Выполнен'";
        PreparedStatement pst = getDbConnection().prepareStatement(sql);
        pst.execute();
    }

    public void signUpMaster(User user) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO user(login, password, name, role) VALUES(?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, user.getLogin());
        prSt.setString(2, user.getPassword());
        prSt.setString(3, user.getName());
        prSt.setString(4, user.getRole());
        prSt.executeUpdate();
    }
}
