package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.model.Car;
import sample.model.Driver;

import java.sql.Connection;

public class DatabController {

    @FXML
    private Button OrderButton;

    @FXML
    private Button AddButton;

    @FXML
    private Button ChangeButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button openUsersButton;

    @FXML
    private TableView<Car> TableViewFile;

    @FXML
    private TableColumn<Car, Integer> idColumn;

    @FXML
    private TableColumn<Car, String> markColumn;

    @FXML
    private TableColumn<Car, String> modelColumn;

    @FXML
    private TableColumn<Car, String> tonnageColumn;

    @FXML
    private TableColumn<Driver, String> driverColumn;

    @FXML
    private TableColumn<Driver, Integer> workskillsColumn;

    @FXML
    private TableColumn<Car, Integer> priceColumn;

    Connection dbconnection;


    @FXML
    void initialize() {
        DBConnec



    }

}

