package pack11ch;

import java.io.*;

class MyThread1 extends Thread{
    private static PrintWriter consoleOut = new PrintWriter(System.out, true);

    MyThread1(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        consoleOut.println(getName() + " - start");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                consoleOut.println("In " + getName() + ", counter: " + count);
            }
        } catch (InterruptedException exc) {
            consoleOut.println(getName() + " - interrupted!");
        }
        consoleOut.println(getName() + " - completion");
    }
}

public class ExtendThread {
    public static void main(String[] args) {
        MyThread.consoleOut.println("Main stream - start");

        MyThread1 childOne = new MyThread1("Child #1");
        MyThread1 childTwo = new MyThread1("Child #2");
        MyThread1 childThree = new MyThread1("Child #3");

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
