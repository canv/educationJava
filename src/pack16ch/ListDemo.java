package pack16ch;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

class ListDemo implements ListSelectionListener {

    private JList<String> jList;
    private JLabel jLabel;
    private JScrollPane jScrollPane;

    private String[] names = {"Tom", "Tim", "Thomas",
                      "Tommi", "Thomson", "TM",
                      "Tatty", "Tomato","Toaster",
                      "Turtle","ToTo","Tiger"};

    private ListDemo(){
        JFrame jFrame = new JFrame("JList demo");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(200,160);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jList = new JList<>(names);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(120,90));

        jLabel = new JLabel("Choose a name");

        jList.addListSelectionListener(this);

        jFrame.add(jScrollPane);
        jFrame.add(jLabel);
        jFrame.setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int idx = jList.getSelectedIndex();

        if(idx != -1) jLabel.setText("Current selection: " + names[idx]);
        else jLabel.setText("Choose a name");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListDemo::new);
    }
}