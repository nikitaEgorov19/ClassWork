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
import sample.connect.connectionRegistration;

import java.io.IOException;

public class RegistrationController {

    connectionRegistration connectionRegistration = new connectionRegistration();


    @FXML
    private TextField FirstnameTextField;

    @FXML
    private TextField LastnameTextField;

    @FXML
    private TextField UsernameTextField;

    @FXML
    private TextField AddressTextField;

    @FXML
    private TextField EmailTextField;

    @FXML
    private Button RegistrationButton, CloseButton;

    @FXML
    private PasswordField setPasswordField;

    @FXML
    private Label RegistrationMessageLabel;


    public RegistrationController() {
    }

    @FXML
    void initialize() {
        RegistrationButton.setOnAction(event ->  {
                if (FirstnameTextField.getText().isEmpty()) {
                    RegistrationMessageLabel.setText("Please enter your firstname");
                }
                else if (LastnameTextField.getText().isEmpty()) {
                    RegistrationMessageLabel.setText("Please enter your lastname");
                }
                else if (UsernameTextField.getText().isEmpty()) {
                    RegistrationMessageLabel.setText("Please enter your username");
                }
                else if (AddressTextField.getText().isEmpty()) {
                    RegistrationMessageLabel.setText("Please enter your address");
                }
                else if (setPasswordField.getText().isEmpty()) {
                    RegistrationMessageLabel.setText("PLease enter your password");
                }
                else if (EmailTextField.getText().isEmpty()) {
                    RegistrationMessageLabel.setText("Please enter your email");

                } else



                    UsernameTextField.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/fxml/login.fxml"));


                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                    }
                );
        CloseButton.setOnAction(event -> {
            Stage stage = (Stage) CloseButton.getScene().getWindow();
            stage.close();
        });
        };}


