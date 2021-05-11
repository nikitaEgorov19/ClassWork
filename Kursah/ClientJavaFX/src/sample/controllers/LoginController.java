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
import org.json.JSONException;
import sample.connect.connectionLogin;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField UsernameTextField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button RegistrButton, LoginButton;

    @FXML
    private Label LoginMessageLabel;

    connectionLogin connectionLogin = new connectionLogin();





    @FXML
    void initialize() {
        RegistrButton.setOnAction(event -> {
                UsernameTextField.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/fxml/registration.fxml"));

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

        LoginButton.setOnAction(event -> {
            if ( UsernameTextField.getText().isBlank() && PasswordField.getText().isBlank()){
                LoginMessageLabel.setText("Please enter username and password");

            } else if (UsernameTextField.getText().isBlank()){
                LoginMessageLabel.setText("Please enter username");

            } else if (PasswordField.getText().isBlank()){
                LoginMessageLabel.setText("Please enter password");

            } else {
                try {
                    if (!connectionLogin.get(UsernameTextField.getText(), PasswordField.getText())) {
                        LoginMessageLabel.setText("username or password invalid");
                    } else {
                        UsernameTextField.getScene().getWindow().hide();

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/sample/fxml/databaza.fxml"));


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
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            ;
    });

}}