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

public class RegistController {


    @FXML
    private TextField FirstnameTextField;

    @FXML
    private TextField LastnameTextField;

    @FXML
    private TextField UsernameTextField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField EmailTextField;

    @FXML
    private TextField AddressTextField;

    @FXML
    private Button RegistrationButton;

    @FXML
    private Button CloseButton;

    @FXML
    private Label RegistrationMessageLabel;


    @FXML
    void initialize() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        RegistrationButton.setOnAction(event -> {
            String registText = UsernameTextField.getText().trim();
            String registPass = PasswordField.getText().trim();
            String registName = FirstnameTextField.getText().trim();
            String registName2 = LastnameTextField.getText().trim();
            String registEmail = EmailTextField.getText().trim();
            String registAddress = AddressTextField.getText().trim();

            if (registName.isBlank()) {
                RegistrationMessageLabel.setText("Please enter your firstname");
            }
            else if (registName2.isBlank()) {
                RegistrationMessageLabel.setText("Please enter your lastname");
            }
            else if (registText.isBlank()) {
                RegistrationMessageLabel.setText("Please enter your username");
            }
            else if (registAddress.isBlank()) {
                RegistrationMessageLabel.setText("Please enter your address");
            }
            else if (registPass.isBlank()) {
                RegistrationMessageLabel.setText("PLease enter your password");
            }
            else if (registEmail.isBlank()) {
                RegistrationMessageLabel.setText("Please enter your email");

            } else {

                singUpNewUser();
                RegistrationButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/fxmlField/sample.fxml"));

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

        });
        CloseButton.setOnAction(event -> {
            CloseButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlField/sample.fxml"));
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

    private void singUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        String password = PasswordField.getText();
        String username = UsernameTextField.getText();
        String address = AddressTextField.getText();
        String email = EmailTextField.getText();
        String firstname = FirstnameTextField.getText();
        String lastname = LastnameTextField.getText();

        User user = new User(password, username, address, email, firstname, lastname);
        dbHandler.signUpUser(user);


    }
}
