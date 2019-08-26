/*
File address example:
C:\Users\...\testFC1.txt
*/

package pack16ch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

public class SwingFC implements ActionListener {

    private JTextField firstFileName, secondFileName;
    private JButton compareButton;
    private JLabel labFirstFile, labSecondFile;
    private JLabel labResult;
    private JCheckBox cbShowMismatch;

    SwingFC() {
        JFrame jFrame = new JFrame("Compare files");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(220, 205);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstFileName = new JTextField(14);
        secondFileName = new JTextField(14);
        firstFileName.setActionCommand("fileA");
        secondFileName.setActionCommand("fileB");

        compareButton = new JButton("Compare");
        compareButton.addActionListener(this);

        labFirstFile = new JLabel("First file address:");
        labSecondFile = new JLabel("Second file address:");
        labResult = new JLabel("");

        cbShowMismatch = new JCheckBox("Show mismatch position");

        jFrame.add(labFirstFile);
        jFrame.add(firstFileName);
        jFrame.add(labSecondFile);
        jFrame.add(secondFileName);
        jFrame.add(cbShowMismatch);
        jFrame.add(compareButton);
        jFrame.add(labResult);

        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int i, j, count = 0;

        if (firstFileName.getText().equals("")) {
            labResult.setText("First file name missing");
            return;
        }
        if (secondFileName.getText().equals("")) {
            labResult.setText("Second file name missing");
            return;
        }

        try (FileInputStream f1 = new FileInputStream(firstFileName.getText());
             FileInputStream f2 = new FileInputStream(secondFileName.getText())) {

            do {
                i = f1.read();
                j = f2.read();
                count++;
                if (i != j) break;
            } while (i != -1 && j != -1);
            if (i != j) {
                if (cbShowMismatch.isSelected()) labResult.setText("Files aren't the same, on " + count +
                        " position ");
                        //+"(mismatch \"" + i + "\" and \"" + j + "\")");
                else labResult.setText("Files aren't the same");
            } else labResult.setText("Files compare equal");
        } catch (IOException e) {
            labResult.setText("File not found");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingFC::new);
    }
}