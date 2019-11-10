package gui.view;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MainView extends JFrame {

    private final static int WIDTH = 800;
    private final static int HEIGHT = 800;

    private JPanel mainPanel;
    private JButton searchButton;
    private JTextArea textArea1;
    private JCheckBox amazonBox;
    private JCheckBox fnacBox;
    private JCheckBox pccomponentsBox;
    private JTextField modelField;
    private JComboBox<String> brandField;

    private final List<String> brands = Arrays.asList("huawei", "xiamoi","samsung");

    public MainView() throws HeadlessException {
        setSize(WIDTH, HEIGHT);
        setContentPane(mainPanel);
        initializeBrandComboBox();

    }

    private void initializeBrandComboBox() {
        final DefaultComboBoxModel<String> brandModel = new DefaultComboBoxModel<String>();
        brandModel.addAll(brands);
        brandField.setModel(brandModel);
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public JCheckBox getAmazonBox() {
        return amazonBox;
    }

    public JCheckBox getFnacBox() {
        return fnacBox;
    }

    public JCheckBox getPccomponentsBox() {
        return pccomponentsBox;
    }

    public JComboBox<String> getBrandField() {
        return brandField;
    }
}
