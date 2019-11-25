package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import persistence.PhoneSearch;
import persistence.Sites;
import persistence.models.PhoneModel;

public class HomeController {

    private List<String> DEFAULT_BRANDS = Arrays.asList("huawei", "xiamoi","samsung");
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
        String search = modelInput.getText().trim();
        PhoneSearch phoneSearch = new PhoneSearch();
        final List<PhoneModel> phoneModels = phoneSearch.performSearch(search, getSitesToSearch());
        phoneModels.forEach(e -> items.add(e.toString()));
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
