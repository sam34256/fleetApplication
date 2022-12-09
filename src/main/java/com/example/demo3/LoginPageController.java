package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginPageController {


    public Scene scene;

    @FXML
    private TextField  userName;
    @FXML
    private PasswordField  passwordField;

    @FXML
    private Label passwordShow;
    @FXML
    public void validateLogin(ActionEvent event ) throws SQLException, IOException {
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();
        String query = "select count(1), accessGroup from  login_info where     username = ? and password = ? ";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,userName.getText());
        statement.setString(2,passwordField.getText());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println();
            System.out.println(resultSet.getString(2));
            if (resultSet.getInt(1) == 1 && resultSet.getString(2).equalsIgnoreCase("employee")) {
                System.out.println("correct");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDash.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(true);
                stage.centerOnScreen();
                stage.show();
            } else if (resultSet.getInt(1) == 1 && resultSet.getString(2).equalsIgnoreCase("insurncep")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("insurance.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setResizable(true);
                    stage.centerOnScreen();
                    stage.show();
            } else if (resultSet.getInt(1) == 1 && resultSet.getString(2).equalsIgnoreCase("driver")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("driverPage.fxml"));
                Parent root2 = loader.load();
                Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root2);
                stage2.setScene(scene);
                stage2.setResizable(true);
                stage2.centerOnScreen();
                stage2.show();
            }
            else {
                passwordShow.setText("Wrong user name and password combination!");
            }
        }

   }

}
