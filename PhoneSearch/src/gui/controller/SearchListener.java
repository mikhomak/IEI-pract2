package gui.controller;

import persistence.IPhoneSearch;
import persistence.PhoneSearch;
import persistence.Sites;
import persistence.models.PhoneModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SearchListener implements ActionListener {
    private IPhoneSearch phoneSearch;
    private JTextArea textArea;
    private JCheckBox amazonBox;
    private JCheckBox fnacBox;
    private JCheckBox pccomponentsBox;
    private JComboBox<String> brandField;


    SearchListener(final JComboBox brandField, final JTextArea textArea, final JCheckBox amazon, final JCheckBox fnac, final JCheckBox pccomponents) {
        this.textArea = textArea;
        amazonBox = amazon;
        fnacBox = fnac;
        pccomponentsBox = pccomponents;
        this.brandField = brandField;
        phoneSearch = new PhoneSearch();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        final List<PhoneModel> phoneModels = phoneSearch.performSearch((String) brandField.getSelectedItem(), getSitesToSearch());
        phoneModels.forEach(phone -> textArea.append(phone.toString()));
    }

    private List<Sites> getSitesToSearch() {
        final List<Sites> sites = new ArrayList<>();
        if (amazonBox.isSelected()) {
            sites.add(Sites.AMAZON);
        }
        if (pccomponentsBox.isSelected()) {
            sites.add(Sites.PCCOMPONENTS);
        }
        if (fnacBox.isSelected() || (!fnacBox.isSelected() && !amazonBox.isSelected() && !pccomponentsBox.isSelected())) {
            sites.add(Sites.FNAC);
        }
        return sites;
    }
}
