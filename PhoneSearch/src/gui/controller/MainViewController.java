package gui.controller;

import gui.view.MainView;

import javax.swing.*;

public class MainViewController {

    private MainView mainView;
    private JButton searchButton;


    public MainViewController() {
        mainView = new MainView();
        searchButton = mainView.getSearchButton();

        searchButton.addActionListener(new SearchListener(getMainView().getBrandField(),getMainView().getTextArea1(), getMainView().getAmazonBox(), getMainView().getFnacBox(), getMainView().getPccomponentsBox()));
    }

    public void showMainFrame() {
        mainView.setVisible(true);
    }

    private MainView getMainView() {
        return mainView;
    }
}
