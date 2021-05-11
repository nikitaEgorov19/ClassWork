package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DataBaseHandler;
import sample.model.User;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    @FXML
    private Button RegistrButton;

    @FXML
    private TextField UsernameTextField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button LoginButton;

    @FXML
    private Label LoginMessageLabel;

    @FXML
    private Button AboutButton;

    @FXML
    void initialize() {
        LoginButton.setOnAction(event -> {
            String loginText = UsernameTextField.getText().trim();
            String loginPass = PasswordField.getText().trim();

            if (loginText.isBlank()&&loginPass.isBlank()) {
                LoginMessageLabel.setText("username and password invalid");
            }else if (loginText.isBlank()) {
                LoginMessageLabel.setText("username invalid");
            }else if (loginPass.isBlank()) {
                LoginMessageLabel.setText("password invalid");
            }else {
                if (!loginText.isBlank() && !loginPass.isBlank()) {
                    loginUser(loginText, loginPass);
                }
            }
        });

        RegistrButton.setOnAction(event -> {
            LoginButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlField/registration.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        });
        AboutButton.setOnAction(event -> {
            UsernameTextField.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlField/creator.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });


    }
    private void loginUser(String loginText, String loginPass) {
        DataBaseHandler dbHandler = new DataBaseHandler();
        User user = new User();
        user.setUsername(loginText);
        user.setPassword(loginPass);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        try {
            while (result.next()) {
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (counter >= 1) {
            LoginButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlField/databaza.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            LoginMessageLabel.setText("user doesn't exist");
        }
    }
}

