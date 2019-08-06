package pack14ch;

import static packAlternative.AOutput.consoleOut;

interface IntPredicate {
    boolean test(int n);
}

class MyIntPredicates {

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n / i; i++) {
            if ((n % i) == 0) return false;
        }
        return true;
    }

    static boolean isEven(int n) {
        return (n % 2) == 0;
    }

    static boolean isPositive(int n) {
        return n > 0;
    }
}

public class MethodRefDemo {
    private static boolean numTest(IntPredicate p, int val) {
        return p.test(val);
    }

    public static void main(String[] args) {
        boolean result;

        result = numTest(MyIntPredicates::isPrime, 17);
        if (result) consoleOut.println("17 - is prime");

        result = numTest(MyIntPredicates::isEven, 12);
        if (result) consoleOut.println("12 - is even");

        result = numTest(MyIntPredicates::isPositive, 2);
        if (result) consoleOut.println("2 - is positive");

        if (MyIntPredicates.isPositive(2))
            consoleOut.println("2 - still positive");
    }
}