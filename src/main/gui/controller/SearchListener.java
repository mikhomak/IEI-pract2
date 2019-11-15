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
    private JComboBox brandField;
    private JTextField modelField;


    private final static String DEFAULT_SEARCH_WORD = "xiamoi";


    SearchListener() {
        phoneSearch = new PhoneSearch();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        final StringBuilder searchWord = new StringBuilder();
        if(getBrandField().getSelectedItem() != null){
            searchWord.append(getBrandField().getSelectedItem());
        }
        searchWord.append(" ").append(getModelField().getText());

        final List<PhoneModel> phoneModels = phoneSearch.performSearch(searchWord.toString(), getSitesToSearch());
        phoneModels.forEach(phone -> getTextArea().append(phone.toString()));
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

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JCheckBox getAmazonBox() {
        return amazonBox;
    }

    public void setAmazonBox(JCheckBox amazonBox) {
        this.amazonBox = amazonBox;
    }

    public JCheckBox getFnacBox() {
        return fnacBox;
    }

    public void setFnacBox(JCheckBox fnacBox) {
        this.fnacBox = fnacBox;
    }

    public JCheckBox getPccomponentsBox() {
        return pccomponentsBox;
    }

    public void setPccomponentsBox(JCheckBox pccomponentsBox) {
        this.pccomponentsBox = pccomponentsBox;
    }

    public JComboBox getBrandField() {
        return brandField;
    }

    public void setBrandField(JComboBox brandField) {
        this.brandField = brandField;
    }


    public JTextField getModelField() {
        return modelField;
    }

    public void setModelField(JTextField modelField) {
        this.modelField = modelField;
    }
}
