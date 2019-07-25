package pack12ch;

import java.io.PrintWriter;

public class AutoBoxDemo {
    public static void main(String[] args) {
        Integer testIntObjOne = 100;
        int testIntOne = testIntObjOne;
        consoleOut.println("Integer: " + testIntObjOne + ", int: " + testIntOne);

        putInteger(199);

        Integer testIntObjTwo = getInt10();
        consoleOut.println("Value returned from the getInt10(): " + testIntObjTwo);

        int testIntTwo = getInteger99();
        consoleOut.println("Value returned from the getInteger99(): " + testIntTwo);

        consoleOut.println("Square root of intObj: " + Math.sqrt(testIntObjOne));


        Integer testIntObjThree = 99;
        Integer testIntObjFour;
        int testIntThree;

        consoleOut.println("\nAfter ++testIntObjThree: " + ++testIntObjThree);

        consoleOut.println("After testIntObjThree += 10: " + (testIntObjThree += 10));

        consoleOut.println("After testIntObjFour = testIntObjThree + (testIntObjThree / 3): "
                + (testIntObjFour = testIntObjThree + (testIntObjThree / 3)));

        consoleOut.println("After testIntThree = testIntObjThree + (testIntObjThree / 3): "
                + (testIntThree = testIntObjThree + (testIntObjThree / 3)));
    }

    private static PrintWriter consoleOut =
            new PrintWriter(System.out, true);

    private static void putInteger(Integer val) {
        consoleOut.println("\ngetInteger () got: " + val);
    }

    private static int getInt10() {
        return 10;
    }

    private static Integer getInteger99() {
        return 99;
    }
}
