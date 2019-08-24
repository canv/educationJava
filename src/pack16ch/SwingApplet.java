package pack16ch;

import javax.swing.*;
import java.awt.*;

import static packAlternative.AOutput.consoleOut;

/*
    <object code="SwingApplet" width =200 height=80>
    </object>
*/
public class SwingApplet extends JApplet {
    private JButton buttonUp, buttonDown;
    private JLabel jLabel;

    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(() -> makeGUI());
        }catch (Exception exc){
            consoleOut.println("Can't create GUI, because: " + exc);
        }
    }

    private void makeGUI(){
        setLayout(new FlowLayout());

        buttonUp = new JButton("Up");
        buttonDown = new JButton("Down");

        buttonUp.addActionListener(e -> jLabel.setText("You pressed Up"));
        buttonDown.addActionListener(e -> jLabel.setText("You pressed Down"));

        add(buttonUp);
        add(buttonDown);

        jLabel = new JLabel("Press a button.");

        add(jLabel);
    }
}