package pack16ch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo implements ActionListener {
    private JLabel jLabel;

    private ButtonDemo() {

        JFrame jFrame = new JFrame("Time killer v0.002");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(400, 90);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton killerButton = new JButton("kill");

        killerButton.addActionListener(this);

        jFrame.add(killerButton);

        jLabel = new JLabel("\npress to kill time");
        jFrame.add(jLabel);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("kill"))
            jLabel.setText("Congratulations! " +
                    "You have successfully killed your time!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonDemo();
            }
        });
    }
}