package pack10ch;

import java.io.*;

public class PrintWriterDemo {
    public static void main(String[] args) {
        PrintWriter showMessage = new PrintWriter(System.out, true);
        int testInt = 10;
        double testDouble = 123.65;

        showMessage.println("Using class PrintWriter:\n");
        showMessage.println(testInt);
        showMessage.println(testDouble);
        showMessage.println(testInt + " + "
                + testDouble + " = "
                + (testInt+testDouble));
    }
}
