package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DatabazaController {

    @FXML
    private Button OrderButton;

    @FXML
    private Button AddButton;

    @FXML
    private Button ChangeButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private TableView<?> TableViewFile;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> markColumn;

    @FXML private TableColumn<?, ?> modelColumn;

    @FXML private TableColumn<?, ?> tonnageColumn;

    @FXML private TableColumn<?, ?> driverColumn;

    @FXML private TableColumn<?, ?> workskillsColumn;

    @FXML private TableColumn<?, ?> priceColumn;



    @FXML
    void initialize() {
        OrderButton.setOnAction(event -> {

        });

        AddButton.setOnAction(event -> {

        });

        ChangeButton.setOnAction(event -> {

        });

        DeleteButton.setOnAction(event -> {

        });
    }



}
