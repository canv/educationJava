package pack15ch;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TrackMouse extends Applet
        implements MouseListener, MouseMotionListener {
    private int currentX = 0, currentY = 0;
    private int oldX = 0, oldY = 0;
    private boolean drawFlag;

    @Override
    public void init() {
        addMouseListener(this);
        addMouseMotionListener(this);
        drawFlag = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        oldX = e.getX();
        oldY = e.getY();
        drawFlag = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        drawFlag = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        currentX = e.getX();
        currentY = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        showStatus("Mouse moving: " + e.getX() + ", " + e.getY());

    }

    @Override
    public void paint(Graphics g) {
        if (drawFlag)
            g.drawLine(oldX, oldY, currentX, currentY);
    }
}