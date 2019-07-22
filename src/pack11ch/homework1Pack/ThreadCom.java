package pack11ch.homework1Pack;

import java.io.PrintWriter;

class TickTock {
    private String state;

    synchronized void tick(boolean running) {
        if (!running) {
            state = "TICKed";
            notify();
            return;
        }

        ThreadCom.consoleOut.printf("Tick ");//Incorrect work with '.print', i don't know why
        try {
            Thread.sleep(500);
            state = "TICKed";
            notify();
            while (!state.equals("TOCKed"))
                wait();
        } catch (InterruptedException exc) {
            ThreadCom.consoleOut.println("Interrupted thread(TICKed)!");
        }
    }

    synchronized void tock(boolean running) {
        if (!running) {
            state = "TOCKed";
            notify();
            return;
        }

        ThreadCom.consoleOut.println("Tock ");
        try {
            Thread.sleep(500);
            state = "TOCKed";
            notify();
            while (!state.equals("TICKed")) {
                wait();
            }
        } catch (InterruptedException exc) {
            ThreadCom.consoleOut.println("Interrupted thread(TOCKed)!");
        }
    }
}

class MyThread implements Runnable {
    private Thread thread;
    private TickTock tickTockObj;

    MyThread(String name, TickTock tickTockObj) {
        thread = new Thread(this, name);
        this.tickTockObj = tickTockObj;
        thread.start();
    }

    @Override
    public void run() {
        switch (thread.getName()) {
            case "Tick":
                for (int i = 0; i < 5; i++) tickTockObj.tick(true);
                tickTockObj.tick(false);
                break;
            case "Tock":
                for (int i = 0; i < 5; i++) tickTockObj.tock(true);
                tickTockObj.tock(false);
                break;
            default:
                ThreadCom.consoleOut.println("Thread name reading error!");
        }
    }

    Thread getThread() {
        return thread;
    }
}

class ThreadCom {
    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThread mt1 = new MyThread("Tick", tt);
        MyThread mt2 = new MyThread("Tock", tt);

        try {
            mt1.getThread().join();
            mt2.getThread().join();
        } catch (InterruptedException exc) {
            consoleOut.println("Main thread interrupted!");
        }
    }

    static PrintWriter consoleOut = new PrintWriter(System.out, true);
}