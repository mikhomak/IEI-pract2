package gui.controller;

import gui.view.MainView;

import javax.swing.*;

public class MainViewController {

    private MainView mainView;
    private JButton searchButton;


    public MainViewController() {
        mainView = new MainView();
        searchButton = mainView.getSearchButton();

        initializeListener();
    }

    private void initializeListener() {
        final SearchListener searchListener = new SearchListener();
        searchListener.setAmazonBox(getMainView().getAmazonBox());
        searchListener.setFnacBox(getMainView().getFnacBox());
        searchListener.setPccomponentsBox(getMainView().getPccomponentsBox());
        searchListener.setBrandField(getMainView().getBrandField());
        searchListener.setModelField(getMainView().getModelField());
        searchListener.setTextArea(getMainView().getTextArea1());
        searchButton.addActionListener(searchListener);
    }

    public void showMainFrame() {
        mainView.setVisible(true);
    }

    private MainView getMainView() {
        return mainView;
    }
}
