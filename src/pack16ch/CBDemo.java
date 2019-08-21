package pack16ch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CBDemo implements ItemListener {
    private JLabel labSelected, labChanged;
    private JCheckBox cbAlpha, cbBeta, cbGamma;

    private CBDemo() {
        JFrame jFrame = new JFrame("Check Boxes demo");

        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(280, 120);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labSelected = new JLabel("");
        labChanged = new JLabel("");

        cbAlpha = new JCheckBox("Alpha");
        cbBeta = new JCheckBox("Beta");
        cbGamma = new JCheckBox("Gamma");

        cbAlpha.addItemListener(this);
        cbBeta.addItemListener(this);
        cbGamma.addItemListener(this);

        jFrame.add(cbAlpha);
        jFrame.add(cbBeta);
        jFrame.add(cbGamma);
        jFrame.add(labSelected);
        jFrame.add(labChanged);

        jFrame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String str = "";

        JCheckBox checkBox = (JCheckBox) e.getItem();

        if (checkBox.isSelected())
            labChanged.setText(checkBox.getText() + " was selected");
        else labChanged.setText(checkBox.getText() + " was cleared");

        if (cbAlpha.isSelected()) str += "Alpha ";
        if (cbBeta.isSelected()) str += "Beta ";
        if (cbGamma.isSelected()) str += "Gamma ";

        labSelected.setText("Selected check boxes: " + str);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CBDemo::new);
    }
}