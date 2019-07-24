package pack12ch;

import java.io.PrintWriter;

enum TrafficLightColor {
    RED, GREEN, YEllOW
}

class TrafficLightSimulator implements Runnable {
    private static PrintWriter consoleOut = new PrintWriter(System.out, true);
    private Thread thread;
    private TrafficLightColor color;
    private boolean stop = false;
    private boolean changed = false;


    TrafficLightSimulator(TrafficLightColor initialization) {
        color = initialization;
        thread = new Thread(this);

        thread.start();
    }

    TrafficLightSimulator() {
        color = TrafficLightColor.RED;
        thread = new Thread(this);

        thread.start();
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                switch (color) {
                    case GREEN:
                        Thread.sleep(500);
                        break;
                    case YEllOW:
                        Thread.sleep(300);
                        break;
                    case RED:
                        Thread.sleep(700);
                        break;
                }
            } catch (InterruptedException exc) {
                consoleOut.println(exc);
            }
        }
        changeColor();
    }

    private synchronized void changeColor() {
        switch (color) {
            case RED:
                color = TrafficLightColor.GREEN;
                break;
            case YEllOW:
                color = TrafficLightColor.RED;
                break;
            case GREEN:
                color = TrafficLightColor.YEllOW;
                break;
        }
        changed = true;
        notify();
    }

    synchronized void waitForChange() {
        try {
            while (!changed) wait();
            changed = false;
        } catch (InterruptedException exc) {
            consoleOut.println(exc);
        }
    }

    void showColor() {
        consoleOut.println(color);
    }

    void cancel() {
        stop = true;
    }
}

public class TrafficLightDemo {
    public static void main(String[] args) {

        TrafficLightSimulator simulationOne =
                new TrafficLightSimulator(TrafficLightColor.GREEN);

        for (int i = 0; i < 9; i++) {
            simulationOne.showColor();
            simulationOne.waitForChange();
        }
        simulationOne.cancel();
    }
}