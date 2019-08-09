
package pack15ch;

import java.applet.Applet;
import java.awt.*;

/*
    <applet code="Banner" width =300 height=50>
    </applet>
*/

public class Banner extends Applet implements Runnable {
    private String message = " ☺  Java applet - epic fail ";
    private Thread repaintThread;
    private boolean stopFlag;

    public void init() {
        repaintThread = null;
    }

    public  void start() {
        repaintThread = new Thread(this);
        stopFlag = false;
        repaintThread.start();
    }

    @Override
    public void run() {
        for(;;){
            try{
                repaint();
                Thread.sleep(150);
                if(stopFlag)break;
            }catch (InterruptedException ignored){}
        }
    }

    public void stop(){
        stopFlag = true;
        repaintThread = null;
    }

    public void paint(Graphics g){
        char ch;
        ch = message.charAt(0);
        message = message.substring(1);
        message += ch;
        g.drawString(message,130,170);
    }
}