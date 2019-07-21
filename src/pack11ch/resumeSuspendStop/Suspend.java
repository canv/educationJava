package pack11ch.resumeSuspendStop;

import java.io.PrintWriter;

class MyThread implements Runnable {
    static PrintWriter consoleOut = new PrintWriter(System.out, true);
    Thread thread;
    private volatile boolean suspended, stopped;

    MyThread(String name) {
        thread = new Thread(this, name);
        suspended = false;
        stopped = false;

        thread.start();
    }

    @Override
    public void run() {
        consoleOut.println(thread.getName() + " - start");

        try {
            for (int i = 1; i < 10000; i++) {
                counter10(i);

                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                    if (stopped) break;
                }
            }
        } catch (InterruptedException exc) {
            consoleOut.println(thread.getName() + " - interrupted");
        }
        consoleOut.println(thread.getName() + " - exit");
    }

    private void counter10(int i) {
        try {
            consoleOut.print(i + " ");
            if (i % 10 == 0) {
                consoleOut.println();
                Thread.sleep(250);
            }

        } catch (InterruptedException exc) {
            consoleOut.println(thread.getName() + " - interrupted");
        }
    }

    synchronized void myStop() {
        stopped = true;
        suspended = false;
        notify();

    }

    synchronized void mySuspend() {
        suspended = true;
    }

    synchronized void myResume() {
        suspended = false;
        notify();
    }
}

public class Suspend {
    public static void main(String[] args) {
        MyThread threadObj = new MyThread("My Thread");
        try {
            Thread.sleep(1000);

            threadObj.mySuspend();
            MyThread.consoleOut.println("Thread suspend");
            Thread.sleep(1000);

            threadObj.myResume();
            MyThread.consoleOut.println("Thread resume");
            Thread.sleep(1000);

            threadObj.mySuspend();
            MyThread.consoleOut.println("Thread suspend");
            Thread.sleep(1000);

            threadObj.myResume();
            MyThread.consoleOut.println("Thread resume");
            Thread.sleep(1000);

            threadObj.mySuspend();
            MyThread.consoleOut.println("Thread stop");
            threadObj.myStop();
        } catch (InterruptedException exc) {
            MyThread.consoleOut.println("Main thread interrupted");
        }

        try {
            threadObj.thread.join();
        } catch (InterruptedException exc) {
            MyThread.consoleOut.println("Main thread interrupted");
        }
        MyThread.consoleOut.println("Main thread exit");
    }
}
