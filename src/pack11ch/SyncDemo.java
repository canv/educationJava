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
        int answer = sumObj.sumArray(sumArr);
        SyncDemo.consoleOut.println(thread.getName() + " - start");
        SyncDemo.consoleOut.println("SUM for " + thread.getName() + ": " + answer);
        SyncDemo.consoleOut.println(thread.getName() + " - end");
    }
}

public class SyncDemo {
    public static void main(String[] args) {
        int[] forSummationArr = {1, 2, 3, 4, 5};

        UseThreadSyncMethod mt1 = new UseThreadSyncMethod("Child#1", forSummationArr);
        UseThreadSyncMethod mt2 = new UseThreadSyncMethod("Child#2", forSummationArr);
    }
    static PrintWriter consoleOut = new PrintWriter(System.out, true);
}
