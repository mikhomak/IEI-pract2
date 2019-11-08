package gui.view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private final static int WIDTH = 500;
    private final static int HEIGHT = 500;

    private JPanel mainPanel;
    private JButton searchButton;
    private JTextArea textArea1;

    public MainView() throws HeadlessException {
        setSize(WIDTH, HEIGHT);
        setContentPane(mainPanel);
    }

    
}
