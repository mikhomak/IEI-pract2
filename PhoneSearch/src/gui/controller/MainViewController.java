package gui.controller;

import gui.view.MainView;
import persistence.IPhoneSearch;

import javax.swing.*;

public class MainViewController {

    private MainView mainView;
    private JButton searchButton;
    private JTextArea textArea1;


    public MainViewController() {
        mainView = new MainView();
        searchButton = mainView.getSearchButton();
        textArea1 = mainView.getTextArea1();

        searchButton.addActionListener(new SearchListener());
    }

    public void showMainFrame(){
        mainView.setVisible(true);
    }
}
