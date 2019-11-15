package gui.controller;

import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class HomeController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField modelInput;

    @FXML
    private CheckBox pccomponentes;

    @FXML
    private CheckBox fnac;

    @FXML
    private CheckBox amazon;

    @FXML
    private ComboBox<?> selectBrand;

    @FXML
    void initialize() {

    }
}
