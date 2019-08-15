package pack15ch;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*
    <applet code="MouseEvents" width =300 height=100>
    </applet>
*/

public class MouseEvents extends Applet
        implements MouseListener, MouseMotionListener {
    private String message = "";
    private int mouseX = 0, mouseY = 0;

    @Override
    public void init() {
        addMouseListener(this);
        addMouseMotionListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseX = 0;
        mouseY = 10;
        message = "Mouse clicked";
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseX = 0;
        mouseY = 10;
        message = "Mouse entered";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseX = 0;
        mouseY = 10;
        message = "Mouse exited";
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        message = "Down";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        message = "Up";
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        message = "*";
        showStatus("Dragging mouse at " + mouseX + ", " + mouseY);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        showStatus("Moving mouse at " + mouseX + ", " + mouseY);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(message, mouseX, mouseY);
    }
}