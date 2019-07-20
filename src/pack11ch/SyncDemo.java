package pack11ch;

import java.io.PrintWriter;

class SyncMethodSumArray {

    synchronized int sumArray(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
            SyncDemo.consoleOut.println("Current sum value for "
                    + Thread.currentThread().getName() + ": " + sum);
            try {
                Thread.sleep(10);
            } catch (InterruptedException exc) {
                SyncDemo.consoleOut.println("Main thread interrupted!");
            }
        }
        return sum;
    }
}
class UseThreadSyncMethod implements Runnable {
    private Thread thread;
    private static SyncMethodSumArray sumObj = new SyncMethodSumArray();
    private int[] sumArr;

    UseThreadSyncMethod(String name, int[] nums) {
        thread = new Thread(this, name);
        sumArr = nums;
        thread.start();
    }

    @Override
    public void run() {
        SyncDemo.consoleOut.println(thread.getName() + " - start");
        int answer = sumObj.sumArray(sumArr);
        SyncDemo.consoleOut.println("SUM for " + thread.getName() + ": " + answer);
        SyncDemo.consoleOut.println(thread.getName() + " - end");
    }

    Thread getThread() {
        return thread;
    }
}



class SyncBlockSumArray {

    int sumArray(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
            SyncDemo.consoleOut.println("Current sum value for "
                    + Thread.currentThread().getName() + ": " + sum);
            try {
                Thread.sleep(10);
            } catch (InterruptedException exc) {
                SyncDemo.consoleOut.println("Main thread interrupted!");
            }
        }
        return sum;
    }
}
class UseThreadSyncBlock implements Runnable {
    private Thread thread;
    private static SyncBlockSumArray sumObj = new SyncBlockSumArray();
    private int[] sumArr;

    UseThreadSyncBlock(String name, int[] nums) {
        thread = new Thread(this, name);
        sumArr = nums;
        thread.start();
    }

    @Override
    public void run() {
        int answer;
        SyncDemo.consoleOut.println(thread.getName() + " - start");
        synchronized (sumObj){
        answer = sumObj.sumArray(sumArr);
        }
        SyncDemo.consoleOut.println("SUM for " + thread.getName() + ": " + answer);
        SyncDemo.consoleOut.println(thread.getName() + " - end");
    }

    Thread getThread() {
        return thread;
    }
}

public class SyncDemo {
    public static void main(String[] args) {
        int[] forSummationArr = {1, 2, 3, 4, 5};

        SyncDemo.consoleOut.println("\nSynchronization demo by method: ");
        UseThreadSyncMethod mt1 = new UseThreadSyncMethod("Child#1.1", forSummationArr);
        UseThreadSyncMethod mt2 = new UseThreadSyncMethod("Child#2.1", forSummationArr);
        try{
            mt1.getThread().join();
            mt2.getThread().join();
        }catch (InterruptedException exc){
            SyncDemo.consoleOut.println("Interrupt the first part of the main thread");
        }

        SyncDemo.consoleOut.println("\nSynchronization demo by block: ");
        UseThreadSyncBlock mt3 = new UseThreadSyncBlock("Child#1.2", forSummationArr);
        UseThreadSyncBlock mt4 = new UseThreadSyncBlock("Child#2.2", forSummationArr);
        try{
            mt3.getThread().join();
            mt4.getThread().join();
        }catch (InterruptedException exc){
            SyncDemo.consoleOut.println("Interrupt the second part of the main thread");
        }

        SyncDemo.consoleOut.println("\nMain thread - end");
    }
    static PrintWriter consoleOut = new PrintWriter(System.out, true);
}
