package pack16ch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TFDemo implements ActionListener {

    private JTextField testField;
    private JButton reverseButton;
    private JLabel labPrompt, labContents;

    TFDemo(){
        JFrame jFrame = new JFrame("Use A test Field");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(240,120);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        testField = new JTextField(10);
        testField.setActionCommand("myTF");

        reverseButton = new JButton("Reverse");

        testField.addActionListener(this);
        reverseButton.addActionListener(this);

        labPrompt = new JLabel("Enter test: ");
        labContents = new JLabel("");

        jFrame.add(labPrompt);
        jFrame.add(testField);
        jFrame.add(reverseButton);
        jFrame.add(labContents);

        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Reverse")){
            String originalStr = testField.getText();
            String reverseStr = "";

            for (int i = originalStr.length()-1; i >=0; i--)
                reverseStr += originalStr.charAt(i);

            testField.setText(reverseStr);
        }else labContents.setText("Tou pressed ENTER. Text is: " +
                testField.getText());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TFDemo();
            }
        });
    }
}