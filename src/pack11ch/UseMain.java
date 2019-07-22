package pack11ch;

import java.io.PrintWriter;

public class UseMain {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();

        consoleOut.println("Main thread name: " + thread.getName()+
                "\nMain thread priority: " + thread.getPriority()+
                "\n\nSetting the name and priority of the main thread\n");

        thread.setName("Thread #1");
        thread.setPriority(8); //equivalently Thread.NORM_PRIORITY + 3

        consoleOut.println("New main thread name: " + thread.getName()+
                "\nNew main thread priority: " + thread.getPriority());
    }
    private static PrintWriter consoleOut = new PrintWriter(System.out, true);
}