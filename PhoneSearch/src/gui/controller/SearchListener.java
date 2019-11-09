package gui.controller;

import org.openqa.selenium.WebDriver;
import persistence.IPhoneSearch;
import persistence.PhoneSearch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchListener implements ActionListener {
    private IPhoneSearch phoneSearch;

    SearchListener() {
        phoneSearch = new PhoneSearch();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        phoneSearch.getTheNameOfThePhone();
    }
}
