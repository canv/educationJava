package pack15ch;

/*
    <applet code="SimpleApplet" width =200 height=60>
    </applet>
*/

import java.applet.*;
import java.awt.*;

public class SimpleApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Java makes applet easy!",120,150);
    }
}