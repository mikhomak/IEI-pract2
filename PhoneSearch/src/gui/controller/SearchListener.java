package gui.controller;

import persistence.IPhoneSearch;
import persistence.PhoneSearch;
import persistence.Sites;
import persistence.models.PhoneModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchListener implements ActionListener {
    private IPhoneSearch phoneSearch;
    private JTextArea textArea;


    SearchListener(final JTextArea textArea) {
        this.textArea = textArea;
        phoneSearch = new PhoneSearch();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        final List<PhoneModel> phoneModels = phoneSearch.performSearch("xiamoi", Sites.FNAC);
        phoneModels.forEach(phone -> textArea.append(phone.toString()));
    }
}
