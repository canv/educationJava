/*
* If one thread has a higher priority than the other one,
* this does not mean that the first thread will be
* executed faster than the second one. A high thread priority
* only means that it can potentially get more CPU time.
*/

package pack11ch;

import java.io.*;

class Priority implements Runnable {
    static PrintWriter consoleOut = new PrintWriter(System.out, true);
    private int count;
    private Thread thread;

    private static boolean stop = false;
    private static String currentName;

    Priority(String name) {
        thread = new Thread(this, name);
        count = 0;
        currentName = name;


    }

    @Override
    public void run() {
        consoleOut.println(thread.getName() + " - start");
        do {
            count++;
            if (currentName.compareTo(thread.getName()) != 0) {
                currentName = thread.getName();
                consoleOut.println("In " + currentName);
            }
        } while (!stop && count < 10_000);
        stop = true;
        consoleOut.println("\n" + thread.getName() + " - end");
    }

    void showCounters() {
        Priority.consoleOut.println("\n" + thread.getName() + "counter: " + count);
    }

    Thread getThread() {
        return thread;
    }
}

public class PriorityDemo {
    public static void main(String[] args) {
        Priority childOne = new Priority("High Priority");
        Priority childTwo = new Priority("Low Priority");

        childOne.getThread().setPriority(7);
        childTwo.getThread().setPriority(3);

        childOne.getThread().start();
        childTwo.getThread().start();

        try {
            childOne.getThread().join();
            childTwo.getThread().join();
        } catch (InterruptedException exc) {
            Priority.consoleOut.println("Main thread interrupted!");
        }
        childOne.showCounters();
        childTwo.showCounters();
    }
}
