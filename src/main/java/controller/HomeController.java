package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import persistence.PhoneSearch;
import persistence.Sites;
import persistence.models.PhoneModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeController {

    private List<String> DEFAULT_BRANDS = Arrays.asList("Huawei", "Xiaomi","Samsung","LG","Sony","Motorola","Apple","Lenovo","OnePlus");
    ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    private TextField modelInput;

    @FXML
    private CheckBox pccomponentes;

    @FXML
    private CheckBox fnac;

    @FXML
    private CheckBox amazon;

    @FXML
    private ComboBox<String> selectBrand;

    @FXML
    private ListView<String> listItems;

    @FXML
    void initialize() {
        selectBrand.setItems(FXCollections.observableList(DEFAULT_BRANDS));
        listItems.setItems(items);
        selectBrand.getSelectionModel().select(0);
    }

    @FXML
    void onSearch(ActionEvent event) {
        listItems.getItems().clear();
        String search = selectBrand.getSelectionModel().getSelectedItem() + " " + modelInput.getText().trim();
        new Thread(() -> {
            PhoneSearch phoneSearch = new PhoneSearch();
            final List<PhoneModel> phoneModels = phoneSearch.performSearch(search, getSitesToSearch());
            Platform.runLater(() -> phoneModels.forEach(e -> items.add(e.toString())));
        }).start();
    }

    private List<Sites> getSitesToSearch() {
        final List<Sites> sites = new ArrayList<>();
        if (amazon.isSelected()) {
            sites.add(Sites.AMAZON);
        }
        if (pccomponentes.isSelected()) {
            sites.add(Sites.PCCOMPONENTS);
        }
        if (fnac.isSelected()) {
            sites.add(Sites.FNAC);
        }
        return sites;
    }
}
