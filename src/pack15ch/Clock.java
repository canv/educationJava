package pack15ch;

import java.applet.Applet;
import java.awt.*;
import java.util.Calendar;

/*
    <applet code="Clock" width =300 height=50>
    </applet>
*/

public class Clock extends Applet implements Runnable {
    private String message;
    private Thread thread;
    private boolean flag;

    @Override
    public void init() {
        thread = null;
        message = "";
    }

    @Override
    public void start() {
        thread = new Thread(this);
        flag = false;
        thread.start();
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                repaint();
                Thread.sleep(1000);
                if (flag) break;
            } catch (InterruptedException ignored) {
            }
        }
    }

    @Override
    public void stop() {
        flag = true;
        thread = null;
    }

    @Override
    public void paint(Graphics g) {
        Calendar clock = Calendar.getInstance();
        message = "Current time: " + clock.get(Calendar.HOUR);
        message = ":" + clock.get(Calendar.MINUTE);
        message = ":" + clock.get(Calendar.SECOND);
        g.drawString(message, 130, 170);
    }
}