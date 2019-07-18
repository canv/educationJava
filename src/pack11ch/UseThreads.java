package pack11ch;

import java.io.*;

class MyThread implements Runnable {
    static PrintWriter consoleOut = new PrintWriter(System.out, true);
    private Thread threadOne;

    MyThread(String name) {
        threadOne = new Thread(this, name);
        threadOne.start();
    }

    @Override
    public void run() {
        consoleOut.println(threadOne.getName() + " - start");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                consoleOut.println("In " + threadOne.getName() + ", counter: " + count);
            }
        } catch (InterruptedException exc) {
            consoleOut.println(threadOne.getName() + " - interrupted!");
        }
        consoleOut.println(threadOne.getName() + " - completion");
    }
}

public class UseThreads {
    public static void main(String[] args) {
        MyThread.consoleOut.println("Main stream - start");

        MyThread childOb = new MyThread("Child #1");

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
