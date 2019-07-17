package pack11ch;

import java.io.*;

class MyThread implements Runnable {
    static PrintWriter consoleOut = new PrintWriter(System.out, true);
    private String threadName;

    MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        consoleOut.println(threadName + " - start");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                consoleOut.println("In " + threadName + ", counter: " + count);
            }
        } catch (InterruptedException exc) {
            consoleOut.println(threadName + " - interrupted!");
        }
        consoleOut.println(threadName + " - completion");
    }
}

public class UseThreads {
    public static void main(String[] args) {
        MyThread.consoleOut.println("Main stream - start");

        MyThread childOb = new MyThread("Child #1");
        Thread childThd = new Thread(childOb);

        childThd.start();

        for (int i = 0; i < 50; i++) {
            MyThread.consoleOut.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                MyThread.consoleOut.println("Main stream - interrupted!");
            }
        }
        MyThread.consoleOut.println("Main stream - completion");
    }
}
