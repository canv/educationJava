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
    private JLabel labFirstFile, labSeconfFile;
    private JLabel labResult;

    SwingFC() {
        JFrame jFrame = new JFrame("Compare files");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(200, 190);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstFileName = new JTextField(14);
        secondFileName = new JTextField(14);
        firstFileName.setActionCommand("fileA");
        secondFileName.setActionCommand("fileB");

        compareButton = new JButton("Compare");
        compareButton.addActionListener(this);

        labFirstFile = new JLabel("First file address:");
        labSeconfFile = new JLabel("Second file address:");
        labResult = new JLabel("");

        jFrame.add(labFirstFile);
        jFrame.add(firstFileName);
        jFrame.add(labSeconfFile);
        jFrame.add(secondFileName);
        jFrame.add(compareButton);
        jFrame.add(labResult);

        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int i, j;

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
                if (i != j) break;
            } while (i != -1 && j != -1);
            if (i != j) labResult.setText("Files aren't the same");
            else labResult.setText("Files compare equal");
        } catch (IOException e) {
            labResult.setText("File not found");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingFC::new);
    }
}