/*
    Modify the source code of the TrafficLight program
    so that the duration of the display of each color of the traffic light
    is given by the constants of the enum type TrafficLightColor.

    Try to abandon the switch operator and use the ordinal values
    of each color to switch the traffic light
 */

package pack12ch.homework1Pack;

import java.io.PrintWriter;

enum TrafficLightColor {
    GREEN(3000),
    YEllOW(1500),
    RED(5000);

    private int delay;

    TrafficLightColor(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }
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
        consoleOut.println("\nSimulation begins with " + color + " color\n");

        thread.start();
    }

    TrafficLightSimulator() {
        color = TrafficLightColor.RED;
        thread = new Thread(this);
        consoleOut.println("\nSimulation begins with " + color + " color\n");

        thread.start();
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Thread.sleep(color.getDelay());
            } catch (InterruptedException exc) {
                consoleOut.println(exc);
            }
            changeColor();
        }
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
        consoleOut.println(color + "(~" + ((double) color.getDelay() / 1000) + " sec)");
    }

    void cancel() {
        stop = true;
    }

    public Thread getThread() {
        return thread;
    }
}

public class TrafficLightDemo {
    public static void main(String[] args) {


        TrafficLightSimulator simulationOne =
                new TrafficLightSimulator(TrafficLightColor.YEllOW);

        for (int i = 0; i < 6; i++) {
            simulationOne.showColor();
            simulationOne.waitForChange();
        }
        simulationOne.cancel();

        try {
            simulationOne.getThread().join();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }


        TrafficLightSimulator simulationTwo =
                new TrafficLightSimulator();

        for (int i = 0; i < 3; i++) {
            simulationTwo.showColor();
            simulationTwo.waitForChange();
        }
        simulationTwo.cancel();

        try {
            simulationTwo.getThread().join();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }
}